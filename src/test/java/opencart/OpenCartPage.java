package opencart;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.OSEnum;

import java.util.concurrent.TimeUnit;

import static util.ApplicationProperty.get;
import static util.OSEnum.*;

public class OpenCartPage {
    public static ChromeDriver driver;
    public static WebDriverWait wait;

    private static String CHROME_DRIVER_PATH;
    public final static String BASE_URL = "https://www.opencart.com/index.php?route=%s";

    @BeforeAll
    static void setUp() {
        System.out.println("STARTING THE TESTS...");
        handleOperatingSystem();

        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
    }

    private static void handleOperatingSystem() {
        CHROME_DRIVER_PATH =
                switch (getOS()) {
                    case WINDOWS -> get("chrome.driver.path.windows");
                    case LINUX -> get("chrome.driver.path.linux");
                    case MAC -> get("chrome.driver.path.mac");
                };
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

    @AfterAll
    static void finish() {
        System.out.println("FINISH");
        driver.close();
        driver.quit();
    }
}
