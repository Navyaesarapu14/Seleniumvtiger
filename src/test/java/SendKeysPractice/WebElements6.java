package SendKeysPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElements6 {

		public static void main(String[] args) throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.facebook.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebElement loginButton = driver.findElement(By.name("login"));
			System.out.println(loginButton.getCssValue("font"));
			System.out.println(loginButton.getCssValue("background-color"));
			System.out.println(loginButton.getCssValue("color"));
			driver.close();
			
	}
		

}
