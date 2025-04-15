@sanityTest
Feature: Shipping Code

  @qaseId=74
  Scenario: Apply shipping code when user get free shipping
    Given open hint website
    And user close popup banner
    And user already logged in
    Then open product bundle variant detail
    And user set qty product into two
    And add to bag
    And go to checkout shipping page
    And user change into IDR currency
    And go to checkout delivery and payment page
    And user input shipping code when user already got free shipping
    And user can't apply free shipping from code because already qualified for free shipping
    And choose Virtual Account BCA as payment method
    And go to checkout summary page
    And go to confirmed page
    And go to confirmed page
    Then verify showing shipping disc information