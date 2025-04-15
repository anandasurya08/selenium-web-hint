@sanityTest
Feature: Shipping Code

  @qaseId=71
  Scenario: Apply shipping code with product purchase
    Given open hint website
    And user close popup banner
    And user already logged in
    Then open promotion product detail
    And add to bag
    And go to checkout shipping page
    And user change into IDR currency
    And go to checkout delivery and payment page
    And user input shipping code with product purchase
    And choose Virtual Account BCA as payment method
    And go to checkout summary page
    And go to confirmed page
    Then verify showing discount information