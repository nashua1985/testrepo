Feature: Regression_DSG_PDP_011_ATC_Custom_Jersey
  Background: open page
    Given we are on "customJersey" page

  @PDP
  @Regression
  @PDP_011
  @Batch1
  Scenario: Regression_DSG_011_ATC_Custom_Jersey
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "customJersey" page
    And we wait for 10 seconds
    And we click  Ship to me
    And we click on the first product in search grid
    And we select Size 52
    And we click on Add to Cart button
    And we wait for 5 seconds
    Then we should see the customizer title
    #And we scroll down in the customizer
#  need to work on this
    And we type "DOE" in Player Name field and "99" in the Player Number field
    And we click Next in the customizer
    And we click Save Selections
    And we wait for 5 seconds
    Then we should see "DOE 99"
    And we click on Add to Cart button
    And we click GO TO CART in safari
    Then we should see "1 item"

  @PDP_mobile
  @Smoke
  @Regression
  @PDP_011_mobile
  Scenario: Regression_PDP_011_ATC_Custom_Jersey
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "customJersey" page
    And we wait for 10 seconds
    And we click  Ship to me
    And we click on the first product in search grid
    And we select Size 52
    And we click on Add to Cart button
    And we wait for 5 seconds
    And we type "DOE" in Player Name field and "99" in the Player Number field for mobile
    And we click Next in the customizer
    And we click Save Selections
    And we wait for 5 seconds
    Then we should see "DOE 99"
    And we click on Add to Cart button
    And we click GO TO CART
    Then we should see "1 item"


