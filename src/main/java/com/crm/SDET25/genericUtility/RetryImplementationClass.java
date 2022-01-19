package com.crm.SDET25.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementationClass implements IRetryAnalyzer{
	
	int count =0;
	int retryCount = 4;
	
	public boolean retry(ITestResult result) {
		while (count < retryCount) {
			count++;
			return true;
		}
		return false;
	}

}
