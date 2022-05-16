Feature: Choose Flight

  Background: User opened Flights Page
    Given user open FLIGHT_PAGE

      Scenario: User chose flight positive case
        When user added destination
        And user chose round trip and dates
#        Then user chose 2 passengers and pressed search button
