package projectObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckYourEmailPage {
	WebDriver driver;
	
	@FindBy(xpath ="//div/p[@class='senttext mb12'][1]")WebElement message;
	
	public CheckYourEmailPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTextFromMessage() {
		String s = message.getText();
		return s;
	}
}
