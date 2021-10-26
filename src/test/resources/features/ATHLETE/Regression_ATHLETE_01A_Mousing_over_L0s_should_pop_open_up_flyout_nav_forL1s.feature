Feature: Regression_ATHLETE_01A_Mousing_over_L0s_should_pop_open_up_flyout_nav_forL1s.

  @ATHLETE_01A
  @ATHLETE_Regression
  @ATHLETE_Smoke_ui
  @ATHLETE_Smoke_run1
Scenario: Regression_ATHLETE_01A_Mousing_over_L0s_should_pop_open_up_flyout_nav_forL1s.
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we should see L1 flyout when hovering on L0
