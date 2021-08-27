Feature: Account and Settings 


Scenario Outline: Check Success Payment
    #Given Search any <ShoName> and verfiy its redirected to correct page
    #When Buy the sho using <PaymentMode> with <PaymentScenario>
    #Then Verify after payment <ShoName> is playing and close the player
    And Check <ShoName> in transactaions for <PaymentMode> and <PaymentScenario>

    Examples: 
      | ShoName | PaymentMode | PaymentScenario |
      | Hacking | Card        | Success         |
