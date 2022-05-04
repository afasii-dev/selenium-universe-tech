package opencart.model;

import io.netty.util.internal.StringUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Driver;

@Getter
@RequiredArgsConstructor
public class RegisterPage extends Driver {

    private final String REGISTER_PAGE_TITLE = "Register Account";

    private static String RANDOM_EMAIL = String.format("%s@gmail.com"RandomStringUtils.randomAlphabetic(10);
    private static String RANDOM_PHONE = RandomStringUtils.randomNumeric(10);


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
        var randomEmail =
        email.sendKeys(RANDOM_EMAIL);
        password.sendKeys("1234567");
        passwordConfirm.sendKeys("1234567");
        agreeCheckbox.click();
        continueButton.click();
    }

}