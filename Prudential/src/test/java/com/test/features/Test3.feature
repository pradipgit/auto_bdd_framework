#Author: pradip.blr28@gmail.com

@tag
Feature: Verifies search functionality for valid city

  @search
  Scenario: Verify that website successfully returns weather details for the valid city
    Given I open the application in the browser
    And I enter a city name "Bangalore"
    When I Searches for the weather  
    Then I verifies that website successfully returns weather details for the city "Bangalore, IN"   
    
      
         
 