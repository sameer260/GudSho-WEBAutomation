@Paywall
Feature: Paywall Scenarios

   
  Scenario Outline: Watch List Popup 
    Given Search any <ShoName> and verfiy its redirected to correct page
    And From sho detail page click on add to watchlist
    Then Vaildate Signin Popup

    Examples: 
      | ShoName |
      | Talent  |
      

  Scenario Outline: Promo icon Gud Popup 
     Given Search any <ShoName> and verfiy its redirected to correct page
    And From sho detail page click on any promo
    When while playing click on greate gud button
    Then Vaildate Signin Popup

    Examples: 
      | ShoName |
      | Talent  |
      
    
  Scenario Outline: Buy Button Popup
     Given Search any <ShoName> and verfiy its redirected to correct page
    And From sho detail page click on Buy button
    Then Vaildate Signin Popup

    Examples: 
      | ShoName  |
      | Talent   |
      
   Scenario Outline: Sho Page Social Media Icons Redirection
    Given Search any <ShoName> and verfiy its redirected to correct page
    When Click on Share button
    Then Check share popup is displayed with social ions

    Examples: 
      | ShoName |
      | Talent  |
  
  Scenario Outline: Promo Player Social Media Icons Redirection
    Given Search any <ShoName> and verfiy its redirected to correct page
    Then Share <PromoName> and verify share popup and share icons are displayed

    Examples: 
      | ShoName | PromoName                     |
      | Talent  | Vakeel Sab Theatrical Trailer |
      
   
  Scenario Outline: Follow Studio PopUp
    Given Search any studio <studioname> and verify it should redirected to correct page
    And From studio detail page click on follow button
    Then Vaildate Signin Popup

    Examples: 
      | studioname      |
      | santii's studio |
      
     
    Scenario Outline: Studio Page Social Media Icons Redirection
    Given Search any studio <studioname> and verify it should redirected to correct page
    When Click studio share icon
    Then Check share popup is displayed with social ions

    Examples: 
      | studioname |
      | Sameer     |   
       