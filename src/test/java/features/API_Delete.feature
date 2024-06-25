@API-Delete
Feature: This feature includes getting list of users and deleting the resource.

Background: Running Get list method in background to get the id
Scenario: Getting id for deletion
When user hits "GET" for "GetList"
Then Validate user is getting status code as 200
And Store first id to delete

Scenario: Validate Delete Resource API
When user hits "DELETE" for "GetorPutorDeleteResource"
Then Validate user is getting status code as 204