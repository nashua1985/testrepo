Feature: Regression_SB_032_041_Validate_Quantity_Change_and_Item_Availability

@SB_Smoke
@SB_Regression
@SB_032_041

  #Make sure, item is not 'see price in cart' only. Price will not appear on quick view or pdp
Scenario Outline: Regression_SB_032_041_Validate_Quantity_Change_and_Item_Availability
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
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

#    @SB_Smoke_Zeta
#    @SB_Regression_Zeta

#    @SB_032_041_Zeta
  #Make sure, item is not 'see price in cart' only. Price will not appear on quick view or pdp
  Scenario Outline: Regression_SB_032_041_Validate_Quantity_Change_and_Item_Availability
    Given we are on "dsg_zeta" page
    When we add cookies to access zeta:
      |zeta|true|
    Given we are on "dsg_zeta" page
    And we search for "<keyWord>" keyword in the search box
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
  #Excluding mobile for now, ios works, but android denies to click on ShipToMe options, need to work on it
#    @SB_Smoke_mobile
#    @SB_Regression_mobile
#    @SB_032_041_mobile
  #Make sure, item is not 'see price in cart' only. Price will not appear on quick view or pdp
  Scenario Outline: Regression_SB_032_041_Validate_Quantity_Change_and_Item_Availability
  Given we are on "dsg" page
  And we wait for 10 seconds
  When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
  Given we are on "dsg" page
  And we wait for 10 seconds
    And we search for "<keyWord>" keyword in the search box
    And we wait for 10 seconds
    And we click on first addToCart in search grid
    And we wait for 3 seconds
    And we validate availability shipToMe
    And we validate quantity calculation on mobile
#  And we should see containing text "Item Selected"
    And we click on addToCart button
      And we wait for 5 seconds
    And we should see containing text "Keep Shopping"
    And we should see containing text "View Cart"
#monitor
    Examples:
      |keyWord|
      |yeti   |