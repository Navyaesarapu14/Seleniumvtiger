package ListenersTestng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener{
	public void onTestStart(ITestResult result) {
		System.err.println("onTestStart");
	}
public void onTestSuccess(ITestResult result) {
		System.err.println("onTestSuccess");
	}
public void onTestFailure(ITestResult result) {
		System.err.println("onTestFailure");
	}
public void onTestSkipped(ITestResult result) {
		System.err.println("onTestSkipped");	}
public void onStart(ITestContext context) {
		System.err.println("onTestStart");	}
public void onFinish(ITestContext context) {
		System.err.println("onFinish");	}
	

}
