package com.crm.SDET25.opportunities.pom;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.SDET25.genericUtility.BaseClass;
import com.crm.SDET25.pomrepositorylibrary.ContactInformationPage;
import com.crm.SDET25.pomrepositorylibrary.CreateNewOpportunityPage;
import com.crm.SDET25.pomrepositorylibrary.CreatingNewContactsPage;
import com.crm.SDET25.pomrepositorylibrary.OpportunitiesPage;
import com.crm.SDET25.pomrepositorylibrary.OpportunityInformationPage;
import com.crm.SDET25.pomrepositorylibrary.Search;
import com.crm.SDET25.pomrepositorylibrary.SearchOrganizationsFromLastName;
@Listeners(com.crm.SDET25.genericUtility.ListenerImplementationClass.class)
public class AdvanceSearchGroupExecution extends BaseClass{

	@Test(groups = "regressionTest")
	public void searchWithDropdownRelatedToandSecondDropdownNoneTest() throws Throwable {


		/*read the common data from property file*/
		String advancedSearchDropDown1 = fUtil.readDataFromPropertyFile("advancedSearchDropDown1");

		/*STEP 2: Navigate To Contacts*/
		SearchOrganizationsFromLastName cPage=new SearchOrganizationsFromLastName(driver);
		cPage.getContactsButton().click();

		/*STEP 3 : Navigate to Create New Contact Page*/
		cPage.getCreateContactImg().click();

		/*Create New Contact*/
		String LASTNAME = exUtil.getDataFromExcelSheet("Sheet1", 14, 2)+ jUtil.getRamdomNumber();
		CreatingNewContactsPage cncp = new CreatingNewContactsPage(driver);
		cncp.createNewContact(LASTNAME);

		/*STEP : 4 Verification*/
		ContactInformationPage cIp = new ContactInformationPage(driver);
		String actualContactInfo = cIp.getContactInfo().getText();
		boolean contactStatus = actualContactInfo.contains(LASTNAME);
		Assert.assertTrue(contactStatus, "Contact name is not created - FAIL");
		System.out.println("Contact Name Created : "+LASTNAME);

		/* STEP : 5 Navigate To Opportunity Page*/
		OpportunitiesPage opPage = new OpportunitiesPage(driver);
		opPage.getOpportunitiesLink().click();

		/*Navigate To Create Opportunity Page */
		opPage.getCreateOpportunityImg().click();


		/*STEP : 6 Create New Opportunity*/
		String opportunityName = exUtil.getDataFromExcelSheet("Sheet1", 14, 0)+ jUtil.getRamdomNumber();
		String expCloseDate = exUtil.getDataFromExcelSheet("Sheet1", 14, 1);

		CreateNewOpportunityPage cnop = new CreateNewOpportunityPage(driver);
		cnop.fillMandatoryFields(opportunityName, expCloseDate);
		SearchOrganizationsFromLastName sofln = new SearchOrganizationsFromLastName(driver);
		sofln.searchLastName(LASTNAME);
		cnop.getSaveButton().click();

		/*STEP:7 Verification*/
		OpportunityInformationPage oIp = new OpportunityInformationPage(driver);
		String actualOpportunityInfo = oIp.getOpportunityInfo().getText();
		boolean opportunityStatus = actualOpportunityInfo.contains(opportunityName);
		Assert.assertTrue(opportunityStatus, "Opportunity is not created - Fail");
		System.out.println("Opportunity is created : "+opportunityName);

		/*Click on opportunities link*/
		opPage.getOpportunitiesLink().click();

		/*STEP:8 Navigate to advanced search area*/
		Search sPage= new Search(driver);

		sPage.getAdvancedSearchButton().click();

		sPage.fillAdvancedSearchFields(advancedSearchDropDown1);

		/* Handle Pop up*/
		wdUtil.swithToAlertWindowAndAccpect(driver);		
	}

