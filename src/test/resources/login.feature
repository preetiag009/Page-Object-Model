Feature: Login Functionality

@test1
Scenario: Login error message
Given Application is up and running
When User on "loginpage"
When Enter username
Then Error message should be displayed

@test2
Scenario: Login To Salesforce
Given Application is up and running
When User on "loginpage"
When Enter valid username
And Enter valid password
And Click on Login button
When User on "homepage"
Then Home page should be displayed

@test2
Scenario: Check Remember me
Given Application is up and running
When User on "loginpage"
When Enter valid username
And Enter valid password
And Check remember me
And Click on Login button
When User on "homepage"
And Click on usermenu dropdown and logout button
When User on "loginpage"
Then Username should be displayed

@test2
Scenario: Forgot Password A
Given Application is up and running
When User on "loginpage"
When Click on Forgot Password
When User on "forgotpasswordpage"
And Provide username in username field and click continue
When User on "checkyouremailpage"
Then Password reset message is displayed

@test2
Scenario: Forgot Password B
Given Application is up and running
When User on "loginpage"
When Enter invalid username and password 
And Click on Login button
Then Login error message should be displayed

