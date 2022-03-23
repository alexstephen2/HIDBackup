package RunnerPackage;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features/React.feature"
		,glue={"StepDefn"}
		,dryRun=false
		,tags={"@MainConcepts ,@AdvanceGuides ,@ScrollFunctionality"}
		)

public class TestRunner {
}
