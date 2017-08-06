package TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class CrossBrowser {

		//For Firefox Browser
	//	@Test
		public void TC1() throws Exception{
		FirefoxDriver ff = new FirefoxDriver();
		ff.get("https://www.allahabadbank.in/english/emi_calculator.aspx");
		ff.manage().window().maximize();
		Thread.sleep(2000);
		ff.findElement(By.id("one")).sendKeys("3500000");
		Thread.sleep(2000);
		ff.findElement(By.id("two")).sendKeys("8");
		Thread.sleep(2000);
		ff.findElement(By.id("three")).sendKeys("240");
		Thread.sleep(2000);
		ff.findElement(By.name("B1")).click();
		Thread.sleep(2000);
		ff.close();
		}
		//For Chrome Browser
	//	@Test
		public void TC2() throws Exception{
		Thread.sleep(4000);
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Drivers\\chromedriver.exe");
		ChromeDriver ch = new ChromeDriver();
		ch.get("https://www.allahabadbank.in/english/emi_calculator.aspx");
		Thread.sleep(2000);
		ch.findElement(By.id("one")).sendKeys("3500000");
		Thread.sleep(2000);
		ch.findElement(By.id("two")).sendKeys("8");
		Thread.sleep(2000);
		ch.findElement(By.id("three")).sendKeys("240");
		Thread.sleep(2000);
		ch.findElement(By.name("B1")).click();
		Thread.sleep(2000);
		ch.close();
		}
		//For Internet Explorer Browser
//		@Test
		public void TC3() throws Exception{
		Thread.sleep(4000);
		System.setProperty("webdriver.ie.driver", "D:\\Selenium\\Drivers\\IEDriverServer.exe");
		InternetExplorerDriver ie = new InternetExplorerDriver();
		ie.get("https://www.allahabadbank.in/english/emi_calculator.aspx");
		Thread.sleep(2000);
		ie.findElement(By.id("one")).sendKeys("3500000");
		Thread.sleep(2000);
		ie.findElement(By.id("two")).sendKeys("8");
		Thread.sleep(2000);
		ie.findElement(By.id("three")).sendKeys("240");
		Thread.sleep(2000);
		ie.findElement(By.name("B1")).click();
		Thread.sleep(2000);
		ie.close();
		}
	

}
