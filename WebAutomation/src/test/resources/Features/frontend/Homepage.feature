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
@test
  Scenario Outline: This test is to verify the added sho in addto watchlist
    Given From home page click on add to watchlist in <shoName> title card
    When check card availbility on my watchlist row
    And check card availbility on my wacthlist row see all
    Then Remove from watchlit

    Examples: 
      | shoName      |
      | vada chennai |
@test
  Scenario Outline: This test is to verify the share button on sho card
    Given From home page click on share button in <shoName> title card
    When Click on share button from the card and verify share popup

    Examples: 
      | shoName      |
      | vada chennai |
@test
  Scenario Outline: This test is to verify the sho detail page redirection from home continue watchling
    Given Search any <ShoName> and verfiy its redirected to correct page
    When Play watch free content and close the player
    And Navigate to gudsho home and click on sho name hyperlink from continue watching and verify redirection

    Examples: 
      | ShoName      |
      | vada chennai |

@test
  Scenario Outline: This test is to verify the added sho in addto watchlist from see all
    Given From home page click on sho type row see all hyperlink
    When Hover and click on click on add to watchlist in <shoName> title card
    And Navigate back and check card availbility on my watchlist row
    Then Remove from watchlit

    Examples: 
      | shoName      |
      | Transformer: The Age Of Extinction |
