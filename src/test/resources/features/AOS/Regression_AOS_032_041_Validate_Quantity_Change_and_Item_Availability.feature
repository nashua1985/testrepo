Feature: Regression_AOS_032_041_Validate_Quantity_Change_and_Item_Availability

@AOS_Smoke
@AOS_Regression
@AOS_032_041

  #Make sure, item is not 'see price in cart' only. Price will not appear on quick view or pdp
Scenario Outline: Regression_AOS_032_041_Validate_Quantity_Change_and_Item_Availability
  Given we are on "dsg_aos" page
  When we enter "42" and click submit
  And we search for "<keyWord>" keyword in the search box
  And we wait for 10 seconds
  And we click on first addToCart in search grid
  And we wait for 3 seconds
  And we validate availability shipToMe
  And we validate quantity calculation
#  And we should see containing text "Item Selected"
  And we click on addToCart button
  And we should see containing text "Keep Shopping"
  And we should see containing text "View Cart"
#monitor
  Examples:
  |keyWord|
  |yeti   |
