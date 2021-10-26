Feature: Regression_ATHLETE_003_A_SAYT_Validate_top_search_keys

  @ATHLETE_003_A
  @ATHLETE_Regression
  @ATHLETE_Smoke_ui
@ATHLETE_Smoke_run1

  Scenario: Regression_ATHLETE_003_A_SAYT_Validate_top_search_keys
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
    When we search for top10 keywords in the search box:
      |treadmill           |
      |dodgers             |
      |los angeles dodgers |
      |jordan 1            |
      |yeti                |
      |north face	       |
      |dumbbell            |
      |weights             |
      |basketball shoes	   |
      |carhartt            |
