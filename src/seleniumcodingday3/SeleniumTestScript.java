/**
 * 
 */
package seleniumcodingday3;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Manasa
 *
 */
public class SeleniumTestScript {

	@Test
	public void webDriverCommands() {

		if (System.getProperty("os.name").equals("Windows 8.1")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "geckodriver");
		}

		WebDriver driver = new FirefoxDriver(); // This will launch FirFox browser

		driver.get("http://automationpractice.com/index.php"); // This will launch the application

		System.out.println(driver.getCurrentUrl()); // Print the url of the page
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();

		WebElement signInLink = driver.findElement(By.xpath("//a[@class='login']")); // Will identify the sign in link and stores
		signInLink.click(); // Clicks the sign in link

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testautomation88@test.com"); // fill in the email address text field and fill in the required value
		WebElement password = driver.findElement(By.id("passwd")); // will find the password text box
		password.sendKeys("123456"); // enter the password
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click(); // click the submit button

		driver.close(); // close the browser

		System.out.println("-------------------\nPassed --> Test suite 1\n-------------------");
	}

	@Test
	public void webDriverCommands2() {

		if (System.getProperty("os.name").equals("Windows 8.1")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "geckodriver");
		}

		WebDriver driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php"); // This will launch the application

		WebElement signInLink = driver.findElement(By.xpath("//a[@class='login']")); // Will identify the sign in link and stores
		signInLink.click(); // Clicks the sign in link

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testautomation88@test.com"); // fill in the email address text field and fill in the required value
		WebElement password = driver.findElement(By.id("passwd")); // will find the password text box
		password.sendKeys("123456"); // enter the password
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click(); // click thesubmit button

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
	public void webDriverCommands3() {
		if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Manasa\\Desktop\\Java\\Selenium-Training\\Assignments\\Selenium_WebDriver_Commands\\Sample_Automation_Script\\geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Manasa\\Desktop\\Java\\Selenium-Training\\Assignments\\Selenium_WebDriver_Commands\\Sample_Automation_Script\\geckodriver");
		}

		WebDriver driver = new FirefoxDriver(); // create driver for firefox browser
		driver.get("http://automationpractice.com/index.php");

		// waiting for web driver
		WebDriverWait wait = new WebDriverWait(driver, 15);

		// getting into signin link
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();

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
	
	
	@Test
	public void testMethod() {
		
		System.out.println("This is a Test Method");
	}

}