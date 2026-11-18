package project.ApexGlobal.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    // Path to your feature files
    features = "src/test/resources/project/ApexGlobal/Features/BillPaymentFunctionality.feature",
    
    // Package where your step definition classes live
    glue = {"project.ApexGlobal.StepDefinitions","project.ApexGlobal.Hooks"},
    
    // Report formatting options
    plugin = {
        "pretty",
        "html:target/cucumber-reports/testng-cucumber.html",
    },    
    // true = verify steps match definitions without running code; false = run tests normally
    dryRun = false,    
    // Makes console log output easier to read
    monochrome = true
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    
    // Optional: Enable parallel execution by overriding the scenarios data provider
//    @Override
//   @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}
