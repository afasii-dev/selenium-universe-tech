package stepdefs;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.apache.log4j.Logger;
import util.Driver;

public class Hooks {

    private static final Logger logger = Logger.getLogger(Hooks.class);

    @BeforeAll
    public static void beforeAll() {
        logger.info("TESTING STARTED...");
    }

    @Before(order = 1, value = "@SELENIUM")
    public void beforeEach() {
        Driver.initialize();
    }

    @AfterAll
    public static void afterAll() {
        Driver.quit();
    }
}
