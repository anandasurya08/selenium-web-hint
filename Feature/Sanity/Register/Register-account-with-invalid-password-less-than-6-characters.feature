@sanityTest
Feature: Register

  @qaseId=8
  Scenario: Register account with invalid password, less than 6 characters
    Given open hint website
    And user close popup banner
    Then open register page
    And input new password less than six characters
    And user click checkbox terms and conditions
    And click register button
    And user see error message password at least six characters on password field
