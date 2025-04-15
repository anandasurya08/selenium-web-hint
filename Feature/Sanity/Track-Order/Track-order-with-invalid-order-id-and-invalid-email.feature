@sanityTest
Feature: Track Order

  @qaseId=193
  Scenario: Track order with invalid order id and invalid email
    Given open hint website
    And user close popup banner
    And user open track order page
    And user input invalid order ID to be tracked
    And user input invalid email to be tracked
    Then user click submit to track order
    And appear error message 'Invalid order ID or email'