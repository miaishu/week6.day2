Feature: ServiceNow Application TestCase Scenarios_Create

Background:
#Launch the browser
#Enter the URL
Given Enter username as 'admin'
And Enter password as 'Ishu1990'
Then Click Login

Scenario Outline: TC01_CreateIncident_Positive
When Search for 'incident' in filter navigator
Then Select All in filter navigator
When Click on create New incident
Given Get the incident number
Given Enter the caller details as "<callername>"
And Enter Short description as "<shortdesc>"
When Click on Submit button
Then Verify incident no is created

Examples:
|callername|shortdesc|
|Fred Luddy|Water spilled in the server|