	@Test(groups = "regressionTest")
	public void searchWithDropdownRelatedToandSecondDropdownContainsTest() throws Throwable {


		/*read the common data from property file*/
		String advancedSearchDropDown1 = fUtil.readDataFromPropertyFile("advancedSearchDropDown1");

		/*STEP 2: Navigate To Contacts*/
		SearchOrganizationsFromLastName cPage=new SearchOrganizationsFromLastName(driver);
		cPage.getContactsButton().click();

		/*STEP 3 : Navigate to Create New Contact Page*/
		cPage.getCreateContactImg().click();

		/*Create New Contact*/
		String LASTNAME = exUtil.getDataFromExcelSheet("Sheet1", 14, 2)+ jUtil.getRamdomNumber();
		CreatingNewContactsPage cncp = new CreatingNewContactsPage(driver);
		cncp.createNewContact(LASTNAME);

		/*STEP : 4 Verification*/
		ContactInformationPage cIp = new ContactInformationPage(driver);
		String actualContactInfo = cIp.getContactInfo().getText();
		boolean contactStatus = actualContactInfo.contains(LASTNAME);
		Assert.assertTrue(contactStatus, "Contact name is not created - FAIL");
		System.out.println("Contact Name Created : "+LASTNAME);

		/* STEP : 5 Navigate To Opportunity Page*/
		OpportunitiesPage opPage = new OpportunitiesPage(driver);
		opPage.getOpportunitiesLink().click();

		/*Navigate To Create Opportunity Page */
		opPage.getCreateOpportunityImg().click();


		/*STEP : 6 Create New Opportunity*/
		String opportunityName = exUtil.getDataFromExcelSheet("Sheet1", 14, 0)+ jUtil.getRamdomNumber();
		String expCloseDate = exUtil.getDataFromExcelSheet("Sheet1", 14, 1);

		CreateNewOpportunityPage cnop = new CreateNewOpportunityPage(driver);
		cnop.fillMandatoryFields(opportunityName, expCloseDate);
		SearchOrganizationsFromLastName sofln = new SearchOrganizationsFromLastName(driver);
		sofln.searchLastName(LASTNAME);
		cnop.getSaveButton().click();

		/*STEP:7 Verification*/
		OpportunityInformationPage oIp = new OpportunityInformationPage(driver);
		String actualOpportunityInfo = oIp.getOpportunityInfo().getText();
		boolean opportunityStatus = actualOpportunityInfo.contains(opportunityName);
		Assert.assertTrue(opportunityStatus, "Opportunity is not created - Fail");
		System.out.println("Opportunity is created : "+opportunityName);

		/*Click on opportunities link*/
		opPage.getOpportunitiesLink().click();

		/*STEP:8 Navigate to advanced search area*/
		Search sPage= new Search(driver);

		sPage.getAdvancedSearchButton().click();

		sPage.fillAdvancedSearchFields(advancedSearchDropDown1);

		/* Handle Pop up*/
		wdUtil.swithToAlertWindowAndAccpect(driver);

		String advancedSearchDropDown7 = fUtil.readDataFromPropertyFile("dropDown2Option7");
		sPage.fillNoneTextField(advancedSearchDropDown7);
	}

