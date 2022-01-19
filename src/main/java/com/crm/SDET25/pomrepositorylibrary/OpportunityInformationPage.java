package com.crm.SDET25.pomrepositorylibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInformationPage {
	
	WebDriver driver = null;
	public OpportunityInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	public WebElement opportunityInfo;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOpportunityInfo() {
		return opportunityInfo;
	}
	
	

}
