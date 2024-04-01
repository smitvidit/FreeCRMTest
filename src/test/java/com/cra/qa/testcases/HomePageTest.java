package com.cra.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	Contacts contacts;

	public HomePageTest() {
		super();
		System.out.println("This is called : Constructor of HomePage");
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();

		contacts = new Contacts();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void validateCurrentUserTest() {
		String user = homePage.checkCorrectUser();
		Assert.assertEquals(user, "Vidit Patel");
	}

	@Test
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}

	@Test
	public void verifyContactsTest() {
		contacts = homePage.clickonContacts();

	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
