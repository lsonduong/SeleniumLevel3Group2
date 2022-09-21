package Cores.Reporting;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentTestManager {
	
	static Map<Long, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = GenerateReport.getReporter();
 
    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((long) (Thread.currentThread().getId()));
    }
 
    public static synchronized void endTest() {
        extent.endTest((ExtentTest) extentTestMap.get((long) (Thread.currentThread().getId())));
    }
 
    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.startTest(testName, desc);
        extentTestMap.put((long) (Thread.currentThread().getId()), test);
        return test;
    }
    
    public static void logInfo(String details) {
    	getTest().log(LogStatus.INFO, details);
    }
}