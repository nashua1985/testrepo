Feature: Regression_AOS_028_Validate_Quickview_for_plp


@AOS_Smoke
@AOS_Regression
@AOS_028

  #all items should have addToCartButton QuickView
Scenario Outline: Regression_AOS_028_Validate_Quickview_for_plp
  Given we are on "aos_dsgKayakFamily" page
  When we enter "42" and click submit
  And we validate addToCart quick view by filtering "<brandName>"
Examples:
  |brandName|
  |Lifetime     |
#  |Nike     |
