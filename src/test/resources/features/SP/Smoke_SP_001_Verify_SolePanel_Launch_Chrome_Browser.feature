Feature: Smoke_SP_001_Verify_SolePanel_Launch_HomePage_Header_Chrome_Browser
  Background: open page
    Given we are on "oktahub" page

@SP
@Smoke
@Regression
@SP_001
Scenario Outline: Smoke_SP_001_Verify_SolePanel_Launch_HomePage_Header_Chrome_Browser
    When we login to Solepanel username "<username>" password "<password>"
    When users click on Solepanel and Header Links in Sole Panel home page in Chrome Browser

  Examples:
    |username	| password	|
    |Lakshmi.Haritheertham@dcsg.com|Iamindu14?|
