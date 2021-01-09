Feature: Leaftaps login functionality
#Author : Abdul

#1
Scenario Outline: TC001_Enter a new address

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
Then Click Summer section under Womens tab

Examples:
|username|password|firstName|lastName|companyName|addressLine1|addressLine2|cityName|stateName|postCode|countryName|homeNum|mobileNum|info|aliasName|
|Automation@american.com|Jan@2020|firstName|lastName|companyName|addressLine1|addressLine2|United States|California|60028|United States|88102030|8879501|info|aliasName|


