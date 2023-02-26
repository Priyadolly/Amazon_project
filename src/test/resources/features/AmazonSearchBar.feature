Feature: Search a Product feature

  Background: User can access the search bar
    Given user is able to access the search bar

  @smoke @meg
  Scenario: Verify that User can able to search  product
    Given The user is navigated to the Amazon website and the search bar is visible.
    When the user enters a product in the search bar and hits the enter key.
    Then The search results page should display all the related products.


  Scenario: Verify that user can able to search with multiple keywords
    Given The user is on the Amazon website.
    When The user enters multiple keywords in the search bar separated by space.
    Then The search results page should display all the relevant products.

  @smoke
  Scenario: Verify that user enters an special characters in search bar
    Given The user is navigated on to the Amazon website and the search bar is visible.
    When The user enters special characters in the search bar.
    Then The search results page should display relevant message indicating characters not found.

  @regression
  Scenario: Verify that user able to search without input
    Given the user is on the Amazon website and search bar is visible.
    When the user DoesNot enter the input and click on search bar.
    Then The Search bar should display all the valid results

  @test
  Scenario Outline: Verify that user is able to search for different products
    Given the user is navigate to the amazon AmazonHome
    When the user enters "<product name>" in the search bar
    Then the search bar should display all the related results "<result>" .
    Examples:
      |  product name      | result |
      |  samsung mobiles   | samsung mobiles |
      |  data cards huawei | data cards huawei    |


