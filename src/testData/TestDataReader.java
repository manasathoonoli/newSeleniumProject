package testData;

import libraries.PropertiesReader;

/**
 * This file will read the test data from the file and input to the test scripts
 * @author Manasa
 *
 */
public class TestDataReader {

	public static PropertiesReader propertiesReader = new PropertiesReader();
	
	public static String email = TestDataReader.propertiesReader.getEmail();
	public static String password = TestDataReader.propertiesReader.getPassword();
	public static String myAccountText = TestDataReader.propertiesReader.getMyAccountText();
	public static String myAccountValidationMessage = TestDataReader.propertiesReader.getMyAccountValidationMessage();
	public static String orderConfirmationValidationMessage = TestDataReader.propertiesReader.getOrderConfirmationValidationMessage();
	public static String orderConfirmationText = TestDataReader.propertiesReader.getOrderConfirmationText();
}
