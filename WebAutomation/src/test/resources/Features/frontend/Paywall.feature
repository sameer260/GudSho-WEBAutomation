Feature: Paywall Functionality

                                #######  Sho Detail Page ###########

Scenario Outline: Search Any sho and add to watchlist
Given Search <shoseries> click on watchlist button
Then Signin popup should open and verify the text
And click on signin button and it should redirect to the login page
And  Again click back and add watchlist from header
Then Signin popup should open and verify the text
And click on signin button and it should redirect to the login page 

Examples:
|shoseries|
|Talent|

Scenario Outline: Search any Sho and Click watch free button
Given Search <shoseries> click on watch free button
Then Page should redirect to the login page
And Again click back and click on watch free button from header

Examples:
|shoseries|
|Check Transacode|

Scenario Outline: Search any sho and click on Buy button
Given Search <shoseries> and click on buy button
Then Page should redirect to the login page
And Again Click buy button from headder and check same

Examples:
|shoseries|
|Talent   |


Scenario Outline: Search any sho and select season and episode
Given Search <shoseries> and click on first episode
Then Page should redirect to the login page
And Click back and now select <season name> from season dropdown
Then Click on any episode it should redirect to login page

Examples:
|shoseries|season name|
|Talent   |Season 3   |

Scenario Outline: Play a promo from Sho detail page and like
Given Search <shoseries> and click on any promo
Then verify the promo is playing and give gud on promo
And verify signin popup opened and verify the text

@Execute
Examples:
|shoseries|
|Talent   |

