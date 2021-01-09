Feature: Automation practise place order
#Author : Abdul

#1
Scenario Outline: TC001_Place all the three products and make payment

Given Click on SignIn link
Then Enter the username as <username> and password <password>
Then Click the Sign in button
Then Click Summer section under Womens tab
Then Change the item view into list
Then Add all three products with Qty <Qty> size <size> and collor as yellow to the cart
Then User click on proceed to check out under Address section
Then User Agrees terms and condition and clicks on proceed to check out
Then User selects the Payment Method as check and completes the payment
Then User clicks on profile
Then User clicks on order history and details
Then User takes screenshot of the order summary details
And User sign out of the application


Examples:
|username|password|Qty|size|
|Automation@american.com|Jan@2020|5|L|

