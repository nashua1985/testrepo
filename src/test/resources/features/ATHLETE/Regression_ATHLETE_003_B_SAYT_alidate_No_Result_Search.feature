Feature: Regression_ATHLETE_003_B_SAYT_Validate_No_Result_Search

    @ATHLETE_003_B
    @ATHLETE_Regression
    @ATHLETE_Smoke_ui
    @ATHLETE_Smoke_run1
Scenario Outline: Regression_ATHLETE_003_B_SAYT_Validate_No_Result_Search
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we search for "<searchTerm>" keyword in the search box
  Then we should see 0 results for "<searchTerm>"

  Examples:
    |searchTerm |
    |xxxxxxxxx  |
#    |basketball |
