Feature: Login functionality

Scenario Outline: Verify login with valid credentials
	Given the user is on the login Page
	When the user enters "<Username>" and "<Password>" 
	And  the user clicks login button
	Then the user should be logged in successfully
Examples:
|Username   | Password     |
|john.doe   | password123  |

Scenario Outline: Verify login failure with invalid Username
	Given the user is on the login Page
	When the user enters "<Username>" and "<Password>"
	And  the user clicks login button
	Then An error message should be displayed on login page
Examples:
|Username   | Password     |
|harshi     | password123  |

Scenario Outline: Verify login failure with invalid Password
	Given the user is on the login Page
	When the user enters "<Username>" and "<Password>"
	And  the user clicks login button
	Then An error message should be displayed on login page
Examples:
|Username   | Password     |
|john.doe   | password     |
