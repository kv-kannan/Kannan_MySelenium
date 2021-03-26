package BankProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginForm {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Go to http://www.demo.guru99.com/V4/  - url
		driver.get("http://www.demo.guru99.com/V4/");
		String cururl = driver.getCurrentUrl();
		System.out.println(cururl);
		String tit = driver.getTitle();
		System.out.println(tit);
		//Enter the Valid UserID
		WebElement username = driver.findElement(By.name("uid"));
		username.sendKeys("mngr316501");
		//Enter the valid password
		WebElement pwd = driver.findElement(By.name("password"));
		pwd.sendKeys("amAhadU");
		//Click login button
		WebElement btLogin = driver.findElement(By.name("btnLogin"));
		btLogin.click();
		String currenturl = driver.getCurrentUrl();
		System.out.println(currenturl);
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(2000);
		driver.quit();
		
	}

}
