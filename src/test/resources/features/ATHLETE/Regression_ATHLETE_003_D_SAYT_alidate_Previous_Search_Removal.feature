Feature: Regression_ATHLETE_003_D_SAYT_Validate_Previous_Search_Removal

    @ATHLETE_003_D
    @ATHLETE_Regression
    @ATHLETE_Smoke_ui
@ATHLETE_Smoke_run1
Scenario Outline: Regression_ATHLETE_003_D_SAYT_Validate_Previous_Search_Removal
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we search for "<searchTerm>" keyword in the search box
  And we wait for 10 seconds
  Then we clear the search box and should not see "<searchTerm>"

  Examples:
    |searchTerm |
    |xxxxxxxxx  |
#    |basketball |