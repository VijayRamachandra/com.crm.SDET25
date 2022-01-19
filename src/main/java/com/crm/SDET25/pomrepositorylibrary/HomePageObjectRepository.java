package com.crm.SDET25.pomrepositorylibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjectRepository {
	
	public void homePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(linkText="Opportunities")
		public WebElement opportunitiesModule;
		
	}
