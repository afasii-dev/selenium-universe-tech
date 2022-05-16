package stepdefs.phpRegistration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import phptravels.enums.FlightData;
import phptravels.enums.PhpFlightPage;
import phptravels.model.FlightPage;
import util.Driver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class FlightChooseStepDefs extends Driver {

    FlightPage flightPage = PageFactory.initElements(driver, FlightPage.class);


    @Given("^user open (.*)$")
    public void userOpenFlightPage(PhpFlightPage phpFlightPage) {
        driver.get(phpFlightPage.getUrl());
        switch (phpFlightPage) {
            case FLIGHT_PAGE -> assertThat("Title is as expected", flightPage.isFlightPage(), equalTo(true));
        }
    }

    @When("^user added destination$")
    public void userAddedDestination(FlightData flightData) throws InterruptedException {
        switch (flightData) {
            case SUCCESS -> {
                flightPage.addedCorrectData();
                Thread.sleep(5000);
            }
        }
    }
}