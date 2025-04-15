@sanityTest
Feature: Delivery

  @qaseId=86
  Scenario: Order product via delivery J&T
    Given open hint website
    And user close popup banner
    And user already logged in
    Then open product single detail
    And add to bag
    And go to checkout shipping page
    And user change into IDR currency
    And go to checkout delivery and payment page
    And choose JNT as delivery courier
    And choose Virtual Account BCA as payment method
    And go to checkout summary page
    And go to confirmed page
    Then verify showing order ID information
    Then verify showing JNT as delivery courier information