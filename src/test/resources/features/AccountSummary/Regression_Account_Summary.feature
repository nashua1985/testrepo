Feature: Regression_Account_Summary

  Background: open page

  #Given we are on "dsg" page
  @CHECKOUT @Regression @CHECKOUT_001 @manish
  Scenario: Regression_Account_Summary
    Given we are on "dsg" page
    And we login to test account
      | dcsgorgs+5@gmail.com | 345CourtStreet! |
        #|dksgpittsburg222@gmail.com|TestPassword1!|
    And we wait for 10 seconds
    And we should land on Sign In page by validating headers
      | Account Summary      |
      | Available Rewards    |
      | Most Recent Purchase |
    And verify the "garence" and "Joseph" is present under the Account Summary
    And verify the Scorecard member "L01DB246YGVQ" is present under the Account Summary
    And verify 0 points are available for the customer
    And verify the Text "Earn 300 points to receive a $10 reward." under Available Rewards
    And verify recent purchanse displayed correctly
    And we wait for 10 seconds
    And verify user is able to navigate to order details from recent purchase
    And verify order details displayed correctly
    #step for manage account (open verify url and close )
    #validate for purchase order
    And user want to navigate to "rewards" tab
    And verify the expected text under active Rewards
      | Earn 300 points to receive a $10 reward. |
    And verify point balance is 0 points
    And verify credit account side bar opened on click credit my account link
    And user want to navigate to "purchase" tab
        And verify recent purchanse displayed correctly
    And verify user is able to navigate to order details from recent purchase  
    And verify order details displayed correctly
    And user want to navigate to "account setting" tab
    And verify all related settings are available
    #And user want to navigate to "faq" tab
    And user clicks on sign out link
    #    And click on account summary
    #    And verify "SCORECARD GOLD" header present
    #And verify "MANAGE ACCOUNT" is available under rewards
