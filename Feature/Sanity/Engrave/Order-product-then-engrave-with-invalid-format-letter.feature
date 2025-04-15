@sanityTest
Feature: Engrave

  @qaseId=33
  Scenario: Order product then engrave with invalid letter
    Given open hint website
    And user close popup banner
    And user already logged in
    Then open product single detail
    And user engrave product but with invalid letter
    Then verify showing error message engrave letter may contain alphabet and number