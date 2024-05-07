package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.googleSearchPageObjects;

public class GoogleSearchPageTest2UsingObject {
	public static WebDriver driver = null;
	static String projectPath = System.getProperty("user.dir");
	
	
	public static void main(String[] args) {
		initiatingBrowser();
		googleSearchTestMethod2();
		googleSearchTestMethod3();
		tearDownBrowser();
		
	}
	
	public static void initiatingBrowser() {
		System.setProperty("webdriver.chromedriver.driver", projectPath+"/Driver/ChromeDriver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://google.ca");
		
		
	}
	
	public static void googleSearchTestMethod2() {
		googleSearchPageObjects obj1 = new googleSearchPageObjects(driver);
		obj1.setTextBoxSearch("this is coming from testmethod2");
		obj1.clickOnSearchButton();
		//driver.close();
	}
	

	public static void googleSearchTestMethod3() {
		driver.navigate().back();
		String title = driver.getTitle();
		System.out.println("title is now on method3" + title);
		// trying to add explicit wait
		WebDriverWait w1 = new WebDriverWait(driver, java.time.Duration.ofMillis(2000));
		w1.until(ExpectedConditions.titleContains(title));
		
		
		googleSearchPageObjects obj1 = new googleSearchPageObjects(driver);
		obj1.setTextBoxSearch("text from text method 3");
		obj1.clickOnSearchButton();
	}
	
	public static void tearDownBrowser() {
		driver.close();
	}
	
	
	
}
