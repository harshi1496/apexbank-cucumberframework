package project.ApexGlobal.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utilities {
	

	public static void selectByVisibleText(WebElement element, String value) {
		
		Select dd = new Select(element); 
		dd.selectByVisibleText(value);;
	}
	
	public static void selectByIndex(WebElement element, Integer index) {
		
		Select dd = new Select(element); 
		dd.selectByIndex(index);
		
	}
	public static void selectByValue(WebElement element, String value) {
		 
		Select dd = new Select(element); 
		dd.selectByValue(value);
			
	 }
	 
	public static void deSelectByVisibleText(WebElement element, String value) {
			
			Select dd = new Select(element); 
			dd.deselectByVisibleText(value);
		}
		
	public static void deSelectByIndex(WebElement element, Integer index) {
			
			Select dd = new Select(element); 
			dd.deselectByIndex(index);
			
		}
	public static void deSelectByValue(WebElement element, String value) {
			 
			Select dd = new Select(element); 
			dd.deselectByValue(value);
				
	}
	
	public static void enterValue(WebElement element, String value) {
		
			element.sendKeys(value);
	}
	
	public static List<String> getOptions(WebElement element) {
		
		Select dd = new Select(element); 
		List<WebElement> options = dd.getOptions();
		List<String> lst = new ArrayList<>();
		for(WebElement w: options) {
			
			lst.add(w.getText());
		}
		return lst;
		
	}
	
	public static void waitForVisibilityOfElement(WebDriver driver, Integer timeInSec, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeInSec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitIfAlertIsPresent(WebDriver driver, Integer timeInSec) {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
	     wait.until(ExpectedConditions.alertIsPresent());

	}
	
	public static void alertAccept(WebDriver driver) {
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public static void alertDismiss(WebDriver driver) {
		
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public static String getAlertText(WebDriver driver) {
		
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
	
	public static void readExcel(String sheetName) throws IOException {
		
		FileInputStream fis = new FileInputStream(ConfigReader.getProperty("excelPath"));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int totalCell = sheet.getRow(0).getLastCellNum();
		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		for(int i=0;i<rowCount;i++) {
			sheet.getRow(i).getCell(i);
		}
		
	}
}
