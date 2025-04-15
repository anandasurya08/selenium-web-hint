Feature: Cart

  @qaseId=289
  Scenario: Verify button subtract qty in cart
    Given open hint website
    And user close popup banner
    And user already logged in
    And open product single detail
    And add to bag
    When open cart sidebar
    And add quantity in cart
    Then subtract quantity in cart