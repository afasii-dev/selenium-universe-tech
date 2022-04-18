package opencart;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegisterPage extends OpenCartPage {

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each method");
    }

    @Test
    public void registerPageTitleTest() {
        String url = String.format(BASE_URL, "account/register");
        driver.get(url);
        String title = driver.getTitle();
        assertThat("Title is as expected", title, equalTo("OpenCart - Account Register"));
    }

    @Test
    public void getCountriesListTest() {
        String url = String.format(BASE_URL, "account/register");
        driver.get(url);
        List<WebElement> countryId = driver.findElementsByXPath("//option[@value!=\'\']");
        countryId.forEach(e -> System.out.println(e.getText()));
        int expectedSize = 241;
        int actualSize = countryId.size();
        assertThat("Array size is as expected", actualSize, equalTo(expectedSize));
    }

    @Test
    public void registrationTest() {
        String url = String.format(BASE_URL, "account/register");
        driver.get(url);
        WebElement username = driver.findElement(By.name("username"));
        WebElement firstname = driver.findElement(By.name("firstname"));
        WebElement lastname = driver.findElement(By.name("lastname"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("password"));
        List<WebElement> countries = driver.findElementsByTagName("option");
        WebElement tadjikistanCountry = driver.findElementByXPath("//option[@value=207]");
        WebElement clickButton = driver.findElement(By.xpath("//*[@id=\"button-register\"]/button[1]"));

        username.sendKeys("username");
        firstname.sendKeys("firstname");
        lastname.sendKeys("lastname");
        email.sendKeys("email@gmail.com");
        password.sendKeys("123456");
        tadjikistanCountry.click();

//        //wait until captcha is resolved
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\'bg-success\']")));
        clickButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='alert alert-danger']")));
        WebElement alert = driver.findElement(By.xpath("//*[@class='alert alert-danger']"));
        assertThat("Wrong email text is present", alert.getText(), containsString("Error: E-Mail Address is already registered!"));
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After each method");
    }

}
