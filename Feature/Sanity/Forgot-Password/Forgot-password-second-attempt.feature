@sanityTest
Feature: Forgot Password

  @qaseId=20
  Scenario: Forgot password second attempt
    Given open hint website
    And user open reset password link
    Then verify showing reset password link is expired
