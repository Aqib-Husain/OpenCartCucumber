package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Features//Registration.feature"},
		glue="stepDefinitions",
		plugin = {"pretty",
				"html:Report/report.html",
				},
		dryRun = false,
		monochrome = true,
		tags="@Sanity"
		
		)
public class TestRunner {

}
