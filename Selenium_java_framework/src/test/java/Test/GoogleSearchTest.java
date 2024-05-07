package Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.GoogleSearchPage;

public class GoogleSearchTest {

	static WebDriver driver = null;
	static String projectPath = System.getProperty("user.dir");	
	
	public static void main(String[] args) {
		
	System.out.println(projectPath);
	googleSearchTest1();
	
	}
	
	public static void googleSearchTest1() {
		System.setProperty("webdriver.chromedriver.driver", projectPath+"/Driver/ChromeDriver/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://google.ca");
		
		GoogleSearchPage.textBox_Search(driver).sendKeys("POM1");
		GoogleSearchPage.Search_button(driver).sendKeys(Keys.RETURN);
	}
	
}
