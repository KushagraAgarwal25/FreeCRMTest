package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateNewConatctPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class NewContactPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	CreateNewConatctPage newContactPage;

	String sheetName = "Contacts";

	public NewContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
		newContactPage = contactsPage.clickOnNewContactLink();

	}

	@Test(priority = 1)
	public void CreateNewContactPageURLTest() {
		Assert.assertEquals(newContactPage.verifyNewContactPageURL(), "https://ui.freecrm.com/contacts/new");
	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 2, dataProvider = "getCRMTestData")
	public void validateCreateNewContactTest(String firstName, String lastName, String middleName, String company) throws InterruptedException {
		// newContactPage.createNewContact("Tom", "Peter", "Kumar", "Google");
		newContactPage.createNewContact(firstName, lastName, middleName, company);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
