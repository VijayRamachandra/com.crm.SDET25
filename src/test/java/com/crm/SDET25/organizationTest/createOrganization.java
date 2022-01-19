package com.crm.SDET25.organizationTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.SDET25.genericUtility.ExcelUtility;
import com.crm.SDET25.genericUtility.FileUtility;



public class createOrganization {
	
	
	@Test
	public void testCase1() throws IOException, InterruptedException {
		
		WebDriver driver = null;
		
		//adding random data
		Random ran = new Random();
		int randomNum = ran.nextInt(1000);
		
		//read the common data from excel file
		
		ExcelUtility ExUtil = new ExcelUtility();
		
		String browser = ExUtil.getDataFromExcelSheet("Sheet1",1,0);
		String url = ExUtil.getDataFromExcelSheet("Sheet1",1,1);
		String username = ExUtil.getDataFromExcelSheet("Sheet1",1,2);
		String password = ExUtil.getDataFromExcelSheet("Sheet1",1,3);
		
		String organizationName = ExUtil.getDataFromExcelSheet("Sheet1",3,0)+randomNum;
		
		
		//launch the browser
		if (browser.equalsIgnoreCase("browser"))
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
		
		//navigate to organizations
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		
		//enter mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(organizationName);
		
		//save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		Thread.sleep(5000);
		
		//signout
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
	}

}
