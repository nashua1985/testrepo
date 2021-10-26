Feature: Regression_ATHLETE_002_API_HomR_Calls_for_footer_should_return_a_200_response
  @ATHLETE_002
  @ATHLETE_Regression
  @ATHLETE_Smoke_api
@ATHLETE_Smoke_run1
  Scenario: Regression_ATHLETE_002_API_HomR_Calls_for_footer_should_return_a_200_response
    When we send api request to get a status code:
      |https://www.dickssportinggoods.com/dcsg-ngx-home/homr/v2/api/v4/content?pageType=footer&name=default&chain=dsg|200|200|
      |https://www.publiclands.com/dcsg-ngx-home/homr/v2/api/v4/content?pageType=footer&name=default&chain=pl        |204|200|

