Feature: Regression_ATHLETE_001_API_HomR_Calls_for_header_should_return_a_200_response
  @ATHLETE_001
  @ATHLETE_Regression
  @ATHLETE_Smoke_api
  @ATHLETE_Smoke_run1
  Scenario: Regression_ATHLETE_001_API_HomR_Calls_for_header_should_return_a_200_response
    When we send api request to get a status code:
      |https://www.dickssportinggoods.com/dcsg-ngx-home/homr/v2/api/v4/content?pageType=header&name=default&chain=dsg|200|200|
      |https://www.publiclands.com/dcsg-ngx-home/homr/v2/api/v4/content?pageType=header&name=default&chain=pl        |200|200|

