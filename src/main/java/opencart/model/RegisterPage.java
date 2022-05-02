package opencart.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Driver;

@Getter
@RequiredArgsConstructor
public class RegisterPage extends Driver {

    private final String REGISTER_PAGE_TITLE = "Register Account";


    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(name = "telephone")
    private WebElement phone;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "confirm")
    private WebElement passwordConfirm;

    @FindBy(name = "agree")
    private WebElement agreeCheckbox;

    @FindBy(className = "btn-primary")
    private WebElement continueButton;

    public boolean isRegisterPage() {
        wait.until(ExpectedConditions.titleContains(REGISTER_PAGE_TITLE));
        return driver.getTitle().contains(REGISTER_PAGE_TITLE);
    }

    public void enterDefaultData() {
        firstName.sendKeys("Maxim");
        lastName.sendKeys("Pupkin");
        phone.sendKeys("9898432415");
        email.sendKeys("qwerty123jj@gmail.com");
        password.sendKeys("1234567");
        passwordConfirm.sendKeys("1234567");
        agreeCheckbox.click();
        continueButton.click();
    }

}