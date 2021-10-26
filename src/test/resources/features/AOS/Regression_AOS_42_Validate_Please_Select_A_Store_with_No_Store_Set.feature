Feature: Regression_AOS_42_Validate_Please_Select_A_Store_with_No_Store_Set

  @AOS_Regression
  @AOS_042
Scenario Outline: Regression_AOS_42_Validate_Please_Select_A_Store_with_No_Store_Set
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  And we search for "<keyWord>" keyword in the search box
  And we clear all filter and validate shipToMe and BOPIS not available
  And we click on first addToCart in search grid
  And we should see storePickup not available
  Examples:
  |keyWord   |
  |yeti      |