package com.crm.SDET25.BasicTestScripts;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class GetTheDataFromXmlFile {
	
	@Test
	public void getData(XmlTest xml) {
		String browser = xml.getParameter("browser");
		System.out.println(browser);
		
		String url = xml.getParameter("url");
		System.out.println(url);
		
		String username = xml.getParameter("username");
		System.out.println(username);
		
		String password = xml.getParameter("password");
		System.out.println(password);
		
		
		
	}

}
