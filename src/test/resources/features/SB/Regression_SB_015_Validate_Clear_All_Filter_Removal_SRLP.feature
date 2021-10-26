Feature: Regression_SB_015_Validate_Clear_All_Filter_Removal_SRLP

  @SB_Smoke
  @SB_Regression
  @SB_015

Scenario Outline: Regression_SB_015_Validate_Clear_All_Filter_Removal_SRLP
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we search for "<keyWord>" keyword in the search box
  And we wait for 10 seconds
  And we filter by brand name "<brandName>" and validate clear all function
Examples:
  |brandName|keyWord|
  |Lifetime     |kayak  |

    @SB_Smoke_Zeta
    @SB_015_Zeta
    @SB_Regression_Zeta
    #

  Scenario Outline: Regression_SB_015_Validate_Clear_All_Filter_Removal_SRLP
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we filter by brand name "<brandName>" and validate clear all function
    Examples:
      |brandName|keyWord|
      |Lifetime     |kayak  |

  @SB_Smoke_mobile
  @SB_Regression_mobile
  @SB_015_mobile

  Scenario Outline: Regression_SB_015_Validate_Clear_All_Filter_Removal_SRLP
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we filter by brand name "<brandName>" and validate clear all function on mobile
    Examples:
      |brandName|keyWord|
      |Lifetime |kayak  |

  @SB_Smoke_Zeta_mobile
  @SB_015_Zeta_mobile
  @SB_Regression_Zeta_mobile

  Scenario Outline: Regression_SB_015_Validate_Clear_All_Filter_Removal_SRLP
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we filter by brand name "<brandName>" and validate clear all function on mobile
    Examples:
      |brandName|keyWord|
      |Lifetime |kayak  |

            ####_Golf_Galaxy_#####

    @SB_GG_Smoke
    @SB_GG_Regression
    @SB_GG_015

  Scenario Outline: Regression_SB_015_Validate_Clear_All_Filter_Removal_SRLP_GG
    Given we are on "dsg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "dsg" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we wait for 10 seconds
    And we filter by brand name "<brandName>" and validate clear all function
    Examples:
      |brandName|keyWord|
      |Lifetime |kayak  |

    @SB_GG_Smoke_mobile
    @SB_GG_Regression_mobile
    @SB_GG_015_mobile

  Scenario Outline: Regression_SB_015_Validate_Clear_All_Filter_Removal_SRLP_GG
    Given we are on "dsg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "dsg" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we wait for 10 seconds
    And we filter by brand name "<brandName>" and validate clear all function on mobile
    Examples:
      |brandName|keyWord|
      |Lifetime |kayak  |

       ####_Public_Lands_#####

    @SB_PL_Smoke
    @SB_PL_Regression
    @SB_PL_015

  Scenario Outline: Regression_SB_015_Validate_Clear_All_Filter_Removal_SRLP_PL
    Given we are on "pl" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
      |beta       |true    |
      Given we are on "pl" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we wait for 10 seconds
    And we filter by brand name "<brandName>" and validate clear all function
    Examples:
      |brandName|keyWord|
      |St. Croix |FISHING ROD  |

    @SB_PL_Smoke_mobile
    @SB_PL_Regression_mobile
    @SB_PL_015_mobile

  Scenario Outline: Regression_SB_015_Validate_Clear_All_Filter_Removal_SRLP_PL
    Given we are on "pl" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
      |beta       |true    |
      Given we are on "pl" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we wait for 10 seconds
    And we filter by brand name "<brandName>" and validate clear all function on mobile
    Examples:
      |brandName|keyWord|
      |St. Croix |FISHING ROD  |

    @SB_PL_Smoke_Zeta
    @SB_PL_015_Zeta
    @SB_PL_Regression_Zeta

  Scenario Outline: Regression_SB_015_Validate_Clear_All_Filter_Removal_SRLP_PL
    Given we are on "pl_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
      |public|lands|
    Given we are on "pl_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we filter by brand name "<brandName>" and validate clear all function
    Examples:
      |brandName|keyWord|
      |St. Croix |FISHING ROD  |

    @SB_PL_Smoke_Zeta_mobile
    @SB_PL_015_Zeta_mobile
    @SB_PL_Regression_Zeta_mobile

  Scenario Outline: Regression_SB_015_Validate_Clear_All_Filter_Removal_SRLP_PL
    Given we are on "pl_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
      |public|lands|
    Given we are on "pl_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we filter by brand name "<brandName>" and validate clear all function on mobile
    Examples:
      |brandName|keyWord|
      |St. Croix |FISHING ROD  |
