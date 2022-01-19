package com.crm.SDET25.pomrepositorylibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Search {

	WebDriver driver = null;
	public Search(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="fcol0")
	public WebElement opportunityNameDropDown;

	@FindBy(id="fop0")
	public WebElement noneTextField;

	@FindBy(id="fval0")
	public WebElement searchTextField;

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchTextField(String var) {
		return searchTextField;
	}

	public WebElement getNoneTextField() {
		return noneTextField;
	}

	@FindBy(linkText="Go to Advanced Search")
	public WebElement advancedSearchButton;

	@FindBy(xpath="//b[text()='Advanced Search']/following::input[@class='crmbutton small create']")
	public WebElement searchNowbutton;

	public WebElement getOpportunityNameDropDown() {
		return opportunityNameDropDown;
	}


	public WebElement getAdvancedSearchButton() {
		return advancedSearchButton;
	}


	public WebElement getSearchNowbutton() {
		return searchNowbutton;
	}


	public WebDriver getDriver() {
		return driver;
	}

	public WebElement fillTheDataOfActual(String LASTNAME) {
		WebElement foundData = driver.findElement(By.xpath("//font[text()='Filters :']/following::a[text()=' "+LASTNAME+"']"));
		return foundData;
	}
	
	public void fillAdvancedSearchFields(String text) {
		//advancedSearchButton.click();
		opportunityNameDropDown.click();
		Select sel = new Select(opportunityNameDropDown);
		sel.selectByVisibleText(text);
		searchNowbutton.click();
	}

	public void fillNoneTextField(String var1) {
		//advancedSearchButton.click();
		noneTextField.click();
		Select sel1 = new Select(noneTextField);
		sel1.selectByVisibleText(var1);
	}

	public void fillSearchTextField(String var) {
		searchTextField.sendKeys(var);
		searchNowbutton.click();

	}
}
