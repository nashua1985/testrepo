Feature: AS_008_Selecting_A_Pro_Shows_Their_Accomplishments_And_A_Calendar

  @AS_008_Selecting_A_Pro_Shows_Their_Accomplishments_And_A_Calendar
  @AS_Smoke_Test
  @AS_Regression_Test

  Scenario: When a professional is selected, then their accomplishments and a calendar should be displayed.
    Given we are on "GGAS" page
    When we enter "15108" into the zip code field
    And click anywhere else on the page
    And select the Robinson store
    And select a 30 minute lesson
    And the Selected Service Next Step button is clicked
    And a drop down list of professionals "Bryson DeChambeau" and "Dustin Johnson" is displayed
    And Dustin Johnson is selected
    Then his accomplishments "About Dustin Johnson: American professional golfer who plays on the PGA Tour. He has won two major championships, the 2016 U.S. Open at Oakmont Country Club with a 4-under-par score of 276 and the 2020 Masters Tournament with a record score of 268, 20-under-par." are displayed
    And the Calendar becomes available