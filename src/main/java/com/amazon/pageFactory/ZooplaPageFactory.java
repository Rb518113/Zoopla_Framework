package com.amazon.pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.basePage.Basepage;

public class ZooplaPageFactory  extends Basepage{

	
	
	public ZooplaPageFactory(){
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	
	@FindBy(xpath=("(//p[contains(text(),'Sign in')])[2]"))
	@CacheLookup
	private WebElement signIn;
	
	@FindBy(id=("input-email-address"))
	@CacheLookup
	private WebElement email;
	
	@FindBy(id=("input-password"))
	@CacheLookup
	private WebElement password;
	
	@FindBy(xpath=("(//a[@href ='/for-sale/'])[1]"))
	@CacheLookup
	private WebElement forSale;
	
	@FindBy(id=("search-input-location"))
	@CacheLookup
	private WebElement searchBox;
	
	
	@FindBy(xpath=("//section[@data-testid='listing-summary-details']"))
	@CacheLookup
	private WebElement thirdPropery;
	
	
	@FindBy(xpath= ("(//a[@data-testid=\"header-profilemenu-sign-out\"])[1]"))
	@CacheLookup
	private WebElement logout;
	
	@FindBy(xpath=("(//p[text()='My Zoopla'])[1]"))
	@CacheLookup
	private WebElement MyZoopla;

	public WebElement getMyZoopla() {
		return MyZoopla;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getThirdPropery() {
		return thirdPropery;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getForSale() {
		return forSale;
	}

	public WebElement getSignIn() {
		return signIn;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}
	
	
	
	
	
	
	
	public WebElement child() {
		List<WebElement> ele= driver.findElements(By.xpath("//ul[@class='css-1t5tv1i e1lu3ugq1']//child::li"));
		
		WebElement found =null;
		
		for(WebElement newEle: ele) {
			if(newEle.getText().equals("UK property for sale")) {
				found =  newEle;
			}
			
		}
		
		return found;
		
	}
	
	
	public List<WebElement> allvalue() {
		List<WebElement> ele= driver.findElements(By.xpath("//*[@class='css-1o565rw-Text eczcs4p0']"));
		return ele;		
		
	}
	
	
	
	public WebElement specificProperty() {
		WebElement number =null;
		List<WebElement> ele= driver.findElements(By.xpath("//*[@class='css-1o565rw-Text eczcs4p0']"));
		for(int i =0; i<ele.size();i++) {
			if(i>1) {
				number = ele.get(i);
				break;
			}
			
		}
		return number;
		
	}
	
	
	
	
	
	
	
	
}
