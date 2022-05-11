@OpencartChangePassword
Feature: Opencart Change Password

  Background: User opened Change Password page
    Given Log in account page is displayed
    Then My account page is displayed

  Scenario: User Change Password
    When user clicked password
    Then Change Password page is displayed
    When user entered the default data password
    Then success! Password is changed