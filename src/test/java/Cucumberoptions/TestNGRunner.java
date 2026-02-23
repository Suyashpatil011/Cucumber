package Cucumberoptions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;     // ✔ CORRECT (TestNG)

@CucumberOptions(
        features = "src/test/java/features",
        glue = "StepDefinitions",
        monochrome = true,
        dryRun = false
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
}