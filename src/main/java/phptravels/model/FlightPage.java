
package phptravels.model;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Driver;

@Getter

public class FlightPage extends Driver {

    private final String FLIGHTS_PAGE = "Search Hotels - PHPTRAVELS";

    @FindBy(id = "round-trip")
    private WebElement roundTrip;

    @FindBy(name = "from")
    private static WebElement flyingFrom;

    @FindBy(name = "to")
    private static WebElement toDestination;

    @FindBy(id = "departure")
    private static WebElement departureCalendar;

    @FindBy(id = "return")
    private static WebElement returnCalendar;

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

        departureCalendar.click();
        WebElement departureDate = driver.findElement(By.xpath("//*[@class = 'day '][text() = '19']"));
        departureDate.click();

//        while (!driver.findElement(By.xpath("//th[@class = 'switch']")).getText().contains("June 2022")) {
//            driver.findElement(By.xpath("//i[@class = 'icon mdi mdi-long-arrow-right']")).click();
//        }

        try {
            WebElement returnDate = driver.findElement(By.xpath("//*[@class = 'day '][text() = '24'][0]"));
//            Actions action = new Actions(driver);
//            action.moveToElement(returnDate).build().perform();
            returnDate.click();
            Thread.sleep(5000);
        } catch (Exception e) {
            Thread.sleep(5000);
        }
    }
}
