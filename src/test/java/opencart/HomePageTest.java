package opencart;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePageTest extends OpenCartPage {

    @Test
    public void homePageTitleTest() {
        String url = String.format(BASE_URL, "common/home");
        driver.get(url);
        String title = driver.getTitle();
        assertThat("Title is as expected", title, equalTo("OpenCart - Open Source Shopping Cart Solution"));
    }
}
