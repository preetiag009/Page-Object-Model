package salesForce;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilityPackage.ExtentReportsUtility;
import utilityPackage.SalesForceUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class SalesForceAutomation extends ParentClass {

	@Test(enabled = false)
	public static void loginErrorMessage1() {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.invalid.userid");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement error = driver.findElement(By.xpath("//div[@id='error']"));
		String actual = getTextFromWebEle(error, "Error");
		System.out.println(actual);
		String expected = "Please enter your password.";

		Assert.assertEquals(actual, expected);
		closeBrowser();

	}

	@Test(enabled = true)
	public static void loginToSalesForce2() {

		Logger logger = LogManager.getLogger(log4jTest.class.getName());
		logger.debug("This is a debug message1");
		logger.warn("This is a warn message1");
		logger.info("Method:loginToSalesForce2");
		extentreport = ExtentReportsUtility.getInstance();
		extentreport.startExtentReport();
		extentreport.startSingleTestReport("loginToSalesForce2");
		extentreport.logTestInfo("Method:loginToSalesForce2");
		
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		String expected = "Home";

		Assert.assertEquals(actual, expected);
		
		extentreport.endReport();
		closeBrowser();
	}

	@Test(enabled = false)
	public static void checkRememberme3() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement checkBox = driver.findElement(By.xpath("//input[@id='rememberUn']"));
		clickAction(checkBox);

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement dropDown = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		clickAction(dropDown);

		WebElement logOut = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		clickAction(logOut);

		Thread.sleep(2000);

		WebElement idCard = driver.findElement(By.xpath("//*[@id='idcard-identity']"));
		String actual = idCard.getText();
		System.out.println(actual);
		Assert.assertEquals(actual, userId);
		closeBrowser();

	}

	@Test(enabled = false)
	public static void forgotPassword4A() {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement forgotPassword = driver.findElement(By.linkText("Forgot Your Password?"));
		clickAction(forgotPassword);

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		WebElement userId2 = driver.findElement(By.xpath("//input[contains(@onkeypress,'checkCaps(event)')]"));
		clickAction(userId2);
		enterText(userId2, userId, "Username");

		WebElement continueButton = driver.findElement(By.id("continue"));
		clickAction(continueButton);

		String actual = "We’ve sent you an email with a link to finish resetting your password.";
		String expected = driver.findElement(By.xpath("//div/p[@class='senttext mb12'][1]")).getText();

		Assert.assertEquals(actual, expected);
		closeBrowser();

	}

	@Test(enabled = false)
	public static void forgotPassword4B() {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.invalid.userid");
		String password = salesforceutility.getPropertyValue("login.invalid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String actual = driver.findElement(By.xpath("//form//div[@class='loginError']")).getText();

		Assert.assertEquals(actual, expected);
		closeBrowser();

	}

	@Test(enabled = true)
	public static void userMenu5() throws InterruptedException {

		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		String expected = "Home";

		Assert.assertEquals(actual, expected);

		List<WebElement> userMenuDropDown = driver.findElements(By.xpath("//div[@id ='userNav-menuItems']/a"));
		Thread.sleep(2000);
		for (WebElement options : userMenuDropDown) {
			System.out.println(options.getAttribute("text"));
		}

		closeBrowser();
	}
	@Test
	public static void myProfileOption6() throws InterruptedException, AWTException {

		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		String lastname = salesforceutility.getPropertyValue("lastname");
		String text = salesforceutility.getPropertyValue("text");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
				
		WebElement userMenuOption = driver.findElement(By.id("userNavLabel"));
		waitTime(userMenuOption);
		clickAction(userMenuOption);
		
		WebElement myProfile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		waitTime(myProfile);
		clickAction(myProfile);
		
		Thread.sleep(2000);
		WebElement editButton = driver.findElement(By.xpath("//div/a[@class ='contactInfoLaunch editLink']"));
		waitTime(editButton);
		clickAction(editButton);
		if (editButton.isSelected()) {System.out.println("Edit button clicked");}
		driver.switchTo().frame("contactInfoContentId"); 
		
		WebElement aboutTab = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		clickAction(aboutTab);
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName' and @name= 'lastName']"));
		enterText(lastName, lastname, "Lastname");
		
		WebElement saveAll = driver.findElement(By.xpath("//input[contains(@value,'Save All')]"));
		clickAction(saveAll);
		
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		WebElement postButton = driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']"));
		clickAction(postButton);
		
		WebElement frame1 =driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, publisherRichTextEditor']"));
		driver.switchTo().frame(frame1);
		WebElement textBox = driver.findElement(By.xpath("//body"));
		
		waitTime(textBox); 
		clickAction(textBox);
		enterText(textBox, text, "Text");
		
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		WebElement share = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		clickAction(share);
		
		Thread.sleep(2000);

		WebElement fileLink = driver.findElement(By.xpath("//a[@id='publisherAttachContentPost']"));
		waitTime(fileLink);
		clickAction(fileLink);
		
		WebElement uploadFileButton = driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
		clickAction(uploadFileButton);
		
		WebElement chooseFile = driver.findElement(By.xpath("//input[@id='chatterFile']"));
		clickAction(chooseFile);
		
		StringSelection stringSelection = new StringSelection("D:\\Book1.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement moderator = driver.findElement(By.xpath("//div/span/img[@class='chatter-photo']"));
		moveToElementAction(moderator);
		
		WebElement addPhoto = driver.findElement(By.xpath("//div[@id='photoSection']/div[@class='photoUploadSection']"));
		clickAction(addPhoto);
		
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='uploadPhotoContentId']"));
		driver.switchTo().frame(frame2);
		System.out.println("Frame found");
		
		Thread.sleep(2000);
		WebElement choosePhoto = driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']"));
		clickAction(choosePhoto);
		
		//choosePhoto.sendKeys("D:\\photo-2.jpeg");
		StringSelection stringSelection2 = new StringSelection("D:\\photo-2.jpeg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection2, null);
		
		Thread.sleep(2000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_V);
		robot1.keyRelease(KeyEvent.VK_CONTROL);
		robot1.keyPress(KeyEvent.VK_ENTER);
		robot1.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(5000);
			
		WebElement uploadPhoto= driver.findElement(By.xpath("//input[@id='j_id0:uploadFileForm:uploadBtn']"));
		clickAction(uploadPhoto);
		
		Thread.sleep(4000);
		WebElement savePhoto= driver.findElement(By.xpath("//input[@id='j_id0:j_id7:save']")); 
		waitTime(savePhoto); 
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", savePhoto);
		executor.executeScript("arguments[0].click();", savePhoto);
		
		driver.switchTo().defaultContent();
		closeBrowser();
	}
	
	@Test
	public static void mySettingsOption7() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		String email = salesforceutility.getPropertyValue("email.name");
		String emailAdd = salesforceutility.getPropertyValue("email.address");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		String expected = "Home";
		
		WebElement userMenuOption = driver.findElement(By.id("userNavLabel"));
		waitTime(userMenuOption);
		clickAction(userMenuOption);
		
		WebElement mySettings = driver.findElement(By.xpath("//div/a[@title =\"My Settings\"]"));
		waitTime(mySettings);
		clickAction(mySettings);
		
		Thread.sleep(2000);
		WebElement personal = driver.findElement(By.xpath("//div/a/span[@id ='PersonalInfo_font']"));
		waitTime(personal);
		clickAction(personal);
		
		WebElement loginHistory = driver.findElement(By.xpath("//div/a[@id =\"LoginHistory_font\"]"));
		waitTime(loginHistory);
		clickAction(loginHistory);
		
		WebElement downloadLoginHistory = driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
		waitTime(downloadLoginHistory);
		clickAction(downloadLoginHistory);
		
		Thread.sleep(2000);
		WebElement displayAndLayout = driver.findElement(By.xpath("//span[@id=\"DisplayAndLayout_font\"]"));
		waitTime(displayAndLayout);
		clickAction(displayAndLayout);
		
		WebElement customizeMyTabs = driver.findElement(By.xpath("//div/a[@id=\"CustomizeTabs_font\"]"));
		waitTime(customizeMyTabs);
		clickAction(customizeMyTabs);
		
		WebElement customAppDropdown = driver.findElement(By.xpath("//tr/td/select[@id=\"p4\"]"));
		waitTime(customAppDropdown);
		clickAction(customAppDropdown);
		Select ob = new Select(customAppDropdown);
		ob.selectByVisibleText("Salesforce Chatter");
		
		WebElement availableTabs =driver.findElement(By.xpath("//td/select[@id='duel_select_0']"));
		Select ob1 = new Select(availableTabs);
		//ob1.selectByVisibleText("Reports");
		
		//WebElement addButton = driver.findElement(By.xpath("//div/a/img[@class='rightArrowIcon']"));
		//clickAction(addButton);
		
		WebElement emailOption = driver.findElement(By.xpath("//a/span[@id ='EmailSetup_font']"));
		waitTime(emailOption);
		clickAction(emailOption);
		
		WebElement emailSettings = driver.findElement(By.xpath("//a/span[@id ='EmailSettings_font']"));
		waitTime(emailSettings);
		clickAction(emailSettings);
		
		WebElement emailName = driver.findElement(By.xpath("//div/input[@id ='sender_name']"));
		waitTime(emailName);
		clickAction(emailName);
		enterText(emailName, email, "Email");
		
		WebElement emailAddress = driver.findElement(By.xpath("//div/input[@id ='sender_email']"));
		waitTime(emailAddress);
		clickAction(emailAddress);
		enterText(emailAddress, emailAdd, "Email Address");
		
		WebElement automaticBcc = driver.findElement(By.xpath("//div/input[@id ='auto_bcc1']"));
		clickAction(automaticBcc);
		
		WebElement save = driver.findElement(By.xpath("//td/input[@value=' Save ']"));
		clickAction(save);
		
		WebElement calendarAndReminders = driver.findElement(By.xpath("//div/a/span[@id='CalendarAndReminders_font']"));
		waitTime(calendarAndReminders);
		clickAction(calendarAndReminders);
		
		WebElement activityReminders = driver.findElement(By.xpath("//div/a[@id='Reminders_font']"));
		waitTime(activityReminders);
		clickAction(activityReminders);
		
		WebElement openTestReminder = driver.findElement(By.xpath("//td/input[@id='testbtn']"));
		waitTime(openTestReminder);
		clickAction(openTestReminder);
		
		closeBrowser();
	}

	@Test
	public static void developersConsole8() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
				
		WebElement userMenuOption = driver.findElement(By.id("userNavLabel"));
		waitTime(userMenuOption);
		clickAction(userMenuOption);
		
		String baseWindowHandle = driver.getWindowHandle();
		WebElement developerConsole = driver.findElement(By.xpath("//div/a[@title='Developer Console (New Window)']"));
		waitTime(developerConsole);
		clickAction(developerConsole);
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle:allWindowHandles) {
			if (!baseWindowHandle.equals(handle)) {
				driver.switchTo().window(handle);
				break;
			}
		}
		Thread.sleep(3000);
		//String windowHandle2= driver.getWindowHandle();
		closeBrowser();
	}
	
	@Test
	public static void logoutOption9() {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
				
		WebElement userMenuOption = driver.findElement(By.id("userNavLabel"));
		waitTime(userMenuOption);
		clickAction(userMenuOption);
		
		WebElement logoutOption = driver.findElement(By.xpath("//div/a[@title='Logout']"));
		waitTime(logoutOption);
		clickAction(logoutOption);
		
		closeBrowser();
	}
	
	@Test
	public static void createAccount10() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		String accountName = salesforceutility.getPropertyValue("account.name");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		WebElement accountsTab = driver.findElement(By.xpath("//ul/li/a[@title='Accounts Tab']"));
		waitTime(accountsTab);
		clickAction(accountsTab);
		Thread.sleep(2000);
		
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		waitTime(closeTab);
		clickAction(closeTab);
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebElement newButton = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		waitTime(newButton);
		clickAction(newButton);
		
		Thread.sleep(2000);
		WebElement account_name = driver.findElement(By.xpath("//td/div/input[@id='acc2']"));
		waitTime(account_name);
		clickAction(account_name);
		enterText(account_name, accountName , "Account Name");
		
		Thread.sleep(2000);
		WebElement type = driver.findElement(By.xpath("//td/span/select[@id='acc6']"));
		waitTime(type);
		clickAction(type);
		Select ob = new Select(type);
		ob.selectByVisibleText("Technology Partner");
		
		Thread.sleep(2000);
		WebElement customerPriority = driver.findElement(By.xpath("//td/span/select[@id='00NDn00000SjaLk']"));
		waitTime(customerPriority);
		clickAction(customerPriority);
		Select ob1 = new Select(customerPriority);
		ob1.selectByVisibleText("High");
		
		WebElement saveButton = driver.findElement(By.xpath("//td/input[@value=' Save ']"));
		waitTime(saveButton);
		clickAction(saveButton);
		
		closeBrowser();
	}
	
	@Test
	public static void createNewView11() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		String viewname = salesforceutility.getPropertyValue("view.name");
		String viewuniquename = salesforceutility.getPropertyValue("view.unique.name");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		WebElement accountsTab = driver.findElement(By.xpath("//ul/li/a[@title='Accounts Tab']"));
		waitTime(accountsTab);
		clickAction(accountsTab);
		Thread.sleep(2000);
		
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		waitTime(closeTab);
		clickAction(closeTab);
		
		WebElement createNewView = driver.findElement(By.xpath("//span/a[text()='Create New View']"));
		waitTime(createNewView);
		clickAction(createNewView);
		
		WebElement viewName = driver.findElement(By.xpath("//div/input[@id='fname']"));
		waitTime(viewName);
		clickAction(viewName);
		enterText(viewName, viewname, "View Name");
		
		WebElement viewUniqueName = driver.findElement(By.xpath("//div/input[@id='devname']"));
		waitTime(viewUniqueName);
		clickAction(viewUniqueName);
		enterText(viewUniqueName, viewuniquename, "View Unique Name");
		
		WebElement saveButton = driver.findElement(By.xpath("//td/input[@value=' Save '][1]"));
		waitTime(saveButton);
		clickAction(saveButton);
		
		closeBrowser();
	}
	
	@Test
	public static void editView12() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		String viewnewname2 = salesforceutility.getPropertyValue("view.new.name2");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		WebElement accountsTab = driver.findElement(By.xpath("//ul/li/a[@title='Accounts Tab']"));
		waitTime(accountsTab);
		clickAction(accountsTab);
		Thread.sleep(2000);
		
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		waitTime(closeTab);
		clickAction(closeTab);
	
		WebElement view = driver.findElement(By.xpath("//span/select[@id='fcf']"));
		waitTime(view);
		clickAction(view);
		
		Select ob = new Select(view);
		ob.selectByVisibleText("View_New_Name_2");
		
		WebElement edit = driver.findElement(By.linkText("Edit"));
		clickAction(edit);
		
		WebElement viewNewName2 = driver.findElement(By.xpath("//input[@id='fname']"));
		clickAction(viewNewName2);
		enterText(viewNewName2, viewnewname2, "View New Name 2");
		
		WebElement field = driver.findElement(By.xpath("//select[@id='fcol1']"));
		clickAction(field);
		Select ob1 = new Select(field);
		ob1.selectByVisibleText("Account Name");
		
		WebElement operator = driver.findElement(By.xpath("//select[@id='fop1']"));
		clickAction(operator);
		Select ob2 = new Select(operator);
		ob2.selectByVisibleText("contains");
		
		WebElement value = driver.findElement(By.xpath("//input[@id='fval1']"));
		clickAction(value);
		enterText(value, "a", "Value");
		
		WebElement save = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		clickAction(save);
		
		closeBrowser();
	}
	
	@Test
	public static void mergeAccounts13() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		String accountName = salesforceutility.getPropertyValue("account.name");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		WebElement accountsTab = driver.findElement(By.xpath("//ul/li/a[@title='Accounts Tab']"));
		waitTime(accountsTab);
		clickAction(accountsTab);
		Thread.sleep(2000);
		
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		waitTime(closeTab);
		clickAction(closeTab);
		
		WebElement mergeAccount = driver.findElement(By.linkText("Merge Accounts"));
		clickAction(mergeAccount);
		
		WebElement searchBox = driver.findElement(By.xpath(" //input[@id='srch']"));
		clickAction(searchBox);
		enterText(searchBox, accountName, "Account Name" );
		
		WebElement findAccounts = driver.findElement(By.xpath("//input[@name='srchbutton']"));
		clickAction(findAccounts);
		
		WebElement checkBox1 = driver.findElement(By.xpath("//input[@id='cid0']"));
		clickAction(checkBox1);
		System.out.println(checkBox1.isSelected());
		if (checkBox1.isSelected()== false) { clickAction(checkBox1);}
		
		WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='cid1']"));
		clickAction(checkBox2);
		System.out.println(checkBox2.isSelected());
		if (checkBox2.isSelected()== false) { clickAction(checkBox2);}
				
		WebElement next = driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[contains(@title,'Next')]"));
		clickAction(next);
				
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		WebElement merge = driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[contains(@title,'Merge')]"));
		clickAction(merge);
				
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		closeBrowser();
	}
	
	@Test
	public static void createAccountReport14() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		String reportname = salesforceutility.getPropertyValue("report.name");
		String reportuniquename = salesforceutility.getPropertyValue("report.unique.name");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		WebElement accountsTab = driver.findElement(By.xpath("//ul/li/a[@title='Accounts Tab']"));
		waitTime(accountsTab);
		clickAction(accountsTab);
		Thread.sleep(2000);
		
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		waitTime(closeTab);
		clickAction(closeTab);
		
		WebElement accountsLastActivity = driver.findElement(By.linkText("Accounts with last activity > 30 days"));
		clickAction(accountsLastActivity);
		
		WebElement dateFieldDropDown = driver.findElement(By.id("ext-gen148"));
		clickAction(dateFieldDropDown);
		
		WebElement createdDate = driver.findElement(By.xpath("//div[contains(text(),'Created Date')]"));
		clickAction(createdDate);
		
		WebElement from = driver.findElement(By.xpath("//img[@id='ext-gen152']"));
		clickAction(from);
		
		WebElement fromToday = driver.findElement(By.xpath("//button[@id='ext-gen281']"));
		clickAction(fromToday);
		
		WebElement to = driver.findElement(By.xpath("//img[@id='ext-gen154']"));
		clickAction(to);
		
		Thread.sleep(2000);
		WebElement toToday = driver.findElement(By.xpath("//button[@id='ext-gen296']"));
		waitTime(toToday);
		clickAction(toToday);
				
		WebElement saveUnsavedReport = driver.findElement(By.xpath("//button[@id='ext-gen49']"));
		clickAction(saveUnsavedReport);
		
		WebElement reportName = driver.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"));
		clickAction(reportName);
		enterText(reportName, reportname, "Report Name");
		
		WebElement reportUniqueName = driver.findElement(By.xpath("	//input[@id='saveReportDlg_DeveloperName']"));
		clickAction(reportUniqueName);
		enterText(reportUniqueName, reportuniquename, "Report Unique Name");
				
		Thread.sleep(2000);
		WebElement saveAndRunReport = driver.findElement(By.xpath("//button[@id='ext-gen316']"));
		waitTime(saveAndRunReport);
		clickAction(saveAndRunReport);	
		
		closeBrowser();
	}
	
	@Test
	public static void opportunitiesDropdown15() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		WebElement opportunitiesTab = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
		clickAction(opportunitiesTab);
		
		Thread.sleep(2000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		waitTime(closeTab);
		clickAction(closeTab);
		
		WebElement allOpportunities = driver.findElement(By.xpath("//select[@id='fcf']"));
		clickAction(allOpportunities);
		System.out.println("Opportunities Dropdown options: ");
		listDropdownOptions(allOpportunities);
		
		closeBrowser();
	}	
	
	@Test
	public static void createNewOpty16() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		String opportunityname = salesforceutility.getPropertyValue("opportunity.name");
		String accountname = salesforceutility.getPropertyValue("account.name");
		String prob = salesforceutility.getPropertyValue("probability");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		WebElement opportunitiesTab = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
		clickAction(opportunitiesTab);
		
		Thread.sleep(2000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		waitTime(closeTab);
		clickAction(closeTab);
		
		WebElement newOpty = driver.findElement(By.xpath("//tr/td[2]/input[@name='new']"));
		clickAction(newOpty);
		
		WebElement optyName = driver.findElement(By.xpath("//input[@id='opp3']"));
		clickAction(optyName);
		enterText(optyName, opportunityname , "Opportunity Name");
		
		WebElement accountName = driver.findElement(By.xpath("//input[@id='opp4']"));
		clickAction(accountName);
		enterText(accountName, accountname, "Account Name");
		
		WebElement closeDate = driver.findElement(By.xpath("//span/span/a[@tabindex='7']"));
		clickAction(closeDate);
		
		WebElement stage = driver.findElement(By.xpath("//span/select[@id='opp11']"));
		clickAction(stage);
		selectFromDropdown(stage, "Closed Won");
				
		WebElement probability = driver.findElement(By.xpath("//input[@id='opp12']"));
		clickAction(probability);
		enterText(probability, prob, "Probability");
		
		WebElement leadSource = driver.findElement(By.xpath("//select[@id='opp6']"));
		clickAction(leadSource);
		selectFromDropdown(leadSource, "Web");
				
		//WebElement primaryCampaignSource = driver.findElement(By.xpath("//input[@id='opp17']"));
		//clickAction(primaryCampaignSource);
		//enterText(primaryCampaignSource, primarycampaignsource, "Primary Campaign Source");
		
		WebElement save = driver.findElement(By.xpath("//td/input[@name='save'][1]"));
		clickAction(save);
		
		closeBrowser();
	}
	
	@Test
	public static void testOptyPipelineReport17() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		WebElement opportunitiesTab = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
		clickAction(opportunitiesTab);
		
		Thread.sleep(2000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		waitTime(closeTab);
		clickAction(closeTab);
		
		WebElement optyPipeline = driver.findElement(By.xpath("//a[contains(text(),'Opportunity Pipeline')]"));
		waitTime(optyPipeline);
		clickAction(optyPipeline);
		
		WebElement pageDisplayed = driver.findElement(By.xpath("//h1[contains(text(),'Opportunity Pipeline')]"));
		String pagename = pageDisplayed.getText();
		Assert.assertEquals(pagename, "Opportunity Pipeline");
		
		closeBrowser();	
	}
	@Test
	public static void testStuckOptyReport18() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		WebElement opportunitiesTab = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
		clickAction(opportunitiesTab);
		
		Thread.sleep(2000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		waitTime(closeTab);
		clickAction(closeTab);
		
		WebElement stuckOpportunities = driver.findElement(By.xpath("//a[contains(text(),'Stuck Opportunities')]"));
		clickAction(stuckOpportunities);
		
		WebElement pageDisplayed = driver.findElement(By.xpath("//h1[contains(text(),'Stuck Opportunities')]"));
		String pagename = pageDisplayed.getText();
		Assert.assertEquals(pagename, "Stuck Opportunities");
		
		closeBrowser();
	}
	
	@Test
	public static void testQuaterlySummaryReport19() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		WebElement opportunitiesTab = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
		clickAction(opportunitiesTab);
		
		Thread.sleep(2000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		waitTime(closeTab);
		clickAction(closeTab);
		
		WebElement interval = driver.findElement(By.xpath("//select[@id='quarter_q']"));
		selectFromDropdown(interval, "Next FQ");
		
		WebElement include = driver.findElement(By.xpath("//select[@id='open']"));
		selectFromDropdown(include, "Open Opportunities");
		
		WebElement runReport = driver.findElement(By.xpath("//td/input[@value='Run Report']"));		
		clickAction(runReport);
		
		WebElement opportunityReportPage = driver.findElement(By.xpath("//h1[contains(text(),'Opportunity Report')]"));	
		String pageText= opportunityReportPage.getText();
		Assert.assertEquals(pageText, "Opportunity Report");
		
		closeBrowser();
	}
	
	@Test
	public static void leadsTab20() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		WebElement leadsTab = driver.findElement(By.xpath("//li[@id ='Lead_Tab']"));
		clickAction(leadsTab);
		
		Thread.sleep(2000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		clickAction(closeTab);
		
		WebElement leadsPage = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/div[1]/div[1]/div[1]/h1[1]"));
		String actualText = leadsPage.getText();
		Assert.assertEquals(actualText, "Leads");
		
		closeBrowser();
	}	
	
	@Test
	public static void leadsSelectView21() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		WebElement leadsTab = driver.findElement(By.xpath("//li[@id ='Lead_Tab']"));
		clickAction(leadsTab);
		
		Thread.sleep(2000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		clickAction(closeTab);
		
		WebElement viewDropDown = driver.findElement(By.xpath("//select[@id ='fcf']"));
		clickAction(viewDropDown);
		listDropdownOptions(viewDropDown);
		
		closeBrowser();
	}
	
	@Test
	public static void defaultView22() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);
		
		WebElement leadsTab = driver.findElement(By.xpath("//li[@id ='Lead_Tab']"));
		clickAction(leadsTab);
		
		Thread.sleep(2000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		clickAction(closeTab);
		
		WebElement viewDropDown = driver.findElement(By.xpath("//select[@id ='fcf']"));
		clickAction(viewDropDown);
		selectFromDropdown(viewDropDown, "My Unread Leads");
		String expectedOptionSelected = getSelectedOption(viewDropDown);
		
		WebElement userMenuOption = driver.findElement(By.id("userNavLabel"));
		waitTime(userMenuOption);
		clickAction(userMenuOption);
		
		WebElement logoutOption = driver.findElement(By.xpath("//div/a[@title='Logout']"));
		waitTime(logoutOption);
		clickAction(logoutOption);
	
		Thread.sleep(5000);
		WebElement Username1 = driver.findElement(By.id("username"));
		clickAction(Username1);
		enterText(Username1, userId, "Username");

		WebElement passWord1 = driver.findElement(By.id("password"));
		clickAction(passWord1);
		enterText(passWord1, password, "Password");

		WebElement loginButton1 = driver.findElement(By.id("Login"));
		clickAction(loginButton1);

		WebElement homePage1 = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual1 = getTextFromWebEle(homePage1, "Home");
		System.out.println(actual1);
		
		WebElement leadsTab1 = driver.findElement(By.xpath("//li[@id ='Lead_Tab']"));
		clickAction(leadsTab1);
		
		Thread.sleep(2000);
		WebElement go = driver.findElement(By.xpath("//input[@value =' Go! ']"));
		clickAction(go);
		
		WebElement dropDown1 = driver.findElement(By.xpath("//select[@id ='00BDn00000ImMSZ_listSelect']"));
		String actualOptionSelected = getSelectedOption(dropDown1);
		Assert.assertEquals(actualOptionSelected, expectedOptionSelected);
		
		closeBrowser();
	}	
	
	@Test
	public static void todaysLeads23() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		WebElement leadsTab = driver.findElement(By.xpath("//li[@id ='Lead_Tab']"));
		clickAction(leadsTab);
		
		Thread.sleep(2000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		clickAction(closeTab);
		
		WebElement viewDropDown = driver.findElement(By.xpath("//select[@id ='fcf']"));
		clickAction(viewDropDown);
		selectFromDropdown(viewDropDown, "Today's Leads");
		String expectedOptionSelected = getSelectedOption(viewDropDown);
		
		Thread.sleep(2000);
		WebElement go = driver.findElement(By.xpath("//input[@value =' Go! ']"));
		clickAction(go);
		
		WebElement dropDown1 = driver.findElement(By.xpath("//select[@id='00BDn00000ImMSn_listSelect']"));
		String actualOptionSelected = getSelectedOption(dropDown1);
		Assert.assertEquals(actualOptionSelected, expectedOptionSelected);
		
		closeBrowser();
	}
	
	@Test
	public static void newLeads24() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		String lastname = salesforceutility.getPropertyValue("lead.lastname");
		String companyname = salesforceutility.getPropertyValue("lead.companyname");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		WebElement leadsTab = driver.findElement(By.xpath("//li[@id ='Lead_Tab']"));
		clickAction(leadsTab);
		
		Thread.sleep(2000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		clickAction(closeTab);
		
		WebElement newTab = driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]"));
		clickAction(newTab);
		
		Thread.sleep(2000);
		WebElement lastName = driver.findElement(By.id("name_lastlea2"));
		clickAction(lastName);
		enterText(lastName, lastname, lastname);
		
		WebElement companyName = driver.findElement(By.xpath("//input[@id='lea3']"));
		clickAction(companyName);
		enterText(companyName, companyname, companyname);
		
		WebElement save = driver.findElement(By.xpath("//input[@value=' Save '][1]"));
		clickAction(save);
		
		closeBrowser();	
	}
	
	@Test
	public static void createNewContact25() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		String lastname = salesforceutility.getPropertyValue("contact.lastname");
		String accountname = salesforceutility.getPropertyValue("account.name");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		Thread.sleep(2000);
		WebElement contactTab = driver.findElement(By.xpath("//li[@id='Contact_Tab']"));
		clickAction(contactTab);
		
		Thread.sleep(2000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		clickAction(closeTab);
				
		WebElement lastName = driver.findElement(By.xpath("//input[@id='name_last']"));
		clickAction(lastName);
		enterText(lastName, lastname, "Last Name");
		
		WebElement account = driver.findElement(By.xpath("//input[@id='account']"));
		clickAction(account);
		enterText(account, accountname, "Account Name");
		
		WebElement save = driver.findElement(By.xpath("//input[@value=' Save ']"));
		clickAction(save);	
		
		closeBrowser();	
	}
	
	@Test
	public static void contactNewView26() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		String viewname = salesforceutility.getPropertyValue("contact.viewname");
		String viewuniquename = salesforceutility.getPropertyValue("contact.uniquename");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		Thread.sleep(2000);
		WebElement contactTab = driver.findElement(By.xpath("//li[@id='Contact_Tab']"));
		clickAction(contactTab);
		
		Thread.sleep(2000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		clickAction(closeTab);
		
		WebElement createNewView = driver.findElement(By.xpath("//a[text()='Create New View']"));
		clickAction(createNewView);
		
		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		clickAction(viewName);
		enterText(viewName, viewname, "View Name");
		
		WebElement viewUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
		clickAction(viewUniqueName);
		enterText(viewUniqueName, viewuniquename, "View Unique Name");
		
		WebElement save = driver.findElement(By.xpath("//input[@value=' Save ']"));
		clickAction(save);
		
		closeBrowser();
	}
	
	@Test
	public static void recentlyCreatedContact27() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		Thread.sleep(2000);
		WebElement contactTab = driver.findElement(By.xpath("//li[@id='Contact_Tab']"));
		clickAction(contactTab);
		
		Thread.sleep(2000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		clickAction(closeTab);
		
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
		selectFromDropdown(dropDown,"Recently Created");
		
		closeBrowser();
	}
	
	@Test
	public static void myContacts28() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		Thread.sleep(2000);
		WebElement contactTab = driver.findElement(By.xpath("//li[@id='Contact_Tab']"));
		clickAction(contactTab);
		
		Thread.sleep(2000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		clickAction(closeTab);
		
		WebElement view = driver.findElement(By.xpath("//select[@id='fcf']"));
		selectFromDropdown(view, "My Contacts");
		
		closeBrowser();	
	}
	
	@Test
	public static void viewContact29() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		Thread.sleep(2000);
		WebElement contactTab = driver.findElement(By.xpath("//li[@id='Contact_Tab']"));
		clickAction(contactTab);
		
		Thread.sleep(2000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		clickAction(closeTab);
		
		WebElement contact1 = driver.findElement(By.xpath("//th/a[text()='Last Name']"));
		clickAction(contact1);	
	}
	
	@Test
	public static void errorNewView30() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		String viewuniquename = salesforceutility.getPropertyValue("error.viewuniquename");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		Thread.sleep(2000);
		WebElement contactTab = driver.findElement(By.xpath("//li[@id='Contact_Tab']"));
		clickAction(contactTab);
		
		Thread.sleep(2000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		clickAction(closeTab);
		
		WebElement createNewView = driver.findElement(By.xpath("//a[text()='Create New View']"));
		clickAction(createNewView);
		
		WebElement viewUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
		clickAction(viewUniqueName);
		enterText(viewUniqueName, viewuniquename, "View Unique Name");
		
		WebElement save = driver.findElement(By.xpath("//input[@value=' Save ']"));
		clickAction(save);
		
		WebElement errorMessage = driver.findElement(By.xpath("//div[@class='errorMsg' and text()=' You must enter a value']"));
		String actual1 = getTextFromWebEle(errorMessage, "Error Message");
		String expected= " You must enter a value";
		
		Assert.assertEquals(actual1, expected);
		
		closeBrowser();	
	}
	
	@Test
	public static void cancelNewView31() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		String viewname = salesforceutility.getPropertyValue("error.viewname");
		String viewuniquename = salesforceutility.getPropertyValue("error.viewuniquename");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		Thread.sleep(2000);
		WebElement contactTab = driver.findElement(By.xpath("//li[@id='Contact_Tab']"));
		clickAction(contactTab);
		
		Thread.sleep(2000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		clickAction(closeTab);
		
		WebElement createNewView = driver.findElement(By.xpath("//a[text()='Create New View']"));
		clickAction(createNewView);
		
		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		clickAction(viewName);
		enterText(viewName, viewname, "View Name");
		
		WebElement viewUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
		clickAction(viewUniqueName);
		enterText(viewUniqueName, viewuniquename, "View Unique Name");
		
		WebElement cancel = driver.findElement(By.xpath("//input[@value='Cancel'][1]"));
		clickAction(cancel);
		
		closeBrowser();
	}
	
	@Test
	public static void createsaveAndNew32() throws InterruptedException {
		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		String lastname = salesforceutility.getPropertyValue("last.name32");
		String accountname = salesforceutility.getPropertyValue("account.name32");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		
		Thread.sleep(2000);
		WebElement contactTab = driver.findElement(By.xpath("//li[@id='Contact_Tab']"));
		clickAction(contactTab);
		
		Thread.sleep(2000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		clickAction(closeTab);
				
		WebElement newButton = driver.findElement(By.xpath("//input[@value=' New ']"));
		clickAction(newButton);
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		clickAction(lastName);
		enterText(lastName, lastname, "Last Name");
		
		WebElement account = driver.findElement(By.xpath("//input[@id='con4']"));
		clickAction(account);
		enterText(account, accountname, "Account Name");
		
		WebElement saveAndNew = driver.findElement(By.xpath("//input[@value='Save & New'][1]"));
		clickAction(saveAndNew);	
		
		// Test case failed
		closeBrowser();	
	}
	
	@Test
	public static void firstlastName33() throws InterruptedException {

		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		clickAction(homePage);
		
		Thread.sleep(3000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		clickAction(closeTab);
		
		WebElement header = driver.findElement(By.xpath("//h1/a")); 
		String actual1 =getTextFromWebEle(header, "Header");
		String expected1 = "Preethi LastName";
		
		Assert.assertEquals(actual1, expected1);
		
		closeBrowser();	
	}
	
	@Test
	public static void verifyEditedlastName34() throws InterruptedException {

		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);

		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		clickAction(homePage);
		
		Thread.sleep(3000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		clickAction(closeTab);
		
		waitUntilPageLoads();
		WebElement header = driver.findElement(By.xpath("//h1/a")); 
		clickAction(header);
		
		Thread.sleep(2000);
		WebElement editProfile = driver.findElement(By.xpath("//a/img[@alt='Edit Profile'][1]")); 
		clickAction(editProfile);
		
		driver.switchTo().frame("contactInfoContentId");
		WebElement aboutTab = driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		clickAction(aboutTab);
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id ='lastName']"));
		clickAction(lastName);
		enterText(lastName, "Abcd", "Lastname");
		
		WebElement saveAll = driver.findElement(By.xpath("//input[@value ='Save All']"));
		clickAction(saveAll);
		
		driver.switchTo().defaultContent();
		
		WebElement header1 = driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']")); 
		String actual1 =getTextFromWebEle(header1, "Header");
		String expected1 = "Preethi Abcd ";
		Assert.assertEquals(actual1, expected1);
		
		WebElement userMenu = driver.findElement(By.xpath("//span[@id='userNavLabel']")); 
		String actual2 = getTextFromWebEle(userMenu, "User Menu");
		String expected2 = "Preethi Abcd";
		Assert.assertEquals(actual2, expected2);
		
		closeBrowser();
	}
	
	@Test
	public static void verifyTabCustomization35() throws InterruptedException {

		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);
		
		WebElement allTabs = driver.findElement(By.xpath("//img[@alt='All Tabs']"));
		clickAction(allTabs);
		
		waitUntilPageLoads();
		Thread.sleep(2000);
		WebElement customizeMyTabs = driver.findElement(By.xpath("//input[@value='Customize My Tabs']"));
		clickAction(customizeMyTabs);
		
		Thread.sleep(2000);
		WebElement selectedTabs = driver.findElement(By.xpath("//select[@id='duel_select_1']"));
		selectFromDropdown(selectedTabs, "Chatter");
		
		WebElement remove = driver.findElement(By.xpath("//img[@title='Remove']"));
		clickAction(remove);
		
		WebElement save = driver.findElement(By.xpath("//input[@value=' Save ']"));
		clickAction(save);
		
		WebElement userMenu = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		clickAction(userMenu);
		
		WebElement logoutOption = driver.findElement(By.xpath("//div/a[@title='Logout']"));
		waitTime(logoutOption);
		clickAction(logoutOption);
		
		Thread.sleep(2000);
		WebElement Username1 = driver.findElement(By.id("username"));
		clickAction(Username1);
		enterText(Username1, userId, "Username");

		WebElement passWord1 = driver.findElement(By.id("password"));
		clickAction(passWord1);
		enterText(passWord1, password, "Password");

		WebElement loginButton1 = driver.findElement(By.id("Login"));
		clickAction(loginButton1);
		
		WebElement allTabs1 = driver.findElement(By.xpath("//img[@alt='All Tabs']"));
		clickAction(allTabs1);
		
		WebElement customizeMyTabs1 = driver.findElement(By.xpath("//input[@value='Customize My Tabs']"));
		clickAction(customizeMyTabs1);
		
		WebElement selectedTabs1 = driver.findElement(By.xpath("//select[@id='duel_select_1']"));
		try{
		selectFromDropdown(selectedTabs1, "Chatter");
		}
		catch (Exception e) {
			System.out.println("Option not found. Test case Passed");
		}
		
		closeBrowser();
	}
	
	@Test
	public static void blockingEvent36() throws InterruptedException {

		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);
	
		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		clickAction(homePage);
		
		Thread.sleep(3000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		clickAction(closeTab);
		
		WebElement currentDate = driver.findElement(By.xpath("//span/a[1]"));
		clickAction(currentDate);
				
		Thread.sleep(2000);
		WebElement eightpm = driver.findElement(By.xpath("//div[@id='p:f:j_id25:j_id61:28:j_id64']/a"));
		clickAction(eightpm);
		
		WebElement subjectCombo = driver.findElement(By.xpath("//img[@class='comboboxIcon']"));
		clickAction(subjectCombo);
		
		String mainWindowHandle= driver.getWindowHandle();
		switchToWindowOpened(mainWindowHandle);
		
		Thread.sleep(2000);
		WebElement other = driver.findElement(By.xpath("//li[@class='listItem4']/a"));
		clickAction(other);
		
		driver.switchTo().window(mainWindowHandle);
		
		Thread.sleep(2000);
	
		WebElement endTimeField = driver.findElement(By.xpath("//span/input[@id='EndDateTime_time']"));
		clickAction(endTimeField);
		
		WebElement ninePm = driver.findElement(By.xpath("//div[@id='timePickerItem_42']"));
		clickAction(ninePm);
		
		WebElement save = driver.findElement(By.xpath("//td/input[@title='Save']"));
		clickAction(save);
		
		closeBrowser();		
	}
	
	@Test
	public static void recurringEvent37() throws InterruptedException {

		SalesForceUtility salesforceutility = new SalesForceUtility();
		salesforceutility.loadFile("salesForceData");
		String url = salesforceutility.getPropertyValue("url");
		String userId = salesforceutility.getPropertyValue("login.valid.userid");
		String password = salesforceutility.getPropertyValue("login.valid.password");
		getDriverInstance("chrome");
		gotourl(url);

		WebElement Username = driver.findElement(By.id("username"));
		clickAction(Username);
		enterText(Username, userId, "Username");

		WebElement passWord = driver.findElement(By.id("password"));
		clickAction(passWord);
		enterText(passWord, password, "Password");

		WebElement loginButton = driver.findElement(By.id("Login"));
		clickAction(loginButton);
	
		WebElement homePage = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		String actual = getTextFromWebEle(homePage, "Home");
		System.out.println(actual);
		clickAction(homePage);
		
		Thread.sleep(3000);
		WebElement closeTab = driver.findElement(By.xpath("//div/a[@id ='tryLexDialogX']"));
		clickAction(closeTab);
		
		WebElement currentDate = driver.findElement(By.xpath("//span/a[1]"));
		clickAction(currentDate);
				
		Thread.sleep(2000);
		WebElement fourpm = driver.findElement(By.xpath("//div[@id='p:f:j_id25:j_id61:20:j_id64']/a"));
		clickAction(fourpm);
		
		WebElement subjectCombo = driver.findElement(By.xpath("//img[@class='comboboxIcon']"));
		clickAction(subjectCombo);
		
		String mainWindowHandle= driver.getWindowHandle();
		switchToWindowOpened(mainWindowHandle);
		
		Thread.sleep(2000);
		WebElement other = driver.findElement(By.xpath("//li[@class='listItem4']/a"));
		clickAction(other);
		
		driver.switchTo().window(mainWindowHandle);
		
		Thread.sleep(2000);
	
		WebElement endTimeField = driver.findElement(By.xpath("//span/input[@id='EndDateTime_time']"));
		clickAction(endTimeField);
		
		WebElement sevenPm = driver.findElement(By.xpath("//div[@id='timePickerItem_38']"));
		clickAction(sevenPm);
		
		WebElement recurrence = driver.findElement(By.xpath("//input[@id='IsRecurrence']"));
		clickAction(recurrence);
		
		WebElement weekly = driver.findElement(By.xpath("//input[@id='rectypeftw']"));
		clickAction(weekly);
		
		WebElement recurrenceEnd = driver.findElement(By.xpath("//input[@id='RecurrenceEndDateOnly']"));
		clickAction(recurrenceEnd);
		
		WebElement endDate = driver.findElement(By.xpath("//tr/td[text()='25']"));
		clickAction(endDate);
		
		WebElement save = driver.findElement(By.xpath("//input[@value=' Save '][1]"));
		clickAction(save);
		
		WebElement monthView = driver.findElement(By.xpath("//img[@alt='Month View']"));
		clickAction(monthView);
		
		closeBrowser();
	}
	
	
	
	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		// loginErrorMessage1();
		// loginToSalesForce2();
		// checkRememberme3();
		// forgotPassword4A();
		// forgotPassword4B();
		// userMenu5();
		// myProfileOption6();
		// mySettingsOption7();
		// developersConsole8();
		// logoutOption9() ;
		// createAccount10();
		// createNewView11();
		// editView12();
		// mergeAccounts13();
		// createAccountReport14();
		// opportunitiesDropdown15();
		// createNewOpty16();
		// testOptyPipelineReport17();
		// testStuckOptyReport18();
		// testQuaterlySummaryReport19();
		// leadsTab20();
		// leadsSelectView21();
		// defaultView22();
		// todaysLeads23();
		// newLeads24();
		// createNewContact25();
		// contactNewView26();
		// recentlyCreatedContact27();
		// myContacts28();
		// viewContact29();
		// errorNewView30();
		// cancelNewView31();
		// createsaveAndNew32();
		// firstlastName33();
		// verifyEditedlastName34();
		// verifyTabCustomization35();
		// blockingEvent36();
		// recurringEvent();
	}

}
