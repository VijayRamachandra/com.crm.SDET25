package com.crm.SDET25.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Sample1 {
	
	@Test
	public void testCase3() throws IOException, InterruptedException {
		String filePath = "./resources/vtiger.properties";
		FileInputStream fis = new FileInputStream(filePath);
		Properties prop = new Properties();
		prop.load(fis);
		
		String url = prop.getProperty("URL");
		String userName = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
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
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(5000);
		WebElement administartor = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(administartor).perform();
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
	}

}
