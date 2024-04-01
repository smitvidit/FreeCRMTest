package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(css = ".user-display")
	WebElement user;

	@FindBy(xpath = "//a[@href=\"/contacts\"]")
	WebElement contacts;

	@FindBy(xpath = "//div[3]//button[1]//i[1]")
	WebElement newContacts;

	@FindBy(css = "a[href=\"/deals\"]")
	WebElement deals;

	@FindBy(css = "a[href=\"/tasks\"]")
	WebElement task;

	// Initializing Page Objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();

	}

	public String checkCorrectUser() {
		String onUser = user.getText();
		return onUser;
	}

	public Contacts clickonContacts() {
		contacts.click();
		return new Contacts();
	}

	public void clickonNewContacts() {
		Actions action = new Actions(driver);
		action.moveToElement(contacts).build().perform();
		newContacts.click();
		;

	}

	public Deals clickonDeals() {
		deals.click();
		return new Deals();
	}
}
