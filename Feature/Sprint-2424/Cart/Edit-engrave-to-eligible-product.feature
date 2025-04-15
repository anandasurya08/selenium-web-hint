@sprint2424 @sanityTest
Feature: Cart

  @qaseId=107
  Scenario: Edit engrave to eligible product
    Given open hint website
    And user close popup banner
    And user already logged in
    Then open product single detail
    And add to bag
    And user engrave product on bag
    And user edit engrave on bag
    And go to checkout shipping page
    And go to checkout delivery and payment page
    And choose Virtual Account BCA as payment method
    And go to checkout summary page
    And go to confirmed page
    Then verify showing order ID information
    Then verify showing added engrave letter