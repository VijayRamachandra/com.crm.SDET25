package com.crm.SDET25.Practice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class clear {
	
	@Test
	public void getClear() throws Throwable {
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

		System.setProperty("webdriver.chrome.dirver", "./drivers/chrome.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.moveByOffset(0, 30).click().perform();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div[class='flex flex-middle p-relative homeCalender']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='"+updatedTimeFormat+"']/following::div[contains(@class,'DayPicker-Day--today')]")).click();
		
		
		//driver.switchTo().frame(1).findElement(By.xpath(path)).click();
		
		//WebElement targetEle = driver.findElement(By.cssSelector("div[class='App flex flex-column']"));
		//driver.switchTo().frame(targetEle).findElement("//abbr[@title='"+finalDay+"']/preceding::div[text()='"+finalMonth+"']/preceding::div[text()='"+date1+"']"));
		//Thread.sleep(3000);
		//String path = "//abbr[@title='"+finalDay+"']/preceding::div[text()='"+finalMonth+"']/preceding::div[text()='"+date1+"']";
		//driver.findElement(By.xpath(path)).click();
	}

}
