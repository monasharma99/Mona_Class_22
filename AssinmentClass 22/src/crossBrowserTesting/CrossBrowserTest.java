package crossBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	WebDriver driver;
	String expectedValue;
	String actualValue;

	@BeforeTest
	@Parameters("browser")

	public void openBrowser(String browser) {
		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.equals("Internet Explorer")) {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		else if (browser.equals("Firefox")) {
			System.setProperty("webdriver.FirefoxDriver.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browser.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", "MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/");
	}

	@Test(priority = 0)

	public void VerifySignInButton() {
		boolean signInButton = driver.findElement(By.id("login-submit")).isEnabled();
		Assert.assertFalse(signInButton);
	}

}

//Good