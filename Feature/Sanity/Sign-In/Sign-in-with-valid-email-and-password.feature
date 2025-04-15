@sanityTest
Feature: Sign In

  @qaseId=13
  Scenario: Sign in with valid email and password
    Given open hint website
    And user close popup banner
    Then open login page
    And user input email
    And user input password
    And user click login button
    Then user has been logged in