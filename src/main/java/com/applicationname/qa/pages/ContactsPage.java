package com.applicationname.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.applicationname.qa.base.TestBase;

public class ContactsPage  extends TestBase {
	
	
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(name="surname")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement save;
	
	
	
	
	public ContactsPage ()
	{
		PageFactory.initElements(driver, this);
		
		}
	
	
	public boolean verifyContactsLabel()
	{
		return contactsLabel.isDisplayed();
	}
	
   public void selectContactByName(String name) {
	   driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
   }

   
   
   public void createNewcontact(String title, String frstName,String lstName ,String comp)
   {
	   Select select =new Select(driver.findElement(By.name("title")));
	   select.selectByVisibleText(title);
	     
	       firstName.sendKeys(frstName);
	       lastName.sendKeys(lstName);
	       company.sendKeys(comp);
	       save.click();
	
   }
}
