package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class googleSearchPageObjects {
	
	WebDriver driver = null;
	public googleSearchPageObjects(WebDriver driver) { this.driver = driver; }
	
	static By textBox_Search = By.cssSelector("#APjFqb");
	static By search_Button = By.cssSelector("div.L3eUgb:nth-child(2) div.o3j99.ikrT4e.om7nvf:nth-child(3) div:nth-child(1) div.A8SBwf:nth-child(1) div.FPdoLc.lJ9FBc:nth-child(5) center:nth-child(1) > input.gNO89b");
	 
	
	public void setTextBoxSearch(String text) {
		driver.findElement(textBox_Search).sendKeys(text);
	}
	
	public void clickOnSearchButton() {
		driver.findElement(search_Button).click();
	}
	
	
	
}
