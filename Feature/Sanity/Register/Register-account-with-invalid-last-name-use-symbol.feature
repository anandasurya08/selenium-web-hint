@sanityTest
Feature: Register

  @qaseId=7
  Scenario: Register account with invalid last name, use symbol
    Given open hint website
    And user close popup banner
    Then open register page
    And input last name with symbol
    And user click checkbox terms and conditions
    And click register button
    And user see error message may contain alphabets and space on last name field
