package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.steps.BaseTest;

public class ListernersUtility implements ITestListener {

	protected WebDriver driver;
	protected static ExtentReportsUtility extentReport = ExtentReportsUtility.getInstance();
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		extentReport.startSingleTestReport(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentReport.logTestPassed(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentReport.logTestFailed(result.getMethod().getMethodName());
		BaseTest ob = new BaseTest();
	    driver= ob.returnDriverInstance();
		String path= null;
			try {
				path = ob.getScreenshot(driver);
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		extentReport.logTestScreenshot(path);
		extentReport.logTestFailedWithException(result.getThrowable());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		extentReport.logTestSkipped(result);
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		extentReport.logTestInfo(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		extentReport.logTestFailedWithTimeout(result);
	}
	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		extentReport.startExtentReport();
	}
	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentReport.endReport();
	}
}
