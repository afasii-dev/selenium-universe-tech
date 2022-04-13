import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static util.ApplicationProperty.get;

public class PropertyTest {

    @Test
    public void getPropertyTest() {
        String env = get("env");
        assertThat(env, notNullValue());
    }
}
