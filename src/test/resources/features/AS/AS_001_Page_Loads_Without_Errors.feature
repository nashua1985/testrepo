Feature: AS_001_Page_Loads_Without_Errors

  @AS_001_Page_Loads_Without_errors
  @AS_Smoke_Test
  @AS_Regression_Test

    Scenario: AS_001_Page_Loads_Without_Errors
    Given we are on "GGAS" page
    When we should see zip code field
    And we should see the text "SCHEDULING SERVICES"