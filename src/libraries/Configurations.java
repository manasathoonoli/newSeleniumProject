/**
 * 
 */
package libraries;

import java.io.File;

/**
 * This class file consists of all the configurations, URL's, path's whch are
 * used in the entire project
 * @author Manasa
 *
 */
public class Configurations {

	public static String URL = "http://automationpractice.com/index.php";
	public static String testDataPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "testData" + File.separator + "TestData";
	public static String resultsPath = System.getProperty("user.dir") + File.separator + "ExtentResults.html"; 
}