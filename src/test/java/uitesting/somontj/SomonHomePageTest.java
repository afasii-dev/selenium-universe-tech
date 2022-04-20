package uitesting.somontj;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import somon_tj.model.HomePage;

public class SomonHomePageTest extends SomonTjPage {

    private static HomePage homePage;

    @Test
    public void homePageSearchFieldHappyFlow() {
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
