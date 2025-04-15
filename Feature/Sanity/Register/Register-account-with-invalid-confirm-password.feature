@sanityTest
Feature: Register

  @qaseId=12
  Scenario: Register account with invalid confirm password
    Given open hint website
    And user close popup banner
    Then open register page
    And input new password
    And input new password confirmation doesn't match
    And user click checkbox terms and conditions
    And click register button
    And user see error message doesn't match on password confirmation field
