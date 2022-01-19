package com.crm.SDET25.BasicTestScripts;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.SDET25.genericUtility.ExcelUtility;
import com.crm.SDET25.genericUtility.FileUtility;

public class CreateOpportunities {
	
	@Test
	public void getCreateOpportunitiesDataReletedToOrganization() throws Throwable {
WebDriver driver = null;
		
		//read the common data from property file
		FileUtility fLib = new FileUtility();
		
		String browser = fLib.readDataFromPropertyFile("browser");
		String url = fLib.readDataFromPropertyFile("url");
		String username = fLib.readDataFromPropertyFile("username");
		String password = fLib.readDataFromPropertyFile("password");
		
		//launch the browser
		if (browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		
		//navigate to the url
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//Click on Opportunities
		driver.findElement(By.linkText("Opportunities")).click();
		
		//click on create opportunities
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Fill mandatory fields
		ExcelUtility exUtil = new ExcelUtility();
		String opportunityName = exUtil.getDataFromExcelSheet("Sheet1",11,3);
		driver.findElement(By.name("potentialname")).sendKeys(opportunityName);
		//WebElement relatedTo = driver.findElement(By.id("related_to_type"));
		//Select s = new Select(relatedTo);
		//s.deselectByVisibleText("Contacts");
		String relatedToOrganization = "//select[@name='related_to_type']/../..//img[@src='themes/softed/images/select.gif']";
		driver.findElement(By.xpath(relatedToOrganization)).click();
		
		//Handling child window popup
		String mainWindowId = driver.getWindowHandle();
		Set<String> allWindowIds = driver.getWindowHandles();
		for (String windowId:allWindowIds) {
			driver.switchTo().window(windowId);
			if (!windowId.equals(mainWindowId)) {
				Thread.sleep(3000);
				driver.findElement(By.linkText("Test2")).click();
				Thread.sleep(3000);
			}
			driver.switchTo().window(mainWindowId);
			Thread.sleep(3000);
			
		//save
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		Thread.sleep(3000);
		
		}
		
		
		
	}

}
