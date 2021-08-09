@HomePage
Feature: GudSho Home Page

  Scenario: Notification Page Redirection
    Given verify notification tab
    When verify notification page redirected to correct page
    Then Click on notifications link and it should redirect to notifications tab

  Scenario: User Profile
    Given verify user profile icon
    Then verify profile icon page

  Scenario: Home page Banner Redirection
    Given Select first card from home banner and check sho detail page redirection

  Scenario: Promo Card Redirection
    Given Select first promo card from promo row
    Then verify redirection of promo player

  Scenario: Sho Card Redirection
    Given Click on sho card from any row and verify its redirected to correct sho detail page

  Scenario: Studio Card Redirection
    Given Click on studio card from studio row and verify its redirected to correct studio detail page
    
  Scenario: This test is to verify the follow button from home
    Given From home page click onfollow button and verify the button changes

  Scenario Outline: This test is to verify the added sho in addto watchlist
    Given From home page click on add to watchlist in <ShoName> title card
    When check card availbility on my watchlist row
    #And check card availbility on my wacthlist row see all
    #Then Remove from watchlit

    Examples: 
      | ShoName      |
      | vada chennai |

  Scenario Outline: This test is to verify the share button on sho card
    Given From home page click on share button in <ShoName> title card
    When Click on share button from the card and verify share popup

    Examples: 
      | ShoName |
      | kaithi  |

  Scenario Outline: This test is to verify the share button on sho card from see all page
    Given From home page click on sho type row see all hyperlink
    When From home page click on share button in <ShoName> title card
    And Click on share button from the card and verify share popup

    Examples: 
      | ShoName      |
      | vada chennai |

  Scenario Outline: This test is to verify the sho detail page redirection from home continue watching
    Given Search any <ShoName> and verfiy its redirected to correct page
    When Play watch free content and close the player
    And Navigate to gudsho home and click on sho name hyperlink from continue watching and verify redirection

      Examples: 
      | ShoName      |
      | scedue       |


  Scenario Outline: This test is to verify the added sho in addto watchlist from see all
    Given From home page click on sho type row see all hyperlink
    When Hover and click on click on add to watchlist in <ShoName> title card
    And Navigate back and <ShoName> availbility on my watchlist row
    Then Remove from watchlit

    Examples: 
      | ShoName                            |
      | Transformer: The Age Of Extinction |

  Scenario Outline: This test is to verify the sho redirection from see all page
    Given From home page click on sho type row see all hyperlink
    When From see all page click on sho card <ShoName> and verif redirection

    Examples: 
      | ShoName      |
      | vada chennai |

  Scenario Outline: This test is to verify the share button on promo card
    Given From home page hover on <PromoName> promo card
    When Click on share button from the card and verify share popup

    Examples: 
      | PromoName                                         |
      | Two Years Of Kaala - The Masterpiece _ Rajinikant |
      

  Scenario Outline: This test is to verify the share button on promo card from see all page
    Given From home page click on promo type row see all hyperlink
    When From home page hover on <PromoName> promo card
    And Click on share button from the card and verify share popup

    Examples: 
      | PromoName                                         |
      | Two Years Of Kaala - The Masterpiece _ Rajinikant |   

  Scenario Outline: This test is to verify the sho detail page redirection from promo player
    Given From home page hover on <PromoName> promo card and close the player
    Then On home page check liked <PromoName> is showing in my gud promos

    Examples: 
      |PromoName|
      |Two Years Of Kaala - The Masterpiece _ Rajinikant|
      
   
  Scenario Outline: This test is to verify the share button on sho card from see all page
   Given From home page click on promo type row see all hyperlink
   And Close promo player <promoName> and verify redirection
   
  Examples:
     | promoName                                         |
     | Two Years Of Kaala - The Masterpiece _ Rajinikant |    
