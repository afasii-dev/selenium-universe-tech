package stepdefs.phpRegistration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import phptravels.enums.PhpTravelsPage;
import phptravels.model.RegisterPage;
import util.Driver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PhpTravelsStepDefs extends Driver {
    RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);

    @Given("^user goes to (.*)$")
    public void userGoesToPage(PhpTravelsPage phpTravelsPage) {
        driver.get(phpTravelsPage.getUrl());
//        Thread.sleep(5000);
        switch (phpTravelsPage) {
            case REGISTER_PAGE -> assertThat("Title is as expected", registerPage.isRegisterPage(), equalTo(true));
        }
    }

    @When("^user enters the default data$")
    public void userEntersTheDefaultData() {
        registerPage.enterDefaultData();
    }

    @Then("signup is successfully")
    public void signupIsSuccessfully() {
        // TODO: implement loginpage in order to validate the title
        wait.until(ExpectedConditions.titleContains("Login - PHPTRAVELS"));
    }
}
