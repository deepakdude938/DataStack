Feature: Login Page Feature

Scenario: Login page title
Given Launch browser "chrome"
When user enters url "https://bifrost.ds.appveen.com/author"
Then page title should be "data.stack:Author"



Scenario: Login with correct credintials
Given user is on login page
When user enters username "deepak@appveen.com"
And user clicks on Next button
And user enters password "123123123"
And user clicks on Login button
Then user gets title of the home page
And page title should be "data.stack:Author"