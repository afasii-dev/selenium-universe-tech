package pageObject.google.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Getter
@RequiredArgsConstructor
public class HomePage extends BasePage {

    private final String HOME_PAGE_TITLE = "Google";


    @FindBy(xpath = "//*[@name='q']")
    private WebElement search;

    public boolean isHomePage() {
        wait.until(ExpectedConditions.titleContains(HOME_PAGE_TITLE));
        return driver.getTitle().contains(HOME_PAGE_TITLE);
    }

}