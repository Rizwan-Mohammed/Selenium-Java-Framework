package Test.shopClueTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import shopCluePages.shopCluesHomePage;

public class test1_ShopCluesHomePage {

	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir");
	shopCluesHomePage schp1 = new shopCluesHomePage(driver);

	@BeforeTest
	public void setupBrowser() throws InterruptedException, AWTException {
	System.setProperty("WebDriver.ChromeDriver.driver", projectPath+"/Selenium_java_framework/Selenium_java_framework");
	driver = new ChromeDriver();
	driver.get("https://www.shopclues.com/");
	Thread.sleep(2000);
	
	driver.switchTo().frame(1);
	
	
	 Alert alert = driver.switchTo().alert(); String alertText =
	 driver.switchTo().alert().getText(); System.out.println("Rizwan is "+
	  alertText); alert.dismiss();
	 
	
		Robot robot = new Robot();
	robot.mouseMove(200, 100);
	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	Thread.sleep(2000);
	robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	
	
	
	
	  Actions a = new Actions(driver); Thread.sleep(2000);
	  a.moveToElement(driver.findElement(By.xpath("//span[@class='moe-notification-title-safari']")));
	 
	  driver.findElement(By.xpath("//span[@class='moe-notification-title-safari']")).click();

	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
	
	
	
	}
	
	 @Test(priority=1) public void clickOnMadeInIndiaTest() throws
	  InterruptedException { Thread.sleep(2000);
	  schp1.clickGreenRibbonMadeinIndia(); }
	 
	  @Test(priority=2) 
	  public void clickOnGreenRibbonManTest() throws InterruptedException { 
		  Thread.sleep(2000); 
		  schp1.clickGreenRibbonMen();
		  }
	  
	  @Test(priority=3) 
	  public void enteringTextInSearchTest() throws
	  InterruptedException { Thread.sleep(2000);
	 schp1.enterTextInSearchBox("this is coming from Automation");
	  schp1.searchButtonBesideSearchTextBox(); }
	  
	  
	  @AfterTest 
	  public void tearDown()
	  { driver.close(); driver.quit(); }
	 

}
