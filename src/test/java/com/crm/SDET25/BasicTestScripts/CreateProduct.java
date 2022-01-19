package com.crm.SDET25.BasicTestScripts;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.SDET25.genericUtility.ExcelUtility;
import com.crm.SDET25.genericUtility.FileUtility;

public class CreateProduct {
	
	@Test
	public void getCreateProductData() throws Throwable {
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
		
		//click on products
		driver.findElement(By.linkText("Products")).click();
		
		//click on create product
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		
		//enter mandatory fields
		ExcelUtility xlUtil = new ExcelUtility();
		String productName = xlUtil.getDataFromExcelSheet("Sheet1",11,1);
		driver.findElement(By.name("productname")).sendKeys(productName);
		String mainWindowId = driver.getWindowHandle();
		driver.findElement(By.cssSelector("img[src='themes/softed/images/select.gif']")).click();
		Thread.sleep(3000);
		
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String windowId:allWindowIds) {
			driver.switchTo().window(windowId);
			if (!windowId.equals(mainWindowId)) {
			driver.findElement(By.linkText("Vendor1")).click();
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
