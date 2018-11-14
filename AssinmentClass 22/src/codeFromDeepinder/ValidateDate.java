package codeFromDeepinder;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidateDate {
	
WebDriver driver;
	
	public static boolean dateIsValid(String date) {
		boolean validate = true;
		try {
			DateTimeFormatter formatter  = DateTimeFormat.forPattern("MMM dd, yyyy");
			DateTime dob = formatter.parseDateTime(date);
		}
		catch(Exception e) {
			validate = false;
		}
		return validate;
	}

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/");
	}
	
	@Test
	public void dateValidationTest() {
		String date = driver.findElement(By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td:nth-child(3) > form > table > tbody > tr:nth-child(1) > td > font > b")).getText();
		Assert.assertTrue(dateIsValid(date));		
	}
	

}
