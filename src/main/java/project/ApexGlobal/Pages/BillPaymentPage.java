package project.ApexGlobal.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import project.ApexGlobal.Utilities.DriverManager;
import project.ApexGlobal.Utilities.ExtentReportManager;
import project.ApexGlobal.Utilities.Utilities;

public class BillPaymentPage {
	
	public WebDriver driver;

	@FindBy(id="billFromAccountSelect")
	private WebElement payFromAccount; 
	
	@FindBy(id="billerCategorySelect")
	private WebElement billCategory; 
	
	@FindBy(id="billerProviderSelect")
	private WebElement serviceProvider; 
	
	@FindBy(id="consumerNumberInput")
	private WebElement accountNumber; 
	
	@FindBy(id="billAmountInput")
	private WebElement paymentAmount; 
	
	@FindBy(name="payBillSubmitButton")
	private WebElement payBillSubmitBtn; 
	
	@FindBy(xpath="//h4[text()='Payment Successful']")
	private WebElement paymentSuccessMsg;
	
	@FindBy(id="doneReceiptBtn")
	private WebElement doneBtn; 
	
	@FindBy(id="navDashboard")
	private WebElement dashboardPage;
	
	@FindBy(id="billHistoryTable")
	private WebElement billHistoryTable;
	
	public BillPaymentPage() {
		this.driver = DriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	public void navigateToDashBoardpage() {
		
		dashboardPage.click();
	}
	
	public void getTitle() {
		Assert.assertTrue(driver.getTitle().equals("Bill Payments & Utilities - Apex Global Bank"));
		ExtentReportManager.getTest().pass("Navigated to Bill payment successfully");
	}
	
	public Double payUtilityBill(String accountName, String billCategory, String serviceProvider, String accountNumber, String amount) {
		DashboardPage dashboard = new DashboardPage();
		Double oldBalance = dashboard.getSavingsAccountBalance();
		List<String> lst = Utilities.getOptions(payFromAccount);
		for(String s: lst) {
			
			if(s.contains(accountName)) {
				System.out.println(s);
				Utilities.selectByVisibleText(this.payFromAccount,s);
			}
		}
		
		Utilities.selectByVisibleText(this.billCategory, billCategory);
		Utilities.selectByVisibleText(this.serviceProvider, serviceProvider);
		this.accountNumber.sendKeys(accountNumber);
		this.paymentAmount.sendKeys(amount);
		this.payBillSubmitBtn.click();
		Utilities.waitForVisibilityOfElement(DriverManager.getDriver(), 3, paymentSuccessMsg);
		Assert.assertTrue(paymentSuccessMsg.getText().equals("Payment Successful"));
		ExtentReportManager.getTest().pass(billCategory+" bill paid successfully.");	
		doneBtn.click();
		return oldBalance;
	}
	
	public void setPayFromAccount(String accountName) {
		
		List<String> lst = Utilities.getOptions(payFromAccount);
		for(String s: lst) {
			
			if(s.contains(accountName)) {
				System.out.println(s);
				Utilities.selectByVisibleText(this.payFromAccount,s);
			}
		}
	}
	
	public void setBillerCategory(String billcategory) {
		
		Utilities.selectByVisibleText(this.billCategory, billcategory);
	}
	
	public void setServiceProvider(String serviceProvider) {
		
		Utilities.selectByVisibleText(this.serviceProvider, serviceProvider);
	}
	
	public void enterAccountID(String accountID) {
		
		this.accountNumber.sendKeys(accountID);
	}
	
	public void enterAmount(String amount) {
		
		this.paymentAmount.sendKeys(amount);
	}
	
	public void clickOnBillPaymentButton() {
		
		this.payBillSubmitBtn.click();
		
	}
	
	public void verifyPaymentIsSuccessful() {
		
		Utilities.waitForVisibilityOfElement(driver, 3, paymentSuccessMsg);
		Assert.assertTrue(paymentSuccessMsg.getText().equals("Payment Successful"));	
		doneBtn.click();
		ExtentReportManager.getTest().pass("Bill payment was completed successfully.");
	}
	
	public void verifyBillPaymentIsAddedInThePaymentHistory(String account,String category, String provider, String amount, String paid) {
		
		Utilities.waitForVisibilityOfElement(driver, 3, billHistoryTable);
		
		WebElement row = billHistoryTable.findElements(By.tagName("tr")).get(1);
		
		List<WebElement> cells = row.findElements(By.tagName("td"));
		
		Assert.assertTrue(category.toUpperCase().contains(cells.get(1).getText()));
		Assert.assertTrue(cells.get(2).getText().equals(provider));
		Assert.assertTrue(account.contains(cells.get(3).getText()));
		Assert.assertTrue(cells.get(4).getText().contains(amount));		
		Assert.assertTrue(cells.get(5).getText().equals(paid));
		
		ExtentReportManager.getTest().pass("Payment record was successfully added to the payment history table.");		
		
	}
	
//	public void verifyBalanceIsUpdated(String accountType, Double oldBalance) {
//		
//		Double billAmount = Double.parseDouble(amount);
//		Double remainingBal = oldBalance - billAmount;
//	}
}
