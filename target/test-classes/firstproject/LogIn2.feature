Feature: Login Page Feature

Scenario Outline: Log into Author
	Given User navigate to Author login page
	And User enters "<username>" and "<password>" in Author login page
	And Verify User has Logged in successfully in Author Url
Examples:
|username|password|
|test_ui_appadmin@appveen.com | Veen@99%win |
Scenario: Delete data service
	Given User search data  service "string_TextT"
	And User get data service "" then delete it  else create it

