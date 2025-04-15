@sanityTest
Feature: Register

  @qaseId=2
  Scenario: Register account when all fields are empty
    Given open hint website
    And user close popup banner
    Then open register page
    And user click checkbox terms and conditions
    And click register button
    And user see error message all register fields are required
