package class24;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptExecutor {

	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://www.facebook.com/");
	}

	@Test
	public void enterText() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('email').value='abc@gmail.com'");
		js.executeScript("document.getElementById('pass').value='password'");
		js.executeScript("document.getElementById('loginbutton').click()");

	}
}
//Perfect