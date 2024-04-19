Feature: Delete products using delete API

  Scenario Outline: Validate Delete product API status code works correctly
    Given I hit the URL of delete product API endpoint
    When I pass the delete URL of the products in request with <ProductNumber>
    Then I receive the response code as 200
    Examples:
      |ProductNumber  |
      | 8      |

  Scenario Outline: Validate Delete product API status code works correctly with characters
    Given I hit the URL of delete product API endpoint
    When I pass the delete URL of the products with characters in request with <ProductId>
    Then I receive the response code
    Examples:
      |ProductId  |
      | -      |