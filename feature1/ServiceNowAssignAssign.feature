Feature: ServiceNow Application TestCase Scenarios_Assign

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
Then Assign the incident to Software group
Then Update the incident with work notes
Then Click the Update Button
Then Verify the incident assignedgroup

Examples:
|incidentno|
|INC0010026|