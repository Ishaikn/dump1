package com.Jenkins;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenLinkstest {
	@Test
	public void links() throws IOException{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");

		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		System.out.println(allLinks.size());

		for (WebElement eachLink : allLinks) {
			String link = eachLink.getAttribute("href");

			try {
				URL url = new URL(link);// If URL was not found will get the Mulfound Exception//

				HttpURLConnection httpconn = (HttpURLConnection) url.openConnection();// we are performing downcasting
																						// bcz-->For this the super
																						// parent class is URL
																						// connection from here to we
																						// are downcasting the
																						// HttpURLConnection
				int statusCode = httpconn.getResponseCode();

				if (statusCode >= 400) {
					System.out.println(link + "--->" + statusCode);
				}

			} catch (IOException e) {

			}

		}

	}
}
