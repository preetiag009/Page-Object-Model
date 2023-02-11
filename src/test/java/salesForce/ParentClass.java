package salesForce;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.apache.hc.core5.http.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hpsf.Date;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilityPackage.Constants;
import utilityPackage.ExtentReportsUtility;
import utilityPackage.SalesForceUtility;

public class ParentClass {

	// static WebDriver driver = null;
	protected static WebDriver driver = null;
	protected static WebDriverWait wait = null;
	protected static Logger logger = null;
	protected static ExtentReportsUtility extentreport = ExtentReportsUtility.getInstance();
	

	@BeforeTest
	public void setUpBeforeTest() {
		logger = LogManager.getLogger(ParentClass.class.getName());
		extentreport = ExtentReportsUtility.getInstance();
		extentreport.startExtentReport();
	}
	
	// @BeforeMethod
	// @Parameters("browsername", "url")
//	public void setUpBeforeMethod(@Optional("chrome") String browserName,String url, Method method) {
//		
//		logger.info("Inside method"+ method.name());
//		SalesForceUtility salesforceutility = new SalesForceUtility();
//		salesforceutility.loadFile("salesForceData");
//		String url = salesforceutility.getPropertyValue("url");
//		getDriverInstance(browserName);
//		gotourl(url);
//		
//		}

	public static void getDriverInstance(String browserName) {
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			break;
		default:
			System.out.println("Invalid browser name");

		}
	}

	public static void gotourl(String url) {
		driver.get(url);
	}

	public static void enterText(WebElement element, String text, String name) {
		if (element.isDisplayed()) {
			element.clear();
			element.sendKeys(text);
		} else {
			System.out.println(name + " not displayed");
		}
	}

	public static String getTextFromWebEle(WebElement element, String name) {
		if (element.isDisplayed()) {
			return (element.getText());
		} else {
			System.out.println(name + " element not displayed");
			return null;
		}
	}

	public static void waitTime(WebElement userMenuDropDown) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf((WebElement) userMenuDropDown));
	}

	public static void waitUntilPageLoads() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public static void clickAction(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).click().perform();
	}

	public static void moveToElementAction(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
	}

	public static void listDropdownOptions(WebElement ele) {
		Select ob = new Select(ele);
		List<WebElement> list = ob.getOptions();
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.println(list.get(i).getText());
		}
	}

	public static void selectFromDropdown(WebElement ele, String option) {
		Select ob = new Select(ele);
		ob.selectByVisibleText(option);
	
	}

	public static String getSelectedOption(WebElement ele) {
		Select ob = new Select(ele);
		String s = ob.getFirstSelectedOption().getText();
		return s;
	}

	public static void switchToWindowOpened(String mainWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!mainWindowHandle.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle);
			}
		}
	}

	public static String getScreenshotOfPage(WebDriver driver) throws IOException {
		String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		String curDir = System.getProperty("user.dir");
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File imgFile = screenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File(Constants.SCREENSHOTS_DIRECTORY_PATH+date+".png");
		FileHandler.copy(imgFile, destFile);
		return destFile.getAbsolutePath();
		
	}
	public static void closeBrowser() {
		driver.close();
	}

	// @AfterMethod
	public void setUpAfterTestMethod() {
		driver.close();
		extentreport.endReport();
	}

}
