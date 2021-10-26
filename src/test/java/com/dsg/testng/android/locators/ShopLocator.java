package com.dsg.testng.android.locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

public class ShopLocator {

  // TODO: Updates Performed
  // Removed . , % , 0, ', + , &
  // Removed duplicates FOOTWEARView, WOMENSView, MENSView, OUTDOOR_LIVINGView, APPARELView,
  // Learn_MoreView

  // SHOP BY SPORT CATEGORIES
  public By Shop_By_Sport_View = By.xpath("//*[@text='Shop By Sport']");
  public By Shop_By_Baseball = By.xpath("//*[@class='android.widget.Button'][@text='Baseball']");
  public By Shop_By_Menu = By.xpath("//*[@class='android.widget.Button'][1]");
  public By Shop_By_Basketball = By.xpath("//*[@class='android.widget.Button'][2]");
  public By Shop_By_Bikes_And_Cycling = By.xpath("//*[@class='android.widget.Button'][3]");
  public By Shop_By_Bowling = By.xpath("//*[@class='android.widget.Button'][4]");
  public By Shop_By_Boxing_And_MMA = By.xpath("//*[@class='android.widget.Button'][5]");
  public By Shop_By_Camping_And_Hiking = By.xpath("//*[@class='android.widget.Button'][6]");
  public By Shop_By_Cheerleading = By.xpath("//*[@class='android.widget.Button'][7]");
  public By Shop_By_Climbing = By.xpath("//*[@class='android.view.View'][@text='Climbing']");
  public By Shop_By_Cricket = By.xpath("//*[@class='android.view.View'][@text='Cricket']");
  public By Shop_By_Exercise_And_Fitness =
      By.xpath("//*[@class='android.widget.Button'][@text='Exercise & Fitness']");
  public By Shop_By_Field_Hockey =
      By.xpath("//*[@class='android.widget.Button'][@text='Field Hockey']");
  public By Shop_By_Fishing = By.xpath("//*[@class='android.widget.Button'][@text='Fishing']");
  public By Shop_By_Football = By.xpath("//*[@class='android.widget.Button'][@text='Football']");
  public By Shop_By_Golf = By.xpath("//*[@class='android.widget.Button'][@text='Golf']");
  public By Shop_By_Gymnastics =
      By.xpath("//*[@class='android.widget.Button'][@text='Gymnastics']");
  public By Shop_By_Handball = By.xpath("//*[@class='android.view.View'][@text='Handball']");
  public By Shop_By_Hockey = By.xpath("//*[@class='android.widget.Button'][@text='Hockey']");
  public By Shop_By_Hunting_And_Shooting =
      By.xpath("//*[@class='android.widget.Button'][@text='Hunting & Shooting']");
  public By Shop_By_Ice_Skating =
      By.xpath("//*[@class='android.widget.Button'][@text='Ice Skating']");
  public By Shop_By_Kayak_And_Paddle =
      By.xpath("//*[@class='android.widget.Button'][@text='Kayak & Paddle']");
  public By Shop_By_Lacrosse = By.xpath("//*[@class='android.widget.Button'][@text='Lacrosse']");
  public By Shop_By_Outdoor_Living =
      By.xpath("//*[@class='android.widget.Button'][@text='Outdoor Living']");
  public By Shop_By_Rec_Room_Games =
      By.xpath("//*[@class='android.widget.Button'][@text='Rec Room Games']");
  public By Shop_By_Rugby = By.xpath("//*[@class='android.widget.Button'][@text='Rugby']");
  public By Shop_By_Running = By.xpath("//*[@class='android.widget.Button'][@text='Running']");
  public By Shop_By_Skates_And_Scooters =
      By.xpath("//*[@class='android.widget.Button'][@text='Skates & Scooters']");
  public By Shop_By_Soccer = By.xpath("//*[@class='android.widget.Button'][@text='Soccer']");
  public By Shop_By_Softball = By.xpath("//*[@class='android.widget.Button'][@text='Softball']");
  public By Shop_By_Swimming = By.xpath("//*[@class='android.widget.Button'][@text='Swimming']");
  public By Shop_By_Table_Tennis =
      By.xpath("//*[@class='android.widget.Button'][@text='Table Tennis']");
  public By Shop_By_Tennis_And_Racquet =
      By.xpath("//*[@class='android.widget.Button'][@text='Tennis & Racquet']");
  public By Shop_By_Track_And_Field =
      By.xpath("//*[@class='android.widget.Button'][@text='Track & Field']");
  public By Shop_By_Volleyball =
      By.xpath("//*[@class='android.widget.Button'][@text='Volleyball']");
  public By Shop_By_Water_Sports =
      By.xpath("//*[@class='android.widget.Button'][@text='Water Sports']");
  public By Shop_By_Wellness = By.xpath("//*[@class='android.widget.Button'][@text='Wellness']");
  public By Shop_By_Winter_Sports =
      By.xpath("//*[@class='android.widget.Button'][@text='Winter Sports']");
  public By Shop_By_Wrestling = By.xpath("//*[@class='android.widget.Button'][@text='Wrestling']");
  public By Shop_By_Yard_Games =
      By.xpath("//*[@class='android.widget.Button'][@text='Yard Games']");
  public By Shop_By_Yoga_And_Studio =
      By.xpath("//*[@class='android.widget.Button'][@text='Yoga & Studio']");
  public By Shop_By_Clearance = By.xpath("//*[@class='android.widget.Button'][@text='Clearance']");

