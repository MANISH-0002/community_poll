package runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Community_Poll\\Com_poll\\src\\test\\java\\feature\\com_poll.feature", glue = { "steps" }, 
plugin = {"html:target/Cucumber_Poll_report.html", "pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "timeline:test-output-thread/" },monochrome = true)

public class TestRunner {
	
}
