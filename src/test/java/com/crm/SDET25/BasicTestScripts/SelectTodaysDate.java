package com.crm.SDET25.BasicTestScripts;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.SDET25.genericUtility.FileUtility;

public class SelectTodaysDate {
	@Test
	public void getDates() throws InterruptedException, Throwable {
		
		WebDriver driver= null;

		//read the common data from property file
		FileUtility fLib = new FileUtility();
		String browser = fLib.readDataFromPropertyFile("browser");

		//Calculate Departure Date using LocalDateTime
		LocalDateTime dateAndTime = LocalDateTime.now();
		int date = dateAndTime.getDayOfMonth();
		String day = dateAndTime.getDayOfWeek().name();
		String finalDay = day.substring(0, 1)+day.substring(1, 3).toLowerCase().concat(",");
		String month = dateAndTime.getMonth().name();
		String finalMonth = month.substring(0, 1)+month.substring(1, 3).toLowerCase();
		System.out.print(finalDay);
		System.out.print(finalMonth);
		System.out.println(date);
		String updatedTimeFormat = finalDay+" "+finalMonth+" "+date;



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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");
		
		//Click to avoid ElementClickInterceptedException
		Actions actions = new Actions(driver);
		actions.moveByOffset(0, 30).click().perform();
		
		//Click on Calendar button to select date
		driver.findElement(By.xpath("//div[contains(@class,'homeCalender')]")).click();
		
		//Click on Date
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='"+updatedTimeFormat+"']/following::div[contains(@class,'DayPicker-Day--today')]")).click();

	}
}
