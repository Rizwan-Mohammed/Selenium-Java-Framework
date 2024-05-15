package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportWithTestNG {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver=null;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeSuite
	public void setup() {
		htmlReporter = new ExtentHtmlReporter("TestNG Extent report.html");
		extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		
		
	}
	@BeforeTest
	public void setupTest1() {
		System.setProperty("webdriver.chromedriver.driver", projectPath+"Selenium_java_framework/Selenium_java_framework/Driver/ChromeDriver");
		driver = new ChromeDriver();
	}
	
	
	@Test
	public void testNGTest() throws IOException {
		ExtentTest test1 = extent.createTest("GoogleChromeSearchPageTest");
		test1.log(Status.INFO, "Startng the test");
		
		driver.get("https://google.com");
		test1.pass("successfully navigated to the page");
		
		driver.findElement(By.name("q")).sendKeys("this is extenreport test");
		test1.pass("successfully found the element");
		
		driver.findElement(By.cssSelector("div.L3eUgb:nth-child(2) div.o3j99.ikrT4e.om7nvf:nth-child(3) div:nth-child(1) div.A8SBwf:nth-child(1) div.FPdoLc.lJ9FBc:nth-child(5) center:nth-child(1) > input.gNO89b")).sendKeys(Keys.RETURN);
		test1.pass("successfully found the element");
		
		test1.pass("passed", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		test1.addScreenCaptureFromPath("screenshot.png");
		test1.info("test completed");
		
	}
	@AfterTest
	public void tearDownTest1() throws Exception {
		//driver.wait(2);
		driver.close();
		driver.quit();
	}
	

	@BeforeTest
	public void setupTest2() {
		System.setProperty("webdriver.chromedriver.driver", projectPath+"Selenium_java_framework/Selenium_java_framework/Driver/ChromeDriver");
		driver = new ChromeDriver();
	}
	
	@Test
	public void failedTestNGTest() throws IOException {
		ExtentTest failedTest = extent.createTest("Failed test case");
		failedTest.log(Status.INFO, "testing failed testcase");
		
		driver.get("https://yahoo.com");
		failedTest.pass("navigated to yahoo");
		
		String headerIs = driver.getTitle();
		
		if(headerIs == "google") {
			failedTest.pass("navigated to google page");
		}
		else {
			failedTest.fail("failed", MediaEntityBuilder.createScreenCaptureFromPath("failedTest.png").build());
			failedTest.addScreenCaptureFromPath("failedTest.png");
			failedTest.fail("this test has failed as the title is not same as Header expected");
		}
	}
	
	@AfterTest
	public void tearDownTest2() throws Exception {
		//driver.wait(2);
		driver.close();
		driver.quit();
	}
	
	@AfterSuite
	public void teardown() {
		extent.flush();
	}
	
}
