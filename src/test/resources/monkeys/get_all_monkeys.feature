#   MIT License
#   Author: abdiel

@txn
Feature: Get them Monkeys
  As a restful client
  I want to get monkeys
  So that I can look at them chimp

  Background: There are monkeys
    Given There is a monkey with name "Manuel"
    And There is a monkey with name "Oliver"
    And There is a monkey with name "Ricardo"
    And The monkey named "Manuel" has 2 bananas

  Scenario: get all monkeys
    Given I access the url "/monkeys"
    When I do a get all
    Then the status code should be 200
    Then there should be 3 monkeys

  Scenario: get monkey number 1
    Given I access the url "/monkeys/{id}"
    And I provide parameter "id" as 1
    When I do a get
    Then the status code should be 200
    And it should have the field "action" containing the value "chimp"
    And it should have the field "name"

  Scenario Outline: find a monkey
    Given I access the url "/monkeys/{id}"
    And I provide parameter "id" as <search_id>
    When I do a get
    Then the status code should be 200
    And it should have the field "id" containing the value <monkey_id>

  Examples:
    | search_id | monkey_id |
    | 1         | 1         |
    | 2         | 2         |

  Scenario: delete monkey number 3
    Given I access the url "/monkeys/{id}"
    And I provide parameter "id" as 3
    When I delete the monkey
    Then the status code should be 200

#  Scenario: failing scenario
#    Given I access the url "/narf"
#    When I retrieve the results
#    Then the status code should be 200
#
#  Scenario: pending scenario
#    Given I access the url "/monkeys"
#    And I provide parameter "narf" as "1"
#
#  Scenario: skipped scenario
#    Given I do crazy stuff
