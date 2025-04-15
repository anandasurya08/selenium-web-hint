@sprint2424 @sanityTest
Feature: Cart

  @qaseId=108
  Scenario: Not eligible to add and edit engrave when product not eligible to engrave
    Given open hint website
    And user close popup banner
    And user already logged in
    Then open product bundle detail
    And verify Engrave button is not exists
    And add to bag
    And go to checkout shipping page
    And go to checkout delivery and payment page
    And choose Virtual Account BCA as payment method
    And go to checkout summary page
    And go to confirmed page
    Then verify showing order ID information
    Then verify showing no any engrave letter appear