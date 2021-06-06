package com.applicationname.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.applicationname.qa.base.TestBase;

public class Homepage  extends TestBase {
	//object repository or pagefactory
	
	@FindBy(xpath="//td[contains(text(),'User: group automation')]")
	WebElement userNameLabel;
	@CacheLookup  // this will improve the speed of execution by creatinh cache memory
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	
	//intializing page objects
	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	//actions
	
	public String verifyhomepageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnconactsLink() {
	 contactsLink.click();
	 
	 return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
		
	}
	
	public TaskPage clickOnTasklink()
	{
		tasksLink.click();
		return new TaskPage();
	}

public boolean correctuserName()
{
	return userNameLabel.isDisplayed();
	
}

public void clickOnNewContactLink()
{
	Actions action =new Actions(driver);
	action.moveToElement(contactsLink).build().perform();
	newcontactLink.click();
}
}
