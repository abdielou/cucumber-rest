#   MIT License
#   Date: 6/19/13
#   Time: 5:14 PM
#   Author: abdiel

Feature: Get them Monkeys
  As a restful client
  I want to get monkeys
  So that I can look at them chimp

  Scenario: get all monkeys
    Given I access the url "/monkeys"
    When I retrieve the results
    Then the status code should be 200
    Then there should be more than 1 monkeys

  Scenario: get monkey number 1
    Given I access the url "/monkeys"
    And I provide parameter "id" as "1"
    When I retrieve the results
    Then the status code should be 200
    And it should have the field "action" containing the value "chimp"
    And it should have the field "name"

  Scenario Outline: find a monkey
    Given I access the url "/monkeys"
    And I provide parameter "id" as <search_id>
    When I retrieve the results
    Then the status code should be 200
    And it should have the field "id" containing the value <monkey_id>

    Examples:
      | search_id |  monkey_id |
      | "1"       |  "1"       |
      | "2"       |  "2"       |

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
