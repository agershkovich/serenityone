package runTests;//Info: File should be in package that we specified in failsafe maven plugin
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features={"src/test/resources/features"},
    glue = { "stepDefinitions" },
    plugin = {"pretty", "html:target/cucumber-html-report"})
public class GoogleSearchTests {}