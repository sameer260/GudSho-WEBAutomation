package Pageobjects.frontend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.BaseSetup;
import steps.frontend.shodetailpagesteps;

public class commonlocatorsandmethods extends BaseSetup {

	public commonlocatorsandmethods() {
		PageFactory.initElements(driver, this);
	}

	public static Logger log = Logger.getLogger(commonlocatorsandmethods.class.getName());
	ToastandErrormessages toast = new ToastandErrormessages();
	// Home Page- Watch List Elements and Methods-start
	static By ShoCradShareButton = By
			.xpath("//div[@class='slider-content hovered']/swiper/div/app-gud-card/div/div/div[2]/div/div/div/div[2]");
	static By WatchListRow = By.xpath(
			"//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider[2]/div/div[2]/swiper/div/app-gud-card");
	static By WatchListRowShoCard = By.xpath(
			"//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider[2]/div/div[2]/swiper/div/app-gud-card/div");
	static By ShoNameonShoCard = By.xpath(
			"//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider[2]/div/div[2]//following::a[1]//child::img");
	static By ShoCardWatchListButton = By
			.xpath("//div[@class='slider-content hovered']/swiper/div/app-gud-card/div/div/div[2]/div/div/div/div[1]");

	@FindBy(xpath = "//span[starts-with(@class, 'cursor ng-tns')]")
	public static List<WebElement> allStarRating;
	@FindBy(xpath = "//span[starts-with(@class,'rating-status orange ng-tns-')]")
	public static WebElement starRatingsValue;
	@FindBy(xpath = "//*[starts-with(@class, 'mat-menu-trigger right-box cursor flex align-items-center')]")
	public static WebElement rateShoDetailButton;
	@FindBy(xpath = "//*[starts-with(@class,'button is-icon primary-gradient large coins-temp-plan mat-button mat-button-base ng')]")
	public static WebElement ratePopupButton;
	@FindBy(xpath = "//textarea[starts-with(@id,'mat-input')]")
	public static WebElement ratingTextBox;
	@FindBy(xpath = "//span[starts-with(@class,'bg-close_watchhistory ng')]")
	public static WebElement friendsRatingPopupCloseButton;

