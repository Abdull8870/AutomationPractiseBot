Feature: Automation practise place order alternative
#Author : Abdul

#1
Scenario Outline: TC_005_Placing the order with sequence of steps

Given Click on SignIn link
Then  Enter the username as <username> and password <password>
Then Click the Sign in button
Then Click Summer section under Womens tab
Then Change the item view into list
Then Click on the firt item of the page
Then Increase the quantity to <Qty> 
And Change the size to <size>
And Select any colour
Then Click Add to cart
Then Click on Continue Shopping
Then Click Summer section under Womens tab
Then Change the item view into list
Then Click on the Second item of the page
Then Increase the quantity to <Qty> 
And  Change the size to <size>
And Select any colour
Then Click Add to cart
Then Click on Continue Shopping
Then Click Summer section under Womens tab
Then Change the item view into list
Then Click on the Third item of the page
Then Increase the quantity to <Qty> 
And  Change the size to <size>
And Select any colour
Then Click Add to cart
Then Click on proceed to checkout
Then User click on proceed to check out under Address section
Then User Agrees terms and condition and clicks on proceed to check out
Then User selects the Payment Method as check and completes the payment
Then User clicks on profile
Then User clicks on order history and details
Then User takes screenshot of the order summary details
And User sign out of the application


Examples:
|username|password|Qty|size|
|Automation@americantech.com|Jan@2020|5|L|



