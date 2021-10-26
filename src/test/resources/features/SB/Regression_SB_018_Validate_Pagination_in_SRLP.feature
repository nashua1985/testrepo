Feature: Regression_SB_018_Validate_Pagination_in_SRLP

  @SB_Regression
  @SB_018
  @SB_Regression_mobile
  @SB_018_mobile

Scenario Outline: Regression_SB_018_Validate_Pagination_in_SRLP-Page_clicking
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we search for "<keyWord>" keyword in the search box
  And we wait for 10 seconds
  And we validate pagination on SRLP-PLP by clicking page numbers

  Examples:
  |keyWord |
  |yeti    |

  @SB_Regression
  @SB_018
  @SB_018_arrow
  @SB_Regression_mobile
  @SB_018_mobile
Scenario Outline: Regression_SB_018_Validate_Pagination_in_SRLP-Arrow_clicking
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we search for "<keyWord>" keyword in the search box
  And we validate pagination on SRLP-PLP by clicking arrows
 Examples:
  |keyWord |
  |yeti    |

      @SB_018_Zeta
      @SB_Regression_Zeta
      @SB_018_Zeta_mobile
      @SB_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_018_Validate_Pagination_in_SRLP-Page_clicking
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we validate pagination on SRLP-PLP by clicking page numbers

    Examples:
      |keyWord |
      |yeti    |

      @SB_018_Zeta
      @SB_Regression_Zeta
      @SB_018_Zeta_mobile
      @SB_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_018_Validate_Pagination_in_SRLP-Arrow_clicking
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we validate pagination on SRLP-PLP by clicking arrows
    Examples:
      |keyWord |
      |yeti    |

            ####_Golf_Galaxy_#####
    @SB_GG_Regression
    @SB_GG_018
    @SB_GG_Regression_mobile
    @SB_GG_018_mobile

  Scenario Outline: Regression_SB_018_Validate_Pagination_in_SRLP-Page_clicking_GG
    Given we are on "gg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we wait for 10 seconds
    And we validate pagination on SRLP-PLP by clicking page numbers

    Examples:
      |keyWord |
      |grip    |

    @SB_GG_Regression
    @SB_GG_018
    @SB_GG_018_arrow
    @SB_GG_Regression_mobile
    @SB_GG_018_mobile
  Scenario Outline: Regression_SB_018_Validate_Pagination_in_SRLP-Arrow_clicking_GG
    Given we are on "gg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we validate pagination on SRLP-PLP by clicking arrows
    Examples:
      |keyWord |
      |grip    |
####_Public_Lands_#####
    @SB_PL_Regression
    @SB_PL_018
    @SB_PL_Regression_mobile
    @SB_PL_018_mobile

  Scenario Outline: Regression_SB_018_Validate_Pagination_in_SRLP-Page_clicking_PL
    Given we are on "pl" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
      |beta       |true    |
    Given we are on "pl" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we wait for 10 seconds
    And we validate pagination on SRLP-PLP by clicking page numbers
    Examples:
      |keyWord |
      |FISHING ROD     |

    @SB_PL_Regression
    @SB_PL_018
    @SB_PL_018_arrow
    @SB_PL_Regression_mobile
    @SB_PL_018_mobile
  Scenario Outline: Regression_SB_018_Validate_Pagination_in_SRLP-Arrow_clicking_PL
    Given we are on "pl" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
      |beta       |true    |
    Given we are on "pl" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we validate pagination on SRLP-PLP by clicking arrows
    Examples:
      |keyWord |
      |FISHING ROD     |

    @SB_PL_018_Zeta
    @SB_PL_Regression_Zeta
    @SB_PL_018_Zeta_mobile
    @SB_PL_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_018_Validate_Pagination_in_SRLP-Page_clicking_PL_Zeta
    Given we are on "pl_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
      |public|lands|
    Given we are on "pl_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we validate pagination on SRLP-PLP by clicking page numbers
    Examples:
      |keyWord |
      |FISHING ROD     |

    @SB_PL_018_Zeta
    @SB_PL_Regression_Zeta
    @SB_PL_018_Zeta_mobile
    @SB_PL_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_018_Validate_Pagination_in_SRLP-Arrow_clicking_PL_Zeta
    Given we are on "pl_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
      |public|lands|
    Given we are on "pl_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we validate pagination on SRLP-PLP by clicking arrows
    Examples:
      |keyWord |
      |FISHING ROD     |
