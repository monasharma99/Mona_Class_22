package codeFromDeepinder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidateTimeFormat {
	WebDriver driver;
	private static Matcher matcher;
	private static Pattern pattern;

	private static final String TimePattern = "[012][0-9]:[0-5][0-9]:[0-5][0-9]";

	public ValidateTimeFormat() {
		pattern = Pattern.compile(TimePattern);
	}

	public static boolean validateTime(String time) {
		matcher = pattern.matcher(time);
		return matcher.matches();
	}

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.timeanddate.com/worldclock/india/new-delhi");
	}

	@Test
	public void validateTime() {
		String time = driver.findElement(By.id("ct")).getText();

		Assert.assertTrue(validateTime(time));

	}

}
