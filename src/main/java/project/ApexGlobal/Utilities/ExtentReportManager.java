package project.ApexGlobal.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

	private static ExtentReports extent ;
	
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public static ExtentReports getInstance() {
		if(extent == null) {
			String path =System.getProperty("user.dir")+"\\test-output\\reports\\Extent-Report_"+System.currentTimeMillis()+".html";
			System.out.println(path);
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
			
			sparkReporter.config().setTheme(Theme.STANDARD);
			sparkReporter.config().setDocumentTitle("Automation Test Report");
			sparkReporter.config().setReportName("Functional Test Suite");
			
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
		}
		
		
		return extent;
	}
	
	public static ExtentTest getTest() {
		return extentTest.get();
	}
	
	public static void setTest(ExtentTest test) {
		extentTest.set(test);
	}
	
	public static void removeTest() {
		extentTest.remove();
	}
}


