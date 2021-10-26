Feature: Regression_DSG_PDP_012_ATC_Custom_Helmet
  Background: open page
    Given we are on "customHelmet" page

  @PDP
  @Regression
  @PDP_012
  @Batch1
  @PDP_mobile
  Scenario: Regression_DSG_PDP_012_ATC_Custom_Helmet
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "customHelmet" page
    And we wait for 10 seconds
    And we click  Ship to me
    And we click on the first product in search grid
    And we click on Add to Cart button
    And we wait for 5 seconds
    #Then we should see the customizer title
    And we select the size "Medium" on customizer
    And we click Next in the customizer
    And we select the color Navy
    And we click Next in the customizer
    And we select the Facemask "S2BD-HS4"
    And we click Next in the customizer
    And we select the color Black on customizer
    And we click Next in the customizer
    And we click Save Selections
    And we wait for 5 seconds
    Then we should see "S2BD-HS4"
    Then we should see "Navy"
    #Then we should see "Black"
    And we click on Add to Cart button
    And we click GO TO CART in safari
    Then we should see "1 item"
