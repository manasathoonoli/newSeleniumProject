package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;

/**
 * This file contains all the methods/objects related to home page of the appliaction 
 * @author Manasa
 *
 */
public class HomePageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	
	public HomePageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.genericMethods = new GenericMethods(this.driver, this.wait);
	}

	public void clickSignInLink() throws Exception{
		this.genericMethods.clickByXpath("//a[@class='login']", "FAIL -- Sign in link not found");
	}
}
