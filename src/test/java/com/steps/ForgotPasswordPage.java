package com.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExtentReportsUtility;

public class ForgotPasswordPage extends BaseTest {
		
	@FindBy(xpath= "//input[contains(@onkeypress,'checkCaps(event)')]") WebElement userId2;
	@FindBy(id ="continue") WebElement continueButton;
	
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterTextUserId2(String text) {
		userId2.sendKeys(text);
		extentReport.logTestInfo("Username entered on forgot password page" );
		logger.info("Username entered on forgot password page");
	}
	
	public void clickContinue() {
		continueButton.click();
		extentReport.logTestInfo("Continue button clicked." );
		logger.info("Continue button clicked.");
	}
	
	
	
}
