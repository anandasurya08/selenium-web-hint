@sanityTest
Feature: Voucher Code

  @qaseId=69
  Scenario: Apply voucher code with product purchase
    Given open hint website
    And user close popup banner
    And user already logged in
    Then open product single detail
    And add to bag
    And go to checkout shipping page
    And user change into IDR currency
    And go to checkout delivery and payment page
    And user input voucher code with product purchase
    And choose Virtual Account BCA as payment method
    And go to checkout summary page
    And go to confirmed page
    Then verify showing discount information