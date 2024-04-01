package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Contacts extends TestBase {

	@FindBy(css = "input[name='first_name']")
	WebElement firstName;

	@FindBy(css = "input[name='last_name']")
	WebElement lastName;

	@FindBy(xpath = "//button[@class='ui linkedin button']")
	WebElement save;

	public Contacts() {
		PageFactory.initElements(driver, this);
	}

	public void createNewContact(String f, String l) {
		firstName.sendKeys(f);
		lastName.sendKeys(l);

		save.click();
		;
	}

}
