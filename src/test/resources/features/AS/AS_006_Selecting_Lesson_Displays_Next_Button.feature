Feature: AS_006_Selecting_Lesson_Displays_Next_Button

  @AS_006_Selecting_Lesson_Displays_Next_Button
  @AS_Smoke_Test
  @AS_Regression_Test

  Scenario: When a location and service have been selected, the Next Steps button should be available.
    Given we are on "GGAS" page
    When we enter "15108" into the zip code field
    And click anywhere else on the page
    And select the Robinson store
    And select a 30 minute lesson
    Then the Next Step button becomes available