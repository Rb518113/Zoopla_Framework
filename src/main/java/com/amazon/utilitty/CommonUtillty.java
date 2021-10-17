package com.amazon.utilitty;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.basePage.Basepage;

public class CommonUtillty extends Basepage{
	
	
	
	//Take a screen Shot method by the interface of TakeScreenshots
	public static void takeScreenshot(String fileName) throws Exception {
 //Takesscreenshot.........file.......FileHandler
		TakesScreenshot ts = (TakesScreenshot) driver;
		                // method...........output as file type
		File source = ts.getScreenshotAs(OutputType.FILE);

		//                                 // location       file name   adn png
		FileHandler.copy(source, new File("./Screenshot/" + fileName + ".png"));		
		
	}
	
	
	
	
	
	
// Method for the element to be clickable in explicit wait
	public static void explicitWait(WebElement element , long time) {
		                                   //passing driver and time
		WebDriverWait wait = new WebDriverWait(driver,time);
		     //untill(condition                        passing element
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	
	
	
	
	//Highlight the element by the JavascriptExecutor interface
	public static void highLighterMethod(WebDriver driver, WebElement element) {
		//JavascriptExecutor is a Interface           type casting
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//      method            // passing                                         and    WebElement         element
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;')", element);
		
	}
	
	
	//Mouseover by the Action interface and move to element
	public static void mouseOver(WebElement element) {
		// Actions is a interface from the selenimum and passing the driver 
		Actions act = new Actions(driver);
		// it is just moving to the element that i need to be.
		act.moveToElement(element).build().perform();
		
	}
	
	
	public static Alert alertAcceptPopUp() {
		Alert alert = driver.switchTo().alert();
		return alert;	
			
	}
	
	
	
	public static void iFrame(WebElement element) {
		driver.switchTo().frame(element);		
			
	}
	
	public static void ParentFrame() {
		driver.switchTo().defaultContent();
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
