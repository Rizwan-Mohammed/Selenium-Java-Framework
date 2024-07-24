package Test.shopClueTest;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import shopCluePages.shopCluesHomePage;

public class Test4_RobotClass {

	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	@BeforeTest
	public void setUpBrowserAndPage() {
		System.setProperty("WebDriver.ChromeDriver.driver", projectPath+"/driver");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
		driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
		driver.get("https://www.shopclues.com/");
	}
	
	@BeforeClass
	public void extentReportSetup() {
		htmlReporter = new ExtentHtmlReporter("riz_test4_report");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);	
	}
	
	@Test
	public void RobotClassTest() throws AWTException, InterruptedException {
		shopCluesHomePage p1 = new shopCluesHomePage(driver);
		Thread.sleep(2500);
		p1.clickOnDontAllowButtonOnHomePage();
		Thread.sleep(2500);
		p1.navigteToClearanceUsingRobot();
	}
	
	
	@AfterClass
	public void flushExtentReport() {
		extent.flush();
	}
	
	@AfterTest
	public void tearDownBrowser() {
		driver.close();
		driver.quit();
	}
}
