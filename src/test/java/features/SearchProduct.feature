Feature: Search and Verify the product Name

  @searchProduct
  Scenario Outline: Search Experience for product name and validate the result

    Given User is on Amazon Landing page
    When user searched with <Name> in search bar
    Then user validate the first result contains name as <Result>

    Examples:
      | Name   | Result       |
      | iphone | Apple iPhone |
