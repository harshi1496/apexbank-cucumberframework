package project.ApexGlobal.Utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExecutionPopupListner implements WebDriverListener{
	
	@Override
	public void beforeClick(WebElement element){
		
		try {
           
            WebDriver driver = DriverManager.getDriver();
            if (driver != null) {
   
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                
                System.out.println("⚠️ [Listener] Unexpected alert detected before click: " + alert.getText());
                alert.dismiss(); 
            }
        } catch (Exception e) {
          
        	
        }
    }
}	

	
	

