package Test;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.googleSearchPageObjects;

public class screenShotExample {

	WebDriver driver = null;

	@BeforeTest
	public void setup() {
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		System.setProperty("webdriver.chromedriver.driver", projectPath + "Driver/ChromeDriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@Test(priority = 1)
	public void googleTestPage() throws InterruptedException {
		googleSearchPageObjects g1 = new googleSearchPageObjects(driver);
		driver.get("https://google.com");
		g1.setTextBoxSearch("this is the text");
		g1.clickOnSearchButton();
		Thread.sleep(10000);

		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles().size());
	}

	
	  @Test(priority=2) public void getScreenshotTest() throws IOException {
	 TakesScreenshot scrshot1 = ((TakesScreenshot)driver); File srcFile =
	 scrshot1.getScreenshotAs(OutputType.FILE); String destFileLocation =
	 "/Users/rizwanmohammedshaik/git/Selenium_java_framework/Selenium_java_framework/Saved Screenshot/sample.png"
	  ; File destFile = new File(destFileLocation); FileHandler.copy(srcFile,
	  destFile); }
	 

	@AfterTest
	public void tearDown() {
//		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); this is deprecated
		driver.close();
		driver.quit();

	}

}
