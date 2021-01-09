Feature: Automation practise create address and place order
#Author : Abdul

#1
Scenario Outline: TC003_Create a new address and the place all the three products and make payment

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
Then Change the item view into list
Then Add all three products with Qty <Qty> size <size> and collor as yellow to the cart
Then User click on proceed to check out under Address section
Then User Agrees terms and condition and clicks on proceed to check out
Then User selects the Payment Method as check and completes the payment
Then User clicks on profile
Then User clicks on order history and details
Then User takes screenshot of the order summary details
And  User sign out of the application


Examples:
|username|password|firstName|lastName|companyName|addressLine1|addressLine2|cityName|stateName|postCode|countryName|homeNum|mobileNum|info|aliasName|Qty|size|
|Automation@american.com|Jan@2020|firstName|lastName|companyName|addressLine1|addressLine2|United States|California|60028|United States|88102030|8879501|info|aliasName4|5|L|


