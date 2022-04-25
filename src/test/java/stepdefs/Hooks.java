package stepdefs;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import util.Driver;

public class Hooks {

    @BeforeAll
    public static void beforeAll() {
        Driver.initialize();
    }

    @Before(order = 1)
    public void beforeEach() {
        System.out.println("Restart the server  1");
    }

    @Before(order = 2)
    public void cleanupDatabase() {
        System.out.println("Cleanup DB...");
    }

    @AfterAll
    public static void afterAll() {
        Driver.quit();
    }
}
