package util;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Driver {

    public static ChromeDriver driver = null;
    public static WebDriverWait wait = null;

    public static void initialize() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver();
        }
        //Perform Basic Operations
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
    }

    public static void quit() {
        driver.close();
        driver.quit();
        driver = null; // we destroy the driver object after quit operation
    }

    public static void openUrl(String url) {
        driver.get(url);
    }
}
