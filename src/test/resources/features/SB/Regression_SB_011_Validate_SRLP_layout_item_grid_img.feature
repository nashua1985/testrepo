Feature: Regression_SB_011_Validate_SRLP_layout_item_grid_img

@SB_Regression
@ProdSupportSmoke
@SB_011
@SB_Regression_mobile
@SB_011_mobile

Scenario Outline: Regression_SB_011_Validate_SRLP_layout_item_grid_img
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
  And we search for "<keyWord>" keyword in the search box
  And we validate srlp page layout, image and item count
  Examples:
  |keyWord |
  |COOLING TOWELS    |

    @SB_011_Zeta
    @SB_Regression_Zeta
    @SB_011_Zeta_mobile
    @SB_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_011_Validate_SRLP_layout_item_grid_img
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we validate srlp page layout, image and item count
    Examples:
      |keyWord |
      |COOLING TOWELS    |

    ####_Golf_Galaxy_#####
    @SB_GG_Regression
    @SB_GG_011
    @SB_GG_Regression_mobile
    @SB_GG_011_mobile

  Scenario Outline: Regression_SB_011_Validate_SRLP_layout_item_grid_img_GG
    Given we are on "gg" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we validate srlp page layout, image and item count
    Examples:
      |keyWord  |
      |push cart|

       ####_Public_Lands_#####
    @SB_PL_Regression
    @SB_PL_011
    @SB_PL_Regression_mobile
    @SB_PL_011_mobile
  Scenario Outline: Regression_SB_011_Validate_SRLP_layout_item_grid_img_PL
    Given we are on "pl" page
    And we wait for 10 seconds
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
      |beta       |true    |
    Given we are on "pl" page
    And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we validate srlp page layout, image and item count
    Examples:
      |keyWord     |
      |FISHING ROD |

    @SB_PL_011_Zeta
    @SB_PL_Regression_Zeta
    @SB_PL_011_Zeta_mobile
    @SB_PL_Regression_Zeta_mobile
  Scenario Outline: Regression_SB_011_Validate_SRLP_layout_item_grid_img_PL_Zeta
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
      |public|lands|
    Given we are on "dsg_zeta" page
    And we search for "<keyWord>" keyword in the search box
    And we validate srlp page layout, image and item count
    Examples:
      |keyWord |
      |FISHING ROD |
