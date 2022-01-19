package com.crm.SDET25.BasicTestScripts;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import com.crm.SDET25.genericUtility.FileUtility;

public class getDataFromJsonFile {

	@Test
	public void getTheData() throws Throwable {
		
		FileUtility fUtil = new FileUtility();
		System.out.println(fUtil.readDataFromJsonFile("browser"));
		System.out.println(fUtil.readDataFromJsonFile("url"));
		System.out.println(fUtil.readDataFromJsonFile("username"));
		System.out.println(fUtil.readDataFromJsonFile("password"));
	
	}

}
