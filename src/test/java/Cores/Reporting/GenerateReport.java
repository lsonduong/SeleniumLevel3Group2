package Cores.Reporting;

import java.sql.Timestamp;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
 
public class GenerateReport {
	
	static ExtentReports reports;
	static Timestamp timestamp = new Timestamp(System.currentTimeMillis());
 
    public synchronized static ExtentReports getReporter() {
        if (reports == null) {
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
            	reports = new ExtentReports(workingDir + "\\HtmlReport\\ExtentReportResults.html", true);
            }
            else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            	reports = new ExtentReports(workingDir + "/HtmlReport/ExtentReportResults.html", true);
            }
        }
        return reports;
    }
    
    public static void tearDown(ExtentTest test) {
        // Ending Test
        reports.endTest(test);
 
        // writing everything into HTML report
        reports.flush();
    }
}