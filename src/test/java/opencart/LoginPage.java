package opencart;

import org.junit.jupiter.api.Test;

public class LoginPage extends OpenCartPage {
    @Test
    public void loginTest() {
        String url = String.format(BASE_URL, "account/login");
        driver.get(url);

    }
}
