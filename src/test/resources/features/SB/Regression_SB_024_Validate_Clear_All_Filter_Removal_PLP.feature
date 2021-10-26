Feature: Regression_SB_024_Validate_Clear_All_Filter_Removal_PLP

    @SB_Regression
    @SB_024

  Scenario Outline: Regression_SB_024_Validate_Clear_All_Filter_Removal_PLP
    Given we are on "dsgKayakFamily" page
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "dsgKayakFamily" page
    And we filter by brand name "<brandName>" and validate clear all function
    Examples:
      |brandName|
      |Lifetime |

    @SB_024_Zeta
    @SB_Regression_Zeta

  Scenario Outline: Regression_SB_024_Validate_Clear_All_Filter_Removal_PLP
    Given we are on "dsgKayakFamily_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsgKayakFamily_zeta" page
    And we filter by brand name "<brandName>" and validate clear all function
    Examples:
      |brandName|
      |Lifetime |

    @SB_Regression_mobile
    @SB_024_mobile

  Scenario Outline: Regression_SB_024_Validate_Clear_All_Filter_Removal_PLP
    Given we are on "dsgKayakFamily" page
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "dsgKayakFamily" page
    And we filter by brand name "<brandName>" and validate clear all function on mobile
    Examples:
      |brandName|
      |Lifetime |

    @SB_024_Zeta_mobile
    @SB_Regression_Zeta_mobile

  Scenario Outline: Regression_SB_024_Validate_Clear_All_Filter_Removal_PLP
    Given we are on "dsgKayakFamily_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsgKayakFamily_zeta" page
    And we filter by brand name "<brandName>" and validate clear all function on mobile
    Examples:
      |brandName|
      |Lifetime |

                            ####_Golf_Galaxy_#####

    @SB_GG_Regression
    @SB_GG_024
  Scenario Outline: Regression_SB_024_Validate_Clear_All_Filter_Removal_PLP_GG
    Given we are on "gg_drivers" page
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg_drivers" page
    And we filter by brand name "<brandName>" and validate clear all function
    Examples:
      |brandName|
      |Cobra    |

    @SB_GG_Regression_mobile
    @SB_GG_024_mobile
  Scenario Outline: Regression_SB_024_Validate_Clear_All_Filter_Removal_PLP_GG
    Given we are on "gg_drivers" page
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg_drivers" page
    And we filter by brand name "<brandName>" and validate clear all function on mobile
    Examples:
      |brandName|
      |Cobra    |