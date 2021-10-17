package com.amazon.basePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Basepage {
// declaration for the webdriver object
	public static WebDriver driver;
	
	public static Properties prop; // Decration for the properties object
	public static Logger logger; // Decration for the Logger object
	
	// here is my SUpper class constructor
	public Basepage() {
		//title
		logger = Logger.getLogger("Zoopla_Looger");
		//configure property file
		PropertyConfigurator.configure("Log4j.properties"); //PropertyConfigurator  and configure method
		

		prop = new Properties();
		//location for the file                   //standard way                //locataion
		FileInputStream ip;
		
		try {
			ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/amazon/config/config.properties" );
			try {
				// for loading file
				prop.load(ip);       // prop and method load. 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	


	
	
	public static void intialization() {
		
		
		String browser = prop.getProperty("browser"); // getting value 

		if(browser.equalsIgnoreCase("Chrome")) { // one condition start
			System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
			driver = new ChromeDriver();
			
			
			
		} // one condition end
		
		
		else if(browser.equalsIgnoreCase("Firefox")) { // Two condition start
		System.setProperty("webdriver.gecko.driver", "/Applications/geckodriver");
		driver = new FirefoxDriver();
		
		}//  Two condition end
		
		
		else if(browser.equalsIgnoreCase("safari")) { // three condition start
			driver = new SafariDriver();
		
		}//  Three condition end
		
		else {
			System.out.println("No browser found!");
		
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));

		
		
	}
	
	
	
	
	
	
	
	
}