	@Test(groups = "regressionTest")
	public void searchWithDropdownRelatedToandSecondDropdownDoesNotContainsTest() throws Throwable {


		/*read the common data from property file*/
		String advancedSearchDropDown1 = fUtil.readDataFromPropertyFile("advancedSearchDropDown1");

		/*STEP 2: Navigate To Contacts*/
		SearchOrganizationsFromLastName cPage=new SearchOrganizationsFromLastName(driver);
		cPage.getContactsButton().click();

		/*STEP 3 : Navigate to Create New Contact Page*/
		cPage.getCreateContactImg().click();

		/*Create New Contact*/
		String LASTNAME = exUtil.getDataFromExcelSheet("Sheet1", 14, 2)+ jUtil.getRamdomNumber();
		CreatingNewContactsPage cncp = new CreatingNewContactsPage(driver);
		cncp.createNewContact(LASTNAME);

		/*STEP : 4 Verification*/
		ContactInformationPage cIp = new ContactInformationPage(driver);
		String actualContactInfo = cIp.getContactInfo().getText();
		boolean contactStatus = actualContactInfo.contains(LASTNAME);
		Assert.assertTrue(contactStatus, "Contact name is not created - FAIL");
		System.out.println("Contact Name Created : "+LASTNAME);

		/* STEP : 5 Navigate To Opportunity Page*/
		OpportunitiesPage opPage = new OpportunitiesPage(driver);
		opPage.getOpportunitiesLink().click();

		/*Navigate To Create Opportunity Page */
		opPage.getCreateOpportunityImg().click();


		/*STEP : 6 Create New Opportunity*/
		String opportunityName = exUtil.getDataFromExcelSheet("Sheet1", 14, 0)+ jUtil.getRamdomNumber();
		String expCloseDate = exUtil.getDataFromExcelSheet("Sheet1", 14, 1);

		CreateNewOpportunityPage cnop = new CreateNewOpportunityPage(driver);
		cnop.fillMandatoryFields(opportunityName, expCloseDate);
		SearchOrganizationsFromLastName sofln = new SearchOrganizationsFromLastName(driver);
		sofln.searchLastName(LASTNAME);
		cnop.getSaveButton().click();

		/*STEP:7 Verification*/
		OpportunityInformationPage oIp = new OpportunityInformationPage(driver);
		String actualOpportunityInfo = oIp.getOpportunityInfo().getText();
		boolean opportunityStatus = actualOpportunityInfo.contains(opportunityName);
		Assert.assertTrue(opportunityStatus, "Opportunity is not created - Fail");
		System.out.println("Opportunity is created : "+opportunityName);

		/*Click on opportunities link*/
		opPage.getOpportunitiesLink().click();

		/*STEP:8 Navigate to advanced search area*/
		Search sPage= new Search(driver);

		sPage.getAdvancedSearchButton().click();

		sPage.fillAdvancedSearchFields(advancedSearchDropDown1);

		/* Handle Pop up*/
		wdUtil.swithToAlertWindowAndAccpect(driver);

		String advancedSearchDropDown2 = fUtil.readDataFromPropertyFile("dropDown2Option2");
		sPage.fillNoneTextField(advancedSearchDropDown2);
	}

	@Test(groups = "smokeTest")
	public void searchWithDropdownRelatedToandSecondDropdownEndsWithTest() throws Throwable {


		/*read the common data from property file*/
		String advancedSearchDropDown1 = fUtil.readDataFromPropertyFile("advancedSearchDropDown1");

		/*STEP 2: Navigate To Contacts*/
		SearchOrganizationsFromLastName cPage=new SearchOrganizationsFromLastName(driver);
		cPage.getContactsButton().click();

		/*STEP 3 : Navigate to Create New Contact Page*/
		cPage.getCreateContactImg().click();

		/*Create New Contact*/
		String LASTNAME = exUtil.getDataFromExcelSheet("Sheet1", 14, 2)+ jUtil.getRamdomNumber();
		CreatingNewContactsPage cncp = new CreatingNewContactsPage(driver);
		cncp.createNewContact(LASTNAME);

		/*STEP : 4 Verification*/
		ContactInformationPage cIp = new ContactInformationPage(driver);
		String actualContactInfo = cIp.getContactInfo().getText();
		boolean contactStatus = actualContactInfo.contains(LASTNAME);
		Assert.assertTrue(contactStatus, "Contact name is not created - FAIL");
		System.out.println("Contact Name Created : "+LASTNAME);

		/* STEP : 5 Navigate To Opportunity Page*/
		OpportunitiesPage opPage = new OpportunitiesPage(driver);
		opPage.getOpportunitiesLink().click();

		/*Navigate To Create Opportunity Page */
		opPage.getCreateOpportunityImg().click();


		/*STEP : 6 Create New Opportunity*/
		String opportunityName = exUtil.getDataFromExcelSheet("Sheet1", 14, 0)+ jUtil.getRamdomNumber();
		String expCloseDate = exUtil.getDataFromExcelSheet("Sheet1", 14, 1);

		CreateNewOpportunityPage cnop = new CreateNewOpportunityPage(driver);
		cnop.fillMandatoryFields(opportunityName, expCloseDate);
		SearchOrganizationsFromLastName sofln = new SearchOrganizationsFromLastName(driver);
		sofln.searchLastName(LASTNAME);
		cnop.getSaveButton().click();

		/*STEP:7 Verification*/
		OpportunityInformationPage oIp = new OpportunityInformationPage(driver);
		String actualOpportunityInfo = oIp.getOpportunityInfo().getText();
		boolean opportunityStatus = actualOpportunityInfo.contains(opportunityName);
		Assert.assertTrue(opportunityStatus, "Opportunity is not created - Fail");
		System.out.println("Opportunity is created : "+opportunityName);

		/*Click on opportunities link*/
		opPage.getOpportunitiesLink().click();

		/*STEP:8 Navigate to advanced search area*/
		Search sPage= new Search(driver);

		sPage.getAdvancedSearchButton().click();

		sPage.fillAdvancedSearchFields(advancedSearchDropDown1);

		/* Handle Pop up*/
		wdUtil.swithToAlertWindowAndAccpect(driver);

		String advancedSearchDropDown3 = fUtil.readDataFromPropertyFile("dropDown2Option3");
		sPage.fillNoneTextField(advancedSearchDropDown3);
	}

