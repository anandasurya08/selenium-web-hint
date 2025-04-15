@sprint2424 @sanityTest
Feature: Shipping

  @qaseId=253
  Scenario: Show default address as selected address when checkout
    Given open hint website
    And user close popup banner
    And user already logged in
    Then open product single detail
    And add to bag
    And go to checkout shipping page
    And verify selected address on checkout was default address
    And go to checkout delivery and payment page
    And choose Virtual Account BCA as payment method
    And go to checkout summary page
    And go to confirmed page
    Then verify showing order ID information






