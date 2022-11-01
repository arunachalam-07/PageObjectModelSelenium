package pageobjectmodehandson1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class PageObjectModelSample1 {
	
	
	
	public  static void targetUrl(WebDriver driver , String url)
	{
		driver.get("https://demo.guru99.com/V4/index.php");
	}
	public static  WebElement usernameField(WebDriver driver)
	{
		WebElement username=driver.findElement(By.name("uid"));
		
		return username;
		
		
	}
	
	public static WebElement passwordField(WebDriver driver)
	{
		WebElement password=driver.findElement(By.name("password"));
		return password;
		
		
	}
	
	public static void clickLoginButton(WebDriver driver)
	{
		WebElement loginButton=driver.findElement(By.name("btnLogin"));
		loginButton.click();
	}
	public static void logout(WebDriver driver)
	{
		WebElement logoutLink=driver.findElement(By.partialLinkText("Log out"));
		logoutLink.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	@AfterTest
	public static void close(WebDriver driver)
	{
		driver.quit();
	}

}
