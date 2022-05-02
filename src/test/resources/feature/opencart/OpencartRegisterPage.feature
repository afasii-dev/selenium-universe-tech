@OpencartRegistration
Feature: Opencart Register page

  Background: User opened registration page
    Given REGISTER_PAGE is opened

  Scenario: User registration

    When user entered the default data
    Then success message is displayed