package com.amazon.utilitty;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amazon.basePage.Basepage;

public class ExplicitWaitZoopla extends Basepage {

	
	public static void explicitWait(WebElement element , long time) {
		
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	
		
		
	}
	
	
	
	
	
}
