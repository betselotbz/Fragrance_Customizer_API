Feature: Rest API functionalities
  Scenario: User is able to add and remove a perfume from the cart
    Given a list of perfume are available in shopping list
    When the user adds perfume to their cart
    Then the perfume is added to the user's cart
    When the user removes perfumefrom their cart
    Then the perfume is removed from the user's cart

  Scenario: User is able to add and remove a custom fragrance from the cart
    Given a list of ingredients are available in shopping list
    When the user adds ingredients to their cart
    Then the ingredient is added to the user's cart
    When the user removes ingredient from their cart
    Then the ingredient is removed from the user's cart