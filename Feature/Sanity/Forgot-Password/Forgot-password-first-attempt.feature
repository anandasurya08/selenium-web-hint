@sanityTest
Feature: Forgot Password

  @qaseId=19
  Scenario: Forgot password first attempt
    Given open hint website
    And user close popup banner
    And check reset password link is expired or not
    And user open forgot password page
    And user input registered email to forgot password
    And user click send email forgot password
    Then user successfully forgot password
    And user open reset password link
    And user input new password
    And user input new confirm password
    And user click submit password button
    Then verify showing reset password successfully
