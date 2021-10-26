Feature: Regression_AOS_015_Validate_Clear_All_Filter_Removal_SRLP

  @AOS_Smoke
  @AOS_Regression
  @AOS_015

Scenario Outline: Regression_AOS_015_Validate_Clear_All_Filter_Removal_SRLP
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  And we search for "<keyWord>" keyword in the search box
  And we wait for 10 seconds
  And we filter by brand name "<brandName>" and validate clear all function
Examples:
  |brandName|keyWord|
  |Lifetime     |kayak  |
