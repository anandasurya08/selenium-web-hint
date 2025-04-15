@sanityTest
Feature: Delivery

  @qaseId=34
  Scenario: Order product via delivery JNE
    Given open hint website
    And user close popup banner
    And user already logged in
    Then open product single detail
    And add to bag
    And go to checkout shipping page
    And user change into IDR currency
    And go to checkout delivery and payment page
    And choose JNE as delivery courier
    And choose Virtual Account BCA as payment method
    And go to checkout summary page
    And go to confirmed page
    Then verify showing order ID information
    Then verify showing JNE as delivery courier information