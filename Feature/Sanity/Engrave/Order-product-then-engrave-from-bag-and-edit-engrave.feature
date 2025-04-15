@sanityTest
Feature: Engrave

  @qaseId=31
  Scenario: Order product then engrave from bag and edit engrave
    Given open hint website
    And user close popup banner
    And user already logged in
    Then open product single detail
    And user engrave product on product detail
    And user edit engrave on bag
    And go to checkout shipping page
    And user change into IDR currency
    And go to checkout delivery and payment page
    And choose Virtual Account BCA as payment method
    And go to checkout summary page
    And go to confirmed page
    Then verify showing order ID information
    Then verify showing added engrave letter