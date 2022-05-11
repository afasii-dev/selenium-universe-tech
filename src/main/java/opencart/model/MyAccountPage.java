package opencart.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Driver;

@Getter
@RequiredArgsConstructor
public class MyAccountPage extends Driver {
    private final String MY_ACCOUNT_PAGE_TITLE = "My Account";

    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[3]")
    private WebElement password;


    public boolean isMyAccountPage() {
        wait.until(ExpectedConditions.titleContains(MY_ACCOUNT_PAGE_TITLE));
        return driver.getTitle().contains(MY_ACCOUNT_PAGE_TITLE);
    }
}
