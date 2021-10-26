Feature: Regression_ATHLETE_006_My_store_validation

#  @ATHLETE_006
#  @ATHLETE_Regression
#  @ATHLETE_Smoke
#  @ATHLETE_Smoke_run1
# wait for the new header and implement there
  Scenario: Regression_ATHLETE_006_My_store_validation
  Given we are on "dsgKayakFamily" page
#  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsgKayakFamily" page
  And we click on findMyStore
  And we wait for 10 seconds
  And we validate Athlete is able to select store
      |19115|Liberty Plaza|
#  And we validate Get Directions does not 404 takes user to google maps


