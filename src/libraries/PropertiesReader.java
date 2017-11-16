package libraries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This file will actually read the data from the Properties file. This will help in
 * fetchnig the test data for this project
 * @author Manasa
 *
 */
public class PropertiesReader {
	
	Properties prop;
	
	public PropertiesReader() {

		File file = new File(Configurations.testDataPath);

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getEmail() {
		return prop.getProperty("email");
	}
	
	public String getPassword(){
		return prop.getProperty("password");
	}
	
	public String getMyAccountText(){
		return prop.getProperty("myAccountText");
	}
	
	public String getMyAccountValidationMessage(){
		return prop.getProperty("myAccountValidationMessage");
	}
	
	public String getOrderConfirmationText(){
		return prop.getProperty("orderConfirmationText");
	}
	
	public String getOrderConfirmationValidationMessage(){
		return prop.getProperty("orderConfirmationValidationMessage");
	}
}
