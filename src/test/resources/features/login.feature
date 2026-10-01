@login
Feature: SauceDemo Login

  @smoke
  Scenario Outline: Login with valid credentials

    Given user is on the SauceDemo login page
    When user logs in with "<username>" and "<password>"
    Then user should see the products page

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |




