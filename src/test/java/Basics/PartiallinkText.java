package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Scenario:
 * Open the browser
 * ENter demo.actitime.com
 * click on forgot your password
 * click on return to login page
 * close the browser
 */

public class PartiallinkText {

	public static void main(String[] args)throws Exception {
	ChromeDriver driver=new ChromeDriver();
	driver.get("https://demo.actitime.com/login.do");
	Thread.sleep(2000);
	driver.findElement(By.partialLinkText("Forgot")).click();
	Thread.sleep(2000);
	driver.findElement(By.partialLinkText("Return")).click();
	Thread.sleep(2000);
	driver.close();

	}

}
