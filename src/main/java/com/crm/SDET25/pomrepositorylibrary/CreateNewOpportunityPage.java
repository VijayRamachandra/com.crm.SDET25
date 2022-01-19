package com.crm.SDET25.pomrepositorylibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.SDET25.genericUtility.WebDriverUtility;

public class CreateNewOpportunityPage {
	
	WebDriver driver = null;
	public CreateNewOpportunityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOpportunityNameTxtField() {
		return opportunityNameTxtField;
	}

	public WebElement getRelatedToDropDown() {
		return relatedToDropDown;
	}

	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public WebElement getAddContactImg() {
		return addContactImg;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	@FindBy(name="potentialname")
	public WebElement opportunityNameTxtField;
	
	@FindBy(id="related_to_type")
	public WebElement relatedToDropDown;
	
	@FindBy(name="closingdate")
	public WebElement expectedCloseDate;
	
	@FindBy(xpath="//td[text()='Next Step ']/preceding::img[@title='Select']")
	public WebElement addContactImg;
	
	@FindBy(xpath="//b[text()='Opportunity Information:']/preceding::input[@title='Save [Alt+S]']")
	public WebElement saveButton;
	
	public void fillMandatoryFields(String opportunityName, String expCloseDate) {
		opportunityNameTxtField.sendKeys(opportunityName);
		expectedCloseDate.clear();
		expectedCloseDate.sendKeys(expCloseDate);
		relatedToDropDown.click();
		WebDriverUtility wd = new WebDriverUtility();
		wd.selectVisible(relatedToDropDown, "Contacts");
		addContactImg.click();	
	}

}
