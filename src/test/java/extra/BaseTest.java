package extra;
import java.io.File;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	static WebDriver driver = null;
	
	public static void enterText(WebElement element, String text, String name) {
		if (element.isDisplayed()) {
			element.clear();
			element.sendKeys(text);
		}
		else {
			System.out.println(name+ " not displayed");
	}
		driver.getTitle();
	}
	
	public static void gotourl(String url) {
		driver.get(url);
	}
	
	public static void getDriverInstance(String browserName) {
		switch (browserName) {
		case "chrome" :	WebDriverManager.chromedriver().setup();
						//driver = new ChromeDriver();
						ChromeOptions option = new ChromeOptions();
						//option.addArguments("--incognito");
						//option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
						driver = new ChromeDriver(option);
						driver.manage().window().maximize();
						break;
		case "edge" : 	WebDriverManager.edgedriver().setup();
						driver = new EdgeDriver();
						driver.manage().window().maximize();
						break;
		default : 		System.out.println("Invalid browser name");				
						
			}
		}
	
	public static String getTextFromWebEle(WebElement element, String name) {
		if (element.isDisplayed()){
			return (element.getText());
		}
		else {
			System.out.println(name +" element not displayed");
			return null;
		}
}
	public static void driverClose() {
		driver.close();
	}
	
	public static void waitTime(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf((WebElement)ele ));
	}
	
	public static void clickAction(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).click().perform();
	}
	
	public static void moveToElementAction(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
	}
	
}
