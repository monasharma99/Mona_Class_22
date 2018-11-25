package codeFromDeepinder;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DDF {
	WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
	}

	@Test
	public void printPriceTest() throws InterruptedException, IOException {
		String[][] data = ReadExcel.getData("TestData.xlsx", "Sheet1");

		for (int i = 1; i < data.length; i++) {
			String source = data[i][1];
			String destination = data[i][2];

			// Select the source
			driver.findElement(By.id("hp-widget__sfrom")).clear();
			driver.findElement(By.id("hp-widget__sfrom")).sendKeys(source);
			Thread.sleep(1000);

			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();

			// Select the destination
			driver.findElement(By.id("hp-widget__sTo")).clear();
			driver.findElement(By.id("hp-widget__sTo")).sendKeys(destination);
			Thread.sleep(1000);
			action.sendKeys(Keys.ENTER).build().perform();

			// Select 12th of coming month from calendar
			if (i == 1) {
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

			// Click Search
			driver.findElement(By.cssSelector("#searchBtn")).click();

			// Print min price and corresponding Airline for the source and destination
			String minPrice = driver.findElement(By.cssSelector(
					"#content > div > div.container.ng-scope > div.row > div.main.col-lg-9.col-md-9.col-sm-12.col-xs-12 > div:nth-child(5) > div > div.top_first_part.clearfix > div.col-lg-2.col-md-2.col-sm-2.col-xs-4.text-right.price_sectn.make_relative.pad0 > p.price_info.RobotoRegular > span.num.ng-binding"))
					.getText();
			String airline = driver.findElement(By.cssSelector(
					"#content > div > div.container.ng-scope > div.row > div.main.col-lg-9.col-md-9.col-sm-12.col-xs-12 > div:nth-child(5) > div > div.top_first_part.clearfix > div.col-lg-2.col-md-2.col-sm-2.col-xs-2.logo_section.padR0 > span.block.append_bottom3.clearfix > span.pull-left.airline_info_detls > span.logo_name.append_bottomSpace6.hidden-xs.visible-stb.ng-binding.ng-scope"))
					.getText();

			System.out.println("From " + source + "to" + destination + ",minimum price = Rs." + minPrice
					+ " and is being offered by " + airline);

			driver.navigate().back();
		}

	}

}
