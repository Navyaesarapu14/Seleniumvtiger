package ListenersTestng;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import bsh.Capabilities;

public class ListenerImplementationExtentReports implements ITestListener {
	private ExtentReports report;
	private ExtentTest test;
	public static ExtentTest stest;
	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReports/report.html");
		spark.config().setReportName("Extent Reports");
spark.config().setDocumentTitle("VTIGER-CRM");
spark.config().setTheme(Theme.STANDARD);
report = new ExtentReports();
report.attachReporter(spark);
report.setSystemInfo("Author", "Navya");
report.setSystemInfo("OS", System.getProperty("os.name"));
report.setSystemInfo("OS Version", System.getProperty("os.version"));
report.setSystemInfo("Java Version", System.getProperty("java.version"));
	}
	@Override
	public void onTestStart(ITestResult result) {
		Capabilities cap = (RemoteWebDriver)(BaseClass2.sdriver)).getCapablities();
		report.setSystemInfo("Browser", cap.getBrowserName());
		report.setSystemInfo("Browser Version", cap.getBrowserVersion());
		test = report.createTest(result.getMethod().getMethodName());
		stest = test;
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName()+"pass");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+" fail");
		test.fail(result.getThrowable());
		TakesScreenshot ts = (TakesScreenshot)(BaseClass2.sdriver)

	
		
	}

}
