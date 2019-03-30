package com.techexam.uat;

import org.junit.Test;

import junit.framework.Assert;


public class exectest {

	@Test
	public void testadd()
	{
		testingjunit test = new testingjunit ();
		Assert.assertEquals(30, test.add(10, 20));
	}
	
}