	@Test(groups = "smokeTest")
	public void searchWithDropdownRelatedToandSecondDropdownNotEqualToTest() throws Throwable {


		/*read the common data from property file*/
		String advancedSearchDropDown1 = fUtil.readDataFromPropertyFile("advancedSearchDropDown1");

		/*STEP 2: Navigate To Contacts*/
		SearchOrganizationsFromLastName cPage=new SearchOrganizationsFromLastName(driver);
		cPage.getContactsButton().click();

		/*STEP 3 : Navigate to Create New Contact Page*/
		cPage.getCreateContactImg().click();

		/*Create New Contact*/
		String LASTNAME = exUtil.getDataFromExcelSheet("Sheet1", 14, 2)+ jUtil.getRamdomNumber();
		CreatingNewContactsPage cncp = new CreatingNewContactsPage(driver);
		cncp.createNewContact(LASTNAME);

		/*STEP : 4 Verification*/
		ContactInformationPage cIp = new ContactInformationPage(driver);
		String actualContactInfo = cIp.getContactInfo().getText();
		boolean contactStatus = actualContactInfo.contains(LASTNAME);
		Assert.assertTrue(contactStatus, "Contact name is not created - FAIL");
		System.out.println("Contact Name Created : "+LASTNAME);

		/* STEP : 5 Navigate To Opportunity Page*/
		OpportunitiesPage opPage = new OpportunitiesPage(driver);
		opPage.getOpportunitiesLink().click();

		/*Navigate To Create Opportunity Page */
		opPage.getCreateOpportunityImg().click();


		/*STEP : 6 Create New Opportunity*/
		String opportunityName = exUtil.getDataFromExcelSheet("Sheet1", 14, 0)+ jUtil.getRamdomNumber();
		String expCloseDate = exUtil.getDataFromExcelSheet("Sheet1", 14, 1);

		CreateNewOpportunityPage cnop = new CreateNewOpportunityPage(driver);
		cnop.fillMandatoryFields(opportunityName, expCloseDate);
		SearchOrganizationsFromLastName sofln = new SearchOrganizationsFromLastName(driver);
		sofln.searchLastName(LASTNAME);
		cnop.getSaveButton().click();

		/*STEP:7 Verification*/
		OpportunityInformationPage oIp = new OpportunityInformationPage(driver);
		String actualOpportunityInfo = oIp.getOpportunityInfo().getText();
		boolean opportunityStatus = actualOpportunityInfo.contains(opportunityName);
		Assert.assertTrue(opportunityStatus, "Opportunity is not created - Fail");
		System.out.println("Opportunity is created : "+opportunityName);

		/*Click on opportunities link*/
		opPage.getOpportunitiesLink().click();

		/*STEP:8 Navigate to advanced search area*/
		Search sPage= new Search(driver);

		sPage.getAdvancedSearchButton().click();

		sPage.fillAdvancedSearchFields(advancedSearchDropDown1);

		/* Handle Pop up*/
		wdUtil.swithToAlertWindowAndAccpect(driver);

		String advancedSearchDropDown5 = fUtil.readDataFromPropertyFile("dropDown2Option5");
		sPage.fillNoneTextField(advancedSearchDropDown5);
	}
	
