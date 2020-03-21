package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}
	// test cases should be separated == independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home Page title not matched");

	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}

	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		contactsPage = homePage.clickOnContactsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}