package cucumberOptions;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/features/Login.feature", glue = {"stepDefinitions"})

public class TestRunner extends AbstractTestNGCucumberTests {
}
