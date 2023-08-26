package Pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	//Declaration
	@FindBy(name= "user_name")
	private WebElement usernameTF;
	@FindBy(name= "user_password")
	private WebElement passwordTF;
	@FindBy(name= "submitButton")
	private WebElement loginButtonTF;
	//Initialization
	public Loginpage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public void loginToApp(String username, String password) {
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginButtonTF.submit();
	}
	

}
