@sanityTest
Feature: Sign In

  @qaseId=18
  Scenario: Sign in with unregistered account
    Given open hint website
    And user close popup banner
    Then open login page
    And user input unregistered email
    And user input password
    And user click login button
    Then user see error message email not registered