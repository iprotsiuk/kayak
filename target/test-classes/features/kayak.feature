@kayak
Feature: Kayak test

  @steps_for_kayak1
  Scenario: search flight on Kayak with data#1
    Given I navigate to kayak
    Then I enter origin city as "SFO"
    And I enter destination city as "LAX"
    Then I enter departure date as "09/01/2019"
    And I enter return date as "09/14/2019"
    When I click submit
    Then I close the ads
    Then I compare destinations

  Scenario: search flight on Kayak with data#2
    Given I navigate to kayak
    Then I enter origin city as "LAX"
    And I enter destination city as "AMD"
    Then I enter departure date as "09/01/2019"
    And I enter return date as "09/14/2019"
    When I click submit
    Then I close the ads
    Then I compare destinations

  @steps_for_kayak1
  Scenario: search flight on Kayak with data#3
    Given I navigate to kayak
    Then I enter origin city as "AMD"
    And I enter destination city as "SFO"
    Then I enter departure date as "09/01/2019"
    And I enter return date as "09/14/2019"
    When I click submit
    Then I close the ads
    Then I compare destinations

