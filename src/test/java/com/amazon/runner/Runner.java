package com.amazon.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		// Feature file location
		features = "./Features",
		// step def and hook class location
		glue={"com.amazon.stepdef","com.zoopla.hook"},
		//report type
		plugin= {"pretty","json:target/cucumber.json"},
		//
		dryRun = false,
		//for read console clear
		monochrome = true,
		
		//for which test case I need to exucte
		tags = "@Sanity"
		
		
		)



// extend for run this ruuner class with the testNG

public class Runner extends AbstractTestNGCucumberTests {

}
