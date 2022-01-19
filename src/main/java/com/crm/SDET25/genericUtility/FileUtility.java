package com.crm.SDET25.genericUtility;

import java.io.FileInputStream;

/**
 * This class contains generic methods for reading data from property file
 * @author Vijay Ramachandra
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileUtility {
	
	/**
	 * This method will return the value from property file when key is passed
	 * @author Vijay Ramachandra
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromPropertyFile(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream(IpathConstants.PROPERTY_PATH);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		
		return value; 
		
	}
	
	/**
	 * This method will return json values in String form
	 * @author Vijay Ramachandra
	 * @param jsonKey
	 * @return
	 * @throws Throwable
	 */
	
	public String readDataFromJsonFile(String jsonKey) throws Throwable {
		JSONParser jsonParser = new JSONParser();
		FileReader file = new FileReader(IpathConstants.JSON_PATH);
		Object object = jsonParser.parse(file);
		JSONObject jsonObj = (JSONObject)object;
		return jsonObj.get(jsonKey).toString();
	}
	
	
	

}
