@sanityTest
Feature: Sign In

  @qaseId=17
  Scenario: Sign in with valid email and invalid password
    Given open hint website
    And user close popup banner
    Then open login page
    And user input email
    And user input invalid password
    And user click login button
    Then user see error message invalid password