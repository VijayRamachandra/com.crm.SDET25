package com.crm.SDET25.BasicTestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.SDET25.genericUtility.ExcelUtility;
import com.crm.SDET25.genericUtility.FileUtility;

public class CreateVendor {
	
	@Test
	public void getCreateVendorData() throws Throwable {
		
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
				
		//click on vendors
		Actions action = new Actions(driver);
		WebElement moreOption = driver.findElement(By.cssSelector("img[src='themes/softed/images/menuDnArrow.gif']"));
		action.moveToElement(moreOption).perform();
		driver.findElement(By.linkText("Vendors")).click();
		
		//click on create vendor
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		
		//fill mandatory fields
		ExcelUtility xlUtil = new ExcelUtility();
		String vendorName = xlUtil.getDataFromExcelSheet("Sheet1",11, 0);
		driver.findElement(By.name("vendorname")).sendKeys(vendorName);
		
		//save
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		Thread.sleep(5000);
		
		//Signout
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}

}
