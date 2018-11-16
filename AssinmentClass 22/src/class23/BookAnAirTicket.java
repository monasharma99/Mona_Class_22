package class23;



import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;





public class BookAnAirTicket {

	
	WebDriver driver;
	
	
	@Test

	public void openBrowser() throws IOException  {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe" );	
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://www.newtours.demoaut.com/");
		driver.findElement(By.name("userName")).sendKeys("monasharma");
		driver.findElement(By.name("password")).sendKeys("Password");
		driver.findElement(By.name("login")).click();
		
		
		Select DeparCity = new Select(driver.findElement(By.name("fromPort")));
		DeparCity.selectByVisibleText("London");
		
		Select ArivalCity = new Select(driver.findElement(By.name("fromPort")));
		ArivalCity.selectByVisibleText("London");
		
		
		
		WebElement on = driver.findElement(By.name("fromDay"));
		new Select(on);
		
	
	
	
	
	}
	
	





		public void TakeScreenshot() throws Exception {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source, new File("C:\\ScreenShotsfrom Seleniume"));
		
	}

	
	}
		


