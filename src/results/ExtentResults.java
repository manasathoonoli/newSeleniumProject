package results;

import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import libraries.Configurations;

/**
 * This file contains methods related to Extent Reports
 * @author Manasa
 *
 */
public class ExtentResults {
	public static ExtentReports extreports = new ExtentReports(Configurations.resultsPath, true);
	public static ExtentTest log;
	
	/**
	 * 
	 * @param testcasename - method name running the test
	 * @param testname - class having the above method
	 */
	public static void createTestCase(String testcasename, String testname){
		ExtentResults.log = ExtentResults.extreports.startTest(testcasename);
		ExtentResults.log.assignCategory(testname);
		ExtentResults.extreports.endTest(log);
		ExtentResults.extreports.flush();
	}
	
	public void assertEquals(Object actual, Object expected, String message) throws Exception{
		try{
			Assert.assertEquals(actual, expected, message);
			ExtentResults.log.log(LogStatus.PASS, "PASS -- " + message);
		}catch(AssertionError e){
			ExtentResults.log.log(LogStatus.FAIL, "FAIL -- " + message, e);
			throw new Exception(message);
		}finally{
			ExtentResults.extreports.endTest(log);
			ExtentResults.extreports.flush(); //will remove all the files that are opened up for the log and close the file
		}
	}
	
	public void log(String message, boolean flag) throws Exception{
		try{
			Reporter.log(message, flag);
			ExtentResults.log.log(LogStatus.PASS, "PASS -- " + message);
		}catch(AssertionError e){
			ExtentResults.log.log(LogStatus.FAIL, "FAIL -- " + message, e);
			throw new Exception(message);
		}finally{
			ExtentResults.extreports.endTest(log);
			ExtentResults.extreports.flush(); //will remove all the files that are opened up for the log and close the file
		}
	}
}