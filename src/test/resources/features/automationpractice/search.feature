Feature: Search
  As a registered user
  I want to search for clothes
  So that I can find products to buy

  Scenario Outline: search for clothes
    Given I am authenticated
    And the current stock levels are
      | <item> |   <count>   |
    When I search for <item>
    Then the result count for <item> is the same as the stock count for that item

    Examples:
      | item   | count |
      | blouse |   1   |
      | dress  |   7   |
