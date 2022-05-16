
package phptravels.model;

import lombok.Getter;
import org.openqa.selenium.By;
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

    @FindBy(id = "departure")
    private static List<WebElement> departureDate;

    @FindBy(id = "return")
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
        driver.findElement(By.id("departure")).click();
        while (!driver.findElement(By.xpath("//th[@class = 'switch']")).getText().contains("June 2022")) {
        driver.findElement(By.xpath("//i[@class = 'icon mdi mdi-long-arrow-right']")).click();
     }
     int count = driver.findElements(By.xpath("//a[@class = 'day  active']")).size();
        for (int i=0; i<count; i++) {
            String text = driver.findElements(By.xpath("//a[@class = 'day  active']")).get(i).getText();
            if (text.equalsIgnoreCase("6")) {
                driver.findElements(By.xpath("//a[@class = 'day  active']")).get(i).click();
                Thread.sleep(3000);
            }
        }
        driver.findElement(By.id("return"));
        while (!driver.findElement(By.xpath("//th[@class = 'switch']")).getText().contains("June 2022"));                   }
        int count = driver.findElements(By.xpath("//a[@class = 'day  active']")).size();
        for (int i=0; i<count; i++) {
            String text = driver.findElements(By.xpath("//a[@class = 'day  active']")).get(i).getText();
            if (text.equalsIgnoreCase("6")) {
                driver.findElements(By.xpath("//a[@class = 'day  active']")).get(i).click();
                Thread.sleep(3000);
            }
        }
//        searchButton.click();

}
}

