package Cores.Reporting;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import Cores.DriverCore.WebDriverManager;		

public class TestListener implements ITestListener {		

    @Override		
    public void onFinish(ITestContext Result) {
    	ExtentTestManager.getTest().log(LogStatus.INFO, "This test case has finished execution.");
    	GenerateReport.tearDown(ExtentTestManager.getTest());      		
    }		

    @Override		
    public void onStart(ITestContext Result) {	
    }		

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {		
	
    }		

    // When Test case get failed, this method is called.		
    @Override		
    public void onTestFailure(ITestResult Result) {
    	ExtentTestManager.getTest().log(LogStatus.FAIL, "The name of the testcase Failed is :"+ Result.getName());
        // Take screen shot of page
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) WebDriverManager.getDriverInstance().getWebDriver()).
                getScreenshotAs(OutputType.BASE64);
     
            //ExtentReports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed. Snapshot below: ",
        ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));

    }		

    // When Test case get Skipped, this method is called.		
    @Override		
    public void onTestSkipped(ITestResult Result) {		
    	ExtentTestManager.getTest().log(LogStatus.SKIP,"The name of the testcase Skipped is :"+ Result.getName());					
    }		

    // When Test case get Started, this method is called.		
    @Override		
    public void onTestStart(ITestResult Result)	{		
    	ExtentTestManager.startTest(Result.getName(), "");			
    }		

    // When Test case get passed, this method is called.		
    @Override		
    public void onTestSuccess(ITestResult Result) {		
    	ExtentTestManager.getTest().log(LogStatus.PASS,"The name of the testcase Passed is :"+ Result.getName());					
    }		

}		