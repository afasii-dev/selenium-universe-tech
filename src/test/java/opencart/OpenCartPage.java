package opencart;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static util.ApplicationProperty.get;

public class OpenCartPage {
    public static ChromeDriver driver;
    public static WebDriverWait wait;

    private static String CHROME_DRIVER_PATH;
    public final static String BASE_URL = "https://www.opencart.com/index.php?route=%s";

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

    @AfterAll
    static void finish() {
        System.out.println("After all method");
        driver.close();
        driver.quit();
    }
}
