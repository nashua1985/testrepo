Feature: AS_005_Selecting_A_Store_Displays_Services

  @AS_005_Selecting_A_Store_Displays_Services
  @AS_Smoke_Test
  @AS_Regression_Test

  Scenario: When a store is selected the Golf Lesson and Club Fitting services should become available.
    Given we are on "GGAS" page
    When we enter "15108" into the zip code field
    And click anywhere else on the page
    And select the Robinson store
    Then the page displays the Golf Lessons service
    And the page displays the Club Fitting service