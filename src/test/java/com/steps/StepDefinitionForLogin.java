package com.steps;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitionForLogin extends BaseTest {
//	public static WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	CheckYourEmailPage checkyouremailpage;
	ForgotPasswordPage forgotpasswordpage;
	
	@BeforeAll
	public static void logStart() {
		logger = LogManager.getLogger(BaseTest.class.getName());
		logger.info("The test has started.");
	}
	
	@AfterAll
	public static void logEnd() {
		logger.info("The test has completed.");
	}
	
	@Before
	public static void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
	}
	
	@Given("Application is up and running")
	public WebDriver application_is_up_and_running() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		Thread.sleep(2000);
		return driver;
	}

	@When ("User on {string}" )
	public void user_on(String page) {
		switch (page) {
		case "loginpage" : loginpage = new LoginPage(driver);
		break;
		case "homepage" : homepage = new HomePage(driver);
		break;
		case "checkyouremailpage" : checkyouremailpage = new CheckYourEmailPage(driver);
		break;
		case "forgotpasswordpage" : forgotpasswordpage = new ForgotPasswordPage(driver);
		break;
		default : System.out.println("Inavalid page");
			
		}
	}
	@When("Enter username")
	public void enter_username() throws InterruptedException, InvalidFormatException, IOException {
		Thread.sleep(2000);
		loginpage.enterUsername(getData(1,0));
		loginpage.clickLogin();
	}

	@Then("Error message should be displayed")
	public void error_message_should_be_displayed() throws InvalidFormatException, IOException {
		String expected = getData(1,2);
		String actual = loginpage.getTextFromError();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(actual, expected);
		driver.close();
	}
	
	@When("Enter valid username")
	public void enter_valid_username() throws InvalidFormatException, IOException {
		loginpage.enterUsername(getData(2,0));  
	}
	
	@When("Enter valid password")
	public void enter_valid_password() throws InvalidFormatException, IOException {
		loginpage.enterPassword(getData(2,1));
	}
	
	@When("Click on Login button")
	public void click_on_login_button() {
		loginpage.clickLogin();
	}
	
	@Then("Home page should be displayed")
	public void home_page_should_be_displayed() throws InvalidFormatException, IOException {
		String actual = homepage.getTextFromHomeTab();
		String expected = getData(2,2);
		Assert.assertEquals(actual, expected);
		driver.close();
	}
	
	@When("Check remember me")
	public void check_remember_me() {
		loginpage.clickCheckBox();
	}
	
	@When("Click on usermenu dropdown and logout button")
	public void click_on_usermenu_dropdown_and_logout_button() {
		homepage.clickdropDown();
		homepage.clickLogout();  
	}
	
	@Then("Username should be displayed")
	public void username_should_be_displayed() throws InterruptedException, InvalidFormatException, IOException {
		Thread.sleep(2000);
		String actual=loginpage.getTextFromidCard();
		String expected = getData(2,0);
		Assert.assertEquals(actual, expected);
		driver.close();
	}
	
	@When("Click on Forgot Password")
	public void click_on_forgot_password() {
		loginpage.clickForgotPassword();
	}
	
	@When("Provide username in username field and click continue")
	public void provide_username_in_username_field_and_click_continue() throws InvalidFormatException, IOException {
		forgotpasswordpage.enterTextUserId2(getData(2,0));
		forgotpasswordpage.clickContinue();
	}
	
	@Then("Password reset message is displayed")
	public void password_reset_message_is_displayed() throws InvalidFormatException, IOException {
		String expected = getData(3,2);
		String actual = checkyouremailpage.getTextFromMessage();
		Assert.assertEquals(actual, expected);
		driver.close();
	}
	
	@When("Enter invalid username and password")
	public void enter_invalid_username_and_password() throws InterruptedException, InvalidFormatException, IOException {
		loginpage.enterUsername(getData(4,0));
		loginpage.enterPassword(getData(4,1));
		Thread.sleep(2000);
	}
	
	@Then("Login error message should be displayed")
	public void login_error_message_should_be_displayed() throws InvalidFormatException, IOException {
		String actual = loginpage.getTextFromLoginError();
		String expected = getData(4,2);
		Assert.assertEquals(actual, expected);
		driver.close();
	}

	
}
