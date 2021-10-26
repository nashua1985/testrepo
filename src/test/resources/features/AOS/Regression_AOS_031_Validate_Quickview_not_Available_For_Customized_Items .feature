Feature: Regression_AOS_031_Validate_Quickview_not_Available_For_Customized_Items


  @AOS_Smoke
  @AOS_Regression
  @AOS_031

Scenario Outline: Regression_AOS_031_Validate_Quickview_not_Available_For_Customized_Items
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  And we search for "<keyWord>" keyword in the search box
  And we should not see quickView addToCard button

Examples:
  |keyWord|
#  |personalized|
  |personalized golf balls  |