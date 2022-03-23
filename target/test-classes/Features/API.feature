Feature: API Testing

@coinmapget
Scenario: Coinmap API Validation
Given the user sends a GET request to Coinmap API
When the status code is 200
Then Count the total number of Categories
And Extract the Names of Food Category
