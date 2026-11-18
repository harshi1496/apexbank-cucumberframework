Feature: Login functionality

Scenario Outline: Successful Login with valid credentials
	Given the user is on the login Page on "chrome" browser
	When the user enters valid "<Username>" and "<Password>" and clicks login button
	And the user clicks login button
	Then the user should be redirected to dashboard page
Examples:
|Username   | Password     |
|john.doe   | password123  |
