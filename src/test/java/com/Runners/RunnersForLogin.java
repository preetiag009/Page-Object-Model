package com.Runners;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Listeners (utility.ListernersUtility.class)
@CucumberOptions(
		features= {"src/test/resources/login.feature"},
		glue= {"com.steps"},
		monochrome = true,
		dryRun = false,
		plugin = {"pretty", "html:target/cucumber.html", "json:target/json.jason"}
		//tags = "@test1"
		)

public class RunnersForLogin extends AbstractTestNGCucumberTests {

}

