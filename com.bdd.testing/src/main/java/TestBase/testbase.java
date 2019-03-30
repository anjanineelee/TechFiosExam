package TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.TestUtil.TestUtil;

import cucumber.api.java.Before;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class testbase {

	
	public static Properties prop;
	public static WebDriver driver;
	public static final Logger logger = Logger.getLogger(testbase.class.getName()); 
	
	public testbase()
	{
		try {
			prop = new Properties();
			FileInputStream fle = new FileInputStream("C:\\Users\\Administrator\\TechFios-Projects\\com.bdd.testing\\src\\main\\java\\config\\config.properties");
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
		String Browser = prop.getProperty("browser");
		if(Browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "\\C:\\Driver\\chromedriver.exe\\");
			driver = new ChromeDriver();
			
		}
		else if(Browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.geckco.driver", "\\C:\\Driver\\geckcodriver.exe\\");
			driver = new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window();
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitwait,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageloadtimeout, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));// from config
		
	}   
	
	
}
