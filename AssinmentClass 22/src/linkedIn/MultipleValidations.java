package linkedIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleValidations {
	WebDriver driver;
	String expectedValue;
	String actualValue;

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/");
	}

	@Test(priority = 2)
	public void Medhod1() {
		driver.findElement(By.id("reg-email")).sendKeys("monasharma99@yahoo.ca");
		boolean EmailAddress = driver.findElement(By.id("reg-email")).isDisplayed();
		Assert.assertTrue(EmailAddress);

	}

	@Test(priority = 3)
	public void Method2() {
		expectedValue = "Get started - it's free.";
		actualValue = driver.findElement(By.cssSelector("#regForm > h3")).getText();
		Assert.assertEquals(actualValue, expectedValue);
	}

	@Test(priority = 1)
	public void Medhod3() {
		driver.findElement(By.id("reg-firstname")).sendKeys("MonaSharma");
		boolean FirstName = driver.findElement(By.id("reg-firstname")).isDisplayed();
		Assert.assertTrue(FirstName);

	}

}

// Good