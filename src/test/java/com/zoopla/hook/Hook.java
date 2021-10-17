package com.zoopla.hook;

import com.amazon.basePage.Basepage;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook extends Basepage{

	
	
	@Before
	public void suiteSetup() {
		logger.info(" ");
		logger.info(" ");
		logger.info("********* Start Automation *************");
		logger.info(" ");
		logger.info(" ");
		intialization();
		
	}
	
	
	@After
    public void tearDown() {
		//logger.info("End Automation");
		//driver.close();
		//driver.quit();
		
		
	}
	
	
	
	
	
	
}
