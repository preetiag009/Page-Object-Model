package com.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExtentReportsUtility;

public class LoginPage extends BaseTest {

	@FindBy(id="username") WebElement username;
	@FindBy(id ="password") WebElement password;
	@FindBy(id="Login")WebElement loginButton;
	@FindBy(xpath="//div[@id='error']")WebElement error;
	@FindBy(xpath="//*[@id='idcard-identity']") WebElement idCard;
	@FindBy(xpath="//input[@id='rememberUn']") WebElement checkBox;
	@FindBy(id="forgot_password_link") WebElement forgotPassword;
	@FindBy(xpath="//form//div[@class='loginError']") WebElement loginError;
	
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String text) {
		username.sendKeys(text);
		extentReport.logTestInfo("Username entered");
		logger.info("Username entered");
	}
	
	public void enterPassword(String text) {
		password.sendKeys(text);
		extentReport.logTestInfo("Password entered");
		logger.info("Password entered");
	}
	
	public WebDriver clickLogin() {
		loginButton.click();
		extentReport.logTestInfo("Login button clicked.");
		logger.info("Login button clicked.");
		return driver;
	}
	
	public String getTextFromError (){
		String s = error.getText();
		logger.info("Error text retrieved.");
		extentReport.logTestInfo("Username entered");
		return s;
	}
	public String getTextFromidCard() {
		String s = idCard.getText();
		logger.info("Text retrieved from Id.");
		extentReport.logTestInfo("Text retrieved from Id.");
		return s;
	}
	
	public void clickCheckBox() {
		checkBox.click();
		logger.info("Checkbox clicked");
		extentReport.logTestInfo("Checkbox clicked.");
	}
	
	public WebDriver clickForgotPassword() {
		forgotPassword.click();
		logger.info("Forgot password clicked.");
		extentReport.logTestInfo("Forgot Password clicked.");
		return driver;
	}
	
	public String getTextFromLoginError() {
		String s =loginError.getText();
		logger.info("Login error retrieved.");
		extentReport.logTestInfo("Login error retrieved.");
		return s;
	}
}
