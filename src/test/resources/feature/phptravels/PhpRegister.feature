@Registration
Feature: Register page

  Background: User opened registration page
    Given user goes to REGISTER_PAGE

  Scenario: User registration positive case
    When user enters the DEFAULT data
    Then signup is SUCCESS

  Scenario: User registration negative case
    When user enters the CUSTOM data
    Then signup is FAILED



