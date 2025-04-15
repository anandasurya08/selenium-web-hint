@sanityTest
Feature: Track Order

  @qaseId=191
  Scenario: Track order with valid order id and invalid email
    Given open hint website
    And user close popup banner
    And user open track order page
    And user input valid order ID to be tracked
    And user input invalid email to be tracked
    Then user click submit to track order
    And appear error message 'Invalid order ID or email'