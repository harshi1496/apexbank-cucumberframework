package project.ApexGlobal.Utilities;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class WebDriverFactory {

	private static WebDriver driver;
	
	public static WebDriver initializeBrowser(String browser) {
		
		switch(browser) {
		
		case "chrome": ChromeOptions coptions = new ChromeOptions();
					   coptions.addArguments("--disable-popup-blocking");
					   coptions.addArguments("--disable-features=PasswordLeakDetection");
				       coptions.addArguments("--disable-save-password-bubble");
				 
				       Map<String, Object> prefs = new HashMap<>();
				       prefs.put("credentials_enable_service", false);
				       prefs.put("profile.password_manager_enabled", false);
				       prefs.put("profile.password_manager_leak_detection", false);
				       coptions.setExperimentalOption("prefs", prefs);
					   driver = new ChromeDriver(coptions);
					   break;
					   
		case "edge":   EdgeOptions eoptions = new EdgeOptions();
					   eoptions.addArguments("--disable-popup-blocking");
					   driver = new EdgeDriver(eoptions);
					   break;
		
		}
		
		
		AlertListner listner = new AlertListner();
		WebDriver decoratedDriver = new EventFiringDecorator<>(listner).decorate(driver);
		return decoratedDriver;
	}
	
	public static WebDriver getDriver() {
		
		return DriverManager.getDriver();
	}
}
