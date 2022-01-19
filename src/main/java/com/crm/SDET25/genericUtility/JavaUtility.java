package com.crm.SDET25.genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class JavaUtility {
	
	/**This method will return random number
	 * @return 
	 * @author Vijay Ramachandra
	 */
	
	public int getRamdomNumber() {
		Random ran = new Random();
		int randomNumber = ran.nextInt(10000);
		return randomNumber;
	}

	/**
	 * This method performs window maximize operation
	 * @param driver
	 */
	public void maximizeTheScreen(WebDriver driver) {
		driver.manage().window().maximize();
		

}
	/**
	 * This method returns system date and time in string form
	 * @author Vijay Ramachandra
	 * @return
	 */
	public String getSystemDate() {
		Date date = new Date();
		String dateAndTime = date.toString();
		return dateAndTime;
	}
	
	/**
	 * This method returns the system dtae in YYYY-MM-DD format
	 * @author Vijay Ramachandra
	 * @return
	 */
	public String getSystemDate_YYYY_MM_DD() {
		Date date = new Date();
		String systemDateAndTime = date.toString();
		System.out.println(systemDateAndTime);
		String[] arr = systemDateAndTime.split(" ");
		String DD = arr[2];
        String YYYY = arr[5];   
        int MM = date.getMonth()+1;
        String finalFromat = YYYY+"-"+MM+"-"+DD;
		return finalFromat;

	}
	/**
	 * This method returns Date and Time for IListener screenshot format
	 * @return
	 * @author Vijay Ramachandra
	 */
	public String getDateAndTime() {
		Date date = new Date();
		String dateFormat = date.toString().replace(":", "_").replace(" ", "_");
		return dateFormat;
	}
	
	/**
	 * This method will press the enter key
	 * @author Vijay Ramachandra
	 * @throws Throwable
	 */
	public void pressVirtualEnterKey() throws Throwable {
		Robot rc = new Robot();
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	}
	
}
