@API_E2E
Feature: This feature includes creating a resource, updating the resource and validating the resource

  Background: Running Post method in background to get the id
  Scenario: Validate Add Resource API
    Given When user hits Reqres API with payload "Sam" and "Leader"
    When user hits "POST" for "AddResource"
    Then Validate user is getting status code as 201
    And Validate values in response

  Scenario: Validate Put Resource API
    Given When user hits Reqres API with payload "Tony" and "QA"
    When user hits "PUT" for "GetorPutorDeleteResource"
    Then Validate user is getting status code as 200

  Scenario: Validate Get Resource API
    When user hits "GET" for "GetorPutorDeleteResource"
    Then Validate user is getting status code as 200
