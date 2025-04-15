@sanityTest
Feature: Register

  @qaseId=88
  Scenario: Register account with invalid format email address
    Given open hint website
    And user close popup banner
    Then open register page
    And input invalid format email
    And user click checkbox terms and conditions
    And click register button
    And user see error message invalid email address on email field