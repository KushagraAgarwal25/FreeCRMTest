package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//*[@id='dashboard-toolbar']/div[1]/")
	WebElement contactsLabel;

	@FindBy(xpath = "//a[@href = '/contacts/new']")
	WebElement newConatctLink;

	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyContactPageURL(){
		String ContactURL = driver.getCurrentUrl();
		return ContactURL;
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//*[contains(text(),'" + name + "')]")).click();
		/// preceding-sibling::td//input[@name = 'id']
	}

	public CreateNewConatctPage clickOnNewContactLink() {
		newConatctLink.click();
		return new CreateNewConatctPage();
	}

}

// org.openqa.selenium.InvalidSelectorException: invalid selector: The result of
// the xpath expression "//*[@id='dashboard-toolbar']/div[1]/text()" is: [object
// Text]. It should be an element.
// (Session info: chrome=79.0.3945.130)
// For documentation on this error, please visit:
// https://www.seleniumhq.org/exceptions/invalid_selector_exception.html
// Build info: version: '3.141.59', revision: 'e82be7d358', time:
// '2018-11-14T08:17:03'
// System info: host: 'HP', ip: '192.168.1.19', os.name: 'Windows 8', os.arch:
// 'amd64', os.version: '6.2', java.version: '1.8.0_05'
// Driver info: org.openqa.selenium.chrome.ChromeDriver
// Capabilities {acceptInsecureCerts: false, browserName: chrome,
// browserVersion: 79.0.3945.130, chrome: {chromedriverVersion: 79.0.3945.36
// (3582db32b3389..., userDataDir: C:\Users\KUSHA_~1\AppData\L...},
// goog:chromeOptions: {debuggerAddress: localhost:54580}, javascriptEnabled:
// true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform:
// WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true,
// strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000,
// script: 30000}, unhandledPromptBehavior: dismiss and notify}
// Session ID: bd095ec5a1ec2aba156388e0f662c396
// *** Element info: {Using=xpath,
// value=//*[@id='dashboard-toolbar']/div[1]/text()}
