package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;
import results.ExtentResults;

/**
 * This file contains all the methods/objects related to login page of the appliaction
 * @author Manasa
 *
 */
public class LoginPageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	ExtentResults results = new ExtentResults();
	
	public LoginPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.genericMethods = new GenericMethods(this.driver, this.wait);
	}
	
	public void clickSignInButton() throws Exception{
		this.genericMethods.clickByXpath("//button[@id='SubmitLogin']", "FAIL -- sign in button not found");
		this.results.log("Sign in button found", true);
	}
	
	public void enterUsername(String username) throws Exception{
		this.genericMethods.enterByXpath("//input[@id='email']", username, "FAIL -- Username text field not found");
		this.results.log("Username text field found", true);
	}
	
	public void enterPassword(String password) throws Exception{
		this.genericMethods.enterById("passwd", password, "FAIL -- Password text field not found");
		this.results.log("Passowrd text field found", true);
	}
}
