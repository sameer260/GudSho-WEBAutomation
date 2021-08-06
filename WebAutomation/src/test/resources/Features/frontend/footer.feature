@Footer
Feature: Footer Links & Profile Hover elements Redirection Scenarios

  @Paywall
  Scenario: gudsho logo
    Then verify gudsho logo
    And verify footer paragraph text
    And  Verify Footer headings
    
  @Paywall  
  Scenario: About us page redirection
    Given click about us link and verify it should redirected to correct page

  @Paywall
  Scenario: Help&support  page redirection
    Given click help&support link and verify it should redirected to correct page

  @Paywall
  Scenario: Submit your film  page redirection
    Given click Submit your film link and verify it should redirected to correct page

  @Paywall
  Scenario: Blog  page redirection
    Given click blog link and verify it should redirected to correct page

  @Paywall
  Scenario: Terms  page redirection
    Given click terms link and verify it should redirected to correct page

  @Paywall
  Scenario: Privacy  page redirection
    Given click privacy link and verify it should redirected to correct page

  @Paywall
  Scenario: Sell your movies & series on gudsho  page redirection
    Given click Sell your movies & series on gudsho link and verify it should redirected to correct page
    
  @Paywall
  Scenario: PlayStore App Redirection
    Given Check Play store App redirection
    
   @Paywall 
  Scenario: App Store Redirection  
    Given Check App store App redirection   
  
  @Paywall
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
    Given Hover on profile
    Then Click on Signout and check toaster
    
  
  Scenario: Verify Mobile Number and Name on profile
    Given Hover on profile
    Then Click on Account and settings menu and verify redirection
    And capture name and profile and verify with name and number
 
      
    
  
    
