Feature: Regression_AOS_024_Validate_Clear_All_Filter_Removal_PLP

    @AOS_Regression
    @AOS_024

  Scenario Outline: Regression_AOS_024_Validate_Clear_All_Filter_Removal_PLP
Given we are on "aos_dsgKayakFamily" page
  When we enter "42" and click submit
    And we filter by brand name "<brandName>" and validate clear all function
    Examples:
      |brandName|
      |Lifetime |
