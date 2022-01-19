package com.crm.SDET25.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.SDET25.genericUtility.FileUtility;

public class Case3 {
	
	@Test
	public void testCase3() throws IOException, InterruptedException {
WebDriver driver = null;
		
		//read the common data from property file
		FileUtility fLib = new FileUtility();
		
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		
		//launch the browser
		if (BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		
		//navigate to the url
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get(URL);
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		
		//provide mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("V");
		String organizationName = "//td[text()='Organization Name 			']/..//img[@src='themes/softed/images/select.gif']";
		String mainWindowId = driver.getWindowHandle();
		driver.findElement(By.xpath(organizationName)).click();
		
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String windowId:allWindowIds) {
			driver.switchTo().window(windowId);
			if (!windowId.equals(mainWindowId)) {
			driver.findElement(By.xpath("//td[text()=' Administrator']/..//a")).click();
			}
			driver.switchTo().window(mainWindowId);
		}
		
		
		Thread.sleep(5000);
		
		//save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(5000);
		
		//logout
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
	}

}
