package project.ApexGlobal.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;


public class ExtentListner implements ITestListener {
	
	private static ExtentReports extent = ExtentReportManager.getInstance();
	private String scenarioName;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		Object[] params = result.getParameters();		
	    scenarioName = (params.length > 0) ? params[0].toString() : result.getMethod().getMethodName();
        scenarioName = scenarioName.replace("\"", ""); 
        ExtentTest test = extent.createTest(scenarioName);
		ExtentReportManager.setTest(test);
		ExtentReportManager.getTest().info("Scenario execution started.");
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		ExtentReportManager.getTest().pass("Scenario execution completed successfully.");
		ExtentReportManager.removeTest();
	}
	
	@Override
	public void onTestFailure(ITestResult result){
		
		ExtentTest test = ExtentReportManager.getTest();
		
		WebDriver driver = WebDriverFactory.getDriver();
		
		if(driver!=null) {
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir") + "/screenshots/" + scenarioName + "_" + timestamp + ".png";
			File destFile = new File(path);
			try {				
				FileUtils.copyFile(srcFile, destFile);				
				test.fail("Failure screenshot",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			} catch (IOException e) {				
				e.printStackTrace();
				test.info("Could not attach screenshot: " + e.getMessage());
			}
		}
	}
	
	@Override
	public void onFinish(ITestContext context) {
		
		if(extent!=null) {
			extent.flush();
		}
		
	}
	
	

}
