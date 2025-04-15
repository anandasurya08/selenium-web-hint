@sanityTest
Feature: Free Shipping

  @qaseId=49
  Scenario: Order when total more than minimum free shipping
    Given open hint website
    And user close popup banner
    And user already logged in
    Then open product for free shipping
    And user set qty product into two
    And add to bag
    And go to checkout shipping page
    And user change into IDR currency
    And go to checkout delivery and payment page
    And verify showing free shipping information on delivery method
    And choose Virtual Account BCA as payment method
    And go to checkout summary page
    And go to confirmed page
    Then verify showing shipping disc information