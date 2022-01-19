package com.crm.SDET25.pomrepositorylibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver = null;
	public HomePage(WebDriver driver) {
		this .driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImage;

	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLink;

	public void logout() {
		administratorImage.click();
		signOutLink.click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAdministratorImage() {
		return administratorImage;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}


}
