Feature: Rest Api
Scenario: Get user by ID positive case

Given User opened webpage http://localhost:8080/v1/users/
When user added "1" after /
Then ID with user shown on page

Scenario: Get user by ID negative case
When user added "10" after /
Then App shown error message "500Internal Server Error"

Scenario Outline Saving  new user positive case
When user add <Username> and <Password> at open window
And user pressed ENTER button
Then new user successfully added and saved
Examples:
|username| password|
|Rustam  | 12345687|

Scenario Saving  new user negative case
When user added invalid <Username> and <Password> at open window
And user pressed ENTER button
Then App shown error message "400 Bad Request"

Scenario Outline Update user positive case
When user opened users profiles
And chose username and update <username> and <password>
Then user successfully updated
Examples:
|username| password|
|Rustam  | 12345687|
|Ivan    | Qwewrrwew123|

Scenario Outline Update user negative case
When user opened users profile
And chose username and update <username> by numbers
Then App shown error message "400 Bad Request"
|username| password|
|Rustam  | 12345687|
|1234546 | 12345687|


