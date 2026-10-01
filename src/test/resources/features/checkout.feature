@checkout
Feature: SauceDemo Checkout

  @regression
  Scenario Outline: Complete checkout

    Given user is on the SauceDemo login page for test case "<testCaseId>"
    When user logs in
    And user adds product to cart
    And user opens the cart
    Then user should see product in the cart
    And user proceeds to checkout
    And user enters customer details
    And user continues to order overview
    Then user should see the order summary
    When user finishes the order
    Then user should see the order confirmation
    And user logs out

    Examples:
      | testCaseId |
      | TC001      |