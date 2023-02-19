package projectObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver driver;
	
	@FindBy(id="username") WebElement username;
	@FindBy(id ="password") WebElement password;
	@FindBy(id="Login")WebElement loginButton;
	@FindBy(xpath="//div[@id='error']")WebElement error;
	@FindBy(xpath="//*[@id='idcard-identity']") WebElement idCard;
	@FindBy(xpath="//input[@id='rememberUn']") WebElement checkBox;
	@FindBy(id="forgot_password_link") WebElement forgotPassword;
	@FindBy(xpath="//form//div[@class='loginError']") WebElement loginError;
	
	
	public loginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String text) {
		username.sendKeys(text);
	}
	
	public void enterPassword(String text) {
		password.sendKeys(text);
	}
	
	public WebDriver clickLogin() {
		loginButton.click();
		return driver;
	}
	
	public String getTextFromError (){
		String s = error.getText();
		return s;
	}
	public String getTextFromidCard() {
		String s = idCard.getText();
		return s;
	}
	
	public void clickCheckBox() {
		checkBox.click();
	}
	
	public WebDriver clickForgotPassword() {
		forgotPassword.click();
		return driver;
	}
	
	public String getTextFromLoginError() {
		String s =loginError.getText();
		return s;
	}
}
