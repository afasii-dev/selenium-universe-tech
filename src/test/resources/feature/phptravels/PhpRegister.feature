@Registration
Feature: Register page

  Background: User opened registration page
    Given user goes to REGISTER_PAGE

  Scenario Outline: User registration positive case
    When user enters the <dataType> data
    Then signup is <status>
    Examples:
      | dataType | status  |
      | DEFAULT  | SUCCESS |
      | CUSTOM   | FAILED  |

#  Scenario: User registration negative case
#    When user enters the CUSTOM data
#    Then signup is FAILED



