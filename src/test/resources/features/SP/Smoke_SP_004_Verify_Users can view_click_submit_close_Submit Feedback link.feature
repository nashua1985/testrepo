Feature: Smoke_SP_004_Verify_Users_can_view_click_submit_close_Submit_Feedback_link
  Background: open page
    Given we are on "oktahub" page
@SP
@Smoke
@Regression
@SP_004
Scenario Outline: Smoke_SP_004_Verify_Users_can_view_click_submit_close_Submit_Feedback_link
  When we login to Solepanel username "<username>" password "<password>"
  And users click on Submit Feedback link in Solepanel
  Then users should be able to view,click,submit feedback and close Submit Feedback link.


    Examples:
      |username	| password	|
      |Lakshmi.Haritheertham@dcsg.com|Iamindu14?|