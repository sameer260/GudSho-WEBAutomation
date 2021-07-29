@ShodetailPage
Feature: Sho Detail Page Scenarios

  Scenario Outline: Sho-Purchase & Payment
    Given Search any <ShoName> and verfiy its redirected to correct page
    When Buy the sho using <PaymentMode> with <PaymentScenario>
    Then Verify after payment <ShoName> is playing and close the player

    Examples: 
      | ShoName          | PaymentMode | PaymentScenario |
      | Talent           | Card        | Success         |
      
      
  Scenario Outline: Promo Gud
    Given Search any <ShoName> and verfiy its redirected to correct page
    When Play <PromoName> and like promo
    Then On home page check liked <PromoName> is showing in my gud promos

    Examples: 
      | ShoName | PromoName                     |
      | Talent  | Vakeel Sab Theatrical Trailer |
    
  Scenario Outline: Sho Watchlist
    Given Search any <ShoName> and verfiy its redirected to correct page
    When Add <ShoName> in to watchlist and check the toaster message
    Then On home page check the added watchlist <ShoName>

    Examples: 
      | ShoName |
      | Talent  |

  Scenario Outline: Sho Page Social Media Icons Redirection
    Given Search any <ShoName> and verfiy its redirected to correct page
    When Click on Share button
    Then Share the <ShareType> using all social icons

    Examples: 
      | ShoName | ShareType  |
      | Talent  | shoshare   |
  
  Scenario Outline: Promo Player Social Media Icons Redirection
    Given Search any <ShoName> and verfiy its redirected to correct page
    Then Hover on <PromoName> card and share promo <ShareType> using all shares

    Examples: 
      | ShoName | PromoName                     | ShareType  |
      | Talent  | Vakeel Sab Theatrical Trailer | promoshare |

  Scenario Outline: Studio Link Redirection
    Given Search any <ShoName> and verfiy its redirected to correct page
    Then Click on Studio link and check redirected to studio detail page

    Examples: 
      | ShoName |
      | Talent  |

  Scenario Outline: Continue Watching 
    Given Search any <ShoName> and verfiy its redirected to correct page
    When Play watch free content and close the player
    And On sho detail page verify watch now button should change to resume
    Then On Home Page check continue wathing is showing <ShoName>

    Examples: 
      | ShoName |
      | Paytm   |
   
   Scenario Outline: Validate all shodetailpage validation
    Given Search any <ShoName> and verfiy its redirected to correct page
    When 
  
      
      
      
  
      
      
    
    
    
      
      
