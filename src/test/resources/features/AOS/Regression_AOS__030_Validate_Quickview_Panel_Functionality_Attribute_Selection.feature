Feature: Regression_AOS_030_Validate_Quickview_Panel_Functionality_Attribute_Selection

@AOS_Smoke
@AOS_Regression
@AOS_030

Scenario: Regression_AOS_030_Validate_Quickview_Panel_Functionality_Attribute_Selection
  Given we are on "aos_dsgKayakFamily" page
  When we enter "42" and click submit
  And we validate attribute selection in quick view
  And we click on addToCart button
  And we should see containing text "PLEASE SELECT Color"
  #And we should see containing text "PLEASE SELECT Delivery OR Pickup"
  And we wait for 3 seconds
  And we validate availability shipToMe
  And we should see containing text "Item Selected"
  And we click on addToCart button
  And we wait for 5 seconds
  And we should see containing text "Keep Shopping"
  And we should see containing text "View Cart"
