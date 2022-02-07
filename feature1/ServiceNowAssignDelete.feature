Feature: ServiceNow Application TestCase Scenarios_Delete

Background:
#Launch the browser
#Enter the URL
Given Enter username as 'admin'
And Enter password as 'Ishu1990'
Then Click Login

Scenario Outline: TC_02 Update Incident_Positive
When Search for 'incident' in filter navigator
Then Select Open in filter navigator
When Enter the "<incidentno>" in search
Then Click on the incident number
Then Click the Delete Button
Then Click on the Pop-up Alert
Then Verify the "<incidentno>" is deleted


Examples:
|incidentno|
|INC0010033|