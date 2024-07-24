package Test.shopClueTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import shopCluePages.shopCluesHomePage;

public class Test3_actionsClass {

	WebDriver driver = null;
	String projectPath;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	@BeforeTest
	public void setUpBrowserAndPage() {
		//setting path and set property to configure for Chromedriver
		projectPath=System.getProperty("user.dir");
		System.setProperty("WebDriver.ChromeDriver.Driver", projectPath+"/driver");
		
		//disabling popus ups by opening in Incognito
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
		driver.get("https://www.shopclues.com/");	
		
	}
	@BeforeClass
	public void setUpExtentReports() {
		htmlReporter = new ExtentHtmlReporter("riz_test3_report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@Test
	public void navigateToClearanceSaleButtonViaAction() throws InterruptedException {
		ExtentTest test1 = extent.createTest("Test3_Action_demo");
		shopCluesHomePage p1 = new shopCluesHomePage(driver);
		test1.info("moving this to the clearanceButton");
		Thread.sleep(3000);
		p1.clickOnDontAllowButtonOnHomePage();
		test1.log(Status.INFO, "this is to dont allow the popup disappear");
		Thread.sleep(2000);
		p1.navigateToClearance();
		test1.pass("This is now clicked and passed");
		
		Thread.sleep(4000);		
		test1.log(Status.INFO, "info on this");
	}
	
	@AfterClass
	public void closeExtentReportProperly() {
		extent.flush();
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
