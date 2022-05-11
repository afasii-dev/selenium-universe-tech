package opencart.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Driver;
import util.RandomStringUtils;

public class ChangePasswordPage extends Driver {
    private final String CHANGE_PASSWORD_PAGE_TITLE = "Change Password";

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "confirm")
    private WebElement confirm;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
    private WebElement continueButton;

    public boolean isChangePasswordPage() {
        wait.until(ExpectedConditions.titleContains(CHANGE_PASSWORD_PAGE_TITLE));
        return driver.getTitle().contains(CHANGE_PASSWORD_PAGE_TITLE);
    }

    public void enterNewPassword() {
        String randomPassword = RandomStringUtils.getRandomNumeric(8);
        password.sendKeys(randomPassword);
        confirm.sendKeys(randomPassword);
        continueButton.click();
    }
}
