package phptravels.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Driver;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class RegisterPage extends Driver {

    private final String REGISTER_PAGE_TITLE = "Signup - PHPTRAVELS";

    private static String RANDOM_EMAIL = String.format("%s@gmail.com", RandomStringUtils.randomAlphanumeric(10));
    private static String RANDOM_PHONE = RandomStringUtils.randomNumeric(10);
    private static String RANDOM_PASSWORD = RandomStringUtils.randomAlphanumeric(10);


    @FindBy(name = "first_name")
    private WebElement firstName;

    @FindBy(name = "last_name")
    private WebElement lastName;

    @FindBy(name = "phone")
    private WebElement phone;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "select2-selection__rendered")
    private List<WebElement> accountType;

    @FindBy(className = "ladda-label")
    private WebElement signUpButton;

    public boolean isRegisterPage() {
        wait.until(ExpectedConditions.titleContains(REGISTER_PAGE_TITLE));
        return driver.getTitle().contains(REGISTER_PAGE_TITLE);
    }

    public void enterDefaultData() {
        firstName.sendKeys("Maxim");
        lastName.sendKeys("Pupkin");
        phone.sendKeys(RANDOM_PHONE);
        email.sendKeys(RANDOM_EMAIL);
        password.sendKeys(RANDOM_PASSWORD);
        signUpButton.click();
    }

}