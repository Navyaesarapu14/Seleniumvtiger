package genericlibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.github.dockerjava.core.exec.CreateNetworkCmdExec;

import Pompages.Homepage;
import Pompages.Loginpage;
import Pompages.OrganizationsPage;

public class BaseClass {
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected WebDriver driver;
	
	protected Loginpage login;
	protected Homepage home;
	protected OrganizationsPage org;
	protected ContactsPage contacts;
	protected LeadsPage lead;
	protected CreateNewOrganizationPage createOrg;
	protected CreateNewContactPage createContact;
	protected CreateNewEventPage createEvent;
	protected CreateNewLeadPage createLead;
	protected NewOrgInfoPage newOrgInfo;
	protected NewContactInfoPage newContactInfo;
	protected NewLeadInfoPage newLeadInfo;
	protected NewEventInfoPage newEventInfo;
	protected DuplicatingLeadPage duplicatingLead;
	
	public static WebDriver sdriver;
	public static JavaUtility sjutil;
	
	
	
	//@BeforeSuite
	//@BeforeTest
	@BeforeClass
	public void classSetup() {
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		jutil = new JavaUtility();
		web = new WebDriverUtility();
		property.propertiesInitialization(IConstantPath.PROPERTIES_PATH);
		driver = web.launchBrowser(property.readFromProperties("browser", null));
		web.maximizeBrowser();
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("time")));
		sdriver = driver;
		sjutil = jutil;
		
}
	@BeforeMethod
	public void methodSetup () {
		excel.excelInitialization(IConstantPath.EXCEL_PATH);
		
		login = new Loginpage(driver);
		home = new Homepage(driver);
		org = new OrganizationsPage(driver);
		contacts = new ContactsPage(driver);
		lead = new LeadsPage(driver);
		createOrg = new CreateNewOrganizationPage(driver);
		createContact = new CreateNewContactPage(driver);
		createEvent = new CreateNewEventPage(driver);
		createLead = new CreateNewLeadPage(driver);
		newOrgInfo = new NewOrgInfoPage(driver);
		newContactInfo = new NewContactInfoPage(driver);
		newLeadInfo = new NewLeadInfoPage(driver);
		newEventInfo = new NewLeadInfoPage(driver);
		duplicatingLead = new DuplicatingLeadPage(driver);
		
		web.navigateToApp(property.readFromProperties("url"));
		Assert.assertTrue(driver.getTitle().contains("vtiger"));
		login.loginToApp(property.readFromProperties("username"), property.readFromProperties("password"));
		Assert.assertTrue(driver.getTitle().contains("Home"));	
	}
	}
	
