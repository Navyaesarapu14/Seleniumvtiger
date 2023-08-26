package vtigerFinalScripts;

import java.util.Map;

import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IConstantPath;

public class CreateContactTest extends BaseClass{
	public void createContactTest() {
		SoftAssert soft = new SoftAssert();
		home.clickContacts();
		soft.assertTrue(driver.getTitle().contains("Contacts"));
		contacts.clickPlusButton();
		soft.assertEquals(createContact.getPageHeader(), "Creating New Contact");
		Map<String,String> map = excel.readFromExcel("ContactsTestData", "Create Contact");
		String lastName = map.get("Last Name")+jutil.generateRandomNum(100);
		createContact.setLastName(lastName);
		createContact.clickSaveButton();
		soft.assertTrue(newContactInfo.getPageHeader().contains(lastName));
		if(newContactInfo.getPageHeader().contains(lastName))
			excel.writeToExcel("ContactsTestData", "Create Contact", "Pass", IConstantPath)
			else
				excel.writeToExcel("ContactsTestData", "Create Contact", "Fail", IConstantPath);
			soft.assertAll();
		
		
	}

}
