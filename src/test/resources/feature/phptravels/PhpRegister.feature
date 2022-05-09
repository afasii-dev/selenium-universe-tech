@Registration
Feature: Register page

  Background: User opened registration page
    Given user goes to REGISTER_PAGE

  Scenario Outline: User registration positive case
    When user enters the following data
      | firstName  | lastName  | phone    | email        | password   |
      | Ibrohimjon | Abdulloev | 12345670 | ib@gmail.com | 1234567890 |
    Then signup is <status>
    Examples:
      | status  |
      | SUCCESS |

  Scenario: User registration negative case
    When user enters the following data
      | firstName  | lastName  | phone    | email | password   |
      | Ibrohimjon | Abdulloev | 12345670 |       | 1234567890 |
    Then signup is FAILED



