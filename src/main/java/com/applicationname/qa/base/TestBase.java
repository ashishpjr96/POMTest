package com.applicationname.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.applicationname.qa.util.TestUtil;
import com.applicationname.qa.util.WebEventListener;

public class TestBase {
	
public static WebDriver driver;
public  static Properties prop;
public static EventFiringWebDriver event_driver;
public static WebEventListener eventListener;

	
	public  TestBase() {
		 prop= new Properties();
		 try {
			FileInputStream ip= new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\PomTest\\src\\main\\java\\com\\applicationname\\qa\\config\\config.properties");
			prop.load(ip);
		} 
		 catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
		 catch (IOException  e) {
			e.printStackTrace();
		}
		}
	
public static void intialization()
{
	String browserName=prop.getProperty("browser");
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Desktop\\chromedriver_win32 (1)\\chromedriver.exe");
		driver= new ChromeDriver();

	}
	else if(browserName.equals("FF"))
	{
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\HP\\Desktop\\chromedriver_win32 (1)\\geckodriver.exe");
		driver= new FirefoxDriver();
	}
	
	 event_driver = new EventFiringWebDriver(driver);
	//Now create object of EventListenerHandler to register it with EventfiringWebDriver
       eventListener = new WebEventListener();
	event_driver.register(eventListener);
	driver=event_driver;
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	
}
	
	
	
	}


