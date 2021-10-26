Feature: Regression_AOS_023_Validate_Filter_Removal_PLP

@AOS_Regression
@AOS_023

  Scenario Outline: Regression_AOS_023_Validate_Filter_Removal_PLP
Given we are on "aos_dsgKayakFamily" page
  When we enter "42" and click submit
    And we filter by brand name "<brandName>"
    Examples:
      |brandName|
      |Lifetime |