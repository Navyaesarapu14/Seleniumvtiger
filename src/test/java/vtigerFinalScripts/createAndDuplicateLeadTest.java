package vtigerFinalScripts;

import java.util.Map;

import org.testng.asserts.SoftAssert;

public class createAndDuplicateLeadTest {
	SoftAssert soft = new SoftAssert();
	home.clickLeads();
	soft.assertTrue(driver.getTitle().contains("Leads"));
	lead.clickPlusButton();
	soft.assertEquals(createLead.getPageHeader(), "Creating New Lead");
	Map<String,String> map = excel.readFromExcel("LeadtsTestData", "Create and Duplicate Lead");
	String lastName = map.get("Last Name")+jutil.generateRandomNum(100);
	createLead.setLastName(lastName);
	CreateLead.setCompanyName(map.get("Company"));
	createLead.clickSaveButton();
	soft.assertTrue(newLeadInfo.getPageHeader().contains(lastName));
	newLeadInfo.clickDuplicateButton();
	soft.assertTrue(duplicatingLead.getPageHeader().contains("Duplicating"));
	String newLastName = map.get("New Last Name")+jutil.generateRandomNum(100);
			duplicatingLead.setLastName(newLastName);
			duplicatingLead.clickSaveButton();
			
	if(newContactInfo.getPageHeader().contains(lastName))
		excel.writeToExcel("LeadsTestData", "Create and Duplicate Lead", "Pass", IConstantPath)
		else
			excel.writeToExcel("LeadsTestData", "Create and Duplicate Lead", "Fail", IConstantPath);
		soft.assertAll();

}
