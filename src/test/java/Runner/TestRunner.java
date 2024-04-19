package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Users\\RaviTejaKorati\\IdeaProjects\\APITestingJava\\src\\main\\resources\\Tags_Features",
glue = {"StepDefinitions"},
plugin = {"pretty", "html :target/cucumber-reports/Report"},
monochrome = true

)

public class TestRunner {


}
