Feature: Rest API functionalities
  Scenario: User is able to add and remove a perfume from the cart
    Given a user with ID 123 exists
    And a perfume with ID 456 is available
    And the user has an empty cart
    When the user adds perfume with ID 456 to their cart
    Then the perfume with ID 456 is added to the user's cart
    When the user removes perfume with ID 456 from their cart
    Then the perfume with ID 456 is removed from the user's cart

  Scenario: User is able to add and remove a custom fragrance from the cart
    Given a user with ID 123 exists
    And a custom fragrance with ID 789 is available
    And the user has an empty cart
    When the user adds custom fragrance with ID 789 to their cart
    Then the custom fragrance with ID 789 is added to the user's cart
    When the user removes custom fragrance with ID 789 from their cart
    Then the custom fragrance with ID 789 is removed from the user's cart