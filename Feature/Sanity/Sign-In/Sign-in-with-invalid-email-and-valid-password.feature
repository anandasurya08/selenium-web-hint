@sanityTest
Feature: Sign In

  @qaseId=16
  Scenario: Sign in with invalid email and valid password
    Given open hint website
    And user close popup banner
    Then open login page
    And user input invalid email
    And user input password
    And user click login button
    Then user see error message invalid email