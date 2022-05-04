package stepdefs.phpRegistration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import phptravels.enums.DataType;
import phptravels.enums.PhpTravelsPage;
import phptravels.enums.Status;
import phptravels.model.LoginPage;
import phptravels.model.RegisterPage;
import util.Driver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PhpTravelsStepDefs extends Driver {
    RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    @Given("^user goes to (.*)$")
    public void userGoesToPage(PhpTravelsPage phpTravelsPage) {
        driver.get(phpTravelsPage.getUrl());
//        Thread.sleep(5000);
        switch (phpTravelsPage) {
            case REGISTER_PAGE -> assertThat("Title is as expected", registerPage.isRegisterPage(), equalTo(true));
        }
    }

    @When("^user enters the (.*) data$")
    public void userEntersTheDefaultData(DataType dataType) {
        switch (dataType) {
            case DEFAULT -> registerPage.enterDefaultData();
            case CUSTOM -> registerPage.enterWrongData();
        }
    }

    @Then("^signup is (.*)$")
    public void signupIs(Status status) {
        switch (status) {
            case SUCCESS -> loginPage.isLoginPage();
            case FAILED -> registerPage.isRegisterPage();
        }
    }
}
