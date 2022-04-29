@HomePage @Google
Feature: Google Home Page

#  Hooks @BeforeAll -> Driver init
#  BeforeEach -> order: 1, 2

  Background:
    When user opened HOME_PAGE
    Then user is on HOME_PAGE

  Scenario Outline: First scenario
    When user entered <value> in the search field
    And user pressed <button> button
    Then user is on SEARCH_PAGE
    Examples:
      | value       | button |
      | Hello world | ENTER  |
#      | Bye-bye world | ENTER  |

    #  Hooks @AfterAll