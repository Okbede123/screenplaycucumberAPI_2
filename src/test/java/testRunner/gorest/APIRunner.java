package testRunner.gorest;

//import cucumber.api.CucumberOptions;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/",
                    glue = "stepDefinitions",
                    tags = "@CreateUser")
public class APIRunner {

}
