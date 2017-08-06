package GenericLibrary;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {
	public static ExtentReports er;
	public ExtentTest startTest; 
	public WebDriver bwr;
	public String browser_type;
	public String tcid;
	public String order;
//	public String btype="ff";

	@BeforeSuite(groups={"Smk"})
	public void createreport() {
		er = new ExtentReports("E:\\newreport_"+get_newdatetimestamp() +".html", false);
//		er = new ExtentReports("E:\\DecFramework\\Report\\Ecommerce_"+get_datetimestamp() +".html",false);
	//	er = new ExtentReports("E:\\newrepor.html");
	}

	public String get_newdatetimestamp() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh-mm-ss");
		String format = dateFormat.format(date);
		return format;

	}


	@Parameters({"browser"})
	@BeforeMethod(groups={"Smk"})
	public void launchapp(String btype) throws IOException {
		browser_type = btype;
		if (btype.equals("ff")) {
			bwr = new FirefoxDriver();
		} else if (btype.equals("ch")) {
			System.setProperty("webdriver.chrome.driver","D:\\Selenium\\Drivers\\chromedriver.exe");
			bwr = new ChromeDriver();
		} else if (btype.equals("ie")) {
			System.setProperty("webdriver.ie.driver","D:\\Selenium\\Drivers\\IEDriverServer.exe");
			bwr = new InternetExplorerDriver();
		}
		bwr.get(Utility.getval(Utility.getval("env")));
		bwr.manage().window().maximize();
		bwr.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);

	}
	@AfterMethod(groups={"Smk"})
	public void closeapp(){
		er.flush();
		er.endTest(startTest);
		bwr.close();
	}

}
