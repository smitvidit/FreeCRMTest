package com.cra.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	Contacts contacts;

	String Sheetname = "contacts";

	public ContactsPageTest() {
		super();
		System.out.println("This is called : Constructor of Contacts");
		
		System.out.println("This is called : Constructor of Contacts");
	}

	@BeforeMethod
	public void setUp() {

		initialization();
		loginPage = new LoginPage();

		contacts = new Contacts();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contacts = homePage.clickonContacts();

	}

	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(Sheetname);
		return data;
	}

	@Test(dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String fname, String lname) throws InterruptedException {
		homePage.clickonNewContacts();
		contacts.createNewContact(fname, lname);

		System.out.println(fname + " is added");
		Thread.sleep(3000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
