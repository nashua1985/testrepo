Feature: Smoke_SP_003_Verify_Users_can_view_click_close_Whats_new_link
  Background: open page
    Given we are on "oktahub" page
@SP
@Smoke
@Regression
@SP_003
Scenario Outline: Smoke_SP_003_Verify_Users_can_view_click_close_Whats_new_link
  When we login to Solepanel username "<username>" password "<password>"
  And  user click on Whats_new link in Solepanel
  And  user should be able to view,click and close Whats-new link


    Examples:
      |username	| password	|
      |Lakshmi.Haritheertham@dcsg.com|Iamindu14?|
