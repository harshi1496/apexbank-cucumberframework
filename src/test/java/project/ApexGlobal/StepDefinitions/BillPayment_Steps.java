package project.ApexGlobal.StepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import project.ApexGlobal.Pages.BillPaymentPage;
import project.ApexGlobal.Pages.DashboardPage;

public class BillPayment_Steps {

	private  DashboardPage db ;
	private  BillPaymentPage bp;
	
	
	
	@Given("user is on the Bill payment page")
	public void navigateToBillPaymentPage() {
		db = new DashboardPage();
		db.navigateToBillPaymentPage();
	}
	
	@When("user fills {string} as the funding account")
	public void selectPayFromAccount(String payFromAccount) {
		bp = new BillPaymentPage();
		bp.setPayFromAccount(payFromAccount);
	}
	
	@When("selects {string} and {string}")
	public void selectBillerCategoryAndServiceProvider(String billCategory, String serviceProvider) {
		
		bp.setBillerCategory(billCategory);
		bp.setServiceProvider(serviceProvider);
	}
	
	@When("enters the Account ID {string} and payment amount {string}")
	public void fillAccountIDAndPaymentAmount(String accountID, String amount) {
		bp.enterAccountID(accountID);
		bp.enterAmount(amount);
	}
	
	@When("clicks Authorize instant bill payment button")
	public void completeBillPayment() {
		
		bp.clickOnBillPaymentButton();
	}
	
	@Then("the payment should be successful")
	public void assertPaymentSuccessful() {
		
		bp.verifyPaymentIsSuccessful();
	}
	
	@Then("the payment should be updated in payment history {string}{string}{string}{string}{string}")
	public void verifyPaymentHistory(String account, String category, String provider, String amount, String paid) {
		
        	bp.verifyBillPaymentIsAddedInThePaymentHistory(account,category,provider,amount, paid);
	}
	
	@Then("the account balance should be updated in Dashboard page by deducting the {string} amount")
	public void validateAccountBalance(String amount) {
		bp.navigateToDashBoardpage();
		double sb = db.getSavingsAccountBalance();
		sb=sb-Double.parseDouble(amount);
		db.setSavingsAccountBalance(sb);	
		Assert.assertTrue(Double.parseDouble(db.getSavingsAccountBalanceFromDashboard().getText().replaceAll("[^\\d.]", ""))==sb,"Account balance is updated.");
		
	}
}
