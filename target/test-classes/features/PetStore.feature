Feature: To perform basic api tests on pet store


  Scenario: To add new pet to store
    Given I have required pet details
    When I add new pet to store
    Then New pet should be added
