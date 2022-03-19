Feature: As a user, I should be able to search for summer dresses and proceed with checkout

Scenario: As a user, I should be able to search for summer dresses and proceed with checkout
Given I accessed the automationpractice website
When I search for summer dresses 
And Select products from the results and add to cart
And Proceed with checkout process
Then I should be able to purchase the products