package com.applicationname.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.applicationname.qa.base.TestBase;
import com.applicationname.qa.pages.ContactsPage;
import com.applicationname.qa.pages.Homepage;
import com.applicationname.qa.pages.LoginPage;
import com.applicationname.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage;
	Homepage  homepage;
	TestUtil testutil;
	ContactsPage contactpage;
	
	String SheetName="Contacts";
	
@BeforeMethod
public void setup() {
	intialization();
	loginpage=new LoginPage();
	homepage=new Homepage();
    contactpage = new ContactsPage();
   testutil=new TestUtil();
	
    homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
    testutil.switchToFrame();
    contactpage=homepage.clickOnconactsLink();
    
    
}
    
@Test( priority=1)
public void verifyConatctslabel() {
	Assert.assertTrue(contactpage.verifyContactsLabel(),"Missing conact page label");
	
	
}

@Test (priority=2)
public void selectContactName()
{
	contactpage.selectContactByName("Apple Malvia");
}
    
@Test (priority=3)
public void selectMultipleContactName()
{
	contactpage.selectContactByName("Bogus Otani");
	contactpage.selectContactByName("Caliton Derra");
	contactpage.selectContactByName("Apricot Malvia");
	contactpage.selectContactByName("Banana Chautala");
}

@DataProvider
public Object[][] getCRMTestData() {

	Object data[][]=TestUtil.getTestData(SheetName);
	return data;
}

@Test(priority=4, dataProvider="getCRMTestData")
public void creatNewContact(String titl,String firstname,String lastname,String com) {
	homepage.clickOnNewContactLink();
//	contactpage.createNewcontact("Mr.", "Apple", "Malvia", "Google");
	contactpage.createNewcontact(titl, firstname, lastname, com);
}


    @AfterMethod
    public void tearDown() {
    	driver.quit();
    	
    }
}
