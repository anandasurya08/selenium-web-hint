@sanityTest
Feature: Engrave

  @qaseId=30
  Scenario: Order product then engrave from bag
    Given open hint website
    And user close popup banner
    And user already logged in
    Then open product single detail
    And add to bag
    And user engrave product on bag
    And go to checkout shipping page
    And user change into IDR currency
    And go to checkout delivery and payment page
    And choose Virtual Account BCA as payment method
    And go to checkout summary page
    And go to confirmed page
    Then verify showing order ID information
    Then verify showing added engrave letter