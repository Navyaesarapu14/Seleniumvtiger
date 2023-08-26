package genericUtilityimplementation;

import java.time.Duration;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericlibraries.ExcelUtility;
import genericlibraries.IConstantPath;
import genericlibraries.JavaUtility;
import genericlibraries.PropertiesUtility;
import genericlibraries.WebDriverUtility;

public class vtigerOrganizations {

	public static void main(String[] args) throws Exception {
		PropertiesUtility property = new PropertiesUtility();
		ExcelUtility excel = new ExcelUtility();
		JavaUtility jutil = new JavaUtility();
		WebDriverUtility  webdriver = new WebDriverUtility();
		
		property.propertiesInitialization(IConstantPath.PROPERTIES_PATH);
		excel.excelInitialization(IConstantPath.EXCEL_PATH);
		
		
		// WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.get("http://localhost:8888/");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriver driver = webUtil.launchBrowser(property.readFromProperties("browser"));
		webUtil.maximizeBrowser();
		webUtil.navigateToApp(property.readFromProperties("time"));
		

		if(driver.getTitle().contains("vtiger"))
			System.out.println("Login page should displayed");
		else
			System.out.println("Login page not found");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("shalom");
		driver.findElement(By.id("submitButton")).submit();
		if(driver.getTitle().contains("Home"))
			System.out.println("Home page is displayed");
		else
			System.out.println("Home page not found");
		driver.findElement(By.xpath("//a[text()='Organizations' and contains(@href, 'action=index')]")).click();
		if(driver.getTitle().contains("Organizations"))
			System.out.println("Organizations page is displayed");
		else
		System.out.println("Organizations page not found");
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		WebElement createOrg = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		if(createOrg.getText().equals("Creating New Organization"))
			System.out.println("Creating New Organization page displayed");
		else
			System.out.println("Creating New Organization page not found");
		//Random random = new Random();
		//int randomNum = random.nextInt(100);
		Map<String, String> map = excel.readFromExcel("OrganizationsTestData", "CreateOrganization");
		String orgName = map.get("Organization Name")+jutil.generateRandomNum(100);
		String orgName = "TCS"+randomNum;
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
		String newOrgInfo = driver.findElement(By.xpath("//span[@ class='dvHeaderText']")).getText();
		if(newOrgInfo.contains(orgName)) {
			System.out.println("Organization created successfully");
		excel.writeToExcel("OrganizationsTestData", "CreateOrganization", "Pass", IConstantPath.EXCEL_PATH);
		}
		else {
			excel.writeToExcel("OrganizationsTestData", "CreateOrganization", "Fail", IConstantPath.EXCEL_PATH);
		}
			System.out.println("Organization not created");
			
		WebElement adminIcon = driver.findElement(By.xpath("//img[@ src='themes/softed/images/user.PNG']"));
		//Actions a = new Actions(driver);
		//a.moveToElement(adminIcon).perform();
		webUtil.mouseHover(adminICon);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//driver.quit();
		webUtil.quitAllWindows();
		excel.closeExcel();
	}

		
		

	}

