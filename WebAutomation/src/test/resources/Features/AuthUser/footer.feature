@Footer
Feature: Footer Links & Profile Hover elements Redirection Scenarios

  
  Scenario: gudsho logo
    Then verify gudsho logo
    And verify footer paragraph text
    And  Verify Footer headings
    
    
  Scenario: About us page redirection
    Given click about us link and verify it should redirected to correct page

  
  Scenario: Help&support  page redirection
    Given click help&support link and verify it should redirected to correct page

  
  Scenario: Submit your film  page redirection
    Given click Submit your film link and verify it should redirected to correct page

  
  Scenario: Blog  page redirection
    Given click blog link and verify it should redirected to correct page

  
  Scenario: Terms  page redirection
    Given click terms link and verify it should redirected to correct page

  
  Scenario: Privacy  page redirection
    Given click privacy link and verify it should redirected to correct page

  
  Scenario: Sell your movies & series on gudsho  page redirection
    Given click Sell your movies & series on gudsho link and verify it should redirected to correct page
    
  
  Scenario: PlayStore App Redirection
    Given Check Play store App redirection
    
    
  Scenario: App Store Redirection  
    Given Check App store App redirection   
  
  
  Scenario: Social Links Redirection  
    Given Check Facebook redirection
    And Check Twitter redirection
    And Check Instagram redirection
    And Check Linkedin redirection
    And Check Youtube redirection
    

  Scenario: Check all profile hover elements redirections
    Given Hover on profile
    Then Click on support menu and verify redirection
    Given Hover on profile
    Then Click on Friends menu and verify redirection
    Given Hover on profile
    Then Click on Account and settings menu and verify redirection
    
    
  
  Scenario: Verify Mobile Number and Name on profile
    Given Hover on profile
    Then Click on Account and settings menu and verify redirection
    And capture name and profile and verify with name and number
 
      
    
  
    
