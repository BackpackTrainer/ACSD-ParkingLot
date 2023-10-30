Feature:

  Scenario:  Long Term Lot
    Given I am staying in the "Long Term" parking lot
    When I enter on "2023-10-26 01:30"
    And I exit on "2023-10-26 02:30"
    Then my fee is 2


