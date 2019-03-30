package TestCaseExceution;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;// import this libaray 
import com.TestBase.testbase;
import TestPages.Catagory_test_pages;
import TestUtil.Testutil;

public class testcase_exe_catagory extends testbase {
	Catagory_test_pages ctp; // Catagory_test_pages created short name Catagory_test_pages class
	
	String sheetnamefromxls= "catagory";// sheet name must match with execl sheetname 
	
	//Logger log = Logger.getLogger(testcase_exe_catagory.class);
	
	public testcase_exe_catagory()
	{ 
		
		super();
		
	}
	
@BeforeMethod // comming from testng

public void setup() throws Exception
{
	logger.info("launching browser");//logger coming from testbase clasee we have created a global variable .info is the method and iam wriring the textmsg
	initializer();
	ctp = new Catagory_test_pages();//as methods in Catagory_test_pages class are non static creating an object
	Thread.sleep(3000);
	
}
@DataProvider
public Object [][] getsheetfromxls(){
	Object[][] data=Testutil.getTestData(sheetnamefromxls);//Testutil.getTestData is coming from testutil class and gettestdata is the methodname
	return data;
}

@Test(dataProvider="getsheetfromxls") // coming from testng//namecatagory coming from excel
public void clickcatagory(String name) throws Exception //name coming from excel sheet
{
 logger.info("adding category");
ctp.verifyaddcatagory(name);//name coming from execlsheet
 Thread.sleep(3000);
 Testutil.capturesceernshot(driver, "catagorypage");
	
}
@Test(dataProvider="getsheetfromxls")
public void duplicatecategory(String name) throws Exception
{
	logger.info("duplicate entry");
	ctp.verifyduplicatecatagory(name);
	Thread.sleep(3000);
		
}

@Test
public void month() // this method is to verify list of months in calendar
{
	ctp.verifymonth();
}

@AfterMethod // coming from testng
public void TearDown()
{
	driver.quit();
}
}
