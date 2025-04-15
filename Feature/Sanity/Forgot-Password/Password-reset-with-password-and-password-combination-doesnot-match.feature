@sanityTest
Feature: Forgot Password

  @qaseId=94
  Scenario: Reset password between password & password combination doesn't match
    Given open hint website
    And check reset password link is expired or not
    And user open forgot password page
    And user input registered email to forgot password
    And user click send email forgot password
    Then user successfully forgot password
    And user open reset password link
    And user input password and confirm password which doesnot match
    And user click submit password button
    Then see error message 'The Confirm New Password field does not match the New Password field.' on reset password field
