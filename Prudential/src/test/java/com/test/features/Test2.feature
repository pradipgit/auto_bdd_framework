#Author: pradip.blr28@gmail.com

@tag
Feature: Verifies search functionality for invalid city

  @search
  Scenario: Verifies that website suggests city is Not found
    Given I open the application in the browser
    And I enter a city name "notexist"
    When I Searches for the weather  
    Then I Verifies that website suggests city is "Not found"   
    
      
         
 