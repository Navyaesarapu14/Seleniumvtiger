package vtigerTests;

import java.util.Map;

import org.testng.asserts.SoftAssert;

public class createOrgTest {
	SoftAssert soft = new SoftAssert();
	home.clickOrganizations();
	soft.assertTrue(driver.getTitle().contains("Organizations"));
	org.clickPlusButton();
	soft.assertTrue(createOrg.getpageHeader().equals("Creating New Organization"));
	Map<String, String> map = excel.readFromExcel("OrganizationTestData", "Create Organization");
	String orgName = map.get("Organization Name")+jutil.generateRandomNum(100);
	createOrg.setOrgName(orgName);
	createOrg.clickSaveButton();
	soft.assertTrue(newOrgInfo.getPageHeader().contains(orgName));
	if(newOrgInfo.getPageHeader().contains(orgName))
		excel.writeToExcel("OrganizationsTestData", "Create Organization", "Pass"), IConstantPath
	
		else
			excel.writeToExcel("OrganizationsTestData", "Create Organization", "Fail"), IConstantPath
			soft.assertAll();
}

	

}
