@sanityTest
Feature: Engrave

  @qaseId=32
  Scenario: Order product then engrave when all fields empty
    Given open hint website
    And user close popup banner
    And user already logged in
    Then open product single detail
    And user engrave product but with empty field
    And go to checkout shipping page
    And user change into IDR currency
    And go to checkout delivery and payment page
    And choose Virtual Account BCA as payment method
    And go to checkout summary page
    And go to confirmed page
    Then verify showing order ID information
    Then verify showing no any engrave letter appear