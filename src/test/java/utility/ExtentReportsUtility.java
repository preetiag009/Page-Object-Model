package utility;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReportsUtility {
	
	public static ExtentReports reports;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest extentest;
	private static ExtentReportsUtility extentObject= null;
	
	public static ExtentReportsUtility getInstance() {
		if (extentObject==null) {
			extentObject = new ExtentReportsUtility();
		}
		return extentObject;
	}
	
	public void startExtentReport() {
		sparkReporter = new ExtentSparkReporter(Constants.TEST_REPORT);
		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);
		reports.setSystemInfo("Host Name", "Salesforce Login");
		reports.setSystemInfo("Environment", "Cucumber Automation");
		reports.setSystemInfo("User Name", "Preeti");
		
		sparkReporter.config().setDocumentTitle("Cucumber Automation Login Testcases");
		sparkReporter.config().setReportName("Cucumber Regression Login");
		sparkReporter.config().setTheme(Theme.DARK);
	}
	
	public void startSingleTestReport(String testScriptName) {
		extentest = reports.createTest(testScriptName);
	}
	
	public void logTestInfo(String text) {
		extentest.info(text);
	}
	public void logTestPassed (String testcaseName) {
		extentest.pass(MarkupHelper.createLabel(testcaseName, ExtentColor.GREEN));
	}
	
	public void logTestFailed (String testcaseName) {
		extentest.fail(MarkupHelper.createLabel(testcaseName, ExtentColor.RED));
	}
	
	public void logTestFailedWithException (Throwable throwable) {
		extentest.log(Status.FAIL, throwable);	
	}
	
	public void logTestScreenshot(String path) {
		extentest.addScreenCaptureFromPath(path);
	}
	
	public void logTestSkipped(ITestResult result) {
		extentest.log(Status.INFO, "Test case skipped");
	}
	
	public void logTestFailedWithTimeout (ITestResult result) {
		extentest.log(Status.INFO, "Test case failed with Timeout");
	}
	
	public void endReport() {
		extentest.info("Test completed");
		reports.flush();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	}

}
