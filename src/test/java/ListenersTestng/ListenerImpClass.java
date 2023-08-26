package ListenersTestng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpClass implements ITestListener {
	public void onTestStart(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" test started");
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" pass");
	}
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" fail");
		System.out.println("Failed because: "+result.getThrowable());
		TakesScreenshot ts = (TakesScreenshot) (BaseClass2.sdriver);
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/")
	}

}
