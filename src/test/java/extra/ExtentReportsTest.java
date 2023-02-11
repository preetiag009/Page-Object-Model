package extra;

import java.io.FileNotFoundException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsTest {
	public static ExtentReports report;
	public static ExtentSparkReporter spartReporter;
	public static ExtentTest testLogger;
	
	public static void main(String[] args) {
		spartReporter=new ExtentSparkReporter("./reports./new.html");
		report=new ExtentReports();
		report.attachReporter(spartReporter);
		
		report.setSystemInfo("Host Name", "Salesforce");
		report.setSystemInfo("Environment", "Automation Testing");
		report.setSystemInfo("User Name", "Divyashree");

		spartReporter.config().setDocumentTitle("Test Execution Report");
		spartReporter.config().setReportName("firebase regression tests");
		spartReporter.config().setTheme(Theme.DARK);
		
		
		testLogger=report.createTest("testscript_1");
		testLogger.info("my testscript_1 has started");
		//testLogger.log(Status.INFO,"my testscript_1 has started");
		testLogger.log(Status.INFO,"my testscript_1 opened the url");
		testLogger.log(Status.INFO,"my testscript_1 hhas entered username in username field");
		testLogger.log(Status.INFO,"my testscript_1 has entered password in password field");
		
		testLogger.log(Status.PASS,MarkupHelper.createLabel("testscript_1" + "is passTest", ExtentColor.GREEN));
		
		
		testLogger=report.createTest("testscript_2");
		testLogger.log(Status.INFO,"my testscript_1 has started");
		testLogger.log(Status.INFO,"my testscript_1 opened the url");
		testLogger.log(Status.INFO,"my testscript_1 hhas entered username in username field");
		testLogger.log(Status.INFO,"my testscript_1 has entered password in password field");
		
		testLogger.log(Status.FAIL,MarkupHelper.createLabel("testscript_1" + "is failed", ExtentColor.RED));
		testLogger.addScreenCaptureFromPath("./image1.png");
		
		/*try {
		throw new FileNotFoundException();
		}
		catch(FileNotFoundException e) {
			testLogger.fail(e);
		}*/
		//
		
		report.flush();
		
	}

}