	@Test(groups = "smokeTest")
	public void searchWithDropdownRelatedToandSecondDropdownStartsWith() throws Throwable {


		/*read the common data from property file*/
		String advancedSearchDropDown1 = fUtil.readDataFromPropertyFile("advancedSearchDropDown1");
		
		/*STEP 2: Navigate To Contacts*/
		SearchOrganizationsFromLastName cPage=new SearchOrganizationsFromLastName(driver);
		cPage.getContactsButton().click();

		/*STEP 3 : Navigate to Create New Contact Page*/
		cPage.getCreateContactImg().click();

		/*Create New Contact*/
		String LASTNAME = exUtil.getDataFromExcelSheet("Sheet1", 14, 2)+ jUtil.getRamdomNumber();
		CreatingNewContactsPage cncp = new CreatingNewContactsPage(driver);
		cncp.createNewContact(LASTNAME);

		/*STEP : 4 Verification*/
		ContactInformationPage cIp = new ContactInformationPage(driver);
		String actualContactInfo = cIp.getContactInfo().getText();
		boolean contactStatus = actualContactInfo.contains(LASTNAME);
		Assert.assertTrue(contactStatus, "Contact name is not created - FAIL");
		System.out.println("Contact Name Created : "+LASTNAME);

		/* STEP : 5 Navigate To Opportunity Page*/
		OpportunitiesPage opPage = new OpportunitiesPage(driver);
		opPage.getOpportunitiesLink().click();

		/*Navigate To Create Opportunity Page */
		opPage.getCreateOpportunityImg().click();


		/*STEP : 6 Create New Opportunity*/
		String opportunityName = exUtil.getDataFromExcelSheet("Sheet1", 14, 0)+ jUtil.getRamdomNumber();
		String expCloseDate = exUtil.getDataFromExcelSheet("Sheet1", 14, 1);

		CreateNewOpportunityPage cnop = new CreateNewOpportunityPage(driver);
		cnop.fillMandatoryFields(opportunityName, expCloseDate);
		SearchOrganizationsFromLastName sofln = new SearchOrganizationsFromLastName(driver);
		sofln.searchLastName(LASTNAME);
		cnop.getSaveButton().click();

		/*STEP:7 Verification*/
		OpportunityInformationPage oIp = new OpportunityInformationPage(driver);
		String actualOpportunityInfo = oIp.getOpportunityInfo().getText();
		boolean opportunityStatus = actualOpportunityInfo.contains(opportunityName);
		Assert.assertTrue(opportunityStatus, "Opportunity is not created - Fail");
		System.out.println("Opportunity is created : "+opportunityName);

		/*Click on opportunities link*/
		opPage.getOpportunitiesLink().click();

		/*STEP:8 Navigate to advanced search area*/
		Search sPage= new Search(driver);

		sPage.getAdvancedSearchButton().click();

		sPage.fillAdvancedSearchFields(advancedSearchDropDown1);

		/* Handle Pop up*/
		wdUtil.swithToAlertWindowAndAccpect(driver);
		
		String advancedSearchDropDown6 = fUtil.readDataFromPropertyFile("dropDown2Option6");
		sPage.fillNoneTextField(advancedSearchDropDown6);
	}
}
