package opencart;

import org.junit.jupiter.api.Test;

public class LoginPageTest extends OpenCartPage {
    @Test
    public void loginTest() {
        String url = String.format(BASE_URL, "account/login");
        driver.get(url);

    }
}
