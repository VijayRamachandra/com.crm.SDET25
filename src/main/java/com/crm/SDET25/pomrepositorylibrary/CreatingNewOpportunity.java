package com.crm.SDET25.pomrepositorylibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOpportunity {
	public void creatingNewOpportunity(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="potentialname")
	public WebElement opportunityName;
	
	@FindBy(id="related_to_type")
	public WebElement relatedTo;
	
	@FindBy(name="closingdate")
	public WebElement expectedCloseDate;
	
	@FindBy(xpath="//td[text()='Next Step ']/preceding::img[@title='Select']")
	public WebElement selectOrg;
	
	@FindBy(xpath="//b[text()='Opportunity Information:']/preceding::input[@title='Save [Alt+S]']")
	public WebElement saveButton;
	
	
}
