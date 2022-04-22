package cucumber.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MyStepdefs {

    private ChromeDriver driver;
    private WebDriverWait wait;

    @When("user opened google.com")
    public void userOpenedGoogleCom() {
        driver.get("https://www.google.com/");
        String expectedTitle = "Google";
        wait.until(ExpectedConditions.titleContains(expectedTitle));
        assertThat("Title is as expected", driver.getTitle(), equalTo(expectedTitle));
    }

    @When("^user entered (.*) in the search field$")
    public void userEnteredValueInTheSearchField(String value) {
        WebElement searchField = driver.findElementByName("q");
        searchField.sendKeys(value);
    }

    @And("^user pressed (.*) button$")
    public void userPressedButton(Keys button) {
        WebElement searchField = driver.findElementByName("q");
        searchField.sendKeys(button);
    }

    @Then("user has been redirected to another page")
    public void userHasBeenRedirectedToAnotherPage() {
        String expectedUrlPiece = "search";
        wait.until(ExpectedConditions.urlContains(expectedUrlPiece));
        assertThat("Title is as expected", driver.getCurrentUrl(), containsStringIgnoringCase(expectedUrlPiece));
    }

    @When("user clicked btnI button")
    public void userClickedBtnIButton() {
        driver.findElementByName("btnI").click();
    }

    @Given("^Init driver$")
    public void driverInit() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);
    }

    @And("^Close browser$")
    public void closeBrowser() {
        driver.close();
        driver.quit();
    }
}
