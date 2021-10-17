package com.amazon.stepdef;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import com.amazon.basePage.Basepage;
import com.amazon.pageFactory.ZooplaPageFactory;
import com.amazon.utilitty.ExplicitWaitZoopla;
import com.amazon.utilitty.HighLight;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;


public class Stepdef extends Basepage{
	
	
	 ZooplaPageFactory pf;
	
	
	@Given("^Users is able to verify login information successfully$")
	public void users_is_able_to_verify_login_information_successfully() throws Throwable {
		pf = PageFactory.initElements(driver, ZooplaPageFactory.class);
	    logger.info("Users is able to verify login information successfully");
	    HighLight.highLighterMethod(driver, pf.getSignIn());
	    ExplicitWaitZoopla.explicitWait(pf.getSignIn(), 7);
	    
	    pf.getSignIn().click();
	    
	    HighLight.highLighterMethod(driver, pf.getEmail());
	    ExplicitWaitZoopla.explicitWait(pf.getEmail(), 7);
	    
	    pf.getEmail().sendKeys(prop.getProperty("Email"));
	    
	    HighLight.highLighterMethod(driver, pf.getPassword());
	    
	    ExplicitWaitZoopla.explicitWait(pf.getPassword(), 7);
	    
	    pf.getPassword().sendKeys(prop.getProperty("Password"));
	    pf.getPassword().sendKeys(Keys.ENTER);
	    
	    Thread.sleep(3000);
	    Assert.assertEquals(prop.getProperty("landingPageTitle"), driver.getTitle());
	    Assert.assertTrue(true);
	  
	}

	@When("^Users can hover over the page on the For Sale module and click on the UK Property For Sale$")
	public void users_can_hover_over_the_page_on_the_For_Sale_module_and_click_on_the_UK_Property_For_Sale() throws Throwable {
		 logger.info("Users can hover over the page on the For Sale module and click on the UK Property For Sale");
		Actions act = new Actions(driver);
	    act.moveToElement(pf.getForSale()).build().perform();
	    Thread.sleep(5000);
	    HighLight.highLighterMethod(driver,  pf.child());
	    ExplicitWaitZoopla.explicitWait( pf.child(), 7);
	    pf.child().click();
	    
	    
	}

	@When("^Users is able to enter location- \"([^\"]*)\"- in the text box & hit enter button$")
	public void users_is_able_to_enter_location_in_the_text_box_hit_enter_button(String Adrress) throws Throwable {
		logger.info("Users is able to enter location in the text box & hit enter button");
		HighLight.highLighterMethod(driver, pf.getSearchBox());
	    ExplicitWaitZoopla.explicitWait( pf.getSearchBox(), 7);
	    pf.getSearchBox().sendKeys(Adrress);
	    pf.getSearchBox().sendKeys(Keys.ENTER);
	  
	}

	@When("^Users is able to print all value/price of the properties in the console$")
	public void users_is_able_to_print_all_value_price_of_the_properties_in_the_console() throws Throwable {
		logger.info("Users is able to print all value/price of the properties in the console");
		System.out.println(" Number of value/price of the properties: "+ pf.allvalue().size());
	    for(WebElement ele: pf.allvalue()) {
	    	System.out.println(ele.getText());
	    }
	  
	}

	@When("^click on the third property from the properties list$")
	public void click_on_the_third_property_from_the_properties_list() throws Throwable {
		logger.info("click on the third property from the properties list");
		HighLight.highLighterMethod(driver, pf.specificProperty());
	    ExplicitWaitZoopla.explicitWait( pf.specificProperty(), 7); 
	    pf.specificProperty().click();
	   
	  
	}

	@When("^Users is able to print out the selected property details$")
	public void users_is_able_to_print_out_the_selected_property_details() throws Throwable {
		logger.info("Users is able to print out the selected property details");
	   System.out.println(pf.getThirdPropery().getText()); 
	  
	}

	@Then("^Users can Verify the price of the selected property$")
	public void users_can_Verify_the_price_of_the_selected_property() throws Throwable {
		logger.info("Users can Verify the price of the selected property");
		String Price = prop.getProperty("Price");
	   if(pf.getThirdPropery().getText().contains(Price) && !Price.isEmpty()) {
		   Assert.assertTrue(true);
	   }
	   else {
		   Assert.assertTrue(false);
	   }
	}

	@Then("^User is able to logout the application$")
	public void user_is_able_to_logout_the_application() throws Throwable {
		logger.info("User is able to logout the application");
		HighLight.highLighterMethod(driver, pf.getLogout());
	   //ExplicitWaitZoopla.explicitWait(pf.getLogout(), 7); 
		//Actions act= new Actions(driver);
		//act.moveToElement(pf.getMyZoopla()).build().perform();
	//	pf.getLogout().click();
	  
	}


	
	
	
	
}
