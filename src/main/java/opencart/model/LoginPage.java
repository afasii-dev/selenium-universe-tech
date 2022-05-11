package opencart.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Driver;

@Getter
@RequiredArgsConstructor
public class LoginPage extends Driver {

    private final String LOGIN_PAGE_TITLE = "Account Login";

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
    private WebElement loginButton;

    public boolean isLoginPage() {
        wait.until(ExpectedConditions.titleContains(LOGIN_PAGE_TITLE));
        return driver.getTitle().contains(LOGIN_PAGE_TITLE);
    }

    public void enterLoginData() {
        email.sendKeys("test123google@gmail.com");
        password.sendKeys("1234567");
        loginButton.click();
    }

}