Feature: Regression_ATHLETE_01B_Mobile_menu_should_open_and_close

  @ATHLETE_01B_mobile
  @ATHLETE_Regression_mobile
  @ATHLETE_Smoke
  @ATHLETE_Smoke_run1_mobile
Scenario: Regression_ATHLETE_01B_Mobile_menu_should_open_and_close
  Given we are on "dsg" page
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we should see mobile menu open and close