@sanityTest
Feature: Track Order

  @qaseId=190
  Scenario: Track order with valid order id and valid email
    Given open hint website
    And user close popup banner
    And user open track order page
    And user input valid order ID to be tracked
    And user input valid email to be tracked
    Then user click submit to track order
    And verify redirected to track order page with appear status of certain order ID