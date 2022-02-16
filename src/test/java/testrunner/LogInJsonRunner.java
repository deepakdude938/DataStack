package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"D:\\MaheshWorkSpace\\MaheshMavenProject\\testcases\\string.feature"},
		glue ={"stepdefinitions"},
				strict = true,
				monochrome=true,
				//dryRun=true,
		plugin= {"pretty"}
		
         )
public class LogInJsonRunner {

}
