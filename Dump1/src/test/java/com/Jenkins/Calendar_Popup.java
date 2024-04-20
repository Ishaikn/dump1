package com.Jenkins;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar_Popup {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		String Monthdate = "April 2024";
		int date = 30;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));

		driver.get(
				"https://www.goibibo.com/flights/?utm_source=bing&utm_medium=cpc&utm_campaign=DF-Brand-EM&utm_adgroup=Only%20Goibibo&utm_term=!SEM!DF!B!Brand!RSA!150035352!1211662109442708!!e!goibibo!c!");
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']//parent::div[@class='sc-12foipm-16 wRKJm fswFld ']"))
				.click();
				//		driver.findElement(By.xpath(
				//				"//p[text()='1']/parent::div[@class='DayPicker-Day DayPicker-Day--start DayPicker-Day--selected DayPicker-Day--today']"))
				//				.click();
				//		driver.findElement(By.xpath("//p[text()='27']/ancestor::div[@class='DayPicker-Month' and @role='grid']/parent::div[@class='DayPicker-Months']")).click();		
		for (;;) {
			try {

				driver.findElement(By.xpath("//div[text()='" + Monthdate
						+ "']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='" + date + "']")).click();
				break;
			} catch (Exception e) {
				System.out.println("date is not visible");
				break;
			}
		}
	}
}
