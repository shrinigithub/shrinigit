package TestScripts;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import GenericLibrary.Base;
import PageFactoryPkg.PF_HomePage;
import PageFactoryPkg.PF_LoginPage;


public class LoginScript extends Base{
	
	@Test(dataProvider="ValidLogin",dataProviderClass=DataProviders.dp_login.class,enabled=true,priority=1,groups={"Smk","UAT","Reg"})
	public void Login(Map hm) throws Exception {
		
		String uid = hm.get("username").toString();
		String pwd = hm.get("pwd").toString();
		String exp_msg = hm.get("exp_msg").toString();
		 tcid = hm.get("TC_ID").toString();
		 order=hm.get("Order").toString();
		
		startTest = er.startTest(tcid+"_"+order+"_"+browser_type);
		
//		FirefoxDriver bwr = new FirefoxDriver();
//		bwr.get("http://books.rediff.com/");
//		bwr.manage().window().maximize();

//		bwr.findElement(By.linkText("Sign In")).click();
		
//		bwr.findElement(By.name("logid")).sendKeys(uid);
//		bwr.findElement(By.name("pswd")).sendKeys(pwd);
//		bwr.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();

		PF_HomePage pf_HomePage = new PF_HomePage(bwr);
		pf_HomePage.SignInLink_Click();					
		PF_LoginPage pf_LoginPage = new PF_LoginPage(bwr);
		pf_LoginPage.PFMtdLogin(uid, pwd);
		
		//Thread.sleep(4000);
		String act_msg = bwr.findElement(By.className("proper")).getText();
//		System.out.println("actual msg "+act_msg);
		String actual = act_msg.split(" ")[0];
//		System.out.println(actual);
		String act="Hi "+actual;
//		System.out.println("act "+act);
		if (act.equals(exp_msg)){
			startTest.log(LogStatus.PASS, "Valid Login", "TC to verify valid login");
			System.out.println("TC PASS");
		}else {
			startTest.log(LogStatus.FAIL, "InValid Login", "TC to verify Invalid login");
			System.out.println("TC FAIL");
		}
		bwr.close();
	
	}
	
	
	@Test(dataProvider="InvalidLogin",dataProviderClass=DataProviders.dp_login.class,enabled=true,priority=2,groups={"Smk"})
	public void InvalidLogin(Map hm) throws Exception {
		
		String uid = hm.get("username").toString();
		String pwd = hm.get("pwd").toString();
		String exp_msg = hm.get("exp_msg").toString();

//====		
//		FirefoxDriver bwr = new FirefoxDriver();
//		bwr.get("http://books.rediff.com/");
//		bwr.manage().window().maximize();
//====
		
//====
//		bwr.findElement(By.linkText("Sign In")).click();
//		bwr.findElement(By.name("logid")).sendKeys(uid);
//		bwr.findElement(By.name("pswd")).sendKeys(pwd);
//		bwr.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
//Thread.sleep(4000);
//====
		PF_HomePage pf_HomePage = new PF_HomePage(bwr);
		pf_HomePage.SignInLink_Click();
		PF_LoginPage pf_LoginPage = new PF_LoginPage(bwr);
		pf_LoginPage.PFMtdLogin(uid, pwd);
		
		
		String act_msg = bwr.findElement(By.xpath("//b[contains(text(),'Sorry we were unable to complete this step because')]")).getText();

		if (act_msg.equals(exp_msg)){
			
			System.out.println("TC PASS");
		}else {
			
			System.out.println("TC FAIL");
		}
		bwr.close();	
	}

}
