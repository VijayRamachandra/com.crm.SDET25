package com.crm.SDET25.pomrepositorylibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	WebDriver driver = null;
	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="img[title='Create Opportunity...']")
	public WebElement createOpportunity;
	
	public WebElement getCreateOpportunity() {
		return createOpportunity;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}
	
	public WebElement getSearchNowButton() {
		return searchNowButton;
	}
	
	@FindBy(linkText="Opportunities")
	public WebElement opportunitiesLink;
	
	@FindBy(css="img[title='Create Opportunity...']")
	public WebElement createOpportunityImg;

	@FindBy(linkText="Go to Basic Search")
	public WebElement advancedSearchLink;
	
	@FindBy(xpath="//b[text()='Advanced Search']/following::input[@class='crmbutton small create']")
	public WebElement searchNowButton;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateOpportunityImg() {
		return createOpportunityImg;
	}



}
