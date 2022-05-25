@RESTAPI
Feature: Rest Api

#  Scenario Saving  new user negative case
#  When user added invalid <Username> and <Password> at open window
#  And user pressed ENTER button
#  Then App shown error message "400 Bad Request"

  Scenario: Update user positive case
    Given save new user endpoint is called
      | username | password |
      | Rustam   | 12345687 |
    Then new user successfully added and saved
    When Updating user
      | username  | password | id |
      | Ibrohim22 | pass11   | 4  |
  Then user successfully updated
#  Examples:
#  |usernam| passwor|
#  |Ibrohim  | 12345|
#  |Ivan    | Qwewrr|

#  Scenario Outline Update user negative case
#  When user opened users profile
#  And chose username and update <username> by numbers
#  Then App shown error message "400 Bad Request"
#  |username| password|
#  |Rustam  | 12345687|
#  |1234546 | 12345687|