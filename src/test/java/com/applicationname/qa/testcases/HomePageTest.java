package com.applicationname.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.applicationname.qa.base.TestBase;
import com.applicationname.qa.pages.ContactsPage;
import com.applicationname.qa.pages.Homepage;
import com.applicationname.qa.pages.LoginPage;
import com.applicationname.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	TestUtil testutil;
	LoginPage loginpage;
	Homepage homepage;
	ContactsPage contactslink;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
	 testutil =new TestUtil();
     contactslink =new ContactsPage();
     loginpage=new LoginPage();
    homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@Test(priority=1)
	public void verifyhomepageTitleTest() {
		String homepageTitle=homepage.verifyhomepageTitle();
		Assert.assertEquals(homepageTitle, "CRMPRO","Home page Title not matched");
		
	}
	
	@Test (priority=2)
	public void verifyuserNameTest() {
		testutil.switchToFrame();
	Assert.assertTrue(homepage.correctuserName());
	
	}
	
	@Test(priority=3)
	public void contactsLink() {
	testutil.switchToFrame();
		contactslink=homepage.clickOnconactsLink();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}
