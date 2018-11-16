package class24;

import java.io.IOException;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class VerifyAllLinks {

	WebDriver driver;
	public static void verifyUrlStatus(String URL) throws ClientProtocolException, IOException {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(URL);
		HttpResponse response =  client.execute(request);
		
		if (response.getStatusLine().getStatusCode()!=200) {
			System.out.println("Non working link = " + URL);
		}
	}
	
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://facebook.com/");
	}
	@Test
	public void checkAllLinks()throws ClientProtocolException, IOException {
		List<WebElement>Links = driver.findElements(By.tagName("a"));
		for (WebElement x : Links) {
			String Url = x.getAttribute ("href");
			verifyUrlStatus("url");
				
	}

}
}