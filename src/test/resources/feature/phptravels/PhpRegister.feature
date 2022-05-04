@Registration
Feature: Register page

  Background: User opened registration page
    Given user goes to REGISTER_PAGE

  Scenario: User registration
    When user enters the default data
    Then signup is successfully

