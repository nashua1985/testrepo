Feature: Regression_ATHLETE_008_Validate_Athlete_is_able_to_successfully_sign_up
#not needed for now, approved by Athlete
#  @ATHLETE_008
#  @ATHLETE_Regression
#  @ATHLETE_Smoke
#  @ATHLETE_Smoke_run1

  Scenario: Regression_ATHLETE_008_Validate_Athlete_is_able_to_successfully_sign_up
  Given we are on "dsgKayakFamily" page
#  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsgKayakFamily" page
  And we enter our email to sign up at DSG




