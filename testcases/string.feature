Feature: DS STRING TEXT


Scenario Outline: Log into Author
	Given User navigate to Author login page
	And User enters "<username>" and "<password>" in Author login page
	And Verify User has Logged in successfully in Author Url
Examples:
|username|password|
|test_ui_appadmin@appveen.com|Veen@99%win|

#Scenario: Stop Data Service
#Given Stop dataservice "string_Text"

Scenario: Delete data service
	Given Data service "stack_Data" exists
	Then Remove the data service

Scenario: Create data service
	#Given Data service "string_Text" does not exist
	Given Create new data service "stack_Data"
