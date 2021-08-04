@Footer @Paywall
Feature: Footer  Scenarios

  
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
    
   @test 
  Scenario: PlayStore App Redirection
    Given Check Play store App redirection
    
   @test 
  Scenario: App Store Redirection  
    Given Check App store App redirection   
