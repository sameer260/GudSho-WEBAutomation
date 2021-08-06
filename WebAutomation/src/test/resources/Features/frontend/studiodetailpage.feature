@StudioPage
Feature: Studio Detail page Scenarios

  Scenario Outline: Studio Share
    Given Search any studio <StudioName> and verify it should redirected to correct page
    When Click studio share icon
    Then Share the <ShareType> using all social icons

    Examples: 
      | StudioName | ShareType |
      | Sameer     | shoshare  |

  Scenario Outline: Studio Banner Redirection
    Given Search any studio <StudioName> and verify it should redirected to correct page
    Then Click on Banner image and verify redirection to correct sho detail page

    Examples: 
      | StudioName |
      | Sameer     |

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
      | StudioName |
      | Sameer     |

  Scenario Outline: Sho Card Redirection
    Given Search any studio <StudioName> and verify it should redirected to correct page
    When click sho card and verify its redirected sho detail page

    Examples: 
      | StudioName |
      | Sameer     |

  Scenario Outline: Sho Card Genre Redirection
    Given Search any studio <StudioName> and verify it should redirected to correct page
    When click <genere> and verify sho card redirection

    Examples: 
      | StudioName   | genere |
      | Trail Studio | Drama  |
