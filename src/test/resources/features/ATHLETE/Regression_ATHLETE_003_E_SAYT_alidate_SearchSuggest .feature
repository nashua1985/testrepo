Feature: Regression_ATHLETE_003_E_SAYT_Validate_SearchSuggest
  @ATHLETE_003_E
  @ATHLETE_Regression
  @ATHLETE_Smoke_ui
@ATHLETE_Smoke_run1
Scenario: Regression_ATHLETE_003_E_SAYT_Validate_SearchSuggest
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we should see the suggested search for the following:
    |treadmill           |
    |dodgers             |
    |los angeles dodgers |
    |jordan 1            |
    |yeti                |
    |north face	         |
    |dumbbell            |
    |weights             |
#    |basketball shoes	 | have only basketball shoe (there is a cat 'Basketball Shoes"
    |carhartt            |