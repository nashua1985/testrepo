Feature: Regression_SB_030_Validate_Quickview_Panel_Functionality_Attribute_Selection

@SB_Smoke
@SB_Regression
@SB_030
  #Excluding mobile for now, ios works, but android denies to click on ShipToMe options, need to work on it
#  @SB_Smoke_mobile
#  @SB_Regression_mobile
#  @SB_030_mobile
Scenario: Regression_SB_030_Validate_Quickview_Panel_Functionality_Attribute_Selection
  Given we are on "dsgKayakFamily" page
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
 Given we are on "dsgKayakFamily" page
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

#  @SB_Smoke_Zeta
#  @SB_Regression_Zeta
#  @SB_030_Zeta
  Scenario: Regression_SB_030_Validate_Quickview_Panel_Functionality_Attribute_Selection
    Given we are on "dsgKayakFamily_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsgKayakFamily_zeta" page
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

