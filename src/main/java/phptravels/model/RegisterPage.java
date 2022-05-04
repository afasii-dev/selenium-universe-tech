package phptravels.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Driver;

import java.util.List;

import static util.RandomStringUtils.*;

@Getter
@RequiredArgsConstructor
public class RegisterPage extends Driver {

    private final String REGISTER_PAGE_TITLE = "Signup - PHPTRAVELS";

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
        phone.sendKeys(getRandomNumeric(9));
        email.sendKeys(getRandomEmail(5));
        password.sendKeys(randomAlphanumeric(10));
        signUpButton.click();
    }

}