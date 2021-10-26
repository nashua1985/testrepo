Feature: Regression_DSG_PDP_013_ATC_Custom_Club
  Background: open page
    Given we are on "customDriver" page

  @PDP
  @Regression
  @PDP_013
  @Batch1
  Scenario: Regression_DSG_PDP_013_ATC_Custom_Club
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "customDriver" page
    And we wait for 10 seconds
    #And we click on the first product in search grid
    And we search for "Srixon ZX5 Custom Driver" keyword in the search box
    And we click on Add to Cart button
    And we wait for 5 seconds
    #Then we should see the customizer title
    # couldnt see the gender option in the first selected option , flow is different for different products
    And we select the gender "Women's" and the hand "Left"
    And we click Next in the customizer
    And we select the loft "9.5"
    And we click Next in the customizer
    And we select the shaft manufacturer "Fujikura"
    And we click Next in the customizer
    And we select the length "Men’s Standard"
    And we click Next in the customizer
    And we click Next in the customizer
    And we select the gripbrand "Lamkin"
    And we click Next in the customizer
    And we click Save Selections
    And we wait for 5 seconds
    Then we should see "Fujikura" on customize panel
    Then we should see "Lamkin" on customize panel
    Then we should see "LH" on customize panel
    Then we should see "9.5" on customize panel
    And we click on Add to Cart button
    And we click GO TO CART in safari
    Then we should see "1 item"


  @PDP_mobile
  @Smoke
  @Regression
  @PDP_013_mobile
  Scenario: Regression_PDP_013_ATC_Custom_Club
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "customDriver" page
    And we wait for 10 seconds
    And we click  Ship to me
    #And we click on the first product in search grid
    And we search for "Srixon ZX5 Custom Driver" keyword in the search box
    And we click on Add to Cart button
    And we wait for 5 seconds
    #Then we should see the customizer title
    # couldnt see the gender option in the first selected option , flow is different for different products
    And we select the gender "Women's" and the hand "Left"
    And we click Next in the customizer
    And we select the loft "9.5"
    And we click Next in the customizer
    And we select the shaft manufacturer "Fujikura"
    And we click Next in the customizer
    And we click Next in the customizer
    And we select the length "Men’s Standard"
    And we click Next in the customizer
    And we click Next in the customizer
    And we select the gripbrand "Lamkin"
    And we click Next in the customizer
    And we click Next in the customizer
    And we click Next in the customizer
    And we click Next in the customizer
    And we click Save Selections
    And we wait for 5 seconds
    Then we should see "Fujikura"
    Then we should see "Lamkin"
    Then we should see "LH"
    Then we should see "9.5"
    And we click on Add to Cart button
    And we click GO TO CART
    Then we should see "1 item"


