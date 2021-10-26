Feature: Regression_SB_028_Validate_Quickview_for_plp


@SB_Smoke
@SB_Regression

@SB_028

  #all items should have addToCartButton QuickView
Scenario Outline: Regression_SB_028_Validate_Quickview_for_plp
  Given we are on "dsgKayakFamily" page
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
 Given we are on "dsgKayakFamily" page
  And we validate addToCart quick view by filtering "<brandName>"
Examples:
  |brandName|
  |Lifetime     |
#  |Nike     |

#    @SB_Smoke_Zeta
#    @SB_028_Zeta
#    @SB_Regression_Zeta


  #all items should have addToCartButton QuickView
  Scenario Outline: Regression_SB_028_Validate_Quickview_for_plp
    Given we are on "dsgHatsFamily_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsgHatsFamily_zeta" page
    And we validate addToCart quick view by filtering "<brandName>"
    Examples:
      |brandName|
      |Lifetime     |
#  |Nike     |

    @SB_Smoke_mobile
    @SB_Regression_mobile
    @SB_028_mobile

  #all items should have addToCartButton QuickView
  Scenario Outline: Regression_SB_028_Validate_Quickview_for_plp
    Given we are on "dsgKayakFamily" page
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
 Given we are on "dsgKayakFamily" page
    And we validate addToCart quick view by filtering "<brandName>" on mobile
    Examples:
      |brandName|
      |Lifetime |
#  |Nike     |

#    @SB_Smoke_Zeta_mobile
#    @SB_028_Zeta_mobile
#    @SB_Regression_Zeta_mobile

  #all items should have addToCartButton QuickView
  Scenario Outline: Regression_SB_028_Validate_Quickview_for_plp
    Given we are on "dsgHatsFamily_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsgHatsFamily_zeta" page
    And we validate addToCart quick view by filtering "<brandName>" on mobile
    Examples:
      |brandName|
      |Lifetime |
#  |Nike     |