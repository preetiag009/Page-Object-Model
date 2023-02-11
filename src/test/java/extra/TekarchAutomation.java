package extra;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TekarchAutomation extends BaseTest{
	
	public static void loginToFirebase() throws InterruptedException {
		String expected ="Student Registration Form";
		getDriverInstance("chrome");
		gotourl("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(5000);
		By logId = By.id("email_field");
		
		WebElement username = driver.findElement(logId);
		enterText(username,"admin123@gmail.com","usernameele");
		
		WebElement password = driver.findElement(By.id("password_field"));
		enterText(password,"admin123", "passwordele");
		
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(5000);
		
		WebElement regText = driver.findElement(By.xpath("/html/body/div[2]/div[2]/h1"));
		String actual = regText.getText();
		if (actual.equalsIgnoreCase(expected)) {
			System.out.println("Testcase passed");
		}
		else {
			System.out.println("Testcase failed");
		}
		driverClose();
	}
	
	public static void errorSalesforceLogin() {
		String expected = "Please enter your password.";
		getDriverInstance("chrome");
		gotourl("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.id("username"));
		String attrivalue = username.getAttribute("class");
		System.out.println("Atrribute value of class = "+ attrivalue);
		String tagName = username.getTagName();
		System.out.println("Tagname for the username field = "+ tagName);
		
		enterText(username, "username", "usernameEle");
		
		WebElement password = driver.findElement(By.id("password"));
		enterText (password, " ", "passwordEle");
		driver.findElement(By.id("Login")).click();
		String actual = driver.findElement(By.id("error")).getText();
		if (actual.equalsIgnoreCase(expected)) {
			System.out.println("Error_Login_Salesforce passed. ");
		}
		else {
			System.out.println("Error_Login_Salesforce failed. ");
		}
	}
	
	public static void registrationForm() throws InterruptedException {
		getDriverInstance("chrome");
		gotourl("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(5000);
		By logId = By.id("email_field");
		
		WebElement username = driver.findElement(logId);
		enterText(username,"admin123@gmail.com","usernameele");
		
		WebElement password = driver.findElement(By.id("password_field"));
		enterText(password,"admin123", "passwordele");
		
		driver.findElement(By.tagName("button")).click();
		Thread.sleep(5000);
		
		WebElement nameEle = driver.findElement(By.id("name"));
		enterText (nameEle, "Abcd", "nameEle");
		
		WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@id='radiobut' and @value='female']"));
		femaleRadioButton.click();
		
		WebElement cityDropdown = driver.findElement(By.id("city"));
		Select ob = new Select(cityDropdown);
		//ob.selectByIndex(0);
		//ob.selectByValue("Patna");
		//ob.selectByVisibleText("PATNA");
		List <WebElement> list = ob.getOptions();
		int size = list.size();
			for (int i=0; i<size; i++) {
			System.out.println(list.get(i).getText());
			}	
		//driverClose();
	}
		public static void errorFirbaseLogin() throws InterruptedException {
			String expected ="Error : The email address is badly formatted.";
			getDriverInstance("chrome");
			gotourl("https://qa-tekarch.firebaseapp.com/");
			Thread.sleep(5000);
			By logId = By.id("email_field");
			
			WebElement username = driver.findElement(logId);
			enterText(username,"xyzvjj","usernameele");
			
			WebElement password = driver.findElement(By.id("password_field"));
			enterText(password,"xyz123", "passwordele");
			
			driver.findElement(By.tagName("button")).click();
			Thread.sleep(5000);
			
			Alert alert = driver.switchTo().alert();
			String actual = alert.getText();
			alert.accept();
			
			if (actual.equalsIgnoreCase(expected)) {
				System.out.println("Test case passed");
			}
			else {
				System.out.println("Test case failed.");
			}
			
			
		}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//loginToFirebase();
		//registrationForm();
		errorFirbaseLogin();
	}

}
