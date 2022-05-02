package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature"
        , glue = "stepdefs"
        , tags = "@OpencartRegistration"
        , plugin =
        {"pretty"
                , "html:target/cucumber-reports/html/Report.html"
                , "json:target/cucumber-reports/json/Report.json"
                , "junit:target/cucumber-reports/xml/Report.xml"
        }
)
public class CucumberRunner {
}
