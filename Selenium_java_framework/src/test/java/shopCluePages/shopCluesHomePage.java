package shopCluePages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class shopCluesHomePage {

	WebDriver driver = null;
	
	public shopCluesHomePage(WebDriver driver) 
	{ 
		this.driver = driver; 
		
	}
	 
	 
	// all Webelements
	public By greenRibbonMadeinIndia = By.xpath("//li[@class='made']");
	public By greenRibbonMen = By.xpath("//li[@id=\"nav_43\"]");
	public By searchTextBox = By.xpath("//input[@id='autocomplete']");
	public By searchButton = By.cssSelector("div.sc_header:nth-child(8) div.ffix_header.removeAbc div.wrapper div.sc_search span:nth-child(1) > a.srch_action.btn.orange:nth-child(3)");
	public By iFrameOnHomeDontAllowButton = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/button[1]");
	public By iFrameOnHOmeAllowButton = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/button[2]");
	
	//clearanace sale Button
	By clearanceSaleButton = By.xpath("/html[1]/body[1]/div[7]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]");
	
	//alert box on homepage on first time navigation
	
	//greenRibbon option for me 
	public By grOptionMen = By.xpath("//body/div[4]/div[1]/div[1]/ul[1]/li[3]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]");
	
	public void clickGreenRibbonMadeinIndia() {
		driver.findElement(greenRibbonMadeinIndia).click();
	}
	
	public void clickGreenRibbonMen() {
		driver.findElement(greenRibbonMen).click();
	}
	
	public void enterTextInSearchBox(String textEntered) {
		driver.findElement(searchTextBox).clear();
		driver.findElement(searchTextBox).sendKeys(textEntered);
		driver.findElement(searchTextBox).sendKeys(Keys.RETURN);
	}
	
	// this is somehow not working, unable to interact with the element error on runtime
	public void searchButtonBesideSearchTextBox() {
		driver.findElement(searchButton).click();
	}
	 
	public void clickOnDontAllowButtonOnHomePage() {
		driver.findElement(iFrameOnHomeDontAllowButton).click();
	}
	
	public void navigateToClearance() {
		WebElement e = driver.findElement(clearanceSaleButton);
		Point point = driver.findElement(clearanceSaleButton).getLocation();
		int x = point.x;
		int y = point.y;
		System.out.println("the x coordinate is "+ x);
		System.out.println("the y coordinate is "+ y);
		Actions a = new Actions(driver);
		//a.moveToLocation(x, y).click();
//		a.moveToElement(e);
		//a.moveByOffset(x, y);
		a.moveToElement(e, x, y).perform();
		a.click(e).perform();;
		a.build().perform();
		//a.contextClick();
	}
	
	public void navigteToClearanceUsingRobot() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	//	WebElement e = driver.findElement(clearanceSaleButton);
		Thread.sleep(2500);
		robot.mouseWheel(10);
		Thread.sleep(2500);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(2500);
		robot.keyPress(KeyEvent.VK_CAPS_LOCK);
	}
	
	
	
}
