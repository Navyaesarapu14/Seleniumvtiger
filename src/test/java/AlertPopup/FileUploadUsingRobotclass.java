package AlertPopup;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadUsingRobotclass {

	public static void main(String[] args)throws Exception {
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.naukri.com/registration/createAccount?othersrcp=22636");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.findElement(By.xpath("//button[text()= 'Upload Resume']")).click();
Thread.sleep(3000);
//select the file path
StringSelection str = new StringSelection("\"C:\\Users\\esara\\Downloads\\1559133623668.jpg\"");
//set the file path to system clip board
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
//paste the path to file upload pop up
Robot r = new Robot();
r.keyPress(KeyEvent.VK_CONTROL);
r.keyPress(KeyEvent.VK_V);
r.keyRelease(KeyEvent.VK_CONTROL);
r.keyRelease(KeyEvent.VK_V);
//CLICK ON ENTER
r.keyPress(KeyEvent.VK_ENTER);
r.keyRelease(KeyEvent.VK_ENTER);
Thread.sleep(5000);
driver.quit();
	} 

}
