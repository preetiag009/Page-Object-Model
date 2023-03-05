package com.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExtentReportsUtility;

public class CheckYourEmailPage extends BaseTest{
	
	@FindBy(xpath ="//div/p[@class='senttext mb12'][1]")WebElement message;
	
	public CheckYourEmailPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTextFromMessage() {
		String s = message.getText();
		extentReport.logTestInfo("Text retrieved from check email page.");
		logger.info("Text retrieved from check email page.");
		return s;
	}
}
