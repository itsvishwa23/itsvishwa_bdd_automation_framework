package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/features"},
                 glue={"stepDefination","hooks"},
                    dryRun = false,
        plugin={"pretty","html:target/cucumberReports/Report.html",
                "json:target/cucumberReports/Report.json",
                "junit:target/cucumberReports/Report.xml",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags=" @validate_login"
)
public class Runner {
}
