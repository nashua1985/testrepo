Feature: AS_002_4_Digit_Zip_Not_Accepted

  @AS_002_4_Digit_Zip_Not_Accepted
  @AS_Smoke_Test
  @AS_Regression_Test

  Scenario: When a 4 digit zip code is entered, the page returns a user friendly error message.
    Given we are on "GGAS" page
    When we enter "1510" into the zip code field
    And click anywhere else on the page
    Then the page displays a user friendly error message "Please enter a valid zip code"
    And the store selectors do not appear