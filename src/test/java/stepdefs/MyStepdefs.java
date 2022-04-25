package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObject.enums.Page;
import pageObject.google.model.HomePage;
import pageObject.google.model.SearchPage;
import util.Driver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MyStepdefs extends Driver {

    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);

    @When("^user opened (.*)$")
    public void goTo(Page page) {
        driver.get(page.getUrl());
    }

    @Then("^user is on (.*)$")
    public void userIsOn(Page page) {
        switch (page) {
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
        WebElement searchField = driver.findElementByName("q");
        searchField.sendKeys(button);
    }
}
