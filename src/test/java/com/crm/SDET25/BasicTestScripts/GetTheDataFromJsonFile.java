package com.crm.SDET25.BasicTestScripts;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.mysql.cj.xdevapi.JsonParser;

public class GetTheDataFromJsonFile {
	
	@Test
	public void getData() throws Throwable {
	JSONParser parser = new JSONParser();
	FileReader file = new FileReader("./data.credential.json");
	Object object = parser.parse(file);
	JSONObject jsonObj = (JSONObject)object;
	}

}
