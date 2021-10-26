Feature: Regression_Account_Summary

  Background: open page
    #Given we are on "dsg" page

  @CHECKOUT
  @Regression
  @CHECKOUT_001
  Scenario: Regression_Account_Summary
    Given we are on "dsg" page
    And we wait for 2 seconds
    And we login to test account
      | dcsgorgs+5@gmail.com | 345CourtStreet! |
#    |dksgpittsburg222@gmail.com|TestPassword1!|
    And we should land on Sign In page by validating headers
      | Account Summary      |
      | Available Rewards    |
      | Most Recent Purchase |
    And verify the "garence" and "Joseph" is present under the Account Summary
    And verify the Scorecard member "L01DB246YGVQ" is present under the Account Summary
    And verify 150 points are available for the customer

    And verify the Text "Earn 300 points to receive a $10 reward." under Available Rewards
#    And click on account summary
#    And verify "SCORECARD GOLD" header present
    And verify "MANAGE ACCOUNT" is available under rewards











