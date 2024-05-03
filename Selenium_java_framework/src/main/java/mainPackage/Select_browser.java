package mainPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Select_browser {
	
	static WebDriver driver = null;
	static String projectPath = "/Users/rizwanmohammedshaik/Documents/Projects/Selenium project/Selenium_java_framework/Driver";
	
	public void firefoxBrowser() {
		driver = new FirefoxDriver();
		System.setProperty("webdriver.geckodriver", projectPath+"/FirefoxDriver/geckodriver");
		driver.get("https://google.ca");
	}
	
	public void chromeBrowser() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chromedriver", projectPath+"/ChromeDriver/chromedriver");	
		driver.get("https://google.ca");
	}
}
