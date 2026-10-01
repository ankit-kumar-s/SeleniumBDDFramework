@cart
Feature: SauceDemo Cart

  @regression
  Scenario Outline: Verify product in cart
    Given user is on the SauceDemo login page for test case "<testCaseId>"
    When user logs in
    And user adds product to cart
    And user opens the cart
    Then user should see product in the cart

    Examples:
      | testCaseId |
      | TC001      |