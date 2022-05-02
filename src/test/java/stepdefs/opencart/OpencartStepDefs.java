package stepdefs.opencart;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import opencart.model.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Driver;


public class OpencartStepDefs extends Driver {
    RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);

    @Given("REGISTER_PAGE is opened")
    public void register_pageIsOpened() {
        driver.get("https://demo.opencart.com/index.php?route=account/register");
        registerPage.isRegisterPage();
    }

    @When("^user entered the default data$")
    public void userEntersTheDefaultData() throws InterruptedException {
        registerPage.enterDefaultData();
        Thread.sleep(3000);
    }

    @Then("success message is displayed")
    public void successMessageIsDisplayed() {
//        WebElement successMessage = driver.findElement(By.className("col-sm-9"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("col-sm-9"), "Your Account Has Been Created!"));
    }

}
