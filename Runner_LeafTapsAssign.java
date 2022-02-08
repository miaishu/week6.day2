package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;


@CucumberOptions(features="src/test/java/feature/LeafTapsAssign.feature"
,glue="steps_LeafTapsAssign",monochrome=true,dryRun=false,snippets=SnippetType.CAMELCASE,tags="@EditLead or @CreateLead")

public class Runner_LeafTapsAssign extends AbstractTestNGCucumberTests {

}
