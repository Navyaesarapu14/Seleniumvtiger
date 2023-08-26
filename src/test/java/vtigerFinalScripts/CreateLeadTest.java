package vtigerFinalScripts;

import java.util.Map;

import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;

public class CreateLeadTest extends BaseClass {
	SoftAssert soft = new SoftAssert();
	home.clickLeads();
	soft.assertTrue(driver.getTitle().contains("Contacts"));
	contacts.clickPlusButton();
	soft.assertEquals(createLead.getPageHeader(), "Creating New Lead");
	Map<String,String> map = excel.readFromExcel("LeadsTestData", "Create lead");
	String lastName = map.get("Last Name")+jutil.generateRandomNum(100);
	createLead.setLastName(lastName);
	createLead.setCompanyName(map.get("Company"));
	createLead.clickSaveButton();
	soft.assertTrue(newLeadInfo.getPageHeader().contains(lastName));
	if(newLeadInfo.getPageHeader().contains(lastName))
		excel.writeToExcel("LeadsTestData", "Create lead", "Pass", IConstantPath.EXCEL_PATH);
		else
excel.writeToExcel("leadsTestData", "Create lead", "Fail", IConstantPath.EXCEL_PATH);
		soft.assertAll();
	

}
