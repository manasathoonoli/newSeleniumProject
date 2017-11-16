package libraries;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

/**
 * This class file consists of all methods which are related to this project only.
 * @author Manasa
 *
 */
public class ProjectSpecificMethods {

	WebDriver driver;
	WebDriverWait wait;
	HomePageObject homePageObject;
	LoginPageObject loginPageObject;
	public ProjectSpecificMethods(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.homePageObject = new HomePageObject(this.driver, this.wait);
		this.loginPageObject = new LoginPageObject(this.driver, this.wait);
	}

	/**
	 * This method scrolls the page based on the co-ordinates provided
	 * @param upCoordinates
	 * @param downCoordinates
	 * @throws Exception
	 */
	public void pageScroll(String upCoordinates, String downCoordinates) throws Exception{
		try {
			JavascriptExecutor executor = (JavascriptExecutor) this.driver;
			executor.executeScript("window.scrollBy(" + upCoordinates + "," + downCoordinates + ")", "");
		} catch (Exception e) {
			throw new Exception("FAIL -- Page did not scroll");
		}
	}
	
	public void signIn(String emailId, String password) throws Exception{
		this.homePageObject.clickSignInLink();
		this.loginPageObject.enterUsername(emailId);
		this.loginPageObject.enterPassword(password);
		this.loginPageObject.clickSignInButton();
	}
}