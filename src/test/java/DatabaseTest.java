import model.Database;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static model.Database.DATABASE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class DatabaseTest {

    @BeforeAll
    static void setUp() {
        System.out.println("Testing started.");
        Database.cleanup();
    }

    @Test
    public void testSaveMethod() {
        Database.save("BBL");
        Database.save("Rustam");
        int expectedSize = 2;
        int actualSize = DATABASE.size();
        assertThat("Database size is " + expectedSize, actualSize, equalTo(expectedSize));
    }

    @Test
    public void testGetElementMethod() {
        String expectedName = "BBL";
        Database.save(expectedName);
        String name = Database.get(0);
        assertThat("Object is not null ", name, notNullValue());
        assertThat("Name is as expected", name, equalTo(expectedName));
    }

    @AfterAll
    static void finish() {
        System.out.println("Testing completed.");
    }

}
