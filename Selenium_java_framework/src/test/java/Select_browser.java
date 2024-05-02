import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Select_browser {

	public static void main(String[] args) {
		
		
	}
	
	public static void firefoxBrowser() {
		WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.geckodriver", "/Users/rizwanmohammedshaik/Documents/Projects/Selenium project/Selenium_java_framework/Driver/FirefoxDriver/geckodriver");
		driver.get("https://google.ca");
	}
	
	public static void chromeBrowser() {
	
	}
}
