package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;
import results.ExtentResults;

/**
 * This file contains all the methods/objects related to home page of the appliaction 
 * @author Manasa
 *
 */
public class HomePageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	ExtentResults results = new ExtentResults();
	
	public HomePageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.genericMethods = new GenericMethods(this.driver, this.wait);
	}

	public void clickSignInLink() throws Exception{
		this.genericMethods.clickByXpath("//a[@class='login']", "FAIL -- Sign in link not found");
		this.results.log("Sign in link found", true);
	}
	
	public void clickLogo() throws Exception{
		this.genericMethods.clickByXpath("//img[@alt='My Store']", "FAIL -- to click on home page");
		this.results.log("Logo Found", true);
	}
	
	public void clickUsernameAccount() throws Exception{
		this.genericMethods.clickByXpath("//a[@class='account']", "FAIL -- Username account tab not found");
		this.results.log("Username account tab not found", true);
	}
	
	public void waitForProductSection() throws Exception{
		this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='center_column']"))); // waiting for complete product container
		this.results.log("Order section found", true);
	}
}
