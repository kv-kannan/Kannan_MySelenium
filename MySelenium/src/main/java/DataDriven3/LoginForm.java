package DataDriven3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginForm {
	
	String [][] data ={
		{"Admin","admin1234"},
		{"Admin1234","admin123"},
		{"Admin1234","admin1234"},
		{"Admin","admin123"}
		};
	
	@DataProvider()
	public String[][] loginDataProvider() {
		return data;
	}
	  @Test(dataProvider="loginDataProvider")
	  public void loginForm (String uname, String upwd) throws InterruptedException {
		  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		  
		  WebDriver driver = new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com/");
		  driver.manage().window().maximize();
		 
		  WebElement un = driver.findElement(By.id("txtUsername"));
		  un.sendKeys(uname);
		  
		  WebElement pwd = driver.findElement(By.id("txtPassword"));
		  pwd.sendKeys(upwd);
		  
		  WebElement btlogin = driver.findElement(By.id("btnLogin"));
		  btlogin.click();
		  
		  Thread.sleep(5000);
		  driver.quit();
		  	  
		  
	  }
	}


