Feature: Regression_AOS_020_Validate_PLP_layout_item_grid_img
#note: pinned item maybe a dup for regular item. That's why its hard to get exact count

@AOS_Regression
@AOS_020

Scenario: Regression_AOS_020_Validate_PLP_layout_item_grid_img
  Given we are on "aos_womenSweatersFamily" page
  When we enter "42" and click submit
  And we validate plp page layout, image and item count
