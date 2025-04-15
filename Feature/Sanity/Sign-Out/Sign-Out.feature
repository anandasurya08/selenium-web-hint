@sanityTest
Feature: Sign Out

  @qaseId=43
  Scenario: Sign Out
    Given open hint website
    And user close popup banner
    And user already logged in
    And user click Sign Out
    And appear white icon profile as the user has signed out