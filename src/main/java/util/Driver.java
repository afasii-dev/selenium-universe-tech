package util;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static util.ApplicationProperty.get;
import static util.OSEnum.*;

public class Driver {

    public static ChromeDriver driver = null;
    public static WebDriverWait wait = null;

    public static Screenshot screenshot = null;

    private static String CHROME_DRIVER_PATH;

    private static final Logger logger = Logger.getLogger(Driver.class);

    public static void initialize() {
        if (driver == null) {
            handleOperatingSystem();
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
            logger.info("Driver is initialized...");
        }

        //Perform Basic Operations
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15L));
        screenshot = new Screenshot(driver);
    }

    private static void handleOperatingSystem() {
        CHROME_DRIVER_PATH =
                switch (getOS()) {
                    case WINDOWS -> get("chrome.driver.path.windows");
                    case LINUX -> get("chrome.driver.path.linux");
                    case MAC -> get("chrome.driver.path.mac");
                };
        logger.info("Chrome driver path: " + CHROME_DRIVER_PATH);
    }

    private static OSEnum getOS() {
        var osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("win")) {
            return WINDOWS;
        } else if (osName.contains("linux")) {
            return LINUX;
        } else if (osName.contains("mac")) {
            return MAC;
        } else {
            throw new IllegalArgumentException("OS UNSUPPORTED");
        }
    }

    public static void quit() {
        driver.close();
        driver.quit();
        driver = null; // we destroy the driver object after quit operation
    }

    public static void sendKeys(WebElement webElement, String keysToSend) {
        drawBorder(webElement);
        webElement.sendKeys(keysToSend);
    }

    public static WebElement drawBorder(WebElement webElement) {
        JavascriptExecutor js = driver;
        js.executeScript("arguments[0].style.border='3px solid red'", webElement);
        return webElement;
    }
}