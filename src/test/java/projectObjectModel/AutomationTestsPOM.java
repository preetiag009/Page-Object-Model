package projectObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationTestsPOM {

	@Test
	public static void loginErrorMessage1() throws InterruptedException {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(4000);
		loginPage loginpage = new loginPage(driver);
		loginpage.enterUsername("user@gmail.com");
		loginpage.clickLogin();
		String actual = "Please enter your password.";
		String expected = loginpage.getTextFromError();
		Assert.assertEquals(actual, expected);
		driver.close();
	}
	
	@Test
	public static void loginToSalesForce2() throws InterruptedException {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(4000);
		
		loginPage loginpage = new loginPage(driver);
		loginpage.enterUsername("preethi@tekarch.com");
		loginpage.enterPassword("Automation123");
		loginpage.clickLogin();
		
		HomePage homePage = new HomePage(driver);
		
		String actual = homePage.getTextFromHomeTab();
		String expected = "Home";
		Assert.assertEquals(actual, expected);
		driver.close();
	}
	
	@Test
	public static void checkRememberme3() throws InterruptedException {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(4000);
		
		loginPage loginpage = new loginPage(driver);
		loginpage.enterUsername("preethi@tekarch.com");
		loginpage.enterPassword("Automation123");
		loginpage.clickCheckBox();
		loginpage.clickLogin();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickdropDown();
		homePage.clickLogout();
		
		Thread.sleep(2000);
		String actual=loginpage.getTextFromidCard();
		String expected = "preethi@tekarch.com";
		Assert.assertEquals(actual, expected);
		driver.close();
		}
	@Test
	public static void forgotPassword4A() throws InterruptedException {
		
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(4000);
		
		loginPage loginpage = new loginPage(driver);
		loginpage.clickForgotPassword();
		
		ForgotPasswordPage forgotpasswordpage = new ForgotPasswordPage(driver);
		forgotpasswordpage.enterTextUserId2("preethi@tekarch.com");
		forgotpasswordpage.clickContinue();
		
		String expected = "We’ve sent you an email with a link to finish resetting your password.";
		CheckYourEmailPage checkYourEmailPage = new CheckYourEmailPage(driver);
		String actual = checkYourEmailPage.getTextFromMessage();
		Assert.assertEquals(actual, expected);
		driver.close();
	}
	
	@Test
	public static void forgotPassword4B() throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(4000);
		
		loginPage loginpage = new loginPage(driver);
		loginpage.enterUsername("123");
		loginpage.enterPassword("12321");
		loginpage.clickLogin();
		
		String actual = loginpage.getTextFromLoginError();
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		
		Assert.assertEquals(actual, expected);
		driver.close();
		
	}
}
