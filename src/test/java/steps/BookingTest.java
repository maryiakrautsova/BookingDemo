package steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/feature"},
        publish = true,
        glue = "steps",
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json"}
)
public class BookingTest extends AbstractTestNGCucumberTests {
}

