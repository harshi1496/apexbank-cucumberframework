package project.ApexGlobal.StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import project.ApexGlobal.Pages.DashboardPage;

public class ToggleBalance_Steps {

	private  DashboardPage db;
	
	@Given("the user is on the Dashboard Page")
	public void verifyDashBoardPage() {
		db = new DashboardPage();
		db.getTitle();
	}
	
	@Then("the account balance should be displayed")
	public void verifyBalanceIsDisplayed() {
		db.verifyTotalBalanceIsDisplayed();
	}
	
	@When("the user clicks toggle balance button")
	public void clickToggleBalance() {
		db.getToggleButton().click();
	}
	
	@Then("the account balance should be masked")
	public void verifyAccountBalanceIsMasked() {
		db.verifyMaskedBalance();
	}
	
}
