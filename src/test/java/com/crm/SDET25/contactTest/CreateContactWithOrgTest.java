package com.crm.SDET25.contactTest;

import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.SDET25.genericUtility.ExcelUtility;
import com.crm.SDET25.genericUtility.JavaUtility;
import com.crm.SDET25.genericUtility.WebDriverUtility;

public class CreateContactWithOrgTest {

	@Test
	public void createContactAndOrg() throws Throwable {
		WebDriver driver = null;
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility exUtil= new ExcelUtility();
		WebDriverUtility wdUtil = new WebDriverUtility();
		
		
		String browser = exUtil.getDataFromExcelSheet("Sheet1",1,0);
		String url = exUtil.getDataFromExcelSheet("Sheet1",1,1);
		String username = exUtil.getDataFromExcelSheet("Sheet1",1,2);
		String password = exUtil.getDataFromExcelSheet("Sheet1",1,3);
		String orgName = exUtil.getDataFromExcelSheet("Sheet1", 3, 0)+ jUtil.getRamdomNumber();
		String lastName = exUtil.getDataFromExcelSheet("Sheet1", 7, 0)+ jUtil.getRamdomNumber();
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			System.out.println("Invalid Browser");
		}
		
		//Login
		driver.get(url);
		jUtil.maximizeTheScreen(driver);
		wdUtil.waitForPageToLoad(driver);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//Click on organization
		driver.findElement(By.linkText("Organizations")).click();
		//Click on create organization
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Fill mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		
		//save
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
		
		//explicit wait
		WebElement dvheader = driver.findElement(By.className("dvHeaderText"));
		wdUtil.waitForElementToBeClickable(driver, dvheader);
		
		
		
		//click on contacts module
		driver.findElement(By.linkText("Contacts")).click();
		//click on create contact
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
		
		//Fill mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img[@title='Select']")).click();
		
		//Switch window
		wdUtil.switchToWindow(driver, "Accounts");
		
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		wdUtil.switchToWindow(driver, "Contacts");
		
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//actions class
		WebElement mouseHover = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wdUtil.actionsMoveToElement(driver, mouseHover);
		
		//Signout
		driver.findElement(By.linkText("Sign Out")).click();
			
	}


}
