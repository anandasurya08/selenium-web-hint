@sanityTest
Feature: Currency

  @qaseId=66
  Scenario: Order with USD currency
    Given open hint website
    And user close popup banner
    And user already logged in
    Then open product single detail
    And add to bag
    And go to checkout shipping page
    And user change into USD currency
    And go to checkout delivery and payment page
    And go to checkout summary page
    And go to confirmed page
    And user close snap midtrans
    And user close popup banner
    Then verify showing USD currency information