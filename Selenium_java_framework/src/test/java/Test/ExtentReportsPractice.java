package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsPractice {

	public static void main(String[] args) {
		String projectPath = System.getProperty("user.dir");
		System.out.println("user dir is " + projectPath);
		WebDriver driver = null;
		
		// Creates ExtentReports and attach reporter(s)
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("riz extent report.html"); // give file name in colon
		ExtentReports extent = new ExtentReports();
				
		// creates a toggle for the given test, adds all logs under it
		extent.attachReporter(htmlReporter);
		
		// this is how you declare the test with ExtentTest keyword
		ExtentTest googleTest = extent.createTest("Testing google 1");
		
		System.setProperty("webdriver.chromedriver.driver", projectPath+"Selenium_java_framework/Selenium_java_framework/Driver/ChromeDriver");
		driver = new ChromeDriver();
		googleTest.log(Status.INFO, "starting the test");
		driver.get("https://google.ca");
		
		
		driver.findElement(By.name("q")).sendKeys("this is extenreport test");
		googleTest.pass("search bar was located");
		
		driver.findElement(By.cssSelector("div.L3eUgb:nth-child(2) div.o3j99.ikrT4e.om7nvf:nth-child(3) div:nth-child(1) div.A8SBwf:nth-child(1) div.FPdoLc.lJ9FBc:nth-child(5) center:nth-child(1) > input.gNO89b")).sendKeys(Keys.RETURN);
		googleTest.pass("the search button was entered using the return");
		
		
		driver.close();
		driver.quit();
		googleTest.pass("test was completed");
		googleTest.info("test completed successfully");
		
		 
		//calling flush for the extent writes everything to the log file.
		extent.flush();
		
		
		// writing down the 2nd google test
		ExtentTest googleTestAgain = extent.createTest("Testing google 2");
		
		System.setProperty("webdriver.chromedriver.driver", projectPath+"Selenium_java_framework/Selenium_java_framework/Driver/ChromeDriver");
		driver = new ChromeDriver();
		googleTestAgain.log(Status.INFO, "starting the test");
		driver.get("https://google.ca");
		
		
		driver.findElement(By.name("q")).sendKeys("this is extenreport test");
		googleTestAgain.pass("search bar was located");
		
		driver.findElement(By.cssSelector("div.L3eUgb:nth-child(2) div.o3j99.ikrT4e.om7nvf:nth-child(3) div:nth-child(1) div.A8SBwf:nth-child(1) div.FPdoLc.lJ9FBc:nth-child(5) center:nth-child(1) > input.gNO89b")).sendKeys(Keys.RETURN);
		googleTestAgain.pass("the search button was entered using the return");
		
		
		driver.close();
		driver.quit();
		googleTestAgain.pass("test was completed");
		googleTestAgain.info("test completed successfully");
		
		 
		//calling flush for the extent writes everything to the log file.
		extent.flush();
		
		
		// added this comment to newly created branch and not master, will save and merge and commit to see if master has it
		
	}
	

}
