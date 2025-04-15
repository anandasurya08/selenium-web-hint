@sanityTest
Feature: Register

  @qaseId=89
  Scenario: Register account with invalid password, not combination alphabet and number
    Given open hint website
    And user close popup banner
    Then open register page
    And input new password which not combine alphabet and number
    And user click checkbox terms and conditions
    And click register button
    And user see error message must have one character and one number on password field