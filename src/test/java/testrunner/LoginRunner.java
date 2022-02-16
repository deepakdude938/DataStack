package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= {"D:\\MaheshWorkSpace\\MaheshMavenProject\\src\\test\\java\\firstproject\\LogIn3.feature"},
		glue ={"stepdefinitions"},
				strict = true,
				monochrome=true,
				//dryRun=true,
		plugin= {"pretty"}
		
         )
public class LoginRunner {

}
