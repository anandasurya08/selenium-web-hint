@sanityTest
Feature: Sign In

  @qaseId=14
  Scenario: Sign in when all fields are empty
    Given open hint website
    And user close popup banner
    Then open login page
    And user click login button
    Then user see error message all login fields are required