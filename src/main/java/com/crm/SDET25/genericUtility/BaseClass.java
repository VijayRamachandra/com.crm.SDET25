package com.crm.SDET25.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.SDET25.pomrepositorylibrary.HomePage;
import com.crm.SDET25.pomrepositorylibrary.Login;

public class BaseClass {

	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	/*Create Objects*/
	public FileUtility fUtil = new FileUtility();
	public WebDriverUtility wdUtil = new WebDriverUtility();
	public JavaUtility jUtil = new JavaUtility();
	public ExcelUtility exUtil = new ExcelUtility();
	

	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void bsConfig() throws Throwable {
		System.out.println("==DATABASE CONNECTION==");
	}
@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void bcConfig() throws Throwable {
		String BROWSER = fUtil.readDataFromPropertyFile("browser");
		/*Launch the browser*/
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")){
			driver = new FirefoxDriver();
		}else {
			System.out.println("Invalid Browser");
		}
		sdriver = driver;
	}

	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void bmConfig() throws Throwable {
		/*STEP 1: Login To The Application*/
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		Login lp = new Login(driver);
		lp.loginToApplication(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void amConfig() {
		//SignOut
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void acConfig() {
		//Close the browser
		driver.quit();
	}

	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void asConfig() {
		System.out.println("==DATABASE CONNECTION CLOSED==");
	}

}
