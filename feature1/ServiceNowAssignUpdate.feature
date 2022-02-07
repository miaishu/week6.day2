Feature: ServiceNow Application TestCase Scenarios_Update

Background:
#Launch the browser
#Enter the URL
Given Enter username as 'admin'
And Enter password as 'Ishu1990'
Then Click Login

Scenario Outline: TC_02 Update Incident_Positive
When Search for 'incident' in filter navigator
Then Select All in filter navigator
When Enter the "<incidentno>" in search
Then Click on the incident number
Then Update the incident with urgency as High
Then Update the State as In Progress
Then Click the Update Button
Then Verify the priority and State for "<incidentno>"

Examples:
|incidentno|
|INC0010080|
