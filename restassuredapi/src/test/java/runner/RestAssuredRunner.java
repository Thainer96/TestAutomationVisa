package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/featurerest",
        glue = {"stepDefinitions","hooks"},
        plugin = {"pretty", "summary", "html:target/cucumber-report.html"},
        tags = "@createuser"
)
public class RestAssuredRunner {}
