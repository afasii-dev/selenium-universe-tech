package stepdefs.phpRegistration;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import phptravels.enums.PhpFlightPage;
import phptravels.model.FlightPage;
import util.Driver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class FlightChooseStepDefs extends Driver {

    FlightPage flightPage = PageFactory.initElements(driver, FlightPage.class);

    private static final Logger logger = Logger.getLogger(FlightChooseStepDefs.class);


    @Given("^user open (.*)$")
    public void userOpenFlightPage(PhpFlightPage phpFlightPage) {
        driver.get(phpFlightPage.getUrl());
        switch (phpFlightPage) {
            case FLIGHT_PAGE -> assertThat("Title is as expected", flightPage.isFlightPage(), equalTo(true));
        }
        logger.info("user opened flight page " + phpFlightPage.getUrl());
    }

    @When("^user added destination$")
    public void userAddedDestination() throws InterruptedException {
        flightPage.addedCorrectData();
        Thread.sleep(5000);
    }

    @And("user chose round trip and dates")
    public void userChoseRoundTripAndDates() {
//        flightPage.getRoundTrip().click();
    }
}
