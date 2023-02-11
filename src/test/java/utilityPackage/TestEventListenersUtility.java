package utilityPackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import salesForce.ParentClass;

public class TestEventListenersUtility implements ITestListener{
	protected static ExtentReportsUtility extentreport=null;
	protected WebDriver driver;
	@Override
	public void onTestStart(ITestResult result) {
		
		extentreport.startSingleTestReport(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentreport.logTestpassed(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentreport.logTestFailed(result.getMethod().getMethodName());
		ParentClass ob=new ParentClass();
		//driver=ob.returnDriverInstance();
		String path=null;
		try {
			path = ob.getScreenshotOfPage(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentreport.logTestScreenshot(path);
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		extentreport=ExtentReportsUtility.getInstance();
		extentreport.startExtentReport();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentreport.endReport();
	}

}
