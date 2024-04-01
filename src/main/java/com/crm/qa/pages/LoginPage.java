package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory

	@FindBy(css = "input[placeholder='Email']")
	WebElement email;

	@FindBy(css = "input[placeholder='Password']")
	WebElement password;

	@FindBy(css = ".ui.fluid.large.blue.submit.button")
	WebElement LoginButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// ACtions
	public String validateLoginPage() {
		return driver.getTitle();
	}

	public HomePage login(String un, String pw) {
		email.sendKeys(un);
		password.sendKeys(pw);
		LoginButton.click();

		return new HomePage();
	}

}
