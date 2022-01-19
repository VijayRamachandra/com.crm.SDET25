package com.crm.SDET25.BasicTestScripts;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.SDET25.genericUtility.FileUtility;

public class SelectTomorrowsDate {

	@Test
	public void getTomorrowsDate() throws Throwable {

		WebDriver driver = null;

		//Read the data from property file
		FileUtility fUtil= new FileUtility();
		String browser = fUtil.readDataFromPropertyFile("browser");

		//Create LocalDateTime
		LocalDateTime dateAndTime = LocalDateTime.now().plusDays(1);
		int day = dateAndTime.getDayOfMonth();
		String month = dateAndTime.getMonth().name();
		int year = dateAndTime.getYear();
		System.out.println(day);
		System.out.println(month);
		System.out.println(year);
		String mod_month = month.substring(0, 1)+month.substring(1).toLowerCase()+" "+year;
		System.out.println(mod_month);

		//String expectedDay = day.substring(0,1)+day.substring(1,3).toLowerCase().concat(",");
		//String month = dateAndTime.getMonth().name();
		//String expectedMonth = month.substring(0,1)+month.substring(1,3).toLowerCase();
		//String dateAndTimeFormat = expectedDay+" "+expectedMonth+" "+expectedDate;
		/*System.out.println(expectedDay);
		System.out.println(expectedMonth);
		System.out.println(expectedDate);
		System.out.println(dateAndTimeFormat);*/
		
		//launch the browser
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			System.out.println("Invalid Browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");
		Thread.sleep(2000);
		
		//Click to avoid ElementClickInterceptedException
		Actions actions = new Actions(driver);
		actions.moveByOffset(0, 30).click().perform();
		Thread.sleep(5000);
		
		//click on calendar
		driver.findElement(By.xpath("//div[contains(@class,'homeCalender')]")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		//Click on date
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='"+mod_month+"']/ancestor::div[@class='DayPicker-Month']/descendant::div[text()='"+day+"']")).click();
		
	}
	

}
