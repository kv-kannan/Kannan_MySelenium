package DataDriven1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BothCorrect {
		
	  @Test
	  public void loginForm () throws InterruptedException {
		  System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com/");
		  driver.manage().window().maximize();
		  WebElement un = driver.findElement(By.id("txtUsername"));
		  un.sendKeys("Admin");
		  WebElement pwd = driver.findElement(By.id("txtPassword"));
		  pwd.sendKeys("admin123");
		  WebElement btlogin = driver.findElement(By.id("btnLogin"));
		  btlogin.click();
		  Thread.sleep(5000);
		  driver.quit();
		  	  
		  
	  }
	}


