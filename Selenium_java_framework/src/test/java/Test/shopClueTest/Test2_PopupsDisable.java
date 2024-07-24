package Test.shopClueTest;

import java.io.IOException;
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

public class Test2_PopupsDisable {
	
	WebDriver driver=null;
	String projectPath = System.getProperty("user.dir");
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	@BeforeTest
	public void setUpPageAndBrowser() {
		System.out.println(projectPath);
		System.setProperty("Webdriver.ChromeDriver.driver", projectPath+"/Driver");	
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		driver = new ChromeDriver(option);
		driver.get("https://www.shopclues.com/");
		driver.manage().window().maximize();	
		driver.manage().deleteAllCookies();
	}
	
	
	@BeforeClass
	public void setUpExtentReports() {
		//setting up extent reports
		htmlReporter = new ExtentHtmlReporter("Riz_ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);	
	}
	
	
	
	@Test(priority=1)
	public void iFrameWindowOnHomePageTest1() throws InterruptedException {
		ExtentTest test1 = extent.createTest("iFrameWindowHomePagetest1");
		Thread.sleep(2000);
		test1.info("thread got slept for 2 seconds");
		shopCluesHomePage p1 = new shopCluesHomePage(driver);
		p1.clickOnDontAllowButtonOnHomePage();
		test1.pass("Dont allow button was clicked");
		test1.log(Status.INFO, "only can be proceed further after this step");
		
		Thread.sleep(2000);
		test1.info("thread got slept for 2 seconds");
		test1.info("test1 is passed");
	}
	
	@Test(priority=2)
	public void greenRibbonClickTest2() {
		ExtentTest test2 = extent.createTest("greenRibbonClickTest2");
		shopCluesHomePage p1 = new shopCluesHomePage(driver);p1.clickGreenRibbonMadeinIndia();
		test2.pass("Dont allow button was clicked");
		test2.info("test2 is passed");
	}
	
	@Test(priority=3)
	public void enterTextInTextboxTest3() throws IOException, InterruptedException {
		ExtentTest test3 = extent.createTest("enterTextInTextBoxTest3");
		shopCluesHomePage p1 = new shopCluesHomePage(driver); 
		p1.enterTextInSearchBox("iPhone 15 Pro Max");
		test3.pass("The test text has been entered successfully");
		Thread.sleep(2000);
		
		//test3.addScreenCaptureFromPath("test3_Screenshot.png");
		//p1.searchButtonBesideSearchTextBox();
		test3.pass("Search Button pressed successfully");
		test3.info("test3 is passed");
		
	}
	
	  @AfterTest 
	  public void tearDown()
	  { 
		 
		  driver.close(); 
		  driver.quit(); 
	  }
	  
	 @AfterClass
	  public void extentReportFlush() {
		 extent.flush();
	 }
}
