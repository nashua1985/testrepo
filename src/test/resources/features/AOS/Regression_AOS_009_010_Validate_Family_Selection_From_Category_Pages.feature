Feature: Regression_AOS_009_010_Validate_Family_Selection_From_Category_Pages

@AOS_Smoke
@AOS_Regression
@AOS_009_010
@AOS_009_010_sport

Scenario: Regression_AOS_009_010_Validate_Family_Selection_From_Category_Pages - Sport Cat
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  And we should see some family pages of sport category

@AOS_Smoke
@AOS_Regression
@AOS_009_010
@AOS_009_010_women
Scenario: Regression_AOS_009_010_Validate_Family_Selection_From_Category_Pages - Women Cat
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  And we should see some family pages of women category
