package testCase;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;

public class loginPage {
	WebDriver driver;
	Workbook wb;
	Sheet sh;
	int nrows;
	int ncols;
	
	@BeforeTest
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Jar Files\\chromedriver.exe");
		driver= new ChromeDriver();
		//driver.manage().window().maximize();
		
		driver.get("https://www.phptravels.net/login");
	}
	@Test(dataProvider="testDatafeed")
	public void signIn(String email, String pass) {
		LoginPage lp=new LoginPage(driver);
		lp.singIn(email,pass);
	}
	
	@DataProvider
	public Object[][]testDatafeed() throws Exception{
		//Import the file
		FileInputStream fis = new FileInputStream("C:\\Users\\a66q8zz\\OneDrive - 3M\\Devops\\Training\\eclipse-workspace\\CaseStudy9\\src\\testData\\user.xlsx");
		//call workbook
		wb = WorkbookFactory.create(fis);
		//define the sheet
		sh = wb.getSheet("Sheet1");
		nrows = sh.getLastRowNum();
		ncols = sh.getRow(0).getLastCellNum();
		
		Object[][] formData= new Object[nrows][ncols];
		
		for(int row=0; row<nrows;row++) {
			for (int col=0;col<ncols;col++) {
				formData[row][col]=sh.getRow(row).getCell(col).toString();
			}
		}
		return formData;
		
	}
	
	
	/*
	 * @AfterTest public void CloseBrowser() { driver.quit(); }
	 */

}
