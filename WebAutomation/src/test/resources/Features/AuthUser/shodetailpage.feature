@ShodetailPage
Feature: Sho Detail Page Scenarios

  Scenario Outline: Sho-Purchase & Payment
    Given Search any <ShoName> and verfiy its redirected to correct page
    When Buy the sho using <PaymentMode> with <PaymentScenario>
    Then Verify after payment <ShoName> is playing and close the player

    Examples: 
      | ShoName | PaymentMode | PaymentScenario |
      | Talent  | Card        | Success         |

  Scenario Outline: Promo Gud
    Given Search any <ShoName> and verfiy its redirected to correct page
    When Play <PromoName> and <UserAction> promo
    Then On home page check liked <PromoName> is showing in my gud promos

    Examples: 
      | ShoName | PromoName                     |UserAction|
      | Talent  | Vakeel Sab Theatrical Trailer |Like      |

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
      | ShoName | ShareType |
      | Talent  | shoshare  |

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

  Scenario Outline: Sho detail info
    Given Search any <ShoName> and verfiy its redirected to correct page
    When Check all sho detail info and check seemore popup if <available>
    Then check About section if about tab <availability>

    Examples: 
      | ShoName | available | availability |
      | Narappa | Yes       | Yes          |
      | Paytm   | No        | No           |

  Scenario Outline: Sho Card Watchist and Redirection
    Given Search any <ShoName> and verfiy its redirected to correct page
    Then Check redirection of card and watchlist functionality of sho card on home page


    Examples: 
      | ShoName |
      | narappa |

   Scenario Outline: More like this Share popup
    Given Search any <ShoName> and verfiy its redirected to correct page
    Then Click on shareicon from shocard and verify share popup

    Examples: 
      | ShoName |
      | narappa |

  Scenario Outline: More like this sho card Functionality
    Given Search any <ShoName> and verfiy its redirected to correct page
    Then click on more like this link and check watchlist toaster
    And Check redirection of sho card

    Examples: 
      | ShoName |
      | narappa |

  Scenario Outline: Header Watchlist
  Given Search any <ShoName> and verfiy its redirected to correct page
  When Scroll down page and click on watchlist button
  Then On home page check the added watchlist <ShoName> 
  
    Examples: 
      | ShoName |
      | narappa |
       
   Scenario Outline: Header Share
    Given Search any <ShoName> and verfiy its redirected to correct page
    Then Click header share icon and verify share popup

    Examples: 
      | ShoName |
      | narappa |   
      
      
  Scenario Outline: Header Watch Now-PriceButton
  Given Search any <ShoName> and verfiy its redirected to correct page
  When click header watch now button
  Then verify payment continue popup dislayed
  
    Examples: 
      | ShoName |
      | narappa | 
      
   
  Scenario Outline: Header Watch FreeButton
  Given Search any <ShoName> and verfiy its redirected to correct page
  When click header watch now button
  Then verify sho is playing and close player and verify resume button
  And On sho detail page verify watch now button should change to resume
  Then On Home Page check continue wathing is showing <ShoName>
  
    Examples: 
      |ShoName         |
      |Check Transacode| 
      
     
  Scenario Outline: Animation Buttons verification
  Given Search any <ShoName> and verfiy its redirected to correct page
  When Wait for Animation buttons and Verify its displaying all button
  Then hover on banner check the sho detail element is retained
  
    Examples: 
      | ShoName |
      | Kaithi  |
      
   
  Scenario Outline: Play Left time verification
  Given Search any <ShoName> and verfiy its redirected to correct page
  When Play video till <time> and close player
  Then verify time left on sho detail page
  
  Examples: 
      | ShoName         |time |
      | Khaidhi No 150  |08:20|
      
  Scenario Outline: Left and Right Arrows
  Given Search any <ShoName> and verfiy its redirected to correct page
  Then Check right and left arrow is working as expected
  
  
   Examples: 
      | ShoName         |
      | Khaidhi No 150  |
      
    
  Scenario Outline: Sho Card Labels verification
  Given Search any <ShoName> and verfiy its redirected to correct page
  Then verify all lables of the card with sho detail page
  And verify price label 
  
   Examples: 
      | ShoName  |
      | Hacking  |
  
  Scenario Outline: Gud count Increament and View Count check
  Given Search any <ShoName> and verfiy its redirected to correct page
  And Take a gud and view count of <PromoName>
  When Play <PromoName> and <UserAction> promo
  Then verify view and gudcount of <PromoName> for <UserAction> 
  
   Examples: 
      | ShoName  |PromoName    |UserAction|
      | Hacking  |Kung Fu Panda|Like      |   
      
  
   
  Scenario Outline: Gud count Decrement and View Count check
  Given Search any <ShoName> and verfiy its redirected to correct page
  And Take a gud and view count of <PromoName>
  When Play <PromoName> and <UserAction> promo
  Then verify view and gudcount of <PromoName> for <UserAction>  
  
   Examples: 
      | ShoName  |PromoName    |UserAction|
      | Hacking  |Kung Fu Panda|Unlike    |    
      
      
 ## Home Page Scenarios

  Scenario Outline: Sho Watchlist card redirection
    Given Search any <ShoName> and verfiy its redirected to correct page
    When Add <ShoName> in to watchlist and check the toaster message
    Then On home page check the added watchlist <ShoName>
    And Check redirection of sho card <ShoName> is in mywatchlist row

    Examples: 
      | ShoName |
      | Locked  |
     
   Scenario Outline: Remove watchlist from watchlist row
  Given Search any <ShoName> and verfiy its redirected to correct page
  When Scroll down page and click on watchlist button
  Then On home page check the added watchlist <ShoName>
  And Remove <ShoName> card from watchlist and verify 
  
    Examples: 
      | ShoName |
      | Check   |   
 
          
      
      
         
      
      
      
      
    
              
      
