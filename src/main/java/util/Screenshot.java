package util;

import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.time.LocalDateTime;

@AllArgsConstructor
public class Screenshot {
    private WebDriver driver;
    private static final Logger logger = Logger.getLogger(Screenshot.class);


    public void take() {
        try {
            TakesScreenshot scrShot = ((TakesScreenshot) driver);

            File scrFile = scrShot.getScreenshotAs(OutputType.FILE);

            String pathName = String.format("target/screenshots/%s.png", LocalDateTime.now());
            File destFile = new File(pathName);

            FileUtils.copyFile(scrFile, destFile);
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
}
