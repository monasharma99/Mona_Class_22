package faceBook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Verify3Methods {
	WebDriver driver;
	String expectedValue;
	String actualValue;
	
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe" );	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		}
	
	@Test (priority=1)
	public void verifyText() {
		expectedValue = "It’s free and always will be.";
		actualValue = driver.findElement(By.cssSelector("#content > div > div > div > div > div._6_._74 > div.mbl._3m9._6o._6s._mf")).getText();
		Assert.assertEquals(actualValue, expectedValue);
	
	}
	@Test (priority=2, enabled = false)
	public void verifyFirstNameVisibility() {
	driver.findElement(By.xpath("//*[@id=\"u_0_9\"]")).sendKeys("Mona");
	boolean	firstName = driver.findElement(By.xpath("//*[@id=\"u_0_9\"]")).isEnabled();
	Assert.assertTrue(firstName);
		
	
	}
	@Test (priority=3)
	public void verifyErrorMessage() {
	driver.findElement(By.id("loginbutton")).click();
	boolean ErrorMessage = driver.findElement(By.cssSelector("#globalContainer > div.uiContextualLayerPositioner._572t.uiLayer > div > div > div")).isDisplayed();
	Assert.assertTrue(ErrorMessage);
		
	}

	}
	

