@sanityTest
Feature: Register

  @qaseId=1
  Scenario: Register account
    Given open hint website
    And user close popup banner
    Then open register page
    And input first name
    And input last name
    And input new email
    And input new password
    And input new password confirmation
    And input new birth date
    And user click checkbox terms and conditions
    And click register button
    Then see label congratulations registration is success
