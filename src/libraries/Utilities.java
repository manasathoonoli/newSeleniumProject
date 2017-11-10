package libraries;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This file contains all the pre-requisites that are required to start/run
 * the automation scripts
 * @author Manasa
 *
 */
public class Utilities {

	public WebDriver launchBrowser(){
		if (System.getProperty("os.name").equals("Windows 8.1")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "geckodriver.exe");
		} else {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "geckodriver");
		}
		
		WebDriver driver = new FirefoxDriver(); // This will launch FirFox browser

		driver.get(Configurations.URL); // This will launch the application
		
		return driver;
	}
}