package phptravels.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Driver;

import java.util.List;

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
        phone.sendKeys("9898432415");
        email.sendKeys("usertest@gmail.com");
        password.sendKeys("1234567");
        signUpButton.click();

    }

}