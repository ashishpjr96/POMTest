package com.applicationname.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.applicationname.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory / Object Repository
	
	@FindBy(xpath="//input[@name='username']")
			WebElement userName;
	
	@FindBy(name="password")
			WebElement passWord;
	
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUp;

	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//initalizing the page objects
	public  LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//actions
	public String validateloginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validatecrmLogo()
	{
		return crmLogo.isDisplayed();
	}
	
	public Homepage login(String un,String pass) {
		userName.sendKeys(un);
		passWord.sendKeys(pass);
		loginBtn.click();
		
		return new Homepage();   // since its landing on home page after login so return homepage object 
	}
	
	
}