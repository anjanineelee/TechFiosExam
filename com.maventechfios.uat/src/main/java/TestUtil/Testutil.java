package TestUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.TestBase.testbase;

public class Testutil extends testbase{
	public static long PAGELOADOUTTIME=20;
	public static long IMPLICITYWAIT=30;
	
	static Workbook book; //import from apache poi
	static Sheet sheet;
	static FileInputStream file;
	
	//defining path for excel file
	public static String testdata_path= "C:\\Users\\Administrator\\TechFios-Projects\\com.maventechfios.uat\\src\\main\\java\\TestData\\Techfiosexam.xlsx";
	
	public static Object [][] getTestData(String sheetName){
		
			try {
				file = new FileInputStream(testdata_path);
				book = WorkbookFactory.create(file);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		sheet = book.getSheet(sheetName);
		Object [][] data = new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i = 0; i<sheet.getLastRowNum();i++) {
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}
	
	public static void capturesceernshot(WebDriver driver,String screenshotname)
	{
		try {
			TakesScreenshot tss	= (TakesScreenshot) driver;//TakesScreenshot is an interface
			File source = tss.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File ("./screenshot/"+"screenshotname"+".png"));
			
//("./screenshot/"+"screenshotname"+".png"))everytime it will create new file and ./ will search the screeshot folder created in package and 	screenshotname we will pass the name +.pmg is the extension 		
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
