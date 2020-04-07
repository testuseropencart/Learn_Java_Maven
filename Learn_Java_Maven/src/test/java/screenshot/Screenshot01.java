package screenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Screenshot01 
{
	protected WebDriver driver;
	@BeforeMethod
	public void launchApplication()
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver_80.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.navigate().to("http://demowebshop.tricentis.com/");
	}
	@Test
	public void loginIntoDemoWbShop()
	{
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("manojkumar.manoj.2697@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("manojkumar");
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
	}
	@AfterMethod
	public void takeScreenshot() throws IOException
	{
		TakesScreenshot ss = (TakesScreenshot)driver;
		File screenshot = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./ScreenShots/Screenshot01.jpeg"));
	}
	@AfterClass
	public void logOutAndCloseBrowser()
	{
		driver.findElement(By.linkText("Log out")).click();
		driver.close();
	}
}