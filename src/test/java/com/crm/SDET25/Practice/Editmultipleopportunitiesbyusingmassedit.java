package com.crm.SDET25.Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.SDET25.genericUtility.ExcelUtility;
import com.crm.SDET25.genericUtility.FileUtility;
import com.crm.SDET25.genericUtility.JavaUtility;
import com.crm.SDET25.genericUtility.WebDriverUtility;

public class Editmultipleopportunitiesbyusingmassedit {

	@Test
	public void editmultipleopportunitiesbyusingmassedit() throws Throwable {
		WebDriver driver = null;
		FileUtility fUtil = new FileUtility();
		WebDriverUtility wdUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility exUtil = new ExcelUtility();

		//read the data from property file
		String browser = fUtil.readDataFromPropertyFile("browser");
		String url = fUtil.readDataFromPropertyFile("url");
		String username = fUtil.readDataFromPropertyFile("username");
		String password = fUtil.readDataFromPropertyFile("password");

		//Launch the browser
		if (browser.equals(browser)) {
			driver = new ChromeDriver();
		}else {
			driver = new FirefoxDriver();
		}

		//Navigate to the url
		driver.navigate().to(url);

		//maximize the application
		jUtil.maximizeTheScreen(driver);

		//Implicitly wait
		wdUtil.waitForPageToLoad(driver);

		//Login to the application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		//Click on Opportunities
		driver.findElement(By.linkText("Opportunities")).click();
		
		//click on checkbox
		driver.findElement(By.xpath("//a[text()='qw']/preceding::input[@id='62']")).click();
	}		


}
