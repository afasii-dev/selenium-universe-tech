package uitesting.somontj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import somon_tj.model.HomePage;

public class SomonHomePageTest extends SomonTjPage {

    private static HomePage homePage;

    private TestInfo testInfo;

    @BeforeEach
    void init(TestInfo testInfo) {
        this.testInfo = testInfo;
    }

    @Test
    public void homePageSearchFieldHappyFlow() throws Exception {
        homePage = PageFactory.initElements(driver, HomePage.class);
        driver.get(BASE_URL);

        wait.until(ExpectedConditions.titleContains("Somon.TJ – сайт объявлений в Таджикистане"));

        homePage.getSearch().sendKeys("Audi q7");

        homePage.getCitiesDropdown().click();
        homePage.getCities().stream()
                .filter(city -> city.getAttribute("data-id").equals("511"))
                .findFirst()
                .get().click();
        homePage.getSearchButton().click();

        wait.until(ExpectedConditions.titleContains("Audi q7"));
        screenshot.take();
    }

    @Test
    public void homePageSearchSuggestItems() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        driver.get(BASE_URL);

        wait.until(ExpectedConditions.titleContains("Somon.TJ – сайт объявлений в Таджикистане"));

        homePage.getSearch().sendKeys("Audi q7");
        wait.until(ExpectedConditions.visibilityOfAllElements(homePage.getSearchSuggestItems()));

        homePage.getSearchSuggestItems().get(0).click();

        wait.until(ExpectedConditions.titleContains("Купить Audi"));
    }
}
