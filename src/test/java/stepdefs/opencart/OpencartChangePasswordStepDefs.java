package stepdefs.opencart;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import opencart.model.ChangePasswordPage;
import opencart.model.LoginPage;
import opencart.model.MyAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Driver;


public class OpencartChangePasswordStepDefs extends Driver {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
    ChangePasswordPage changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);


    @Given("^Log in account page is displayed$")
    public void logInAccountPageIsDisplayed() {
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        loginPage.isLoginPage();
        loginPage.enterLoginData();
    }

    @And("Change Password page is displayed")
    public void changePasswordIsOpened() {
        changePasswordPage.isChangePasswordPage();
    }

    @When("^user entered the default data password$")
    public void userEntersTheDefaultDataPassword() throws InterruptedException {
        changePasswordPage.enterNewPassword();
        Thread.sleep(3000);
    }

    @Then("^success! Password is changed$")
    public void successPasswordIsDisChanged() {
       wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("fa-check-circle"), " Success: Your password has been successfully updated."));
    }

    @And("My account page is displayed")
    public void myAccountPageIsDisplayed() {
        myAccountPage.isMyAccountPage();
    }

    @When("user clicked password")
    public void userClickedPassword() {
        myAccountPage.getPassword().click();
    }
}
