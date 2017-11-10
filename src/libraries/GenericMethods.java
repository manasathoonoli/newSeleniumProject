/**
 * 
 */
package libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class file consists of all the generic methods which are used for automation with
 * Selenium webDriver
 * @author Manasa
 *
 */
public class GenericMethods {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public GenericMethods(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}

	/**
	 * This method clicks on the xpath that is provided and throws the message as exception
	 * if the element is not found/clickable
	 * @param xpath
	 * @param message
	 * @throws Exception 
	 */
	public void clickByXpath(String xpath, String message) throws Exception{
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			throw new Exception(message);
		}
	}
	
	/**
	 * This method enters the test provided into the test field and throws as message
	 * if the element is not found/clickable
	 * @param xpath
	 * @param value
	 * @param message
	 * @throws Exception
	 */
	public void enterByXpath(String xpath, String value, String message) throws Exception{
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			driver.findElement(By.xpath(xpath)).sendKeys(value);
		} catch (Exception e) {
			throw new Exception(message);
		}
	}
	
	/**
	 * This method enters the test provided into the test field and throws as message
	 * if the element is not found/clickable
	 * @param id
	 * @param value
	 * @param message
	 * @throws Exception
	 */
	public void enterById(String id, String value, String message) throws Exception{
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(id)));
			driver.findElement(By.id(id)).sendKeys(value);
		} catch (Exception e) {
			throw new Exception(message);
		}
	}
	
	/**
	 * This method fetches the test from the xpath provided and throws the message as exception
	 * if element is not found
	 * @param xpath
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public String getTestByXpath(String xpath, String message) throws Exception{
		try {
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
			return driver.findElement(By.xpath(xpath)).getText();
		} catch (Exception e) {
			throw new Exception(message);
		}
	}

}
