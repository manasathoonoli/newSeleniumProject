package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;
import results.ExtentResults;

/**
 * This file contains all the methods/objects related to my account page of the appliaction
 * @author Manasa
 *
 */
public class MyAccoutPageObject {

	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	ExtentResults results = new ExtentResults();
	
	public MyAccoutPageObject(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.genericMethods = new GenericMethods(this.driver, this.wait);
	}

	public String getMyAccountText() throws Exception{
		String result = this.genericMethods.getTextByXpath("//div[@id='center_column']/h1", "FAIL -- The account page text is not displayedd properyl");
		this.results.log("The account page is text is found", true);
		return result;
	}
	
	public void clickOrderLink() throws Exception{
		this.genericMethods.clickByXpath("//a[@title='Orders']", "FAIL -- unable to click on order button");
		this.results.log("Clicked on order button", true);
	}
	
	public void clickOnSubmittedOrder() throws Exception{
		this.genericMethods.clickByXpath("//a[contains(text(), 'DHZQDWAXX')]", "FAIL -- unable to find submitted order");
		this.results.log("Submit button found", true);
	}
	
	public void clickOnReorderButton() throws Exception{
		this.genericMethods.clickByXpath("//a[@class='button btn btn-default button-medium pull-right']", "FAIL -- unable to click on re-order button");
		this.results.log("Reorder button found", true);
	}
}
