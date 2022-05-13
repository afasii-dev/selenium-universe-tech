package phptravels.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.Driver;

@Getter
@RequiredArgsConstructor
public class LoginPage extends Driver {

    private final String LOGIN_PAGE_TITLE = "Login - PHPTRAVELS";

    public boolean isLoginPage() {
        wait.until(ExpectedConditions.titleContains(LOGIN_PAGE_TITLE));
        return driver.getTitle().contains(LOGIN_PAGE_TITLE);
    }

//    @FindBy() LoginButton

}
