
package phptravels.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Driver;

import java.util.List;

public class FlightPage extends Driver {

    private final String FLIGHTS_PAGE = "Search Hotels - PHPTRAVELS";

//    @FindBy(name = "trip")
//    private static WebElement roundTrip;

    @FindBy(name = "from")
    private static WebElement flyingFrom;

    @FindBy(name = "to")
    private static WebElement toDestination;

    @FindBy(id = "departure")
    private static List<WebElement> departureDate;

    @FindBy(id = "return")
    private static List<WebElement> returnDate;

    @FindBy(className = "guest_flights d-block text-center")
    private static List<WebElement> passengers;

    @FindBy(className = "ladda-label")
    public static WebElement searchButton;

    public boolean isFlightPage() {
        wait.until(ExpectedConditions.titleContains(FLIGHTS_PAGE));
        return driver.getTitle().contains(FLIGHTS_PAGE);
    }



    public void addedCorrectData(){
        sendKeys(flyingFrom, "Dushanbe");
        sendKeys(toDestination, "Chisinau");
        sendKeys((WebElement) departureDate, "19-05-2022");
        sendKeys((WebElement) returnDate, "31-05-2022");
        sendKeys((WebElement) passengers, "2");
        searchButton.click();

    }


}
