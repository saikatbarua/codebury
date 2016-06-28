package TestConfig;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

	@RunWith(Cucumber.class)
	@CucumberOptions(
			
			features = "Features",
			glue = {"StepDefinition"},
			tags = {"@regression"},
			format = { "pretty", "html:target"}
			)

public class TestRunner {

}

