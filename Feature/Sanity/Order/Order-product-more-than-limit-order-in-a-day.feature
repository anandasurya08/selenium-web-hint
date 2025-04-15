@sanityTest
Feature: Order

  @qaseId=28
  Scenario: Order product more than limit order in a day
    Given open hint website
    And user close popup banner
    And user register and login new account
    Then open product with limit order
    And add to bag
    And go to checkout shipping page
    And user change into IDR currency
    And user input shipping data
    And go to checkout delivery and payment page
    And choose Virtual Account BCA as payment method
    And go to checkout summary page
    And go to confirmed page
    Then verify showing order ID information
    And open product with limit order
    And add to bag
    And go to checkout shipping page
    And go to checkout delivery and payment page
    Then verify showing limit order in a day information
