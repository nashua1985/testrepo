Feature: Regression_ATHLETE_007_API_Ticker_HomR_should_return_a_200_response
  @ATHLETE_007
  @ATHLETE_Regression
  @ATHLETE_Smoke_api
@ATHLETE_Smoke_run1
  Scenario: Regression_ATHLETE_007_API_Ticker_HomR_should_return_a_200_response
    When we send api request to get a status code:
      |https://www.dickssportinggoods.com/dcsg-ngx-home/homr/v2/api/v4/content?pageType=ticker&name=default&chain=dsg|200|200|

