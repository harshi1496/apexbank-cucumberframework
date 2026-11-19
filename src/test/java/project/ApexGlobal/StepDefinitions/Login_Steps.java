package project.ApexGlobal.StepDefinitions;

import java.time.Duration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import project.ApexGlobal.Pages.DashboardPage;
import project.ApexGlobal.Pages.LoginPage;
import project.ApexGlobal.Utilities.ConfigReader;
import project.ApexGlobal.Utilities.DriverManager;

public class Login_Steps{	
	
	private  LoginPage lp;
	private  DashboardPage db;
	
	
	@Given("the user is on the login Page")
	public void launchURL() {
		
		String baseUrl = ConfigReader.getProperty("URL");
		DriverManager.getDriver().get(baseUrl);		
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
	}
	
	@When("the user enters {string} and {string}")
    public void enterCredentialsAndLogin(String username, String password) {
        
		lp = new LoginPage();
        lp.getUsername().sendKeys(username);
        lp.getPassword().sendKeys(password);
        
    }
	
	@When("the user clicks login button")
	public void clickLoginButton() {
		lp.getLoginBtn().click();
	}
	
	@Then("the user should be logged in successfully")
	public void verifySuccessfullLogin() {
		
		db = new DashboardPage();
		db.verifyLoginSuccessfull();
	}
	
	@Then("An error message should be displayed on login page")
	public void verifyLoginFailure() {
		lp = new LoginPage();
		lp.verifyErrorMessage();
		
	}
}
