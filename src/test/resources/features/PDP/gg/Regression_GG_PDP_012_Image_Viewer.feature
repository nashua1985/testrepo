Feature: Regression_GG_PDP_012_Image_Viewer
  Background: open page
    Given we are on "yetiBrandGG" page

  @PDP_GG
  @PDP_mobile
  @PDP_mobile_ios
  @Regression
  @PDP_012
  Scenario: Regression_GG_PDP_012_Image_Viewer
    And we click on the first product in search grid
    And we click on the product image
    And we wait for 3 seconds
    And we validate the image viewer
    Then we click close
