
package phptravels.model;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Driver;

import java.util.List;

@Getter

public class FlightPage extends Driver {

    private final String FLIGHTS_PAGE = "Search Hotels - PHPTRAVELS";

    @FindBy(id = "round-trip")
    private WebElement roundTrip;

    @FindBy(name = "from")
    private static WebElement flyingFrom;

    @FindBy(name = "to")
    private static WebElement toDestination;

    @FindBy(className = "day")
    private static List<WebElement> departureDate;

    @FindBy(className = "day")
    private static List<WebElement> returnDate;

//    @FindBy(className = "guest_flights d-block text-center")
//    private static List<WebElement> passengers;

    @FindBy(className = "ladda-label")
    private static WebElement searchButton;

    public boolean isFlightPage() {
        wait.until(ExpectedConditions.titleContains(FLIGHTS_PAGE));
        return driver.getTitle().contains(FLIGHTS_PAGE);
    }



    public void addedCorrectData() throws InterruptedException {
        sendKeys(flyingFrom, "Dushanbe");
        sendKeys(toDestination, "Chisinau");
        roundTrip.click();
        Thread.sleep(3000);
//        sendKeys((WebElement) departureDate, "19-05-2022");
//        sendKeys((WebElement) returnDate, "31-05-2022");
//        sendKeys((WebElement) passengers, "2");
//        searchButton.click();

    }


}
