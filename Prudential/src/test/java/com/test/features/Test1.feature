#Author: pradip.blr28@gmail.com

@tag
Feature: Verify all important information in the page

  @label
  Scenario Outline: Verifies that all important information is there, e.g.  labels etc
    Given I open the application in the browser
    Then I validate entity <name>       
    Examples: 
      | name  |
      | openweathermap |
      | Support Center |  
      | Sign In |
      | Sign Up |
      | Weather |
      | Maps |
      | Guide |
      | Search TextBox |
      | Weather forecast hourly graphic |
      | More weather in your city |
      | How to start |
      | Move to agromonitoring.com |
      | Weather map |
      | Read more |
      | View Solutions |
      | Try free APIs |
      | Connect |
      | Footer |
      
         
 