package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

	static WebElement element;
	
	
	public static WebElement textBox_Search(WebDriver driver) {
		element = driver.findElement(By.name("q"));
		
		return element;
	}
	
	public static WebElement Search_button(WebDriver driver) {
		
		element = driver.findElement(By.cssSelector("div.L3eUgb:nth-child(2) div.o3j99.ikrT4e.om7nvf:nth-child(3) div:nth-child(1) div.A8SBwf:nth-child(1) div.FPdoLc.lJ9FBc:nth-child(5) center:nth-child(1) > input.gNO89b"));
		return element;
	}
}
