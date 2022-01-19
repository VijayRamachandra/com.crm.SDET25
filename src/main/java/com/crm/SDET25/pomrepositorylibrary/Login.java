package com.crm.SDET25.pomrepositorylibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver driver=null;
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	@FindBy(name="user_name")
	public WebElement username;
	
	@FindBy(name="user_password")
	public WebElement password;
	
	@FindBy(id="submitButton")
	public WebElement loginButton;

	
	public void loginToApplication(String URL, String USERNAME, String PASSWORD) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		loginButton.click();
	}
}
