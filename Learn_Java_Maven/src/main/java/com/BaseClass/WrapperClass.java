package com.BaseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WrapperClass {
	private WebDriver driver;
	public void launchApplication() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_80.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.navigate().to("https://www.facebook.com/");
		driver.findElement(By.xpath("(//label[contains(text(),'Email or phone')]//following::input)[1]")).clear();
		driver.findElement(By.xpath("(//label[contains(text(),'Email or phone')]//following::input)[1]")).sendKeys("abc@gmail.com");
		Thread.sleep(2000);
		driver.close();
	}
}