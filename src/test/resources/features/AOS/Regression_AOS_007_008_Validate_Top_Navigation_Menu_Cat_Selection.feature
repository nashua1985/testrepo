Feature: Regression_AOS_007_008_Validate_Top_Navigation_Menu_Cat_Selection

#@AOS_Smoke
#@AOS_Regression
#@AOS_007_008
#until new nav in place, old nav doesnt work with validation
  Scenario: Regression_AOS_007_008_Validate_Top_Navigation_Menu_Cat_Selection
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  And we should see Top Navigation Menu and child submenu