package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue={"steps","hooks"},
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"}
)

public class RunnerTest {
}
