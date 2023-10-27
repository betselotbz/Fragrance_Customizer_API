Feature: Rest API functionalities

  Scenario: User able to get a list of perfumes
    Given A list of perfumes are available in the system
    When The user requests to get a list of perfumes
    Then The system should respond with a list of perfumes
    When The user requests to get songs by perfume ID
    Then The it should return a list of songs by perfume ID
