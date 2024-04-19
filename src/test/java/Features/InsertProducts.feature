Feature: Insert products using post API

  Scenario Outline: Validate post API product works correctly
    Given I hit the URL of post product API endpoint
    When I pass the URL of the products in request
    And I pass the request body of the product title <ProductTitle>
    Then I receive the response code as 200
    Examples:
      |ProductTitle  |
      | Watches      |

  Scenario Outline: Validate post API product response body works correctly
    Given I hit the URL of post product API endpoint
    When I pass the URL of the products in request
    And I pass the request body of the product title <ProductTitle>
    Then I receive the response body with id  as <id>
    Examples:
      |ProductTitle  | id |
      | Watches      | 21 |

  Scenario Outline: Validate post API product response code if we pass price value as string
    Given I hit the URL of post product API endpoint
    When I pass the URL of the products in request
    And I pass the request body of the product Price value <ProductPrice>
    Then I receive the response status code
    Examples:
      |ProductPrice  |
      | hello      |
