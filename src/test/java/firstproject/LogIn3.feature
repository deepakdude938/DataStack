Feature: Login Page Feature

Scenario Outline: Log into Author
	Given User navigate to Author login page
	And User enters "<username>" and "<password>" in Author login page
	And Verify User has Logged in successfully in Author Url
Examples:
|username|password|
|test_ui_appadmin@appveen.com | Veen@99%win |
Scenario: Delete data service
	Given User search data  service "string"
	And User get data service then delete it and create it
	And User not get data service then create it

Scenario Outline: Assign to Appcenter Group
 	Then Group "Practice-Group" does not exist
	Then Create new group "Practice-Group" 
	Then Group "Practice-Group" does exist
	Then Delet group "Practice-Group" then create
	And Assign appcenter permissions for "string" dataservice to "<user>"
Examples:
|user|
|test_ui_ac_ds_manage@appveen.com |
