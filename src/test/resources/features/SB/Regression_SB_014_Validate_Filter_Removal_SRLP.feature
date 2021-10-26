Feature: Regression_SB_014_Validate_Filter_Removal_SRLP

  @SB_Regression
  @ProdSupportSmoke
  @SB_014

Scenario Outline: Regression_SB_014_Validate_Filter_Removal_SRLP
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we search for "<keyWord>" keyword in the search box
#Reusing step definition from SB_023, since logic same as for PLP
  And we wait for 10 seconds
  And we filter by brand name "<brandName>"
Examples:
  |brandName|keyWord|
  |Lifetime |kayak  |

@SB_014_Zeta
@SB_Regression_Zeta
  Scenario Outline: Regression_SB_014_Validate_Filter_Removal_SRLP
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    And we search for "<keyWord>" keyword in the search box
#Reusing step definition from SB_023, since logic same as for PLP
    And we filter by brand name "<brandName>"
    Examples:
      |brandName|keyWord|
      |Lifetime |kayak  |

  @SB_Regression_mobile
  @SB_014_mobile

  Scenario Outline: Regression_SB_014_Validate_Filter_Removal_SRLP
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
#Reusing step definition from SB_023, since logic same as for PLP
    And we filter by brand name "<brandName>" on mobile
    Examples:
      |brandName|keyWord|
      |Lifetime |kayak  |

  @SB_014_Zeta_mobile
  @SB_Regression_Zeta_mobile

  Scenario Outline: Regression_SB_014_Validate_Filter_Removal_SRLP
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    And we search for "<keyWord>" keyword in the search box
#Reusing step definition from SB_023, since logic same as for PLP
    And we filter by brand name "<brandName>" on mobile
    Examples:
      |brandName|keyWord|
      |Lifetime |kayak  |

        ####_Golf_Galaxy_#####

    @SB_GG_Regression
    @SB_GG_014

  Scenario Outline: Regression_SB_014_Validate_Filter_Removal_SRLP_GG
    Given we are on "gg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
#Reusing step definition from SB_023, since logic same as for PLP
    And we wait for 10 seconds
    And we filter by brand name "<brandName>"
    Examples:
      |brandName|keyWord  |
      |empty    |push cart|

    @SB_GG_Regression_mobile
    @SB_GG_014_mobile

  Scenario Outline: Regression_SB_014_Validate_Filter_Removal_SRLP_GG
    Given we are on "gg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
#Reusing step definition from SB_023, since logic same as for PLP
    And we wait for 10 seconds
    And we filter by brand name "<brandName>" on mobile
    Examples:
      |brandName|keyWord  |
      |empty    |push cart|

        ####_Public_Lands_#####

    @SB_PL_Regression
    @SB_PL_014

  Scenario Outline: Regression_SB_014_Validate_Filter_Removal_SRLP_PL
    Given we are on "pl" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
      |beta       |true    |
    Given we are on "pl" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
#Reusing step definition from SB_023, since logic same as for PLP
    And we wait for 10 seconds
    And we filter by brand name "<brandName>"
    Examples:
      |brandName|keyWord     |
      |empty    |FISHING ROD |

    @SB_PL_Regression_mobile
    @SB_PL_014_mobile

  Scenario Outline: Regression_SB_014_Validate_Filter_Removal_SRLP_PL
    Given we are on "pl" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
      |beta       |true    |
      Given we are on "pl" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
#Reusing step definition from SB_023, since logic same as for PLP
    And we wait for 10 seconds
    And we filter by brand name "<brandName>" on mobile
    Examples:
      |brandName|keyWord  |
      |St. Croix|FISHING ROD |

    @SB_PL_014_Zeta
    @SB_PL_Regression_Zeta
  Scenario Outline: Regression_SB_014_Validate_Filter_Removal_SRLP_PL_Zeta
    Given we are on "pl_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
      |public|lands|
    Given we are on "pl_zeta" page
    And we search for "<keyWord>" keyword in the search box
#Reusing step definition from SB_023, since logic same as for PLP
    And we filter by brand name "<brandName>"
    Examples:
      |brandName|keyWord|
      |St. Croix |FISHING ROD  |

    @SB_PL_014_Zeta_mobile
    @SB_PL_Regression_Zeta_mobile

  Scenario Outline: Regression_SB_014_Validate_Filter_Removal_SRLP
    Given we are on "pl_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "pl_zeta" page
    And we search for "<keyWord>" keyword in the search box
#Reusing step definition from SB_023, since logic same as for PLP
    And we filter by brand name "<brandName>" on mobile
    Examples:
      |brandName|keyWord|
      |St. Croix |FISHING ROD  |
