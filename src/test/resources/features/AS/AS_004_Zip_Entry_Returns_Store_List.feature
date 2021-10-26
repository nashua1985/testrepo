Feature: AS_004_A_Valid_Zip_Displays_Local_Stores

  @AS_004_A_Valid_Zip_Displays_Local_Stores
  @AS_Smoke_Test
  @AS_Regression_Test

  Scenario: When a valid zip code is entered, a list of local stores is displayed.
    Given we are on "GGAS" page
    When we enter "15108" into the zip code field
    And click anywhere else on the page
    Then the page displays the Akron and Robinson store radio button
    And the page displays the Robinson store radio button
