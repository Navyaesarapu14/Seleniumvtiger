package Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locatorsnew {

	public static void main(String[] args) throws InterruptedException {
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.facebook.com/");
    driver.findElement(By.linkText("Forgotten password?")).click();
    Thread.sleep(2000);
    driver.navigate().back();
    driver.findElement(By.linkText("Create a Page")).click();
    Thread.sleep(2000);
    driver.close();
	}

}
