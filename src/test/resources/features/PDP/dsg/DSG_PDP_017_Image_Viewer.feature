Feature: Regression_DSG_PDP_017_Image_Viewer
  Background: open page
    Given we are on "womensHoodies" page

  @PDP
  @PDP_mobile
  @PDP_mobile_ios
  @Regression
  @PDP_017
  Scenario: Regression_DSG_PDP_017_Image_Viewer
    When we add cookies to block medalia popup:
      |BlockedTags|Medallia|
    Given we are on "womensHoodies" page
    And we wait for 10 seconds
    And we click on the first product in search grid
    And we click on the product image
    And we wait for 3 seconds
    And we validate the image viewer
    Then we click close
