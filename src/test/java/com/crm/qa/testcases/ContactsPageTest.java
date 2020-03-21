


package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(enabled = false)
	public void verifyContactsLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");

	}

	@Test(priority = 1)
	public void ContactsPageURLTest() {
		Assert.assertEquals(contactsPage.verifyContactPageURL(), "https://ui.freecrm.com/contacts");

	}

	@Test(priority = 2)
	public void selectContactsTest() {
		contactsPage.selectContactsByName("agar kush");
	}

	@Test(priority = 3)
	public void selectMultipleContactTest() {
		contactsPage.selectContactsByName("hghjjh nkjhkhk");
		contactsPage.selectContactsByName("love kush");
		contactsPage.selectContactsByName("kush Agarwal");
	}

	@Test(enabled = false)
	public void clickOnNewContactLinkTets() {
		contactsPage.clickOnNewContactLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}