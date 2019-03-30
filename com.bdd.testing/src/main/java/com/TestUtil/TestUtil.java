package com.TestUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import TestBase.testbase;

public class TestUtil extends testbase{

	public static long implicitwait = 20;
	public static long pageloadtimeout= 20;
	public static void captureScreenShot(WebDriver driver, String screenshotname) {
		TakesScreenshot ts = (TakesScreenshot) driver; //Typecast
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File ("./Screenshot/"+screenshotname+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
	}
