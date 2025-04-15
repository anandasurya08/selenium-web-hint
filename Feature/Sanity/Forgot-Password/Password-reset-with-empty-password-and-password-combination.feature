@sanityTest
Feature: Forgot Password

  @qaseId=93
  Scenario: Reset password with empty field (password & password confirm)
    Given open hint website
    And check reset password link is expired or not
    And user open forgot password page
    And user input registered email to forgot password
    And user click send email forgot password
    Then user successfully forgot password
    And user open reset password link
    And user click submit password button
    Then see error message 'Required field.' on reset password field
