package genericlibraries;

import java.io.File;
import java.io.IOException;

/**
 * This class contains all reusable methods to perform driver related operations
 * @author 
 */

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	private WebDriver driver;
	private WebDriverWait wait;

	/**
	 * This method is used to launch specified browser browser
	 * 
	 * @return
	 */
	public WebDriver launchBrowser(String browser) {
		switch (browser){
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser info");
		}
		return driver;
	}

	/**
	 * This method is used to maximize the browser
	 */
	public void maximizeBrowser() {

		driver.manage().window().maximize();
	}

	public void navigateToApp(String url) {
		driver.get(url);
	}

	public void waitTillElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}

	public WebElement explicitWait(Long time, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement explicitWait(long time, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public Boolean explicitWait(String title, Long time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.titleContains(title));
	}

	public void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void rightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void doubleClickOnElement(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void dragAndDrop(WebElement element, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(element, target).perform();
	}
	public void selectFromDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public void selectFromDropdown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void selectFromDropdown(String visibleText,WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}

	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	
	}
	public void takeScreenshot(String className, JavaUtility jUtil) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+className+"_"+jUtil.getCurrentTime()+".png");
		try {
			FileUtils.copyFile(src, dest);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
	}
	public String takeScreenshot() {
		TakesScreenshot ts = (TakesScreenshot)driver;
		return ts.getScreenshotAs(OutputType.BASE64);
		}
	/**
	 * This method is used to scroll till the specified web element
	 * element
	 */
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0], scrollIntoView(true)", element);
	}
	/**
	 * This method handles alert pop up
	 * status
	 */
	public void handleAlert(String status) {
		Alert alert = driver.switchTo().alert();
		if(status.equalsIgnoreCase("ok"))
			alert.accept();
		else
			alert.dismiss();
	}
	/**
	 * This method is used to switch to child browser
	 */
	public void switchToChildWindow() {
		Set<String> set = driver.getWindowHandles();
		for (String window : set) {
		driver.switchTo().window(window);
		}
		public void switchToWindow(String windowID) {
			driver.switchTo().window(windowID);
		}
		public String getParentWindowID() {
			return driver.getWindowHandle();
		}
	}
		
	}


