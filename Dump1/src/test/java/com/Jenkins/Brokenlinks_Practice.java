package com.Jenkins;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Brokenlinks_Practice {
@Test
public void broken() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("http://www.deadlinkcity.com/");
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println(Links.size());
		int brokenlinks = 0;
		for (WebElement Element : Links) {
			String url = Element.getAttribute("href");

			if (url == null || url.isEmpty()) {
				System.out.println(url + "-->" + " " + "Please be note that Currnet URL is Empty");
				continue;
			}
			try {
				URL link = new URL(url);

				HttpURLConnection httpcon = (HttpURLConnection) link.openConnection();
				httpcon.connect();
				brokenlinks++;

				if (httpcon.getResponseCode() >= 400) {
					System.out
							.println(link + "--->" + httpcon.getResponseCode() + " " + "  Current URL is Broken Link ");
				} else {
					System.out.println(link + "--->" + httpcon.getResponseCode() + " " + "  These Links are Valid");
				}
			} catch (Exception E) {

			}
			System.out.println(brokenlinks);
		}

	}
}
