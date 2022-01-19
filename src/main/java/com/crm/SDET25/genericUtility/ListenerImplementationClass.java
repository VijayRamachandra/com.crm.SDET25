package com.crm.SDET25.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementationClass implements ITestListener{
	JavaUtility jUtil = new JavaUtility();
	public void onTestFailure(ITestResult result) {
		String testCaseName = result.getMethod().getMethodName();
		
		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
		String dateTime = jUtil.getDateAndTime();
		File dest = new File("./screenShot/"+testCaseName+"_"+dateTime +".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
		} 
	}
}
