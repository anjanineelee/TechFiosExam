package com.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import TestUtil.Testutil;

public class testbase {
	
	public static Properties prop;
	public static WebDriver driver;
	public static final Logger logger = Logger.getLogger(testbase.class.getName()); 
	public static String localdirectory = System.getProperty("user.dir");
	
	
	public testbase()// constructor
	{
		prop = new Properties();
		System.out.println("My Local Dir "+localdirectory);
try {
	FileInputStream fle = new FileInputStream(localdirectory + "\\src\\main\\java\\Config\\config.properties");
	prop.load(fle);
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

	
	public static void initializer()
	{
		String Browser = prop.getProperty("browser");//from config
		if (Browser.equalsIgnoreCase("chrome"))// from config
		{
			System.setProperty("webdriver.chrome.driver",localdirectory +"\\src\\main\\resources\\chromedriver.exe\\");
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gekco.driver",localdirectory+"\\src\\main\\resources\\geckodriver.exe\"");
			driver = new FirefoxDriver();
		}
		driver.manage().window();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICITYWAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGELOADOUTTIME, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));// from config
		
	}
	
	@BeforeTest
    public void log() {
       
        String log4jConfPath = System.getProperty("user.dir")+"\\src\\main\\resources\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
}
}