  public By searchBox = By.xpath("//*[@resource-id='SearchBoxText']");

  public By ShopTextView = By.id("dsgui.android:id/toolbar_title");
  public By searchTextView = By.id("dsgui.android:id/search");
  public By shopping_cartTextView = By.id("dsgui.android:id/shopping_cart");
  // public By Your_location_is_needed_for_personalizing_your_app_experience.TextView =
  // By.id("dsgui.android:id/snackbar_text");
  public By menuButton = By.id("nav-open-button");
  public By SIGN_UPButton = By.id("DSG_MarketingEmailSignupForm_Button");
  public By COMPANYButton = By.id("mat-expansion-panel-header-0");
  public By SERVICESButton = By.id("mat-expansion-panel-header-1");
  public By SHOPButton = By.id("mat-expansion-panel-header-2");
  public By RESOURCESButton = By.id("mat-expansion-panel-header-3");
  public By FEATURED_SEARCHESButton = By.id("mat-expansion-panel-header-4");
  public By OKButton = By.id("dsgui.android:id/snackbar_action");
  public By searchRegularEditText = MobileBy.id("search-regular");
  public By emailAddressInputEditText = By.id("emailAddressInput");
  public By Return_to_HomepageView = By.xpath("//*[@text='Return to Homepage']");
  public By searchView = By.xpath("//*[@text='search']");
  // public By 0_items_in_cartView = By.xpath("//*[@text='0 items in cart']");
  public By contentView = By.id("content");
  // public By UP_TO_75%_OFF_SELECT_JACKETS_SHOP_NOWView = By.xpath("//*[@text='UP TO 75% OFF SELECT
  // JACKETS SHOP NOW']");
  // public By FREE_SHIPPING_ON_ORDERS_OF_$65+_ONLINE_ONLY._DETAILSView = By.xpath("//*[@text='FREE
  // SHIPPING ON ORDERS OF $65+ ONLINE ONLY. DETAILS']");
  // public By
  // Three_separate_pictures_showing_a_woman_sewing_the_first_sports_bra_and_two_athletes_wearing_the_latest_sports_bras.View = By.xpath("//*[@text='Three separate pictures showing a woman sewing the first sports bra and two athletes wearing the latest sports bras.']");
  // public By
  // A_FIT_FOR_EVERY_MOVE_The_First_Sports_Bra_Was_Made_in_1977,_Which_Started_a_Movement_of_Women_in_Movement.View = By.xpath("//*[@text='A FIT FOR EVERY MOVE The First Sports Bra Was Made in 1977, Which Started a Movement of Women in Movement.']");
  public By WATCH_NOWView = By.xpath("//*[@text='WATCH NOW']");
  public By ApparelView = By.xpath("//*[@text='Apparel']");
  // public By APPARELView = By.xpath("//*[@text='APPAREL']");
  // public By WOMEN'SView = By.xpath("//*[@text='WOMEN'S']");
  // public By MEN'SView = By.xpath("//*[@text='MEN'S']");
  public By BOYSView = By.xpath("//*[@text='BOYS']");
  public By GIRLSView = By.xpath("//*[@text='GIRLS']");
  public By FOOTWEARView = By.xpath("//*[@text='FOOTWEAR']");
  // public By FOOTWEARView = By.xpath("//*[@text='FOOTWEAR']");
  public By MENSView = By.xpath("//*[@text='MENS']");
  public By WOMENSView = By.xpath("//*[@text='WOMENS']");
  public By YOUTHView = By.xpath("//*[@text='YOUTH']");
  public By NEW_RELEASESView = By.xpath("//*[@text='NEW RELEASES']");
  // public By OUTDOOR_LIVINGView = By.xpath("//*[@text='OUTDOOR LIVING']");
  public By OUTDOOR_LIVINGView = By.xpath("//*[@text='OUTDOOR LIVING']");
  public By COOLERSView = By.xpath("//*[@text='COOLERS']");
  public By CHAIRSView = By.xpath("//*[@text='CHAIRS']");
  public By GRILLSView = By.xpath("//*[@text='GRILLS']");
  public By CANOPIESView = By.xpath("//*[@text='CANOPIES']");
  public By Fan_ShopView = By.xpath("//*[@text='Fan Shop']");
  public By FAN_SHOPView = By.xpath("//*[@text='FAN SHOP']");
  public By NCAAView = By.xpath("//*[@text='NCAA']");
  public By NBAView = By.xpath("//*[@text='NBA']");
  public By MLBView = By.xpath("//*[@text='MLB']");
  public By NHLView = By.xpath("//*[@text='NHL']");
  public By GEAR_UP, _GET_GOINGView = By.xpath("//*[@text='GEAR UP, GET GOING']");
  // public By Athletes_playing_baseball,_softball_and_soccer.View = By.xpath("//*[@text='Athletes
  // playing baseball, softball and soccer.']");
  public By HIT_THE_PITCHView = By.xpath("//*[@text='HIT THE PITCH']");
  // public By THE_LATEST_GEAR._THE_BEST_BRANDS._GAME_ON.View = By.xpath("//*[@text='THE LATEST
  // GEAR. THE BEST BRANDS. GAME ON.']");
  // public By +_Free_Shipping_on_Select_Baseball_and_Softball_Gear._View = By.xpath("//*[@text='+
  // Free Shipping on Select Baseball and Softball Gear. ']");
  public By DetailsView = By.xpath("//*[@text='Details']");
  // public By
  // HIT_THE_PITCH_THE_LATEST_GEAR._THE_BEST_BRANDS._GAME_ON._+_Free_Shipping_on_Select_Baseball_and_Softball_Gear._DetailsView = By.xpath("//*[@text='HIT THE PITCH THE LATEST GEAR. THE BEST BRANDS. GAME ON. + Free Shipping on Select Baseball and Softball Gear. Details']");
  public By SHOP_SOFTBALLView = By.xpath("//*[@text='SHOP SOFTBALL']");
  public By SHOP_SOCCERView = By.xpath("//*[@text='SHOP SOCCER']");
  public By SHOP_BASEBALLView = By.xpath("//*[@text='SHOP BASEBALL']");
  // public By A_man_wearing_stylish_tees_and_shorts_while_carrying_a_tire.View =
  // By.xpath("//*[@text='A man wearing stylish tees and shorts while carrying a tire.']");
  // public By $25_OR_LESS_Select_Men's_and_Boys'_Shorts_and_TeesView = By.xpath("//*[@text='$25 OR
  // LESS Select Men's and Boys' Shorts and Tees']");
  public By SHOP_NOWView = By.xpath("//*[@text='SHOP NOW']");
  // public By A_woman_wearing_stylish_athletic_and_athleisure_clothes.View = By.xpath("//*[@text='A
  // woman wearing stylish athletic and athleisure clothes.']");
  // public By UP_TO_50%_OFF_Select_Women's_and_Girls'_Footwear_and_ApparelView =
  // By.xpath("//*[@text='UP TO 50% OFF Select Women's and Girls' Footwear and Apparel']");
  // public By WOMEN'SView = By.xpath("//*[@text='WOMEN'S']");
  // public By GIRLS'View = By.xpath("//*[@text='GIRLS'']");
  // public By A_man_wearing_a_stylish_winter_coat.View = By.xpath("//*[@text='A man wearing a
  // stylish winter coat.']");
  // public By UP_TO_75%_OFF_Select_Jackets_from_Your_Favorite_BrandsView = By.xpath("//*[@text='UP
  // TO 75% OFF Select Jackets from Your Favorite Brands']");
  // public By SHOP_NOWView = By.xpath("//*[@text='SHOP NOW']");
  // public By A_basketball_player_jumps_up_toward_the_hoop_with_the_basketball_ready_to_dunk.View =
  // By.xpath("//*[@text='A basketball player jumps up toward the hoop with the basketball ready to
  // dunk.']");
  // public By UP_TO_50%_OFF_This_Week's_Deals_on_Your_Favorite_Brands,_Styles_and_GearView =
  // By.xpath("//*[@text='UP TO 50% OFF This Week's Deals on Your Favorite Brands, Styles and
  // Gear']");
  // public By SHOP_NOWView = By.xpath("//*[@text='SHOP NOW']");
  public By HIGHLIGHT_REELView = By.xpath("//*[@text='HIGHLIGHT REEL']");
  // public By Closeup_of_a_golf_club_head_as_seen_in_the_follow_through_of_a_swing.View =
  // By.xpath("//*[@text='Closeup of a golf club head as seen in the follow through of a swing.']");
  public By SWING_INTO_THE_SEASON_Tee_Up_with_the_Latest_Apparel_and_GearView =
      By.xpath("//*[@text='SWING INTO THE SEASON Tee Up with the Latest Apparel and Gear']");
  public By SHOP_NEW_ARRIVALSView = By.xpath("//*[@text='SHOP NEW ARRIVALS']");
  public By SHOP_ALLView = By.xpath("//*[@text='SHOP ALL']");
  // public By Unable_to_play_media.View = By.xpath("//*[@text='Unable to play media.']");
  public By EXPERIENCE_MARCH_TO_THE_MAX_Kick_Off_Air_Max_Month_with_Fresh_KicksView =
      By.xpath("//*[@text='EXPERIENCE MARCH TO THE MAX Kick Off Air Max Month with Fresh Kicks']");
  // public By SHOP_NOWView = By.xpath("//*[@text='SHOP NOW']");
  // public By Two_people_walk_out_of_the_surf_carrying_a_paddle_board.View =
  // By.xpath("//*[@text='Two people walk out of the surf carrying a paddle board.']");
  public By THE_WAVES_ARE_CALLING_Seriously_Chill_Spring_Break_EssentialsView =
      By.xpath("//*[@text='THE WAVES ARE CALLING Seriously Chill Spring Break Essentials']");
  public By APPARELView = By.xpath("//*[@text='APPAREL']");
  public By SWIMView = By.xpath("//*[@text='SWIM']");
  public By SANDALSView = By.xpath("//*[@text='SANDALS']");
  public By HOT_IN_YOUR_AREAView = By.xpath("//*[@text='HOT IN YOUR AREA']");
  // public By VIEW_ALL_View = By.xpath("//*[@text='VIEW ALL ']");
  // public By
  // Product_Image_starstarstarstarstar_border_790_Nike_Men's_Air_Force_1_'07_Shoes_$89.99View =
  // By.xpath("//*[@text='Product Image starstarstarstarstar_border 790 Nike Men's Air Force 1 '07
  // Shoes $89.99']");
  // public By
  // Product_Image_starstarstarstar_borderstar_border_69_DSG_All_Sport_Athletic_Over_the_Calf_Socks_$9.99View = By.xpath("//*[@text='Product Image starstarstarstar_borderstar_border 69 DSG All Sport Athletic Over the Calf Socks $9.99']");
  // public By
  // Product_Image_starstarstarstarstar_border_42_Patagonia_Men's_Better_Sweater_1/4_Zip_Pullover_(Regular_and_Big_&_Tall)_$49.50View = By.xpath("//*[@text='Product Image starstarstarstarstar_border 42 Patagonia Men's Better Sweater 1/4 Zip Pullover (Regular and Big & Tall) $49.50']");
  // public By
  // Product_Image_starstarstarstarstar_border_15_New_Balance_Men's_4040_v5_Metal_Baseball_Cleats_$89.99View = By.xpath("//*[@text='Product Image starstarstarstarstar_border 15 New Balance Men's 4040 v5 Metal Baseball Cleats $89.99']");
  // public By Product_Image_starstarstarstarstar_4_Nike_Zoom_Rival_S_9_Track_and_Field_Shoes_$59.99
  // to $64.99View = By.xpath("//*[@text='Product Image starstarstarstarstar 4 Nike Zoom Rival S 9
  // Track and Field Shoes $59.99 to $64.99']");
  public By home3_rrView = By.id("home3_rr");
  public By TOP_SELLING_PRODUCTSView = By.xpath("//*[@text='TOP-SELLING PRODUCTS']");
  // public By VIEW_ALL_View = By.xpath("//*[@text='VIEW ALL ']");
  // public By
  // Product_Image_starstarstarstarstar_border_24763_YETI_20_oz._Rambler_Tumbler_with_MagSlider_Lid_$29.99View = By.xpath("//*[@text='Product Image starstarstarstarstar_border 24763 YETI 20 oz. Rambler Tumbler with MagSlider Lid $29.99']");
  // public By Product_Image_starstarstarstarstar_border_10_DSG_Girls'_Insulated_Jacket_$14.98View =
  // By.xpath("//*[@text='Product Image starstarstarstarstar_border 10 DSG Girls' Insulated Jacket
  // $14.98']");
  // public By
  // Product_Image_starstarstarstar_borderstar_border_17_DSG_Boys'_Insulated_Jacket_$14.98View =
  // By.xpath("//*[@text='Product Image starstarstarstar_borderstar_border 17 DSG Boys' Insulated
  // Jacket $14.98']");
  // public By Product_Image_starstarstarstarstar_border_45_DSG_Women's_Insulated_Jacket_$21.98View
  // = By.xpath("//*[@text='Product Image starstarstarstarstar_border 45 DSG Women's Insulated
  // Jacket $21.98']");
  // public By
  // Product_Image_starstarstarstarstar_border_422_Hydro_Flask_Wide-Mouth_Straw_Lid_$9.95View =
  // By.xpath("//*[@text='Product Image starstarstarstarstar_border 422 Hydro Flask Wide-Mouth Straw
  // Lid $9.95']");
  public By home_rrView = By.id("home_rr");
  public By THE_LATEST_LINEUPView = By.xpath("//*[@text='THE LATEST LINEUP']");
  public By app_containerView = By.id("app-container");
  public By Best_Price_GuaranteeView = By.xpath("//*[@text='Best Price Guarantee']");
  // public By If_You_Find_a_Lower_Price,_We’ll_Match_It.View = By.xpath("//*[@text='If You Find a
  // Lower Price, We’ll Match It.']");
  public By Learn_MoreView = By.xpath("//*[@text='Learn More']");
  // public By Easy_One-Hour_PickupView = By.xpath("//*[@text='Easy One-Hour Pickup']");
  public By Grab_Your_Gear_and_GoView = By.xpath("//*[@text='Grab Your Gear and Go']");
  // public By Learn_MoreView = By.xpath("//*[@text='Learn More']");
  public By Free_ShippingView = By.xpath("//*[@text='Free Shipping']");
  // public By Online_Only._Exclusions_Apply.View = By.xpath("//*[@text='Online Only. Exclusions
  // Apply.']");
  // public By DetailsView = By.xpath("//*[@text='Details']");
  public By Sports_MatterView = By.xpath("//*[@text='Sports Matter']");
  // public By Join_Us_in_Helping_Save_Youth_Sports.View = By.xpath("//*[@text='Join Us in Helping
  // Save Youth Sports.']");
  public By DonateView = By.xpath("//*[@text='Donate']");
  // public By CONNECT_WITH_US_&_SAVEView = By.xpath("//*[@text='CONNECT WITH US & SAVE']");
  // public By Sign_Up_For_Email_and_Get_10%_OffView = By.xpath("//*[@text='Sign Up For Email and
  // Get 10% Off']");
  public By Email_AddressView = By.xpath("//*[@text='Email Address']");
  public By email_messageView = By.id("email_message");
  public By Email_SignupView = By.id("emailSignupForm");
  // public By Want_$20_Off_$100?View = By.xpath("//*[@text='Want $20 Off $100?']");
  // public By Join_DICK’S_Text_Alerts_to_Receive_Special_Offers!_Online_Only._Exclusions_Apply.View
  // = By.xpath("//*[@text='Join DICK’S Text Alerts to Receive Special Offers! Online Only.
  // Exclusions Apply.']");
  public By _Click_For_DetailsView = By.xpath("//*[@text=' Click For Details']");
  // public By Need_More_Help?View = By.xpath("//*[@text='Need More Help?']");
  public By CHAT_NOWView = By.xpath("//*[@text='CHAT NOW']");
  // public By For_assistance_please_call_1-877-846-9997View = By.xpath("//*[@text='For assistance
  // please call 1-877-846-9997']");
  public By DICKS_Sporting_Goods_YouTubeView =
      By.xpath("//*[@text='DICKS Sporting Goods YouTube']");
  public By DICKS_Sporting_Goods_TwitterView =
      By.xpath("//*[@text='DICKS Sporting Goods Twitter']");
  public By DICKS_Sporting_Goods_FacebookView =
      By.xpath("//*[@text='DICKS Sporting Goods Facebook']");
  public By DICKS_Sporting_Goods_PinterestView =
      By.xpath("//*[@text='DICKS Sporting Goods Pinterest']");
  public By DICKS_Sporting_Goods_InstagramView =
      By.xpath("//*[@text='DICKS Sporting Goods Instagram']");
  // public By SCORE_MORE._GIVE_MORE._PLAY_MORE.View = By.xpath("//*[@text='SCORE MORE. GIVE MORE.
  // PLAY MORE.']");
  // public By Gift_Cards_&_eGift_CardsView = By.xpath("//*[@text='Gift Cards & eGift Cards']");
  // public By Give_the_Gift_That_Always_Fits._View = By.xpath("//*[@text='Give the Gift That Always
  // Fits. ']");
  public By Shop_Gift_CardsView = By.xpath("//*[@text='Shop Gift Cards']");
  // public By ScoreCard_&_ScoreCard_GoldView = By.xpath("//*[@text='ScoreCard & ScoreCard Gold']");
  // public By Earn_One_Point_for_Every_$1_and_get_a_$10_Reward_for_Every_300_Points._View =
  // By.xpath("//*[@text='Earn One Point for Every $1 and get a $10 Reward for Every 300 Points.
  // ']");
  // public By Learn_MoreView = By.xpath("//*[@text='Learn More']");
  // public By ScoreRewards®_Credit_CardView = By.xpath("//*[@text='ScoreRewards® Credit Card']");
  // public By
  // Accelerate_your_Rewards_and_earn_2_points_for_every_$1_on_qualified_purchases_with_a_ScoreRewards_credit_card._View = By.xpath("//*[@text='Accelerate your Rewards and earn 2 points for every $1 on qualified purchases with a ScoreRewards credit card. ']");
  // public By Learn_MoreView = By.xpath("//*[@text='Learn More']");
  // public By ©_2020_DICK'S_Sporting_GoodsView = By.xpath("//*[@text='© 2020 DICK'S Sporting
  // Goods']");
  // public By *View = By.xpath("//*[@text='*']");
  // public By
  // Price_Promotions_-_Due_to_manufacturer_restrictions,_select_new_release_and_other_specified_products_are_excluded_from_price_promotions._Additionally,_there_are_restrictions_on_the_use_of_coupon codes.View = By.xpath("//*[@text='Price Promotions - Due to manufacturer restrictions, select new release and other specified products are excluded from price promotions. Additionally, there are restrictions on the use of coupon codes.']");
  public By
      If_you_are_using_a_screen_reader_or_other_assistive_technology_and_are_having_problems_using_this_website,
      _or_if_you_have_any_other_difficulties_accessing_this_website,
      _please_call_View =
          By.xpath(
              "//*[@text='If you are using a screen reader or other assistive technology and are having problems using this website, or if you have any other difficulties accessing this website, please call ']");
  // public By 877-846-9997View = By.xpath("//*[@text='877-846-9997']");
  // public By _for_assistance.View = By.xpath("//*[@text=' for assistance.']");
  public By Terms_of_UseView = By.xpath("//*[@text='Terms of Use']");
  public By Privacy_PolicyView = By.xpath("//*[@text='Privacy Policy']");
  public By Accessibility_PolicyView = By.xpath("//*[@text='Accessibility Policy']");
  public By California_DisclosuresView = By.xpath("//*[@text='California Disclosures']");
  public By voc_d_pagefeedbackView = By.id("voc_d_pagefeedback");
  public By KampyleAnimationContainerView = By.id("KampyleAnimationContainer");
  // public By dsgui.android:id/webview_progressbar_backgroundView =
  // By.id("dsgui.android:id/webview_progressbar_background");

  public By shop_by_sports_page = By.id("dsgui.android:id/activity_main_content_fragment");
  public By this_weeks_deals = By.xpath("//*[@text='This Weeks Deals']");
  public By school_style_shop = By.xpath("//*[@text='SCHOOL-STYLE SHOP']");
}
