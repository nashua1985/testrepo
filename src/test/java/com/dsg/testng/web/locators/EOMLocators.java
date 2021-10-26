package com.dsg.testng.web.locators;

import org.openqa.selenium.By;

public class EOMLocators {

  public By EOMLoginUser = By.name("j_username");
  public By EOMLoginPassword = By.name("j_password");
  public By EOMLoginSubmitButton = By.id("button-1022-btnInnerEl");

  // menu button in upper left corner of EOM
  public By EOMHamburgerMenu = By.id("button-1013-btnIconEl");
  public By EOMFrame = By.id("uxiframe-1106-iframeEl");
  // public By EOMHamburgerMenu = By.xpath("//*[@id='button-1013-btnIconEl']");
  public By MainMenuOptions = By.id("mps_menusearch-1099-inputEl");

  // Search Orders Locators
  public By SearchOrders_SearchField = By.id("dataForm:listView1:coListFilterId:field440value1");
  public By SearchOrders_Apply = By.id("dataForm:listView1:coListFilterId:coListFilterIdapply");
  public By SearchOrders_ViewOrderDetials = By.xpath("//*[@id = 'dataForm:coList_View_btn_id']");
  public By SearchOrders_DropDown = By.id("dataForm:drop_down_page_ids_som");
  public By SearchOrders_DODFulfillmentFacility =
      By.id(
          "dataForm:dolinelistview_id:DOLineList_MainListTable:0:doLine_View_Fulfillment_Facility");
  // public By SearchOrders_CreateDOButton = By.id("dataForm:coViewAI_createDOBtn");
  public By SearchOrders_CreateDOButton = By.id("dataForm:coLViewAI_createDOButton");

  public By FirstLineItem = By.id("checkAll_c0_dataForm:coLineViewAdditionalListTable");

  // Store Orders Locators
  // public By StoreOrders_StoreSearch = By.id("dataForm:storeSearchId");
  public By StoreOrders_StoreSearch =
      By.id("dataForm:OrderListPage_entityListView:filter_order:field10value1");
  // public By StoreOrders_ApplyTop = By.id("dataForm:apply");
  public By StoreOrders_ApplyTop =
      By.id("dataForm:OrderListPage_entityListView:filter_order:filter_orderapply");
}