	public static String shocardwatchlistcheckforhomepage(String shoname) throws InterruptedException {
		String Shonameonshocard = null;
		WebElement watchlist = driver.findElement(By.xpath(
				"//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider[1]/div/div[2]/swiper/div/app-gud-card"));
		for (int i = 0; i < watchlist.findElements(By.xpath(
				"//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider[1]/div/div[2]/swiper/div/app-gud-card/div"))
				.size(); i++) {
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElements(By.xpath(
					"//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider[1]/div/div[2]/swiper/div/app-gud-card/div"))
					.get(i)).build().perform();
			Thread.sleep(500);
			if (watchlist.findElement(By.xpath(
					"//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider[1]/div/div[2]//following::a[1]//child::img"))
					.getAttribute("alt").equalsIgnoreCase(shoname)) {
				Shonameonshocard = watchlist.findElement(By.xpath(
						"//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider[1]/div/div[2]//following::a[1]//child::img"))
						.getAttribute("alt");
				break;
			}

		}
		return Shonameonshocard;
	}

	public static String shocardwatchlistShoName(String shoname) throws InterruptedException {
		String Shonameonshocard = null;
		WebElement watchlist = driver.findElement(WatchListRow);
		for (int i = 0; i < watchlist.findElements(WatchListRowShoCard).size(); i++) {
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElements(WatchListRowShoCard).get(i)).build().perform();
			Thread.sleep(500);
			if (watchlist.findElement(ShoNameonShoCard).getAttribute("alt").equalsIgnoreCase(shoname)) {
				Shonameonshocard = watchlist.findElement(ShoNameonShoCard).getAttribute("alt");
				break;
			}

		}
		return Shonameonshocard;
	}

	// Home Page-Watch List Elements and Methods -End

	// All see All pages Elements for so cards

	@FindBy(xpath = "//h3[@class='see-category']")
	public static WebElement MoreLikethistext;

	@FindBy(xpath = "//span[@class='back-icon cursor ng-star-inserted']")
	public static WebElement SeeAllPageBackButton;

	@FindBy(xpath = "//div[@class='see-all-content ng-star-inserted']/app-gud-card/div/div/div")
	public static List<WebElement> Shocards;

	@FindBy(xpath = "//div[@class='see-all-content ng-star-inserted']/app-gud-card//following::a[1]//child::img")
	public static List<WebElement> ShoNames;

	@FindBy(xpath = "//div[starts-with(@class,'follow-btn ng-tns-')]/app-watch-later/div")
	public static WebElement WatchLaterbuttononShoCard;

	@FindBy(xpath = "//*[starts-with(@class, 'hover-share flex align-items-center justify-content-center ng-tns-')]")
	public static WebElement ShareButtononShoCard;

	@FindBy(xpath = "//*[starts-with(@class,'mat-card-image ng-tns-')]")
	public static List<WebElement> promocards;

	public static void scrolldownm() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			Object lastHeight = js.executeScript("return document.body.scrollHeight");
			while (true) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(1300);
				Object newHeight = js.executeScript("return document.body.scrollHeight");
				if (newHeight.equals(lastHeight)) {
					break;
				}
				lastHeight = newHeight;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void scrollup() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-250)", "");
	}

	public static void hoverTitleCardHome(String shoName) {
		scrolldownm();

		int alltitles = homepage.allTitles.size();
		System.out.println("Size of element :" + alltitles);

		for (int i = 0; i < alltitles; i++) {
			String titleName = homepage.allTitles.get(i).getAttribute("alt");

			if (titleName.equalsIgnoreCase(shoName)) {

				Actions actions = new Actions(driver);
				actions.moveToElement(homepage.allTitles.get(i)).build().perform();
				break;

			}

		}
	}

	public static void clickTitleCardHome(String shoName) {
		scrolldownm();

		int alltitles = homepage.allTitles.size();
		System.out.println("Size of element :" + alltitles);

		for (int i = 0; i < alltitles; i++) {
			String titleName = homepage.allTitles.get(i).getAttribute("alt");

			if (titleName.equalsIgnoreCase(shoName)) {

				Actions actions = new Actions(driver);
				actions.moveToElement(homepage.allTitles.get(i)).click().build().perform();
				break;

			}

		}
	}

	public static String PromoCardHover(String promoname) {
		Actions a = new Actions(driver);
		String promonameoncard = null;
		for (int i = 0; i < shodetailpage.PromoNamesofPromoCards.size(); i++) {
			if (shodetailpage.PromoNamesofPromoCards.get(i).getText().equalsIgnoreCase(promoname)) {
				promonameoncard = shodetailpage.PromoNamesofPromoCards.get(i).getText();
				a.moveToElement(shodetailpage.PromoNamesofPromoCards.get(i)).build().perform();

			}
		}
		return promonameoncard;
	}

	public static String PromoCardClick(String promoname) throws InterruptedException {
		Actions a = new Actions(driver);
		String promonameoncard = null;
		System.out.println(shodetailpage.PromoNamesofPromoCards.size());
		for (int i = 0; i < shodetailpage.PromoNamesofPromoCards.size(); i++) {
			System.out.println(shodetailpage.PromoNamesofPromoCards.get(i).getText());
			if (shodetailpage.PromoNamesofPromoCards.get(i).getText().equalsIgnoreCase(promoname)) {
				promonameoncard = shodetailpage.PromoNamesofPromoCards.get(i).getText();
				a.moveToElement(shodetailpage.PromoNamesofPromoCards.get(i)).click().build().perform();
				break;
			}
		}
		return promonameoncard;

	}

	static By WatchListRowHomepage = By.xpath(
			"//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider/div/div[2]/swiper/div/app-gud-card");

	public static String WatchlistRowonHomePage(String shoname) throws InterruptedException {
		int rowsize = driver.findElements(WatchListRowHomepage).size();
		String Shonameonshocard = null;
		WebElement watchlist = driver.findElement(WatchListRowHomepage);
		for (int i = 0; i < watchlist
				.findElements(By.xpath("//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider[" + rowsize
						+ "]/div/div[2]/swiper/div/app-gud-card/div"))
				.size(); i++) {
			Actions a = new Actions(driver);
			a.moveToElement(
					driver.findElements(By.xpath("//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider["
							+ rowsize + "]/div/div[2]/swiper/div/app-gud-card/div")).get(i))
					.build().perform();
			Thread.sleep(500);
			if (watchlist
					.findElement(By.xpath("//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider["
							+ rowsize + "]/div/div[2]//following::a[1]//child::img"))
					.getAttribute("alt").equalsIgnoreCase(shoname)) {
				Shonameonshocard = watchlist
						.findElement(By.xpath("//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider["
								+ rowsize + "]/div/div[2]//following::a[1]//child::img"))
						.getAttribute("alt");
				break;
			}

		}
		return Shonameonshocard;

	}

	public static String getPromoViewsAndGuds(String promoname) {
		Actions a = new Actions(driver);
		// String[] counts = new String[5];
		int allPromo = homepage.allPromoNames.size();
		for (int i = 0; i <= allPromo; i++) {
			if (homepage.allPromoNames.get(i).getText().equalsIgnoreCase(promoname)) {
				String counts1 = homepage.allPromoNames.get(i).getText();
				// a.moveToElement(shodetailpage.PromoNamesofPromoCards.get(i)).build().perform();
				System.out.println("Printin all the promo names" + counts1);

			}

		}
		return promoname;
	}

	// Next and Previous Arrows

	@FindBy(xpath = "//div[@aria-label='Next slide']")
	public static List<WebElement> NextArrow;

	@FindBy(xpath = "//div[@aria-label='Previous slide']")
	public static List<WebElement> PreviousArrow;

	@FindBy(xpath = "//div[@class='swiper-container swiper-container-initialized swiper-container-horizontal']/app-gud-card/div/div/div")
	public static List<WebElement> ShoCards;

	public static void RightLeftArrows(List<WebElement> webElement1, List<WebElement> webElement2, int index)
			throws InterruptedException {
		int i = 0;
		int j = 0;
		Actions a = new Actions(driver);

		if (ShoCards.size() > 6) {
			a.moveToElement(webElement1.get(index)).build().perform();
			if (webElement1.get(index).getAttribute("aria-disabled").equalsIgnoreCase("false")) {
				while (!(webElement1.get(index).getAttribute("aria-disabled").equalsIgnoreCase("true"))) {
					i = ShoCards.size();
					a.moveToElement(webElement1.get(index)).build().perform();
					webElement1.get(index).click();
					Thread.sleep(1400);

				}
				log.info("No.of Cards:" + i);

			}
			if (webElement2.get(index).getAttribute("aria-disabled").equalsIgnoreCase("false")) {
				while (!(webElement2.get(index).getAttribute("aria-disabled").equalsIgnoreCase("true"))) {
					j = ShoCards.size();
					webElement2.get(index).click();
				}
				log.info("No.of Cards:" + j);

				assertEquals(i, j);
			}
		} else {
			log.info("The Cards are less less than 6");
			log.info(ShoCards.size());
		}
	}

	// Sho Card Labels

	@FindBy(xpath = "//span[starts-with(@class,'card-badge coin-label ng-tns-')]")
	public static List<WebElement> ShoCardPriceLabel;

	@FindBy(xpath = "//span[starts-with(@class,'wl-sho badge full-badge sho ng-tns-')]")
	public static WebElement ShoSeriesCardLabel;

	@FindBy(xpath = "//ul[@class='ng-star-inserted']/li[1]")
	public static WebElement ShoCardDuration;

	@FindBy(xpath = "//ul[@class='ng-star-inserted']/li[2]")
	public static WebElement ShoCardGenere;

	@FindBy(xpath = "//ul[@class='ng-star-inserted']/li[3]")
	public static WebElement ShoCardLanguage;

	@FindBy(xpath = "//div[starts-with(@class,'card-sho-name flex align-items-center justify-content-between ng-tns-')]/h5")
	public static WebElement ShoNameOnShoCard;

	@FindBy(xpath = "//div[starts-with(@class,'card-sho-name flex align-items-center justify-content-between ng-tns-')]/img")
	public static WebElement ShoNameOnShoCardImage;

	@FindBy(xpath = "//span[@class='gud-value']")
	public static WebElement PriceOnShoBannerWatchButton;

	public static String PriceLabel() {

		return commonlocatorsandmethods.ShoCardPriceLabel.get(0).getText();
	}

	public static void CheckPriceverification(String pricelabel) {

		if (pricelabel.contains("₹")) {
			assertTrue(shodetailpage.WatchFreeButton.isDisplayed());
			log.info(shodetailpage.WatchFreeButton.getText());
			try {
				assertEquals(pricelabel, PriceOnShoBannerWatchButton.getText());
			} catch (Exception e) {
				assertTrue(shodetailpage.WatchFreeButton.isDisplayed());
				log.info(" Resume Button is displaying");
			}
		} else {
			assertTrue(shodetailpage.WatchFreeButton.isDisplayed());
		}

	}

	// static By WatchListRowHomepage =
	// By.xpath("//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider/div/div[2]/swiper/div/app-gud-card");
	public static String WatchlistRowonHomePageCardClick(String shoname) throws InterruptedException {
		int rowsize = driver.findElements(WatchListRowHomepage).size();
		String Shonameonshocard = null;
		WebElement watchlist = driver.findElement(WatchListRowHomepage);
		for (int i = 0; i < watchlist
				.findElements(By.xpath("//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider[" + rowsize
						+ "]/div/div[2]/swiper/div/app-gud-card/div"))
				.size(); i++) {
			Actions a = new Actions(driver);
			a.moveToElement(
					driver.findElements(By.xpath("//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider["
							+ rowsize + "]/div/div[2]/swiper/div/app-gud-card/div")).get(i))
					.build().perform();
			Thread.sleep(500);
			if (watchlist
					.findElement(By.xpath("//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider["
							+ rowsize + "]/div/div[2]//following::a[1]//child::img"))
					.getAttribute("alt").equalsIgnoreCase(shoname)) {
				Shonameonshocard = watchlist
						.findElement(By.xpath("//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider["
								+ rowsize + "]/div/div[2]//following::a[1]//child::img"))
						.getAttribute("alt");
				watchlist.findElements(By.xpath("//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider["
						+ rowsize + "]/div/div[2]/swiper/div/app-gud-card/div")).get(i).click();
				break;
			}

		}
		return Shonameonshocard;

	}

	static WebDriverWait wait = new WebDriverWait(driver, 20);

	public static String RemoveWatchlistRowonHomePage(String shoname) throws InterruptedException {
		int rowsize = driver.findElements(WatchListRowHomepage).size();
		String Shonameonshocard = null;
		WebElement watchlist = driver.findElement(WatchListRowHomepage);
		for (int i = 0; i < watchlist
				.findElements(By.xpath("//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider[" + rowsize
						+ "]/div/div[2]/swiper/div/app-gud-card/div"))
				.size(); i++) {
			Actions a = new Actions(driver);
			a.moveToElement(
					driver.findElements(By.xpath("//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider["
							+ rowsize + "]/div/div[2]/swiper/div/app-gud-card/div")).get(i))
					.build().perform();
			Thread.sleep(500);
			if (watchlist
					.findElement(By.xpath("//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider["
							+ rowsize + "]/div/div[2]//following::a[1]//child::img"))
					.getAttribute("alt").equalsIgnoreCase(shoname)) {
				a.moveToElement(watchlist.findElement(ShoCardWatchListButton)).click().build().perform();
				wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
				Shonameonshocard = watchlist
						.findElement(By.xpath("//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider["
								+ rowsize + "]/div/div[2]//following::a[1]//child::img"))
						.getAttribute("alt");
				break;
			}

		}
		return Shonameonshocard;

	}

	public static void giveRatingsAndCommentsFromPlayer(String yourrating, String comment) throws Throwable {
		
		if (yourrating.equalsIgnoreCase("one")) {
			allStarRating.get(0).click();
			assertEquals("Average", starRatingsValue.getText());

		} else if (yourrating.equalsIgnoreCase("two")) {
			allStarRating.get(1).click();
			assertEquals("Can Recommend", starRatingsValue.getText());
		} else if (yourrating.equalsIgnoreCase("three")) {
			allStarRating.get(2).click();
			assertEquals("Would Watch Again", starRatingsValue.getText());
		} else if (yourrating.equalsIgnoreCase("four")) {
			allStarRating.get(3).click();
			assertEquals("Loved it", starRatingsValue.getText());
		} else if (yourrating.equalsIgnoreCase("five")) {
			allStarRating.get(4).click();
			assertEquals("Masterpiece", starRatingsValue.getText());
		}

		wait.until(ExpectedConditions.visibilityOf(ratePopupButton));
		ratingTextBox.sendKeys(Keys.CONTROL + "a");
		ratingTextBox.sendKeys(Keys.DELETE);
		ratingTextBox.sendKeys(comment);
		Thread.sleep(1000);
		ratePopupButton.click();
		Thread.sleep(1000);
		rateShoDetailButton.click();
		wait.until(ExpectedConditions.visibilityOf(ratePopupButton));
		Thread.sleep(1000);
		assertEquals(ratingTextBox.getText(), comment);
		
		if (yourrating.equalsIgnoreCase("one")) {

			assertEquals("Average", starRatingsValue.getText());

		} else if (yourrating.equalsIgnoreCase("two")) {

			assertEquals("Can Recommend", starRatingsValue.getText());
		} else if (yourrating.equalsIgnoreCase("three")) {

			assertEquals("Would Watch Again", starRatingsValue.getText());
		} else if (yourrating.equalsIgnoreCase("four")) {

			assertEquals("Loved it", starRatingsValue.getText());
		} else if (yourrating.equalsIgnoreCase("five")) {

			assertEquals("Masterpiece", starRatingsValue.getText());
		}
		friendsRatingPopupCloseButton.click();

	}
	
	public static void giveRatingsAndCommentsFromDetailPage(String yourrating, String comment) throws Throwable {
		rateShoDetailButton.click();
		if (yourrating.equalsIgnoreCase("one")) {
			allStarRating.get(0).click();
			assertEquals("Average", starRatingsValue.getText());

		} else if (yourrating.equalsIgnoreCase("two")) {
			allStarRating.get(1).click();
			assertEquals("Can Recommend", starRatingsValue.getText());
		} else if (yourrating.equalsIgnoreCase("three")) {
			allStarRating.get(2).click();
			assertEquals("Would Watch Again", starRatingsValue.getText());
		} else if (yourrating.equalsIgnoreCase("four")) {
			allStarRating.get(3).click();
			assertEquals("Loved it", starRatingsValue.getText());
		} else if (yourrating.equalsIgnoreCase("five")) {
			allStarRating.get(4).click();
			assertEquals("Masterpiece", starRatingsValue.getText());
		}

		wait.until(ExpectedConditions.visibilityOf(ratePopupButton));
		ratingTextBox.sendKeys(Keys.CONTROL + "a");
		ratingTextBox.sendKeys(Keys.DELETE);
		ratingTextBox.sendKeys(comment);
		ratePopupButton.click();
		Thread.sleep(1000);
		rateShoDetailButton.click();
		wait.until(ExpectedConditions.visibilityOf(ratePopupButton));
		Thread.sleep(500);
		assertEquals(ratingTextBox.getText(), comment);
		
		if (yourrating.equalsIgnoreCase("one")) {

			assertEquals("Average", starRatingsValue.getText());

		} else if (yourrating.equalsIgnoreCase("two")) {

			assertEquals("Can Recommend", starRatingsValue.getText());
		} else if (yourrating.equalsIgnoreCase("three")) {

			assertEquals("Would Watch Again", starRatingsValue.getText());
		} else if (yourrating.equalsIgnoreCase("four")) {

			assertEquals("Loved it", starRatingsValue.getText());
		} else if (yourrating.equalsIgnoreCase("five")) {

			assertEquals("Masterpiece", starRatingsValue.getText());
		}
		friendsRatingPopupCloseButton.click();

	}

}