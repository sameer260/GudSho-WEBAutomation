Feature: Account and Settings

  ## Tranactions
  
  Scenario Outline: Razor Payment Popup Screen Validation
    Given Search any <ShoName> and verfiy its redirected to correct page
    When Click on Continue Button and check Razor payment popup
    Then Check razor payment popup validation

    Examples: 
      | ShoName |
      | narappa |

  Scenario Outline: Check Success Payment
    Given Search any <ShoName> and verfiy its redirected to correct page
    When Buy the sho using <PaymentMode> with <PaymentScenario>
    Then Check payment status for <PaymentScenario> for <ShoName>
    And Check <ShoName> in transactions for <PaymentMode> and <PaymentScenario>

    Examples: 
      | ShoName | PaymentMode | PaymentScenario |
      | Hacking | Card        | Failed          |
      | Hacking | Net Banking | Failed          |
      | Hacking | Card        | Success         |
      | Check   | UPI         | Success         |
      | Promo   | Net Banking | Success         |

  ## Watch History
  
  Scenario: Delete from watch history and verify
    Given navigate to my watch history
    Then Verify deletion on the watch history

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
      
   ## Notificaton
   
   Scenario Outline: Check Notificaton Toggle Buttons
   Given navigate to notifications tab
   Then Check notification toggle status for <NotificationType>
   
   Examples:
   |NotificationType    |
   |In-app Notifications|
   |Push Notifications  |  
   
   
   ## Friends 
   @test
    Scenario Outline: Friends functionality
    Given click friends tab and enter <SelfInvite> and verify toast message
    Then click friends tab and enter <NewInvite> and verify success  toast message
    And click emailid tab and enter <SameInvite> and verify error toast message
    And verify null value and <InvalidEmail>
    Then Check mute and unmute functionality
    
    Examples: 
      |SelfInvite        |NewInvite            |SameInvite           |InvalidEmail|
      |sameer.g@contus.in|sameer234@yopmail.com|sameer234@yopmail.com|sameer      |
      
    ## Privacy & Security
     
    Scenario: verify privacy policy
    Given click privacy policy tab and verify it should navigate to correct page
      
