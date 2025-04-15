@sanityTest
Feature: Register

  @qaseId=11
  Scenario: Register account with temporary email address
    Given open hint website
    And user close popup banner
    Then open register page
    And input temporary email
    And user click checkbox terms and conditions
    And click register button
    And user see error message invalid email on email field