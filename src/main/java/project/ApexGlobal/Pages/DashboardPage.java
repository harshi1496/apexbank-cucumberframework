package project.ApexGlobal.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import project.ApexGlobal.Utilities.DriverManager;
import project.ApexGlobal.Utilities.ExtentReportManager;

public class DashboardPage {

	public WebDriver driver;
	
	@FindBy(id="welcomeGreeting")
	private WebElement welcomeGreet;
	
	@FindBy(id="quickBillPayBtn")
	private WebElement payUtilityBill;
	
	@FindBy(xpath="//div[@class='account-card savings']/div")
	private WebElement savingsAccountTxt;
	
	@FindBy(xpath="//div[@class='account-card savings']/div[2]")
	private WebElement savingsAccountNo;
	
	@FindBy(xpath="//div[@class='account-card savings']/div[4]")
	private WebElement savingsAccountBalance;
	
	@FindBy(xpath="//div[@class='account-card savings']/div[5]//strong")
	private WebElement savingsAccountStatus;
	
	@FindBy(linkText="logoutBtn")
	private WebElement logOut;
	
	private static double savingsBal;
	private static double checkingBal;
	private static double fdBal;
	
	
	public DashboardPage() {
		
		this.driver = DriverManager.getDriver();
		PageFactory.initElements(driver, this);
		if(savingsAccountBalance.isDisplayed() && savingsAccountBalance.getText()!=null) {
			
			savingsBal = Double.parseDouble(savingsAccountBalance.getText().replaceAll("[^\\d.]", ""));
		}
		
	}
	
	public void verifyLoginSuccessfull() {
		Assert.assertTrue(welcomeGreet.getText().contains("Welcome back"), "Logged in successfully");
	}
	
	public void navigateToBillPaymentPage() {		
		payUtilityBill.click();		
	}
	
	public void getTitle() {
		
		Assert.assertTrue(driver.getTitle().equals("dashboard"));
		ExtentReportManager.getTest().pass("Navigated to Dashboard successfully");
	}
	
	public Double getSavingsAccountBalance() {
		
		return savingsBal;
		 
	}
	
	public void setSavingsAccountBalance(double amount) {
		
		if(amount<savingsBal) {
			
			savingsBal=amount;
		}
	}
	
	public void clickLogout() {
		
		logOut.click();
	}
	
	public WebElement getSavingsAccountBalanceFromDashboard() {
		
		return savingsAccountBalance;
	}
}
