@sanityTest
Feature: Track Order

  @qaseId=283
  Scenario: Track order with empty value of all fields
    Given open hint website
    And user close popup banner
    And user open track order page
    And user click submit to track order
    Then appear error message 'Required fields.' on order ID and email field