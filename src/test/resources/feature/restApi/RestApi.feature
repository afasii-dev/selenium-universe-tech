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
      | username | password |
      | Rustam   | 12345687 |
    Then new user successfully added and saved

  Scenario Outline: Save new user - negative
    When save new user endpoint is called
      | username   | password   |
      | <username> | <password> |
    Then response contains <errorMessage>
    Examples:
      | username | password | errorMessage          |
      |          | 12345687 | INTERNAL_SERVER_ERROR |
      | Rustam   |          | INTERNAL_SERVER_ERROR |

  Scenario: Update user positive case
    When Updating user
      | username  | password | id |
      | Ibrohim22 | pass11   | 4  |
    Then user successfully updated

  Scenario: Delete user by ID - positive
    When delete user by id endpoint is called
      | 2 |
    Then validate user is deleted



