package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.TestPages.testpages;
import com.TestUtil.TestUtil;

import TestBase.testbase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefinition extends testbase{
	testpages tp;

	
	@Before
	public void setup()
	{
		String log4jConfPath = System.getProperty("user.dir")+"\\src\\main\\java\\log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
		logger.info("Lunanching the browser");
		initializer();
	tp = new testpages();
	}

	

	@Given("Set SkyBlue Background button exists")
	public void set_SkyBlue_Background_button_exists() throws Exception {
	logger.info("check color");
	tp.verifySetSkyBlueBackgroundbuttonexists();
	Thread.sleep(3000);
	}
	
	@Then("user clicks on the button")
	public void user_clicks_on_the_button() {
	   tp.clickonthebuttonSkyBlue();
	}

	@When("the background color will change to sky blue")
	public void the_background_color_will_change_to_sky_blue() {
	    tp.backgroundcolorchangetoskyblue();
	    TestUtil.captureScreenShot(driver, "skybluecolor");
	   
	}
	
	@Given("Set SkyWhite Background button exists")
	public void set_SkyWhite_Background_button_exists() throws Exception {
	    tp.verifyskyWhiteBackgroundbuttonexists();
	    Thread.sleep(3000);
	}

	@When("I click on the button")
	public void i_click_on_the_button() {
		tp.verifyclickonthebutton();
	    
	}

	@Then("the background color will change to white")
	public void the_background_color_will_change_to_white() {
		tp.verifybackgroundcolorwillchangetowhite();
	   // driver.quit();
	}
	@After
	public void TearDown() {
		driver.quit();
	}
	
	
}
