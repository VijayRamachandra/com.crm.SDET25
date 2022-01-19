package com.crm.SDET25.contactTest;

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

import com.crm.SDET25.genericUtility.ExcelUtility;
import com.crm.SDET25.genericUtility.FileUtility;

public class CreateContact {
	
	@Test
	public void testCase3() throws IOException, InterruptedException {
		WebDriver driver = null;
		
		//read the common data from excel file
        ExcelUtility ExUtil = new ExcelUtility();

        String browser = ExUtil.getDataFromExcelSheet("Sheet1",1,0);
        String url = ExUtil.getDataFromExcelSheet("Sheet1",1,1);
        String username = ExUtil.getDataFromExcelSheet("Sheet1",1,2);
        String password = ExUtil.getDataFromExcelSheet("Sheet1",1,3);
        
        String lastName = ExUtil.getDataFromExcelSheet("Sheet1",7,0);
		
        FileUtility fUtil = new FileUtility();
		
		//launch the browser
		if (browser.equalsIgnoreCase(fUtil.readDataFromPropertyFile("browser1")))
		{
			driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase(fUtil.readDataFromPropertyFile("browser2")))
		{
			driver=new FirefoxDriver();
		}else {
			System.out.println("Invalid Browser");
		}
		
		//navigate to the url
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get(url);
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
		
		//provide mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		String organizationName = "//td[text()='Organization Name 			']/..//img[@src='themes/softed/images/select.gif']";
		String mainWindowId = driver.getWindowHandle();
		driver.findElement(By.xpath(organizationName)).click();
		
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String windowId:allWindowIds) {
			driver.switchTo().window(windowId);
			if (!windowId.equals(mainWindowId)) {
			driver.findElement(By.linkText("Test1")).click();
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
