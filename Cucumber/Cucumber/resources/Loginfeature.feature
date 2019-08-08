Feature: Login functionality

  @Login
  Scenario Outline: Login with valid credentials
    Given Navigate to home page
    When user enters "<username>" and "<password>"
    Then user logged in sucessfully

    Examples: 
      | username | password    |
      | Admin    | password456 |
      | lalitha  | password123 |

  @data-driven
  Scenario: user search for item
    When user searches for below products in the search box :
      | Head   |
      | Travel |
      | Laptop |
    Then product should be aded in the cart if available
