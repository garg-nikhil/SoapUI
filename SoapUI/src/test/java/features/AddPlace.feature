#Author: nikhilgarg855@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


@tag
Feature: Add place API testing validation
  

  @tag1
  Scenario: Add place
    Given Add place payload
    When User calls "AddPlaceAPI" with "POST" request
    Then API returns success code "200"
    And "status" in response is "OK"
    And "scope" in response is "APP"
    

  