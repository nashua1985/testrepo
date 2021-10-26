package com.dsg.testng.android.locators;

import org.openqa.selenium.By;

public class SupportAndFeedbackLocators {
  // public By Provide_Feedback_Button =
  // By.xpath("//*[@resource-id='dsgui.android:id/snf_feedback_button']");
  public By Provide_Feedback_Button = By.id("dsgui.android:id/snf_feedback_button");
  public By Report_Problem_Button =
      By.xpath("//*[@resource-id='dsgui.android:id/snf_problem_button']");
  public By toolbar = By.xpath("//*[@resource-id='dsgui.android:id/toolbar']");
  public By feedback_detail_section =
      By.xpath("//*[@resource-id='dsgui.android:id/feedback_detail_section']");
  public By Your_Feedback_Matters_TextView =
      By.xpath("//*[@resource-id='dsgui.android:id/heading_text_view']");
  public By Channel_Spinner = By.xpath("//*[@resource-id='dsgui.android:id/snf_channel']");
  public By Category_Spinner = By.xpath("//*[@resource-id='dsgui.android:id/snf_category']");
}
