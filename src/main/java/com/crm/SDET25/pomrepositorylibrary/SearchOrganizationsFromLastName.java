package com.crm.SDET25.pomrepositorylibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.SDET25.genericUtility.WebDriverUtility;

public class SearchOrganizationsFromLastName {
	
	WebDriver driver = null;
	public SearchOrganizationsFromLastName(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Contacts")
	public WebElement contactsButton;
	
	@FindBy(css="img[title='Create Contact...']")
	public WebElement createContactImg;
	
	@FindBy(id="search_txt")
	public WebElement contactSearchTxtField;
	
	@FindBy(name="search")
	public WebElement searchNowButton;
	
	public WebElement getContactSearchTxtField() {
		return contactSearchTxtField;
	}
	public WebElement getSearchNowButton() {
		return searchNowButton;
	}
	public WebElement getContactsButton() {
		return contactsButton;
	}
	
	public WebElement getCreateContactImg() {
		return createContactImg;
	}
	
	public void searchLastName(String LASTNAME) {
		WebDriverUtility wd = new WebDriverUtility();
		wd.switchToWindow(driver, "Contacts");
		contactSearchTxtField.sendKeys(LASTNAME);
		searchNowButton.click();
		driver.findElement(By.linkText(LASTNAME)).click();
		wd.switchToWindow(driver, "Potentials");
	}

	}

