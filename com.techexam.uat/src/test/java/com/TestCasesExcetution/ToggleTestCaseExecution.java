package com.TestCasesExcetution;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import TestBase.Testbase;
import TestPages.toggleTestpage;

public class ToggleTestCaseExecution extends Testbase{
	toggleTestpage ttp;
	
	public ToggleTestCaseExecution()//constructor is responsible to communicate 
	{
		super();
	}
	
	@Before
	public void setup() throws Exception
	{
		initialize();
		ttp = new toggleTestpage();// calling toggleTestpage page here
		Thread.sleep(4000);
	}
	
	@Test
	public void clicktoggleTestpage() throws Exception
	{
		ttp.ValidateChecks();
		Thread.sleep(6000);
		
	}
	@Test
	public void clickremove() throws Exception
	{
		ttp.validateRemove();
		Thread.sleep(2000);
	}
	
	@Test 
	public void verifyremoveall()
	{
		ttp.validateRemoveAll();
		driver.navigate().back();
	}
	@After
	public void TearDown()
	{
		driver.quit();
	}
}

