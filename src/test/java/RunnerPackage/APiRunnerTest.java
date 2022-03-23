package RunnerPackage;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features/API.feature"
		,glue={"APiSteps"}
		,dryRun=false
		,tags={"@coinmapget"}
		)

public class APiRunnerTest {
}
