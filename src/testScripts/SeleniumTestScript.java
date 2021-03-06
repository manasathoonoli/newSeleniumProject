/**
 * 
 */
package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import libraries.GenericMethods;
import libraries.Utilities;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

/**
 * This file has the test scripts for the basic functionality of demo application
 * @author Manasa
 *
 */
public class SeleniumTestScript {

	Utilities utiltities = new Utilities();
	WebDriver driver;
	WebDriverWait wait;
	GenericMethods genericMethods;
	HomePageObject homePageObject;
	LoginPageObject loginPageObject;
	
	@BeforeTest
	public void startBrowser(){
		this.driver = utiltities.launchBrowser();
		this.driver.manage().window().maximize(); // Maximize the browser
		this.wait = new WebDriverWait(driver, 30);
		this.genericMethods = new GenericMethods(this.driver, this.wait);
		this.homePageObject = new HomePageObject(this.driver, this.wait);
		this.loginPageObject = new LoginPageObject(this.driver, this.wait);
	}
	
	@Test
	public void webDriverCommands() throws Exception {
		
		Reporter.log("This is the current URL : " + this.driver.getCurrentUrl() , true);
		Reporter.log("This page title : " + this.driver.getTitle(), true);
		
		this.homePageObject.clickSignInLink();
		
		this.loginPageObject.enterUsername("testautomation88@test.com");
		this.loginPageObject.enterPassword("123456");
		this.loginPageObject.clickSignInButton();

		System.out.println("-------------------\nPassed --> Test suite 1\n-------------------");
	}

	@Test
	public void webDriverCommands2() throws Exception {

		this.homePageObject.clickSignInLink();

		this.loginPageObject.enterUsername("testautomation88@test.com");
		this.loginPageObject.enterPassword("123456");
		this.loginPageObject.clickSignInButton();

		driver.findElement(By.xpath("//img[@alt='My Store']")).click(); // click on home page logo

		WebDriverWait wait = new WebDriverWait(driver, 30); // creating a explicit wait time to wait for the page to appear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='center_column']"))); // waiting for complete product container

		driver.findElement(By.xpath("//a[@class='account']")).click();

		String accountPageText = driver.findElement(By.xpath("//div[@id='center_column']/h1")).getText();

		Assert.assertEquals(accountPageText, "MY ACCOUNT", "FAIL -- The account page text is not displayedd properyl");

		driver.findElement(By.xpath("//a[@title='Orders']")).click();

		driver.findElement(By.xpath("//a[contains(text(), 'DHZQDWAXX')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='button btn btn-default button-medium pull-right']"))); // waiting for complete product container
		driver.findElement(By.xpath("//a[@class='button btn btn-default button-medium pull-right']")).click();

		String product = driver.findElement(By.xpath("//td[@class='cart_description']/p[@class='product-name']/a")).getText();

		System.out.println("Product name is : " + product);
		Assert.assertEquals(product, "Faded Short Sleeve T-shirts", "Fail -- product name confirmation");

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scroll(0, 400)", "");

		driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']")).click();
		driver.findElement(By.xpath("//button[@name='processAddress']")).click();
		driver.findElement(By.id("cgv")).click();
		driver.findElement(By.xpath("//button[@name='processCarrier']")).click();
		driver.findElement(By.xpath("//a[@title='Pay by bank wire']")).click();
		driver.findElement(By.xpath("//button[@type='submit']/span[contains(text(), 'I confirm my order')]")).click();

		String confirmation = driver.findElement(By.xpath("//p[@class='cheque-indent']")).getText();

		Assert.assertEquals(confirmation, "Your order on My Store is complete.", "FAIL -- order not palced");

		System.out.println("-------------------\nPassed --> Test suite 2\n-------------------");
	}

	@Test
	public void webDriverCommands3() throws Exception {
		
		// waiting for web driver
		WebDriverWait wait = new WebDriverWait(driver, 15);

		// getting into signin link
		this.homePageObject.clickSignInLink();

		// fill in the email and click on create account button
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("reachmanasathoonoli@gmail.com");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();

		// Asserting to see if create account page turned up
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='account-creation_form']")));
		String pagehearder = driver.findElement(By.xpath("//div[@id='noSlide']/h1")).getText();
		Assert.assertEquals(pagehearder, "CREATE AN ACCOUNT", "Fail -- Did not load account creation page");
		
		// Selenium commands for drop-down selection
		WebElement dateDropDown = driver.findElement(By.xpath("//select[@id='days']"));
		Select dateDD = new Select(dateDropDown);
		dateDD.selectByIndex(8); // select date as 8
		
		WebElement monthDropDown = driver.findElement(By.xpath("//select[@id='months']"));
		Select monthDD = new Select(monthDropDown);
		monthDD.selectByValue("7"); // month as July
		
		WebElement yearDropDown = driver.findElement(By.xpath("//select[@id='years']"));
		Select yearDD = new Select(yearDropDown);
		yearDD.selectByVisibleText("1988  "); // year as 1988
		
		System.out.println("-------------------\nPassed --> Test suite 3\n-------------------");
	}
	
	@AfterTest
	public void endBrowser(){
		driver.quit();
	}

}