package Pageobjects.frontend;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.BaseSetup;

public class homepage extends BaseSetup {

	public static Logger log = Logger.getLogger(homepage.class.getName());

	public homepage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='home-banner-slider']")
	public static WebElement HomePageBanners;

	@FindBy(xpath = "//div[@class='home-banner-pagination swiper-pagination-clickable swiper-pagination-bullets']/span")
	public static List<WebElement> HomePageBannerSliderButtons;

	@FindBy(xpath = "//h3[@class='ng-star-inserted']")
	public static List<WebElement> ShoNamesOnBannerText;

	@FindBy(xpath = "//div[@class='gs-coins-btn']/button")
	public static WebElement CoinsButton;

	@FindBy(xpath = "//div[@class='user-navigation']/button")
	public static WebElement HomePageSignInButton;

	@FindBy(id = "home-search-icon")
	private static WebElement SearchICon;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private static WebElement HomePageSearch;

	@FindBy(xpath = "//div[@class='ng-scroll-content']/ul/li/span/span")
	private static List<WebElement> AutoSuggestiveDropdown;

	@FindBy(xpath = "//span[@class='cursor']")
	public static WebElement CookieClose;

	@FindBy(xpath = "button is-default blue-stroke small mat-button mat-button-base")
	private static WebElement CookieGotItButton;

	@FindBy(xpath = "//div[@class='footer']")
	public static WebElement FooterSection;

	@FindBy(xpath = "//div[@class='slider-header flex justify-content-between']/h4")
	private static List<WebElement> RowsTitleText;

	@FindBy(xpath = "//div[@class='header-logo flex align-items-center']/a[1]")
	public static WebElement HeaderLogo;

	@FindBy(xpath = "//div[@class='swiper-container swiper-container-initialized swiper-container-horizontal']/app-gud-card/div")
	private static List<WebElement> WatchlistCards;

	@FindBy(xpath = "//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider[1]/div/div[2]/swiper/div/app-gud-card")
	public static WebElement MyGudPromosRow;

	@FindBy(xpath = "//div[@class='home-slider continue ng-star-inserted']/app-gud-slider/div/div[2]/swiper/div/app-gud-card/div/div/div[2]")
	public static List<WebElement> ShoNamesInContinueWatching;

	@FindBy(xpath = "//span[contains(text(),'Notifications')]")
	public static WebElement clicknotification;

	@FindBy(xpath = "//a[@class='fill-profile']")
	public static WebElement Headderprofileicon;

	@FindBy(xpath = "//a[text()='Account & Settings']")
	public static WebElement accountsettings;

	@FindBy(xpath = "//a[text()='Friends']")
	public static WebElement friends;

	@FindBy(xpath = "//a[text()='Support']")
	public static WebElement support;

	@FindBy(xpath = "//div[@class='settings-box ng-star-inserted']")
	public static WebElement notificationsettingbox;

	@FindBy(xpath = "//div[@class='settings-box ng-star-inserted']/p")
	public static WebElement NotificationSettingText;

	@FindBy(xpath = "//div[@class='user-info-list']/div")
	public static WebElement ProfileUserPhoneNumber;

	@FindBy(xpath = "//div[@class='user-info-list']/span")
	public static WebElement ProfileUserName;

	@FindBy(xpath = "//div[@class='user-detail-list']/ngx-avatar")
	public static WebElement HoverProfileIcon;

	@FindBy(xpath = "//div[@class='swiper-container swiper-container-initialized swiper-container-horizontal swiper-container-multirow']/app-gud-card/div")
	public static List<WebElement> MultipleRowShocards;

	@FindBy(xpath = "//div[@class='swiper-container swiper-container-initialized swiper-container-horizontal']/app-gud-card/div")
	public static List<WebElement> SingleRowShoCards;

	@FindBy(xpath = "//div[@class='home-slider studios-swiper ng-star-inserted']/app-gud-slider/div/div[2]/swiper/div/app-gud-card/div")
	public static List<WebElement> StudioCards;

	@FindBy(xpath = "//div[@class='home-slider studios-swiper ng-star-inserted']/app-gud-slider/div/div[2]/swiper/div/app-gud-card/div/div/div/div[2]/div/a/h6")
	public static List<WebElement> RowStudioNameonCard;

	@FindBy(xpath = "//div[@class='swiper-container swiper-container-initialized swiper-container-horizontal swiper-container-multirow']/app-gud-card/div/div/div/a/app-gud-image/div/div/img")
	public static List<WebElement> MultipleRowShoNamesonShocards;

	@FindBy(xpath = "//*[starts-with(@class, 'home-banner-content flex')]")
	public static List<WebElement> allBanners;

	@FindBy(id = "banner-promo-player")
	public static WebElement ShonameonBanner;

	@FindBy(xpath = "//*[starts-with(@class,'auto-image cursor slider-card-promo promo-top hover-img play-hover-icon')]")
	public static WebElement promoCard;

	static By MyGudPromoCards = By.xpath(
			"//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider[1]/div/div[2]/swiper/div/app-gud-card/div");
	static By PromoNameonGudPromos = By.xpath(
			"//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider[1]/div/div[2]/swiper/div/app-gud-card/div/div/div[2]/h4");

	public static void HomePageSearch(String shoseriesorstudioname) throws InterruptedException {
		homepage.SearchICon.click();
		homepage.HomePageSearch.sendKeys(shoseriesorstudioname);
		log.info("Sent Text in the Home Page is " + shoseriesorstudioname);
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(AutoSuggestiveDropdown));
		for (int i = 0; i < AutoSuggestiveDropdown.size(); i++) {
			String str = AutoSuggestiveDropdown.get(i).getText();
			log.info("The Auto suggestive dropdown shows:" + str);
			if (str.equalsIgnoreCase(shoseriesorstudioname)) {
				AutoSuggestiveDropdown.get(i).click();
				break;
			}
		}
	}

	public static String mygudpromos(String promoname) {
		String Promonameoncard = null;
		WebElement gudpromorow = MyGudPromosRow;
		for (int i = 0; i < gudpromorow.findElements(MyGudPromoCards).size(); i++) {

			if (gudpromorow.findElements(PromoNameonGudPromos).get(i).getText().equalsIgnoreCase(promoname)) {
				Promonameoncard = gudpromorow.findElements(PromoNameonGudPromos).get(i).getText();
				break;
			}

		}
		return Promonameoncard;

	}
	
	public static String mygudpromosdislike(String promoname) {
		String Promonameoncard = null;
		WebElement gudpromorow = MyGudPromosRow;
		for (int i = 0; i < gudpromorow.findElements(MyGudPromoCards).size(); i++) {

			if (!gudpromorow.findElements(PromoNameonGudPromos).get(i).getText().equalsIgnoreCase(promoname)) {
				Promonameoncard = gudpromorow.findElements(PromoNameonGudPromos).get(i).getText();
				break;
			}

		}
		return Promonameoncard;

	}

	@FindBy(xpath = "//*[starts-with(@class,'mat-ripple card-img cursor auto-image')]//child::img")
	public static List<WebElement> allTitles;

	@FindBy(xpath = "//*[@mattooltip='Add to watch list']")
	public static WebElement addToWatchlistButton;

	@FindBy(xpath = "//*[@mattooltip='Added to watch list']")
	public static WebElement removeFromWatchlist;

	// see all
	@FindBy(xpath = "//*[text()=' My Watch List ']")
	public static WebElement myWatchlistSeeAll;

	@FindBy(xpath = "//*[@class='promo-card card-slider ng-star-inserted']//child::div[@class='slider-header flex justify-content-between ng-star-inserted']//h3")
	public static WebElement promoSeeAll;

	@FindBy(xpath = "//*[@class='release-card card-slider ng-star-inserted']//child::span[@class='text']")
	public static List<WebElement> shoTypeRowSeeAll;

	@FindBy(xpath = "//div[starts-with(@class,'studio-card-wrapper card-border ng-tns-')]/div/div[2]/div/app-follow-studios/button")
	public static List<WebElement> followButtons;

	@FindBy(xpath = "//*[@class='button is-default following small mat-button mat-button-base ng-star-inserted']")
	public static WebElement followingButton;

	@FindBy(xpath = "//*[text()=' Yes ']")
	public static WebElement yesButton;

	@FindBy(xpath = "//img[@id='studio']")
	public static List<WebElement> studioCards;

	@FindBy(xpath = "//*[starts-with(@class,'card-badge ng-tns')]")
	public static WebElement shoTypeLabelOnTitleCard;

	@FindBy(xpath = "//*[starts-with(@class,'card-badge ng-tns')]//following::span[1]")
	public static WebElement priceOnTitleCard;

	@FindBy(xpath = "//*[starts-with(@class,'hover-sho-detail ng-tns')]//*[@class='ng-star-inserted']//child::li")
	public static List<WebElement> titleCardInfo;

	@FindBy(xpath = "//ul[@class='clearfix']//child::li")
	public static List<WebElement> titleCardInfoShodetail;

	@FindBy(xpath = "//*[starts-with(@class, 'close flex align-items-center justify-content-center ng-tns-')]")
	public static List<WebElement> continueWatchingCloseButton;

	@FindBy(xpath = "//h4[@mattooltipposition='below']")
	public static List<WebElement> allPromoNames;
	
	@FindBy(xpath = "//p[@mattooltipposition='below']")
	public static List<WebElement> allStudioFollowersCount;

	/*
	 * public static String getShoTypeLableText(String shoTypelable) { shoTypelable
	 * = homepage.shoTypeLabelOnTitleCard.getText(); return shoTypelable;
	 */

}

/*
 * public static String getShoCardPriceAmmountt() {
 * 
 * homepage.priceOnTitleCard.getText(); return null;
 * 
 * }
 * 
 * public static String[] getDurationGenerLang(String[] shoPrice) { shoPrice[0]
 * = homepage.titleCardInfo.get(0).getText(); shoPrice[1] =
 * homepage.titleCardInfo.get(1).getText(); shoPrice[2] =
 * homepage.titleCardInfo.get(1).getText(); return shoPrice;
 * 
 * }
 */
