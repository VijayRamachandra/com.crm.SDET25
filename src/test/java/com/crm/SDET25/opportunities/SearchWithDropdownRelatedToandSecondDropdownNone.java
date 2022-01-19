package com.crm.SDET25.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.SDET25.genericUtility.ExcelUtility;
import com.crm.SDET25.genericUtility.FileUtility;
import com.crm.SDET25.genericUtility.JavaUtility;
import com.crm.SDET25.genericUtility.WebDriverUtility;

public class SearchWithDropdownRelatedToandSecondDropdownNone {

	@Test
	public void searchWithDropdownRelatedToandSecondDropdownNone() throws Throwable {
		WebDriver driver = null;
		
		/*Create Objects*/
		FileUtility fUtil = new FileUtility();
		WebDriverUtility wdUtil = new WebDriverUtility();
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility exUtil = new ExcelUtility();

		/*read common data from property file*/
		String browser = fUtil.readDataFromPropertyFile("browser");
		String url = fUtil.readDataFromPropertyFile("url");
		String username = fUtil.readDataFromPropertyFile("username");
		String password = fUtil.readDataFromPropertyFile("password");

		/*Step 1 : Launch the browser*/
		if (browser.equals(browser)) {
			driver = new ChromeDriver();
		}else {
			driver = new FirefoxDriver();
		}

		/*Navigate to the url*/
		driver.get(url);

		//maximize the application
		jUtil.maximizeTheScreen(driver);

		//Implicitly wait
		wdUtil.waitForPageToLoad(driver);

		//Login to the application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		//navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();

		//provide mandatory fields
		String lastName = exUtil.getDataFromExcelSheet("Sheet1", 14, 2)+ jUtil.getRamdomNumber();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//b[text()='Contact Information']/preceding::input[@title='Save [Alt+S]']")).click();

		//Click on Opportunities
		driver.findElement(By.linkText("Opportunities")).click();

		//click on create opportunities
		driver.findElement(By.cssSelector("img[title='Create Opportunity...']")).click();

		//Fill all the mandatory fields
		String opportunityName = exUtil.getDataFromExcelSheet("Sheet1", 14, 0);
		String expectedCloseDate = exUtil.getDataFromExcelSheet("Sheet1", 14, 1);
		
		driver.findElement(By.name("closingdate")).clear();
		driver.findElement(By.name("closingdate")).sendKeys(expectedCloseDate);
		driver.findElement(By.name("potentialname")).sendKeys(opportunityName);
		WebElement relatedTo = driver.findElement(By.id("related_to_type"));
		wdUtil.selectVisible(relatedTo, "Contacts");
		

		//Switch windows and select last name
		driver.findElement(By.xpath("//td[text()='Next Step ']/preceding::img[@title='Select']")).click();
		wdUtil.switchToWindow(driver, "Accounts");
		driver.findElement(By.name("search_text")).sendKeys(lastName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(""+lastName+"")).click();
		wdUtil.switchToWindow(driver, "Contacts");

		//Save
		driver.findElement(By.xpath("//b[text()='Opportunity Information:']/preceding::input[@title='Save [Alt+S]']")).click();

		//click on opportunities to see opportunities list page and find Advanced search
		driver.findElement(By.linkText("Opportunities")).click();

		//Click on Advanced Search
		driver.findElement(By.linkText("Go to Advanced Search")).click();
		WebElement dropDown1 = driver.findElement(By.id("fcol0"));
		//Related To
		wdUtil.selectVisible(dropDown1, "Related To");
		driver.findElement(By.xpath("//b[text()='Advanced Search']/following::input[@class='crmbutton small create']")).click();

		//Handle Popup
		wdUtil.swithToAlertWindowAndAccpect(driver);
		//Related To and DropDown Not Equals
		WebElement dropDown2 = driver.findElement(By.id("fop0"));
		wdUtil.selectVisible(dropDown2, "not equal to");
		driver.findElement(By.xpath("//b[text()='Advanced Search']/following::input[@class='crmbutton small create']")).click();
		
	}

}
