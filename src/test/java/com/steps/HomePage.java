package com.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ExtentReportsUtility;

public class HomePage extends BaseTest{

	@FindBy(xpath="//li[@id='home_Tab']") WebElement homeTab;
	@FindBy(xpath= "//div[@id='userNav-arrow']")WebElement dropDown;
	@FindBy(xpath="//a[contains(text(),'Logout')]") WebElement logout;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver clickLogout() {
		logout.click();
		extentReport.logTestInfo("Log out clicked");
		logger.info("Log out clicked");
		return driver;
	}
	
	public String getTextFromHomeTab() {
		String s = homeTab.getText();
		return s;
	}
	
	public void clickdropDown() {
		dropDown.click();
		extentReport.logTestInfo("Dropdown clicked");
		logger.info("Dropdown clicked");
	}
	

}


