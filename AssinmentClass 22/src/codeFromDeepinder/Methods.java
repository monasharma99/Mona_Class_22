package codeFromDeepinder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Methods {
	private static WebDriver driver;
	private static Actions action;

	public static void openBrowser() {
		driver = new ChromeDriver();
	}

	public static void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public static void implementImplicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void goToUrl(String baseUrl) {
		driver.get(baseUrl);
	}

	public static void enterSourceCity(String value, String param) throws InterruptedException {
		driver.findElement(By.id(value)).clear();
		driver.findElement(By.id(value)).sendKeys(param);
		Thread.sleep(1000);

		action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}

	public static void enterDestination(String value, String param) throws InterruptedException {
		driver.findElement(By.id(value)).clear();
		driver.findElement(By.id(value)).sendKeys(param);
		Thread.sleep(1000);

		action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
	}

	public static void selectDateFromCalendar(String applicationName) {
		if (applicationName.equals("MakeMyTrip")) {
			driver.findElement(By.id("hp-widget__depart")).click();
			WebElement comingMonth = driver.findElement(By.xpath("(//div[contains(@class,'last')])[1]"));
			List<WebElement> columns = comingMonth.findElements(By.tagName("td"));

			for (WebElement x : columns) {
				if (x.getText().equals("12")) {
					x.click();
					break;
				}
			}
		}

		else if (applicationName.equals("Expedia")) {
			driver.findElement(By.id("flight-departing-single-hp-flight")).click();
			WebElement comingMonth = driver.findElement(
					By.cssSelector("#flight-departing-wrapper-single-hp-flight > div > div > div:nth-child(5) > table"));
			List<WebElement> columns = comingMonth.findElements(By.tagName("td"));

			for (WebElement x : columns) {
				if (x.getText().contains("12")) {
					x.click();
					
					break;
				}
			}

		}
	}

	public static void clickSearchButton(String locator, String value) throws InterruptedException {
		if (locator.equals("id")) {
			driver.findElement(By.id(value)).click();
		}

		else if (locator.equals("cssSelector")) {
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(value)).click();
		}

	}

	public static void pickLeastPrice(String locator, String value) {
		String leastPrice = null;
		if (locator.equals("cssSelector")) {
			leastPrice = driver.findElement(By.cssSelector(value)).getText();
		}

		else if (locator.equals("xpath")) {
			leastPrice = driver.findElement(By.xpath(value)).getText();
		}
		System.out.println("Least price available = Rs " + leastPrice);
	}

	public static void pickAirlineName(String locator, String value) {
		String airlineName = null;
		if (locator.equals("cssSelector")) {
			airlineName = driver.findElement(By.cssSelector(value)).getText();
		} else if (locator.equals("xpath")) {
			airlineName = driver.findElement(By.xpath(value)).getText();
		}

		System.out.println("And is being offered by " + airlineName);
	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void clickFlightTab(String value) {
		driver.findElement(By.id(value)).click();
	}

	public static void selectOneWayTrip(String value) {
		driver.findElement(By.id(value)).click();
	}

}
