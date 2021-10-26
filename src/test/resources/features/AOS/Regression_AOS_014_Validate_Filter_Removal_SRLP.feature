Feature: Regression_AOS_014_Validate_Filter_Removal_SRLP

  @AOS_Regression
  @AOS_014

Scenario Outline: Regression_AOS_014_Validate_Filter_Removal_SRLP
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  And we search for "<keyWord>" keyword in the search box
#Reusing step definition from AOS_023, since logic same as for PLP
  And we wait for 10 seconds
  And we filter by brand name "<brandName>"
Examples:
  |brandName|keyWord|
  |Lifetime |kayak  |