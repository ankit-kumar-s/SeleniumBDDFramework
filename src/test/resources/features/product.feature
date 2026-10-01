@product
Feature: SauceDemo Product

  @regression
  Scenario Outline: Add product to cart
    Given user is on the SauceDemo login page for test case "<testCaseId>"
    When user logs in
    Then user should see the products page
    And user adds product to cart

    Examples:
      | testCaseId |
      | TC001      |