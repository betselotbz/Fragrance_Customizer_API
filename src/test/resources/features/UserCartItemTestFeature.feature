Feature: Rest API functionalities
  Scenario: User is able to add and remove item from the cart
    Given a shopping cart is empty
    When the user adds item to their cart
    Then the item is created to the user's cart
    When the user removes item from their cart
    Then the item is removed from the user's cart

