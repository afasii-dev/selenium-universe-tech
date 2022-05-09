package phptravels.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import phptravels.RegistrationFormData;
import util.Driver;

import java.util.List;

import static util.RandomStringUtils.*;

@Getter
@RequiredArgsConstructor
public class RegisterPage extends Driver {

    private final String REGISTER_PAGE_TITLE = "Signup - PHPTRAVELS";

    @FindBy(name = "first_name")
    private static WebElement firstName;

    @FindBy(name = "last_name")
    private static WebElement lastName;

    @FindBy(name = "phone")
    private static WebElement phone;

    @FindBy(name = "email")
    private static WebElement email;

    @FindBy(name = "password")
    private static WebElement password;

    @FindBy(id = "select2-selection__rendered")
    private List<WebElement> accountType;

    @FindBy(className = "ladda-label")
    private static WebElement signUpButton;

    public boolean isRegisterPage() {
        wait.until(ExpectedConditions.titleContains(REGISTER_PAGE_TITLE));
        return driver.getTitle().contains(REGISTER_PAGE_TITLE);
    }

    public void enterDefaultData() {
        sendKeys(firstName, "Maxim");
        sendKeys(lastName, "Pupkin");
        sendKeys(phone, getRandomNumeric(9));
        sendKeys(email, getRandomEmail(5));
        sendKeys(password, randomAlphanumeric(10));
        drawBorder(signUpButton);
        screenshot.take();
        signUpButton.click();
    }

    public void enterWrongData() {
        firstName.sendKeys("Maxim");
        lastName.sendKeys("Pupkin");
        phone.sendKeys(getRandomNumeric(9));
//        email.sendKeys(getRandomEmail(5));
        password.sendKeys(randomAlphanumeric(10));
        signUpButton.click();
    }

    public static void enterTheFollowingData(RegistrationFormData registrationFormData) {
        sendKeys(firstName, registrationFormData.getFirstName());
        sendKeys(lastName, registrationFormData.getLastName());
        sendKeys(phone, registrationFormData.getPhone());
        sendKeys(email, registrationFormData.getEmail());
        sendKeys(password, registrationFormData.getPassword());
        drawBorder(signUpButton);
        try {
            screenshot.take();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        signUpButton.click();
    }
}