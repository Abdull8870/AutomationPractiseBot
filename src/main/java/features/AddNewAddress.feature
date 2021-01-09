Feature: Automation practise create address
#Author : Abdul

#1
Scenario Outline: TC002_Create a new address

Given Click on SignIn link
Then Enter the username as <username> and password <password>
Then Click the Sign in button
Then Click on on the link MY ADDRESSES
Then Click on Add a new address button
Then Enter new address details firstName <firstName> lastName <lastName> companyname <companyName> addressLineOne <addressLine1> and addressLineTwo <addressLine2>
And  Enter City Name <cityName> and postcode <postCode>
And  Select the state <stateName> and country <countryName>
And  Enter the contact details Home number <homeNum> Mobile number <mobileNum> and additional info <info>
Then Enter the alias name <aliasName> and click save

Examples:
|username|password|firstName|lastName|companyName|addressLine1|addressLine2|cityName|stateName|postCode|countryName|homeNum|mobileNum|info|aliasName|
|Automation@americantech.com|Jan@2020|Virat|Kohli|Viratkohli foundation|Delhi|Feroz shah kotla|Delhi|California|60028|United States|88102030|8879501|info|office 2|


