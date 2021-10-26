Feature: Smoke_SP_006_Verify_Users_are_able_to_Resend_confirmation
  Background: open page
    Given we are on "oktahub" page

@SP
@Smoke
@Regression
@SP_006
Scenario Outline: Smoke_SP_006_Verify_Users are able to Resend confirmation
  When we login to Solepanel username "<username>" password "<password>"
  When users search for Order using phone number "<phone_number>" in Order Look Up container
  And users click on Resend confirmation link in Solepanel Order details page
  Then users should be able to view,click,close,Return to Order or Resend Order confirmation

  Examples:
    |username	| password	|phone_number	|
    |Lakshmi.Haritheertham@dcsg.com|Iamindu14?|412-877-4784|
  