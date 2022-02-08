Feature: LeafTaps TestCase
Background:
#Launch the Browser
#Get URL
Given Enter Username as 'demosalesmanager'
Given Enter Password as 'crmsfa'
Then Click on Login
And Click on 'CRM/SFA'


@CreateLead
Scenario Outline: TC01_CreateLead_Positive
When Verify 'My Home' page
Then Click on 'Leads'
When Verify 'My Leads' page
Then Click on 'Create Lead'
When Verify 'Create Lead' page
When Enter Companyname "<cname>"
When Enter Firstname "<fname>"
When Enter Lastname "<lname>"
When Click on Submit

Examples:

|cname|fname|lname|
|Apple|Connie|Lin|

@EditLead
Scenario Outline: TC_01_EditLead_Positive
When Verify 'My Home' page
Then Click on 'Leads'
When Verify 'My Leads' page
Then Click on 'Find Leads'
When Verify 'Find Leads' page
Then Click Phone
Given Enter "<mobno>"
Then Click on 'Find Leads'
Then Click first data
And Click on 'Edit'
And Clear companyName
And Update companyName "<cname>"
And Click the submitButton
And Verify

Examples:
|mobno|cname|
|99|Valero|
|12345|CTS|


@MergeLead
Scenario: TC_01_MergeLead_Positive
When Verify 'My Home' page
Then Click on 'Leads'
Then Click on 'Merge Leads'
When Verify 'Merge Leads' page
When Go to Lookup Table from lead
Then Search the FirstName as 'Hari'
Then Click Find Leads
And Select the first row 
When Go to Lookup Table to lead
Then Search the MergeName as 'p' 
And Click Find Leads
And Select the first row  
Then Click on 'Merge'
Then Click on Popup Alert
And Verify the FirstName in ViewLead

@DuplicateLead
Scenario: TC_01 DuplicateLead Positive
When Verify 'My Home' page
Then Click on 'Leads'
When Verify 'My Leads' page
Then Click on 'Find Leads'
When Verify 'Find Leads' page
Then Click Phone
Given Enter "<mobno>"
Then Click on 'Find Leads'
Then Click first data
When Click on 'Duplicate Lead'
Then Click the submitButton

@DeleteLead
Scenario: TC_01 DeleteLead Positive
When Verify 'My Home' page
Then Click on 'Leads'
When Verify 'My Leads' page
Then Click on 'Find Leads'
When Verify 'Find Leads' page
Then Click Phone
Given Enter "<mobno>"
Then Click on 'Find Leads'
And Get the id
And Click first data
And Click on 'Delete'
And Click on 'Find Leads'
When Enter LeadID no
Then Verify 'No records to display'













