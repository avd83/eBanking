package eBanking.testCase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;

	public static   ExtentReports getReportObject()
	{		
	//ExtentReports and ExtetntSparkReporter class
		String path = System.getProperty("user.dir")+"\\Reports\\index.html";		
		reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("eBanking Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Abhay Dere");
		return extent;
	}
}
