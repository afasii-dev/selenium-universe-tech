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
        Driver.initialize();
    }

    @Before(order = 1)
    public void beforeEach() {
        logger.info("Restart the server..");
    }

    @Before(order = 2)
    public void cleanupDatabase() {
        logger.info("Cleanup DB...");
    }

    @AfterAll
    public static void afterAll() {
        Driver.quit();
    }
}
