Feature: Smoke_SP_005_Verify_Order_Look_Up_with_Order_number_Phone_Number_Email

Background: open page
  Given we are on "oktahub" page

@SP
@Smoke
@Regression
@SP_005
Scenario Outline: Smoke_SP_005_Verify_Order_Look_Up_with_Order_number
    When we login to Solepanel username "<username>" password "<password>"
	And users search for Order using order number "<order_number>" in Order Look Up container
  	Then users should be navigated to Athlete Summary Page of the order number "<order_number>"
    When  users search for an Order using phone number "<phone_number>" in Order Look Up container
    Then users should be navigated to Athlete Summary Page of the Phone_Number "<phone_number>"
    When users search for Order using email "<email>" in Order Look Up container
    Then users should be navigated to Athlete Summary Page of the email "<email>"

  Examples:
    |username	| password	|order_number	|phone_number	|email	|
    |Lakshmi.Haritheertham@dcsg.com|Iamindu14?|10350024936	|412-877-4784|jaynagel@gmail.com|