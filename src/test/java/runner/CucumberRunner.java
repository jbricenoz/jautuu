package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features = "Feature"
		,glue={"glue"}
		)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
