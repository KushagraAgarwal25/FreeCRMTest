package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class CreateNewConatctPage extends TestBase {
	
	@FindBy(name = "first_name")
	WebElement firstName;
	
	@FindBy(name = "last_name")
	WebElement lastName;
	
	@FindBy(name = "middle_name")
	WebElement middleName;
	
	@FindBy(xpath = "//div[@name = 'company']/input[@class = 'search']")
	WebElement company;
	
	@FindBy(xpath = "//button[@class = 'ui linkedin button']")
	WebElement SaveButton;
	
	//Initializing the Page Objects:
	public CreateNewConatctPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyNewContactPageURL(){
		String NewContactURL = driver.getCurrentUrl();
		return NewContactURL;
	}
	
	public void createNewContact(String fName, String lName, String mName, String comp) throws InterruptedException{
		
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		middleName.sendKeys(mName);
//		WebDriverWait wait = new WebDriverWait(driver, 30);
//		wait.until(ExpectedConditions.visibilityOf(company)); 
//		wait.until(ExpectedConditions.elementToBeSelected(company));
		company.sendKeys(comp);	
		company.sendKeys(Keys.ENTER);
		SaveButton.click();
		Thread.sleep(2000);
	}
	
	
}
