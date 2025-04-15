@sanityTest
Feature: Register

  @qaseId=4
  Scenario: Register account with invalid first name, use symbol
    Given open hint website
    And user close popup banner
    Then open register page
    And input first name with symbol
    And user click checkbox terms and conditions
    And click register button
    And user see error message may contain alphabets and space on first name field
