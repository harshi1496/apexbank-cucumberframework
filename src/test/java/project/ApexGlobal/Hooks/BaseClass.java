package project.ApexGlobal.Hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;


import org.testng.annotations.Parameters;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import project.ApexGlobal.Utilities.ConfigReader;
import project.ApexGlobal.Utilities.DriverManager;
import project.ApexGlobal.Utilities.WebDriverFactory;

public class BaseClass {

	private static WebDriver driver;
	
	@Parameters({"browser"})
	@Before	
	public void hook(Scenario scenario) {
		
		String browser = ConfigReader.getProperty("browser");
		WebDriver driver = WebDriverFactory.initializeBrowser(browser);				
		DriverManager.setDriver(driver);
		String baseUrl = ConfigReader.getProperty("URL");
		DriverManager.getDriver().get(baseUrl);		
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
	}
	
	
	@After
	public void tearDown() {
		
		if(DriverManager.getDriver()!=null) {
			DriverManager.getDriver().close();
		}
		DriverManager.unload();
	}
}
