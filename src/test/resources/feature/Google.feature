Feature: Google

  Background:
    Given Init driver
    When user opened google.com

  Scenario Outline: First scenario
    When user entered <value> in the search field
    And user pressed <button> button
    Then user has been redirected to another page
    And Close browser
    Examples:
      | value         | button |
      | Hello world   | ENTER  |
      | Bye-bye world | ENTER  |




