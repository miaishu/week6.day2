package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;


@CucumberOptions(features="src/test/java/feature1/ServiceNowAssignAssign.feature",glue= "steps_ServiceNow", monochrome = true, dryRun=false,snippets= SnippetType.CAMELCASE, publish=true)
public class ServiceNow_Runner_Assign extends AbstractTestNGCucumberTests {
	//It can be run with getter and setter methods only.
	
	//@DataProvider
	//public Object[][] scenarios() {
		//return super.scenarios();
	}
	


