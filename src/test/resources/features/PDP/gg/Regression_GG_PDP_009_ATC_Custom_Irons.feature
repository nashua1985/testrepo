Feature: Regression_GG_PDP_009_ATC_Custom_Irons
  Background: open page
    Given we are on "gg" page

  @PDP_GG
  @Regression
  @PDP_009
  @Batch1
  Scenario: Regression_GG_PDP_009_ATC_Custom_Irons
    And we search for "Srixon ZX4 Custom Irons" keyword in the search box
    And we click on Add to Cart button
    And we wait for 5 seconds
    Then we should see the customizer title
    And we select the hand "Left" and shaft material "Steel"
    And we click Next in the customizer
    And we select makeup "5-PW, UW, SW" and iron selection "5 iron"
    And we click Next in the customizer
    And we select the shaft manufacturer "KBS"
    And we click Next in the customizer
    And we select the length "Standard"
    And we click Next in the customizer
    And we select the lie as "Flat1"
    And we click Next in the customizer
    And we select the loft "1 Strong"
    And we click Next in the customizer
    And we click Next in the customizer
    And we select the first golf brand option and grip build "Standard"
    And we click Next in the customizer
    And we click Save Selections
    And we wait for 5 seconds
    Then we should see "Steel" on customize panel
    Then we should see "KBS" on customize panel
    Then we should see "Standard" on customize panel
    Then we should see "Flat1" on customize panel
    Then we should see "1 Strong" on customize panel
    And we click on Add to Cart button
    And we click GO TO CART in safari
    Then we should see "1 item"



  @PDP_mobile
  @Smoke
  @Regression
  @PDP_014_mobile
  Scenario: Regression_PDP_014_ATC_Custom_Irons
    #And we click on the first product in search grid
    And we search for "Srixon ZX4 Custom Irons" keyword in the search box
    And we click on Add to Cart button
    And we wait for 5 seconds
    Then we should see the customizer title
    And we select the hand "Left" and shaft material "Steel" for mobile
    And we click Next in the customizer
    And we select makeup "5-PW, UW, SW" and iron selection "5 iron" for mobile
    And we click Next in the customizer
    And we select the shaft manufacturer "KBS"
    And we click Next in the customizer
    And we click Next in the customizer
    And we select the length "Standard"
    And we click Next in the customizer
    And we select the lie as "Standard"
    And we click Next in the customizer
    And we select the loft "Standard"
    And we click Next in the customizer
    And we click Next in the customizer
    And we select the first golf brand option and grip build "Standard" for mobile
    And we click Next in the customizer
    And we click Next in the customizer
    And we click Save Selections
    And we wait for 5 seconds
    Then we should see "Steel"
    Then we should see "LH"
    Then we should see "KBS"
    Then we should see "Standard"
    And we click on Add to Cart button
    And we click GO TO CART
    Then we should see "1 item"

