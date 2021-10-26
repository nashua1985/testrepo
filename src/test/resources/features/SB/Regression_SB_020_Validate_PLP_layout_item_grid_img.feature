Feature: Regression_SB_020_Validate_PLP_layout_item_grid_img
#note: pinned item maybe a dup for regular item. That's why its hard to get exact count

@SB_Regression
@ProdSupportSmoke
@SB_020
@SB_Regression_mobile
@SB_020_mobile

Scenario: Regression_SB_020_Validate_PLP_layout_item_grid_img
  Given we are on "womenSweatersFamily" page
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "womenSweatersFamily" page
  And we validate plp page layout, image and item count

  @SB_020_Zeta
  @SB_Regression_Zeta
  @SB_020_Zeta_mobile
  @SB_Regression_Zeta_mobile
  Scenario: Regression_SB_020_Validate_PLP_layout_item_grid_img
    Given we are on "womenSweatersFamily_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "womenSweatersFamily_zeta" page
    And we validate plp page layout, image and item count

                ####_Golf_Galaxy_#####

  @SB_GG_Regression
  @SB_GG_020
  @SB_GG_Regression_mobile
  @SB_GG_020_mobile

  Scenario: Regression_SB_020_Validate_PLP_layout_item_grid_img_GG
    Given we are on "gg_clubs_family" page
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "gg_clubs_family" page
    And we validate plp page layout, image and item count

                ####_Public_Lands_#####
#no family page yet for PL
#  @SB_PL_Regression
#  @SB_PL_020
#  @SB_PL_Regression_mobile
#  @SB_PL_020_mobile
#
#  Scenario: Regression_SB_020_Validate_PLP_layout_item_grid_img_PL
#    Given we are on "gg_clubs_family" page
#    When we add cookies to block medalia popup:
#      |BlockedTags|Medallia|
#    Given we are on "gg_clubs_family" page
#    And we validate plp page layout, image and item count