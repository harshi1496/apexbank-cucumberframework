Feature: Toggle Balance button functionality

Background: 
	Given the user is on the login Page
	When the user enters "john.doe" and "password123"
	And  the user clicks login button
	Then the user should be logged in successfully
	
Scenario: Verify Toggle Balance button functionality
	Given the user is on the Dashboard Page
	Then the account balance should be displayed
	When the user clicks toggle balance button
	Then the account balance should be masked
	When the user clicks toggle balance button
	Then the account balance should be displayed
	
	

