Feature: Add product to Shopping Cart

  As an User, I can add product to shopping cart

  Scenario: Add products to shopping cart
    Given User go to Shrine Gallery
    When User go to "CLOTHING" filter
    And User Add "Walter henley (white)" to the cart
    And User go to "ACCESSORIES" filter
    And User Add "Shrug bag" to the cart
    Then Shopping cart should have a 2 items
    And User clear the shopping cart