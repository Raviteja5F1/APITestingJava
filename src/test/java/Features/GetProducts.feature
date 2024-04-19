Feature: Get all the products from API

  Scenario: Verify the get api for products
    Given I hit the URL of get products API endpoint
    When I pass the URL of the products in request
    Then I receive the response code as 200


  Scenario Outline: Verify the rate of the first product
    Given I hit the URL of get products API endpoint
    When I pass the URL of the products in request
    Then I verify that the rate of first product is <FirstProductRate>
    Examples:
      | FirstProductRate |
      | 3.9              |

  Scenario Outline: Verify the category of the first product
    Given I hit the URL of get products API endpoint
    When I pass the URL of the products in request
    Then I verify that the category of first product is <category>
    Examples:
      | category |
      | men's clothing  |

  Scenario: Print the titles for products of get api
    Given I hit the URL of get products API endpoint
    When I pass the URL of the products in request
    Then Print the titles of products