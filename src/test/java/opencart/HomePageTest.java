package opencart;

import opencart.model.HomePage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePageTest extends OpenCartPage {

    @Test
    public void homePageTitleTest() {
        String url = String.format(BASE_URL, "common/home");
        driver.get(url);
        String title = driver.getTitle();
        assertThat("Title is as expected", title, equalTo("OpenCart - Open Source Shopping Cart Solution"));
    }

    @Test
    public void homePageRegisterButtonTest() {
        String url = String.format(BASE_URL, "common/home");
        driver.get(url);
        wait.until(ExpectedConditions.titleIs("OpenCart - Open Source Shopping Cart Solution"));
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.getRegisterButton().click();
    }
}
