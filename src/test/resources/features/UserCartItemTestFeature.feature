Feature: Rest API functionalities
  Scenario: User is able to add and remove item from the cart
    Given a list of items are available in shopping list
    When the user adds item to their cart
    Then the item is added to the user's cart
    When the user removes item from their cart
    Then the item is removed from the user's cart

#  Scenario: User is able to add and remove a custom fragrance from the cart
#    Given a list of ingredients are available in shopping list
#    When the user adds ingredients to their cart
#    Then the ingredient is added to the user's cart
#    When the user removes ingredient from their cart
#    Then the ingredient is removed from the user's cart