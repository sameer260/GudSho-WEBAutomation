Feature: ratings scenarios ____ Santhosh

  Scenario Outline: Verify friends rating section element UI for the new sho without friends rating.
    Given Search any <ShoName> and verfiy its redirected to correct page
    When Verify rating section for new sho and click
    And Verify buy now mini popup elements and click on buy CTA
    Then buy sho <PaymentMode> with <PaymentScenario>
    Then From player Give rating <rating> from player and commnets <comment> and verify in detail page

    Examples: 
      | ShoName               | PaymentMode | PaymentScenario | comment | rating |
      | Sho3 For Ramya Studio | Card        | Success         | awsome  | five   |

  Scenario Outline: Verify that user is able to give rating for the sho without comment
    Given Search any <ShoName> and verfiy its redirected to correct page
    Then with out comment submit the rating <rating> and verify

    Examples: 
      | ShoName     | rating |
      | private sho | five   |

  Scenario Outline: Verify that user is able to see audience rating from header
    Given Search any <ShoName> and verfiy its redirected to correct page
    When verify header rating
    And Click on header rating and verify popup

    Examples: 
      | ShoName     |
      | private sho |

  Scenario Outline: Verify friends rating popup UI
    Given Search any <ShoName> and verfiy its redirected to correct page
    When verify header rating and Click on header rating and verify popup <ShoName>

    Examples: 
      | ShoName |
      | Avatar  |

  Scenario Outline: Verify that user is able to update ratings and comments
    Given Search any <ShoName> and verfiy its redirected to correct page
    When Give <rating> and <comments>
    And update <newRating> rating and commnet <newcomment>

    Examples: 
      | ShoName | comments     | newcomment | rating | newRating |
      | kaithi  | awsome movie | whistle    | four   | five      |

@test
  Scenario Outline: Verify audience rating count after sho rated
    Given Search any <ShoName> and verfiy its redirected to correct page
    When get the audience rating count and click your rating
    And Verify buy now mini popup elements and click on buy CTA
    Then buy sho <PaymentMode> with <PaymentScenario> and give rating
    Then From player Give rating <rating> from player and commnets <comment> and verify in detail page
    Then Verify audience rating count increment

    Examples: 
      | ShoName | PaymentMode | PaymentScenario | comment | rating |
      | Locked  | Card        | Success         | awsome  | five   |
