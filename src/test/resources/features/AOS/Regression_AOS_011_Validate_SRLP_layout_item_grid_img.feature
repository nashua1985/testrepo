Feature: Regression_AOS_011_Validate_SRLP_layout_item_grid_img

@AOS_Regression
@AOS_011

Scenario Outline: Regression_AOS_011_Validate_SRLP_layout_item_grid_img
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  And we search for "<keyWord>" keyword in the search box
  And we validate srlp page layout, image and item count
  Examples:
  |keyWord |
  |COOLING TOWELS    |
