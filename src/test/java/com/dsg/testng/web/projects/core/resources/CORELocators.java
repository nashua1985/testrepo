package com.dsg.testng.web.projects.core.resources;

import org.openqa.selenium.By;

public class CORELocators {

  public static By AddRewardCertificates =
      By.id("__tab_ctl00_cph_content_middle_ctl01_tb_add_rewards_certificate");

  public static By PromoCode =
      By.name("ctl00$cph_content_middle$ctl01$tb_add_rewards_certificate$txt_promotion_code");

  public static By ExpirationDate =
      By.name("ctl00$cph_content_middle$ctl01$tb_add_rewards_certificate$txtExpirationDate");

  public static By Denomination =
      By.name("ctl00$cph_content_middle$ctl01$tb_add_rewards_certificate$txtDenomination");

  public static By PointsRemoved =
      By.name("ctl00$cph_content_middle$ctl01$tb_add_rewards_certificate$txtPointsRemoved");

  public static By ReasonForReward =
      By.name("ctl00$cph_content_middle$ctl01$tb_add_rewards_certificate$txtReason");

  public static By CreateRewardCertificate =
      By.id("ctl00_cph_content_middle_ctl01_tb_add_rewards_certificate_butCreateReward");

  public static By RewardExistsBanner =
      By.xpath(
          "//*[@class = 'ui-icon ui-icon-alert' and contains(text(), 'active reward detail')]");
}
