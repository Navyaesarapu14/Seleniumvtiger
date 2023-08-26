package AlertPopup;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadUsingSendkeys {

	public static void main(String[] args) throws InterruptedException{
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://www.foundit.in/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.findElement(By.xpath("//div[normalize-space(text())='Upload Resume']")).click();
driver.findElement(By.id("file-upload")).sendKeys("\"C:\\Users\\esara\\Downloads\\2018-12-08-18-07-00-760.jpg\"");
Thread.sleep(3000);
driver.quit();
	}

}
