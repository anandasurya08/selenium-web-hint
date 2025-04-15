@sanityTest
Feature: Forgot Password

  @qaseId=92
  Scenario: Direct to link expired page when link is expired
    Given open hint website
    And user close popup banner
    And check reset password link is expired or not
    Then verify showing reset password link is expired
