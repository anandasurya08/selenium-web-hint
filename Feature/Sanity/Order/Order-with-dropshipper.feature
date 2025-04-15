@sanityTest
Feature: Order

  @qaseId=37
  Scenario: Order with dropshipper
    Given open hint website
    And user close popup banner
    And user already logged in
    Then open product single detail
    And add to bag
    And go to checkout shipping page
    And user change into IDR currency
    And user input dropshipper data
    And go to checkout delivery and payment page
    And choose Virtual Account BCA as payment method
    And go to checkout summary page
    And go to confirmed page
    Then verify showing order ID information