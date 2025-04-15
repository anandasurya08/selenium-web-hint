@sanityTest
Feature: Shipping Code

  @qaseId=57
  Scenario: Apply shipping code without minimum purchase
    Given open hint website
    And user close popup banner
    And user already logged in
    Then open product single variant detail
    And add to bag
    And go to checkout shipping page
    And user change into IDR currency
    And go to checkout delivery and payment page
    And user input shipping code without minimum purchase
    And choose Virtual Account BCA as payment method
    And go to checkout summary page
    And go to confirmed page
    Then verify showing discount information