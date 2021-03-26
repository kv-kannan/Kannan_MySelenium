package DataDriven4;



import java.io.FileInputStream;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class LoginForm{

	//1
	String[][] data = null;
	WebDriver driver;
	

	//2
	@DataProvider(name="loginData")
	public String[][] loginDataProvider() throws BiffException, IOException{

		data = getExcelData();
		return data;
	}

	//3
	public String[][] getExcelData() throws BiffException, IOException{

		FileInputStream excel = new FileInputStream("D:\\SELENIUM\\DataDrivenLoginExcel.xls");
		Workbook workbook = Workbook.getWorkbook(excel);

		Sheet sheet = workbook.getSheet(0);
		int rowcount = sheet.getRows();
		int columncount = sheet.getColumns();
		
		String testData[][] = new String[rowcount-1][columncount];
		
		for(int i=1; i<rowcount; i++) {
			for(int j=0; j<columncount; j++) {
				testData[i-1][j]=sheet.getCell(j,i).getContents();
			}
			
		}

		return testData;
	}
	@BeforeTest
	public void beforeTest() {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();	
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void afterTest() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.quit();
	}

	//4.
	@Test(dataProvider = "loginData")
	public void allForm(String uname,String upwd) throws InterruptedException {

		
		WebElement un = driver.findElement(By.id("txtUsername"));
		un.sendKeys(uname);

		WebElement up = driver.findElement(By.id("txtPassword"));
		up.sendKeys(upwd);

		WebElement bt = driver.findElement(By.id("btnLogin"));
		bt.click();
		
		Thread.sleep(1000);


	}




}

