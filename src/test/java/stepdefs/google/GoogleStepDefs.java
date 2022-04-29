package stepdefs.google;

import google.enums.GooglePage;
import google.model.HomePage;
import google.model.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.Driver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GoogleStepDefs extends Driver {

    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);

    @When("^user opened (.*)$")
    public void goTo(GooglePage googlePage) {
        driver.get(googlePage.getUrl());
    }

    @Then("^user is on (.*)$")
    public void userIsOn(GooglePage googlePage) {
        switch (googlePage) {
            case HOME_PAGE -> assertThat("Title is as expected", homePage.isHomePage(), equalTo(true));
            case SEARCH_PAGE -> assertThat("Title is as expected", searchPage.isSearchPage(), equalTo(true));
        }
    }

    @When("^user entered (.*) in the search field$")
    public void userEnteredValueInTheSearchField(String value) {
        homePage.getSearch().sendKeys(value);
    }

    @And("^user pressed (.*) button$")
    public void userPressedButton(Keys button) {
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(button);
    }
}
