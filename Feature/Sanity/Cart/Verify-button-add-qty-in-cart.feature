Feature: Cart

  @qaseId=288
  Scenario: Verify button add qty in cart
    Given open hint website
    And user close popup banner
    And user already logged in
    And open product single detail
    And add to bag
    When open cart sidebar
    Then add quantity in cart
