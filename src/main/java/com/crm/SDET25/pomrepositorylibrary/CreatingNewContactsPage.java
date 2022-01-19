package com.crm.SDET25.pomrepositorylibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactsPage {
	
	WebDriver driver = null;
	public CreatingNewContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	public WebElement lastNameTxtField;

	@FindBy(xpath="//b[text()='Contact Information']/preceding::input[@title='Save [Alt+S]']")
	public WebElement saveButton;
	
	public void createNewContact(String LASTNAME) {
		lastNameTxtField.sendKeys(LASTNAME);
		saveButton.click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLastNameTxtField() {
		return lastNameTxtField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
}
