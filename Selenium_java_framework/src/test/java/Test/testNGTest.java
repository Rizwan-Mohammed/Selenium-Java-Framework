package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGTest {

	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("chromedriver.driver", projectPath+"/Selenium_java_framework/Selenium_java_framework");
		driver = new  ChromeDriver();
		System.out.println(projectPath);
	}
	@Test
	public void googleSearchPage() {
		driver.get("https://google.com");
		WebElement textBoxSearch = driver.findElement(By.cssSelector("#APjFqb"));
		textBoxSearch.sendKeys("this is done for TestNG test");
		
		WebElement searchButton = driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[4]/center[1]/input[1]"));
		searchButton.sendKeys(Keys.RETURN);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
