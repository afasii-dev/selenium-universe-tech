@RESTAPI
Feature: Rest Api

  Scenario: Get all users - positive
    When get all users endpoint is called
    Then all users are displayed

  Scenario: Get user by ID - positive
    When get user by id endpoint is called
      | 1 |
    Then validate user is found

  Scenario: Get user by ID - negative
    When get user by id endpoint is called
      | 100 |
    Then validate the following error message is displayed
      | Internal Server Error |

  Scenario: Save new user - positive
    When save new user endpoint is called
      | username | Rustam   |
      | password | 12345687 |
#    Then new user successfully added and saved


#Scenario Saving  new user negative case
#When user added invalid <Username> and <Password> at open window
#And user pressed ENTER button
#Then App shown error message "400 Bad Request"
#
#Scenario Outline Update user positive case
#When user opened users profiles
#And chose username and update <username> and <password>
#Then user successfully updated
#Examples:
#|username| password|
#|Rustam  | 12345687|
#|Ivan    | Qwewrrwew123|
#
#Scenario Outline Update user negative case
#When user opened users profile
#And chose username and update <username> by numbers
#Then App shown error message "400 Bad Request"
#|username| password|
#|Rustam  | 12345687|
#|1234546 | 12345687|


