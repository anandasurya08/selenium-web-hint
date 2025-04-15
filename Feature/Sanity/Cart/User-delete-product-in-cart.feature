Feature: Cart

  @qaseId=290
  Scenario: User delete product in cart
    Given open hint website
    And user close popup banner
    And user already logged in
    And open product single detail
    And add to bag
    When open cart sidebar
    Then delete product in cart