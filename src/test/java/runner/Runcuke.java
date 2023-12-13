package runner;


//import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", 
		glue = {"stepDef"},
		tags = "@LoginTest",
		dryRun=false,
		monochrome= true,
		plugin = {"pretty","html:target/HTML Reports/report.html"}	
)

@Test
public class Runcuke  extends AbstractTestNGCucumberTests {

}
