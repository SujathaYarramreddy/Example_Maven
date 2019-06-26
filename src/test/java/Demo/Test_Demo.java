package Demo;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_Demo {
	WebDriver driver;

	@BeforeTest
	public void BT() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedrivernew.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
	}

	@Test
	public void testcase() throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		  driver.findElement(By.id("btnLogin")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.id("welcome")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
		  Thread.sleep(3000);
	}
	
	@AfterTest
	public void AT() {
		String expectedtitle = "OrangeHRM";
		String actualtitle = driver.getTitle();
		Assert.assertEquals(expectedtitle, actualtitle);
		driver.close();
		
	}
}

