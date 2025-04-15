@sanityTest
Feature: Payment

  @qaseId=42
  Scenario: Order via Gopay
    Given open hint website
    And user close popup banner
    And user already logged in
    Then open product single detail
    And add to bag
    And go to checkout shipping page
    And user change into IDR currency
    And go to checkout delivery and payment page
    And choose Gopay as payment method
    And go to checkout summary page
    And go to confirmed page
    And user paid Gopay payment on midtrans page
    Then verify showing Gopay payment information