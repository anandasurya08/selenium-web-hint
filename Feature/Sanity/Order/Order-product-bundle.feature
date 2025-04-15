@sanityTest
Feature: Order

  @qaseId=25
  Scenario: Order product bundle
    Given open hint website
    And user close popup banner
    And user already logged in
    Then open product bundle detail
    And add to bag
    And go to checkout shipping page
    And user change into IDR currency
    And go to checkout delivery and payment page
    And choose Virtual Account BCA as payment method
    And go to checkout summary page
    And go to confirmed page
    Then verify showing order ID information