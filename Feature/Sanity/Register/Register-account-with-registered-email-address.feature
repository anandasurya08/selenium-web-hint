@sanityTest
Feature: Register

  @qaseId=90
  Scenario: Register account with registered email address
    Given open hint website
    And user close popup banner
    Then open register page
    And input registered email
    And user click checkbox terms and conditions
    And click register button
    And user see error message registered email on email field