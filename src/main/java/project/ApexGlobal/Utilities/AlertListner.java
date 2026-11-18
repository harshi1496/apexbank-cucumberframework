package project.ApexGlobal.Utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertListner implements WebDriverListener{
	
	@Override
	public void beforeClick(WebElement element){
		
		try {
           
            WebDriver driver = DriverManager.getDriver();
            if (driver != null) {
   
                Utilities.waitIfAlertIsPresent(driver, 1);
                Alert alert = driver.switchTo().alert();

                System.out.println("Unexpected alert detected before click: " + alert.getText());
                alert.accept();
            }
        } catch (Exception e) {
          
        	
        }
    }
}	

	
	

