package TestPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.TestBase.testbase;

public class Catagory_test_pages extends testbase {

	@FindBy(name="data")
	WebElement typecatagory;

	@FindBy(name="submit")
	WebElement remove;
	@FindBy(name="submit")
	WebElement complete ;
	@FindBy(xpath="/html/body/div[4]/input[2]")
	WebElement add1;
	@FindBy(linkText="Back")
	WebElement errormsg;	
	@FindBy(name="due_month")
	WebElement month;
	//@FindBy (name="todo")
	//WebElement todolist;


	public Catagory_test_pages()
	{
		PageFactory.initElements(driver, this);
	}
	public void verifyaddcatagory(String name)
	{
		typecatagory.sendKeys(name);
		add1.click();
	}

	public void verifyduplicatecatagory(String name)
	{
		typecatagory.sendKeys(name);
		add1.click();
		System.out.println("duplicate entry"+ name);
		errormsg.click();
		//boolean er = errormsg.isDisplayed();
		//Assert.assertTrue(er, "duplicate entry");
		//driver.navigate().back();
		//todolist.isDisplayed();
	}

	public void verifymonth()
	{
		

		String[] exp = {"None","Jan","Feb","Mar","Apr","May","Jun","Jul","Sep","Oct","Nov","Dec"};
		Select select = new Select(month);//static dropdown we use select  .. when we spy and inspect on month webelement and we see select word then its a select class and we have to pass an webelement
		String mismatch = "";
		String match = "Y";
		List<WebElement> options = select.getOptions();  
		for(WebElement we:options)  
		{  

	//		System.out.println("My drop text "+we.getText());
			for (int i=0; i<exp.length; i++){
	//			System.out.println("My variable "+ exp[i]);
				if (we.getText().equals(exp[i]))
				{
					match = "Y";
					break;
				}
				else {
					match = "N";
					mismatch = we.getText();
								}

			}
			if (match.equals("N")) {
			System.out.println(mismatch);
			}
			//Assert.assertTrue(match);
		}  

	}

	//	public boolean isListElementsVisible() {
	//	    boolean result = false;
	//	    try {
	//	        WebDriverWait wait = new WebDriverWait(driver, 30);
	//	        wait.until(ExpectedConditions.visibilityOfAllElements(month));
	//	        result = true;
	//	    } catch (Exception e) {
	//	        System.out.println(e.getMessage());
	//	        result = false;
	//	    }
	//	   return result;
}

