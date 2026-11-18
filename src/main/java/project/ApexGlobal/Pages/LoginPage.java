package project.ApexGlobal.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import project.ApexGlobal.Utilities.DriverManager;
import project.ApexGlobal.Utilities.ExtentReportManager;
import project.ApexGlobal.Utilities.Utilities;

public class LoginPage {
	
	public WebDriver driver;

	@FindBy(id="usernameInput")
	private WebElement username;
	
	@FindBy(id="passwordInput")
	private WebElement password;
	
	@FindBy(id="loginSubmitBtn")
	private WebElement login;
		
	@FindBy(id="tabSignIn")
	private WebElement signIn;
	
	@FindBy(id="tabRegister")
	private WebElement newRegistration;
	
	@FindBy(name="fullName")
	private WebElement fullName;

	@FindBy(name="username")
	private WebElement regUsername;
	
	@FindBy(id="regPassword")
	private WebElement regPassword;
	
	@FindBy(id="regPhone")
	private WebElement phoneNo;
	
	@FindBy(id="accountType")
	private WebElement accountType;
	
	@FindBy(id="regEmail")
	private WebElement email;
	
	@FindBy(id="regTermsCheck")
	private WebElement termsCheck;
	
	@FindBy(id="registerSubmitBtn")
	private WebElement createBankingAccount;
	
	@FindBy(id="loginAlertBox")
	private WebElement errorMessage;
	
		
	public LoginPage() {
		this.driver = DriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}	
	

	public void loginToApex(String username, String password) {		
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		login.click();
		DashboardPage dashboard = new DashboardPage();
		dashboard.verifyLoginSuccessfull();
	}
	
	public void registerToApex(String fullName, String regUsername, String phoneNo, String accountType, String password,String email ) {
		
		this.fullName.sendKeys(fullName);
		this.regUsername.sendKeys(regUsername);
		this.password.sendKeys(password);
		this.phoneNo.sendKeys(phoneNo);
		this.email.sendKeys(email);
		termsCheck.click();
		Utilities.selectByVisibleText(this.accountType, accountType);
		createBankingAccount.click();
		
	
	}
	
	public WebElement getUsername() {
		
		return this.username;
	}
	
	public WebElement getPassword() {
		
		return this.password;
	}
	
	public WebElement getLoginBtn() {
		
		return this.login;
	}
	
	public void verifyErrorMessage() {
		
		Utilities.waitForVisibilityOfElement(driver, 2, errorMessage);
		Assert.assertTrue(errorMessage.getText().equals("Invalid username or password. Please try again."), "Invalid username or password, please try again");
		ExtentReportManager.getTest().pass("Invalid username or password error message is thrown");
	}
}
	

