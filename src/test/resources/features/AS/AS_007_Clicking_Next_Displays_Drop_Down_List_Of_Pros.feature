Feature: AS_007_Clicking_Next_Displays_Drop_Down_List_Of_Pros

  @AS_007_Clicking_Next_Displays_Drop_Down_List_Of_Pros
  @AS_Smoke_Test
  @AS_Regression_Test

  Scenario: Clicking Next Steps on the service window should display a drop down list of pros on the next page.
    Given we are on "GGAS" page
    When we enter "15108" into the zip code field
    And click anywhere else on the page
    And select the Robinson store
    And select a 30 minute lesson
    And the Selected Service Next Step button is clicked
    Then a drop down list of professionals "Bryson DeChambeau" and "Dustin Johnson" is displayed