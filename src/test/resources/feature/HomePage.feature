@HomePage @Main
Feature: Google Home Page

#  Hooks @BeforeAll -> Driver init
#  BeforeEach -> order: 1, 2
  Background:
    When user opened google.com

  Scenario Outline: First scenario
    When user entered <value> in the search field
    And user pressed <button> button
    Then user has been redirected to another page
    Examples:
      | value         | button |
      | Hello world   | ENTER  |
      | Bye-bye world | ENTER  |

    #  Hooks @AfterAll