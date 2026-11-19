Feature: Bill Payment functionality

Background: 
	Given the user is on the login Page
	When the user enters "john.doe" and "password123"
	And  the user clicks login button
	Then the user should be logged in successfully

Scenario Outline: Verify Bill is paid successfully
	 Given user is on the Bill payment page
	 When user fills "<Pay from Account>" as the funding account
	 And selects "<Biller Category>" and "<Service Provider>"                                                                                                                                                                                                                                                                                                      
	 And enters the Account ID "<Account ID number>" and payment amount "<Payment Amount>"
	 And clicks Authorize instant bill payment button
	 Then the payment should be successful
	 And the payment should be updated in payment history "<Pay from Account>""<Biller Category>""<Service Provider>""<Payment Amount>""<Status>"
	 And the account balance should be updated in Dashboard page by deducting the "<Payment Amount>" amount
Examples:
	 | Pay from Account      | Biller Category     | Service Provider        | Account ID number | Payment Amount| Status |
	 |APEX-1001-SAV (SAVINGS)| Electricity & Power | ConEd Power Corporation | 123               | 100           | PAID   |

