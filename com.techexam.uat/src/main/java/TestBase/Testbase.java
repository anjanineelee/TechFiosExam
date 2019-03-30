package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import TestUtil.TestUtil;

public class Testbase {
//1st we will create a constructor and we will create  properties file for communicate with file 
// we will be using Properties and webdriver oftenly so creating a global variables line 11 and 12
//then call properties object in constructor method
// file input stream is a class and its responsible for reading the config file thats why we are pasting the config path 
	public static Properties prop;
	public static WebDriver driver;
	
	public Testbase()// constructor with class name its going to communicate with properties file
	{
		
		prop = new Properties();
		
		//FileInputStream is comig from java.io
		try {
			FileInputStream fle = new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\com.techexam.uat\\src\\main\\java\\config\\config.properties");
			prop.load(fle);  // we are telling to read and load the file at run time (load is comimg from properties class
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
	public static void initialize()// to launch browser
	{
		// browser is coming from config file and its a url so its a string.. 
		String Browser = prop.getProperty("browser");// the browser inside () is from config file
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver","\\C:\\Driver\\chromedriver.exe\\");
			//System.setProperty("webdriver.chrome.driver", "\\C:\\Users\\gm129\\eclipse-workspace\\Driver\\chromedriver.exe");
	        driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","\\C:\\Driver\\geckodriver.exe\\");
			driver = new FirefoxDriver();
	}

		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageloadtimeout, TimeUnit.SECONDS); //pageloadouttime coming from util class
		driver.manage().timeouts().implicitlyWait(TestUtil.implicttimeout, TimeUnit.SECONDS); //implicitywait coming from util class 
		driver.get(prop.getProperty("url")); //getting URL from config. 100% Abstraction
	}

	
}

