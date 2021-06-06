package com.applicationname.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.applicationname.qa.base.TestBase;
import com.applicationname.qa.pages.Homepage;
import com.applicationname.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	Homepage homepage;
	
	public LoginPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		intialization();
	 loginpage=new LoginPage();
		
		
	}
	
	
	@Test (priority=1)
	
	public void loginpageTitleTest()
	{
	String title=	loginpage.validateloginPageTitle();
	System.out.println( title);
		Assert.assertEquals( title,"CRMPRO  - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void crmlogoTest()
	{
	         boolean flag=loginpage.validatecrmLogo();
	         Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
	homepage=	loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	
	public void tearDown()
	{
		driver.quit();
		
	}

}
