package pageObject.google.model;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Driver;

public class BasePage {
    public static ChromeDriver driver = Driver.driver;
    public static WebDriverWait wait = Driver.wait;
}
