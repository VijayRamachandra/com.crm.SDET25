package com.crm.SDET25.BasicTestScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.SDET25.genericUtility.ExcelUtility;

public class GetMultipleDataFromExcelFile {

	@Test(dataProvider = "data")
	public void getData(String username, String password) {
		System.out.println(username+" "+password);
	}
	
	@DataProvider
	public Object[][] data() throws Throwable {
		ExcelUtility exUtil = new ExcelUtility();
		return exUtil.getMultipleData();

	}
	
}
