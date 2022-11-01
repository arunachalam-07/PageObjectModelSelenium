package pageobjectmodehandson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
 * Page Object model is used to segregate finding strategies  
 * because UI may not be stable it may be changed in future so we separate finding elements and remaining code in separate file 
 * so that we can easily able to change finding strategies and it wont affect working of our code
 */

public class PageObjectModel1 {
	WebDriver driver;

	@BeforeTest
	public void initiateBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"/home/arunachalam/eclipse-workspace/learn_automation_online/selenium/drivers/chromedriver");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	@Parameters("url")
	public void openUrl(String url) {

		PageObjectModelSample1.targetUrl(driver, url);

	}

	@Test(dependsOnMethods = "openUrl")
	@Parameters({ "username", "password" })
	public void loginAction(String username, String password) {
		PageObjectModelSample1.usernameField(driver).sendKeys(username);
		PageObjectModelSample1.passwordField(driver).sendKeys(password);
		PageObjectModelSample1.clickLoginButton(driver);

	}

	@Test(dependsOnMethods = "loginAction")
	public void logoutAction() {
		PageObjectModelSample1.logout(driver);

	}

	@Test(dependsOnMethods = "logoutAction")
	public void closeBrowser() {
		PageObjectModelSample1.close(driver);
	}

}
