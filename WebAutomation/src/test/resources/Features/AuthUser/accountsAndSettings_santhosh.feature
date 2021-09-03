Feature: my watch history phase 3 scenarios


  Scenario: Delete from watch history and verify
    Given navigate to my watch history
    Then Verify deletion on the watch history

  @test
  Scenario: play from watch history and verify
    Given navigate to my watch history
    Then Verify player redirection from watch history

  
  Scenario: clear all from watch history and verify
    Given navigate to my watch history
    Then Verify clear all on the watch history

  Scenario Outline: Buy and play sho then verify the watch history
    Given Search any <ShoName> and verfiy its redirected to correct page
    When Buy the sho using <PaymentMode> with <PaymentScenario>
    And Verify after payment <ShoName> is playing and close the player
    Then navigate to my watch history
    Then Verify <ShoName> from watchh history

    Examples: 
      | ShoName | PaymentMode | PaymentScenario |
      | Narappa | Card        | Success         |
