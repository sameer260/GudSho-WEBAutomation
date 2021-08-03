@StudioPage
Feature: Studio Detail page Scenarios

 Scenario Outline: Studio Share
      Given Search any studio <StudioName> and verify it should redirected to correct page
      When Click studio share icon
      Then Share the <ShareType> using all social icons
      
      Examples:
      |StudioName|ShareType|
      |Sameer    |shoshare | 
     
 Scenario Outline: Studio Banner Redirection
      Given Search any studio <StudioName> and verify it should redirected to correct page
      Then Click on Banner image and verify redirection to correct sho detail page
      
      Examples:
      |StudioName|
      |Sameer    |
     
   
  Scenario Outline: Follow Studio
    Given Search any studio <StudioName> and verify it should redirected to correct page
    When Click on Follow button
    Then check  toaster message and verify following text

    Examples: 
      | StudioName   |
      | Trail Studio |   
      
   
   Scenario Outline: Promo Card Redirection
    Given Search any studio <StudioName> and verify it should redirected to correct page
    When verfiy promo player
    Then close player

    Examples: 
      | StudioName   |
      | Sameer       |

  
  Scenario Outline: Sho Card Redirection
    Given Search any studio <StudioName> and verify it should redirected to correct page
    When click sho card and verify its redirected sho detail page

    Examples: 
      | StudioName  |
      | Sameer      |


  Scenario Outline: Sho Card Genre Redirection
    Given Search any studio <StudioName> and verify it should redirected to correct page
    When click <genere> and verify sho card redirection

    Examples: 
      | StudioName   |genere|
      | Trail Studio |Drama |    
     
  Scenario Outline: UnFollow Studio
    Given Search any studio <StudioName> and verify it should redirected to correct page
    When Click on Follow button
    Then From popup check unfollow studio and check toaster
    And check studio info

    Examples: 
      | StudioName   |
      | Trail Studio |
      
   @Paywall
   Scenario Outline: WatchFree Tab Card functionality
    Given Search any studio <StudioName> and verify it should redirected to correct page
    When click on watch free tab
    Then Check redirection of sho card from watch free tab

    Examples: 
      | StudioName   |
      | Sameer       | 
    @Paywall
   Scenario Outline: Genere which doesnot have any sho or series
    Given Search any studio <StudioName> and verify it should redirected to correct page
    When Click <genere> which doesnot have any shos
    Then Click on studio home and verify its redirection to home
    
    Examples:
    |StudioName  |genere|
    |Trail Studio|Comedy|
    
    @Paywall
   Scenario Outline: Check sharepopup of sho cards
    Given Search any studio <StudioName> and verify it should redirected to correct page
    Then Share sho card from home and verify popup
    Then Click <genere> share sho card and verify popup
    Then Verify share popup on watch free tab sho card
    
    Examples:
    |StudioName  |genere|
    |Trail Studio|Drama | 
    
    @Paywall
   Scenario Outline: Check Share Popup for promo cards
    Given Search any studio <StudioName> and verify it should redirected to correct page
    Then verify promo share popup
    And Click on promo see all link and verify share popup
    
    Examples:
    |StudioName  |genere|
    |Trail Studio|Drama | 
    
    
   Scenario Outline: Gud Promo
    Given Search any studio <StudioName> and verify it should redirected to correct page
    When play <PromoName> from the row and like promo
    Then On home page check liked <PromoName> is showing in my gud promos
    
    Examples:
    |StudioName  |PromoName                                          |
    |Sameer      | Powerful Police Officer Scenes Back To Back _ Top |  
    
    @Paywall
   Scenario Outline: See All Promo redirection
    Given Search any studio <StudioName> and verify it should redirected to correct page
    When Play promo from see all page
    Then check redirection of promo and then to sho detail page
    
    Examples:
    |StudioName  |
    |Sameer      | 
    
    @Paywall
   Scenario Outline: See all sho card Share
    Given Search any studio <StudioName> and verify it should redirected to correct page
    When Click on sho see all link
    Then Check Share popup in see all
    
    Examples:
    |StudioName  |
    |Sameer      | 
    
   @Paywall
   Scenario Outline: See all sho card redirection
    Given Search any studio <StudioName> and verify it should redirected to correct page
    When Click on sho see all link
    Then check sho card redirection in see all
    
    Examples:
    |StudioName  |
    |Sameer      | 
    
   
   Scenario Outline: See all sho card Watchlist
    Given Search any studio <StudioName> and verify it should redirected to correct page
    When Click on sho see all link
    Then Check watchlist in see all
    And On home page check the added watchlist
    
    Examples:
    |StudioName  |
    |Sameer      |    
    
         
          
      
      
