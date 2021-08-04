package steps.frontend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lowagie.text.List;

import Pageobjects.frontend.ShareFeature;
import Pageobjects.frontend.SignUp;
import Pageobjects.frontend.ToastandErrormessages;
import Pageobjects.frontend.accountandsettingspage;
import Pageobjects.frontend.audioplayer;
import Pageobjects.frontend.commonlocatorsandmethods;
import Pageobjects.frontend.homepage;
import Pageobjects.frontend.shodetailpage;
import Pageobjects.frontend.studiodetailpage;
import Pageobjects.frontend.videoplayer;
import Resources.BaseSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Homepagesteps extends BaseSetup {

	public static Logger log = Logger.getLogger(Homepagesteps.class.getName());
	SignUp sign = new SignUp();
	shodetailpage shodetail = new shodetailpage();
	homepage home = new homepage();
	videoplayer video = new videoplayer();
	ToastandErrormessages toaster = new ToastandErrormessages();
	audioplayer audio = new audioplayer();
	studiodetailpage studio = new studiodetailpage();
	accountandsettingspage ac = new accountandsettingspage();
	commonlocatorsandmethods common = new commonlocatorsandmethods();
	ShareFeature share = new ShareFeature();
	WebDriverWait wait = new WebDriverWait(driver, 20);
	JavascriptExecutor executor = (JavascriptExecutor) driver;

	@Given("^verify notification tab$")
	public void verify_notification_tab() throws Throwable {
		WebElement notify = wait.until(ExpectedConditions.elementToBeClickable(homepage.clicknotification));
		executor.executeScript("arguments[0].click();", notify);
		Thread.sleep(2000);
	}

	@When("^verify notification page redirected to correct page$")
	public void verify_notification_page_redirected_to_correct_page() throws Throwable {
		homepage.notificationsettingbox.isDisplayed();
		String actual = homepage.NotificationSettingText.getText();
		assertEquals(actual, "Manage your Email, SMS, In-app and push notifications");
	}

	@Given("^verify user profile icon$")
	public void verify_user_profile_icon() throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(homepage.Headderprofileicon));
		Actions a = new Actions(driver);
		a.moveToElement(homepage.Headderprofileicon).build().perform();
	}

	@Then("^verify profile icon page$")
	public void verify_profile_icon_page() throws Throwable {
		assertTrue(homepage.accountsettings.isDisplayed());
		assertTrue(homepage.friends.isDisplayed());
		assertTrue(homepage.support.isDisplayed());
		assertTrue(homepage.ProfileUserPhoneNumber.isDisplayed());
		assertTrue(homepage.ProfileUserName.isDisplayed());
		assertTrue(homepage.Headderprofileicon.isDisplayed());
	}

	@Given("^Click on sho card from any row and verify its redirected to correct sho detail page$")
	public void click_on_sho_card_from_any_row_and_verify_its_redirected_to_correct_sho_detail_page() throws Throwable {
		Actions a = new Actions(driver);
		a.moveToElement(homepage.MultipleRowShocards.get(0)).build().perform();
		String shonameoncard = homepage.MultipleRowShoNamesonShocards.get(0).getAttribute("alt");
		homepage.MultipleRowShocards.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(shodetailpage.WatchListButton));
		String shoname = shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
		assertEquals(shoname, shonameoncard);
	}

	@Given("^Click on studio card from studio row and verify its redirected to correct studio detail page$")
	public void click_on_studio_card_from_studio_row_and_verify_its_redirected_to_correct_studio_detail_page()
			throws Throwable {
		commonlocatorsandmethods.scrolldownm();
		String studionameoncard = homepage.RowStudioNameonCard.get(0).getText();
		homepage.StudioCards.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(studiodetailpage.StudioNameInStudioPage));
		String studioname = studiodetailpage.StudioNameInStudioPage.getText();
		assertEquals(studioname, studionameoncard);
	}

	String bannerShoName;

	@Given("^Select first card from home banner and check sho detail page redirection$")
	public void Select_first_card_from_home_banner_and_check_sho_detail_page_redirection() throws Throwable {
		Actions a = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOfAllElements(homepage.allBanners));
		String ShonameonBanner = homepage.ShonameonBanner.getAttribute("title");
		System.out.println("Shoname on Banner:" + ShonameonBanner);
		a.moveToElement(homepage.allBanners.get(0)).click().build().perform();
		String shoName = shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
		System.out.println("Shoname on sjodetail:" + shoName);
		assertTrue(shoName.equalsIgnoreCase(ShonameonBanner));
	}

	@Given("^Select first promo card from promo row$")
	public void select_first_promo_card_from_promo_row() throws Throwable {
		commonlocatorsandmethods.scrolldownm();
		Actions a = new Actions(driver);
		a.moveToElement(homepage.promoCard).click().build().perform();
	}

	@Then("^verify redirection of promo player$")
	public void verify_redirection_of_promo_player() throws Throwable {
		Thread.sleep(3000);
		videoplayer.PromoNameonPlayer.isDisplayed();

	}

	@Then("^Click on notifications link and it should redirect to notifications tab$")
	public void click_on_notifications_link_and_it_should_redirect_to_notifications_tab() throws Throwable {
		accountandsettingspage.NotificationSettingLink.click();
		assertTrue(accountandsettingspage.NotificationsTab.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.NotificationElements));
		assertTrue(accountandsettingspage.NotificationElements.isDisplayed());
	}

	// phase 2 home

	String mainShoName;

	@Given("^From home page click on add to watchlist in (.+) title card$")
	public void from_home_page_click_on_add_to_watchlist_in_title_card(String shoName) throws Throwable {

		commonlocatorsandmethods.hoverTitleCardHome(shoName);
		homepage.addToWatchlistButton.click();
		mainShoName = shoName;

	}

	@When("^check card availbility on my watchlist row$")
	public void check_card_availbility_on_my_watchlist_row() throws Throwable {
		commonlocatorsandmethods.scrolldownm();
		String mywatchlistShoCardName = commonlocatorsandmethods.shocardwatchlistShoName(mainShoName);
		assertTrue(mywatchlistShoCardName.equalsIgnoreCase(mainShoName));

	}

	@Then("^Remove from watchlit$")
	public void remove_from_watchlit() throws Throwable {
		commonlocatorsandmethods.hoverTitleCardHome(mainShoName);
		homepage.removeFromWatchlist.click();
	}

	@And("^check card availbility on my wacthlist row see all$")
	public void check_card_availbility_on_my_wacthlist_row_see_all() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(homepage.myWatchlistSeeAll));
		Actions actions = new Actions(driver);
		actions.moveToElement(homepage.myWatchlistSeeAll).click().build().perform();
		commonlocatorsandmethods.shocardwatchlistShoName(mainShoName);

	}

	@Given("^From home page click on share button in (.+) title card$")
	public void from_home_page_click_on_share_button_in_title_card(String shoName) throws Throwable {
		commonlocatorsandmethods.hoverTitleCardHome(shoName);
		Thread.sleep(2000);
		commonlocatorsandmethods.ShareButtononShoCard.click();

	}

	@When("^Click on share button from the card and verify share popup$")
	public void click_on_share_button_from_the_card_and_verify_share_popup() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(ShareFeature.SharePopup));
		assertTrue(ShareFeature.SharePopup.isDisplayed());
	}

	@And("^Navigate to gudsho home and click on sho name hyperlink from continue watching and verify redirection$")
	public void navigate_to_gudsho_home_and_click_on_sho_name_hyperlink_from_continue_watching_and_verify_redirection()
			throws Throwable {

		homepage.HeaderLogo.click();
		String continueWatchlingShoName = homepage.ShoNamesInContinueWatching.get(0).getText();
		homepage.ShoNamesInContinueWatching.get(0).click();
		assertTrue(continueWatchlingShoName.equalsIgnoreCase(shodetailpage.ShoNameonShoDetailPage.getAttribute("alt")));

	}

	@Given("^From home page click on sho type row see all hyperlink$")
	public void from_home_page_click_on_sho_type_row_see_all_hyperlink() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfAllElements(homepage.shoTypeRowSeeAll));
		Actions actions = new Actions(driver);
		actions.moveToElement(homepage.shoTypeRowSeeAll.get(0)).click().build().perform();
	}

	String masterShoName;

	@When("^Hover and click on click on add to watchlist in (.+) title card$")
	public void hover_and_click_on_click_on_add_to_watchlist_in_title_card(String shoname) throws Throwable {
		commonlocatorsandmethods.hoverTitleCardHome(shoname);
		homepage.addToWatchlistButton.click();

		mainShoName = shoname;
	}

	@And("^Navigate back and check card availbility on my watchlist row$")
	public void navigate_back_and_check_card_availbility_on_my_watchlist_row() throws Throwable {
		driver.navigate().back();
		commonlocatorsandmethods.scrolldownm();
		commonlocatorsandmethods.shocardwatchlistShoName(masterShoName);
		

	}
}
