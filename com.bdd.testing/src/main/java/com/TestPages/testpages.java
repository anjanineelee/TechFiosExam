package com.TestPages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestBase.testbase;

public class testpages extends testbase {

	@FindBy(xpath="//button[text()='Set SkyBlue Background']")
	WebElement skyblue;
	@FindBy(xpath= "//*[@id=\"extra\"]/button[2]")
	WebElement white;
//	@FindBy(name="allbox")
//	WebElement toglleall;
	@FindBy(xpath = "/html/body")
	WebElement skybluebackgroundcolor;
	@FindBy(xpath = "/html/body")
	WebElement whitebackgroundcolor;
	

	public testpages()
	{
		PageFactory.initElements(driver, this);
	}
	public void verifySetSkyBlueBackgroundbuttonexists()
	{
		

		boolean ble=skyblue.isEnabled();
				Assert.assertTrue(ble);

		System.out.println("skybluecolorbuttonexits " + " "  + ble);

	}
	public void clickonthebuttonSkyBlue()
	{
		skyblue.click();
		
	}
	public void backgroundcolorchangetoskyblue()
	{
     boolean ble = skybluebackgroundcolor.isDisplayed();
     Assert.assertTrue(ble);
     System.out.println("background color is skyblue   " + " " + ble) ;
	}
	
	public void verifyskyWhiteBackgroundbuttonexists()
	{
		boolean bel = white.isDisplayed();
		Assert.assertTrue(bel);
		System.out.println("sky White Back ground button exists " + bel);
	}
	
	public void verifyclickonthebutton ()
	{
		white.click();
	}
	
	public void verifybackgroundcolorwillchangetowhite()
	{
	boolean ble	= whitebackgroundcolor.isDisplayed();
	Assert.assertTrue(ble);
	System.out.println("Background color is white  "+ ble);
	}
}
