package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Driver;

import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MyStepdefs extends Driver {

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
}
