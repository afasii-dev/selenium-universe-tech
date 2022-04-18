import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static util.ApplicationProperty.get;

public class SeleniumTest {

    private static ChromeDriver driver;
    private static WebDriverWait wait;

    private static String CHROME_DRIVER_PATH;
    private final static String BASE_URL = "https://www.opencart.com/index.php?route=%s";

    @BeforeAll
    static void setUp() {
        System.out.println("Before all method");
        handleOperatingSystem();

        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
    }

    private static void handleOperatingSystem() {
        CHROME_DRIVER_PATH =
                switch (System.getProperty("os.name").toLowerCase()) {
                    case "win" -> get("chrome.driver.path.windows");
                    case "linux" -> get("chrome.driver.path.linux");
                    case "mac" -> get("chrome.driver.path.mac");
                    default -> get("chrome.driver.path.default");
                };
    }

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
    public void homePageTitleTest() {
        String url = String.format(BASE_URL, "common/home");
        driver.get(url);
        String title = driver.getTitle();
        assertThat("Title is as expected", title, equalTo("OpenCart - Open Source Shopping Cart Solution"));
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
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After each method");
    }

    @AfterAll
    static void finish() {
        System.out.println("After all method");
        driver.close();
        driver.quit();
    }
}
