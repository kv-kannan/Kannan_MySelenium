package Week1.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		//Enter Principal value
		WebElement principal = driver.findElement(By.id("principal"));
		principal.sendKeys("90000000");
		System.out.println(principal);
		//Enter Interest
		WebElement interest = driver.findElement(By.id("interest"));
		interest.sendKeys("9");
		System.out.println(interest);
		Thread.sleep(3000);
		WebElement period = driver.findElement(By.id("tenure"));
		period.sendKeys("10");
		WebElement dd = driver.findElement(By.id("tenurePeriod"));
		Select sel = new Select(dd);
		sel.selectByIndex(2);
		WebElement freq = driver.findElement(By.id("frequency"));
		Select freqsel = new Select(freq);
		freqsel.selectByIndex(4);
		WebElement cal = driver.findElement(By.xpath("//*[@id=\'fdMatVal\']/div[2]/a[1]/img"));
		//WebElement cal = driver.findElement(By.xpath(/html/body/div[7]/div[2]/div/div[5]/div/div[1]/div[3]/form/div[2]/a[1]/img));
		
		//*[@id="resp_matval"]/strong
		
		cal.click();	
		WebElement dynamic = driver.findElement(By.xpath("//*[@id=\"resp_matval\"]/strong"));
		String dystring = dynamic.getText();
		System.out.println(dystring);
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
	}

}
