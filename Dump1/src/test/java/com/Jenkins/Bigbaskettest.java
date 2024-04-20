package com.Jenkins;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Bigbaskettest {
	
	@Test
	public void big() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/ps/?q=apple&nc=as");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		JavascriptExecutor jss = (JavascriptExecutor) driver;
		jss.executeScript("window.scrollBy(0,500)");
		WebElement add = driver.findElement(By.xpath(
				"//h3[text()='Apple - Royal Gala Economy']/ancestor::div[@class='SKUDeck___StyledDiv-sc-1e5d9gk-0 eA-dmzP']/descendant::button[@class='Button-sc-1dr2sn8-0 ezcVVO CtaOnDeck___StyledButton3-sc-orwifk-2 hRCLjF CtaOnDeck___StyledButton3-sc-orwifk-2 hRCLjF']"));
		add.click();
		System.out.println("Jenkings");

	}
}
