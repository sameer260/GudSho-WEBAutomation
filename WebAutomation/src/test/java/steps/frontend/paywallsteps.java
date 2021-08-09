package steps.frontend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pageobjects.frontend.ShareFeature;
import Pageobjects.frontend.SignUp;
import Pageobjects.frontend.ToastandErrormessages;
import Pageobjects.frontend.audioplayer;
import Pageobjects.frontend.commonlocatorsandmethods;
import Pageobjects.frontend.homepage;
import Pageobjects.frontend.shodetailpage;
import Pageobjects.frontend.studiodetailpage;
import Pageobjects.frontend.videoplayer;
import Resources.BaseSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class paywallsteps extends BaseSetup {

	public static Logger log = Logger.getLogger(paywallsteps.class.getName());
	SignUp sign = new SignUp();
	shodetailpage shodetail = new shodetailpage();
	homepage home = new homepage();
	videoplayer video = new videoplayer();
	ToastandErrormessages toaster = new ToastandErrormessages();
	audioplayer audio = new audioplayer();
	studiodetailpage studio = new studiodetailpage();
	commonlocatorsandmethods common = new commonlocatorsandmethods();
	WebDriverWait wait = new WebDriverWait(driver, 20);

	@When("^From sho detail page click on add to watchlist$")
	public void from_sho_detail_page_click_on_add_to_watchlist() throws Throwable {
		Thread.sleep(2000);
		log.info("Clicking on the add to watchlist button");
		wait.until(ExpectedConditions.visibilityOf(shodetailpage.WatchListButton));
		shodetailpage.WatchListButton.click();

	}

	/*
	 * @When("^Validate the minipopup add to watchlist$") public void
	 * validate_the_minipopup_add_to_watchlist() throws Throwable {
	 * shodetailpage.SignInPopUp.isDisplayed();
	 * shodetailpage.SignInPopUpHeadderText.isDisplayed();
	 * wait.until(ExpectedConditions.visibilityOf(shodetailpage.
	 * SignInPopUpHeadderText)); assertEquals("Want to save & watch later?",
	 * shodetailpage.SignInPopUpHeadderText.getText());
	 * shodetailpage.SignInPopUpDescriptionText.isDisplayed();
	 * assertEquals("Sign In to save this video & watch again later",
	 * shodetailpage.SignInPopUpDescriptionText.getText());
	 * log.info("All minipopup elements are displaying");
	 * shodetailpage.PopUpSignInButton.click(); WebElement home =
	 * driver.findElement(By.xpath("//*[text()='Hello there!']"));
	 * wait.until(ExpectedConditions.visibilityOf(home)); home.isDisplayed();
	 * 
	 * }
	 */

	/*
	 * @Then("^Validate the minipopup Create gud$") public void
	 * validate_the_minipopup_create_gud() throws Throwable {
	 * shodetailpage.SignInPopUp.isDisplayed();
	 * shodetailpage.SignInPopUpHeadderText.isDisplayed();
	 * assertEquals("Like this Promo?",
	 * shodetailpage.SignInPopUpHeadderText.getText());
	 * shodetailpage.SignInPopUpDescriptionText.isDisplayed();
	 * assertEquals("Sign in now to rate this promo 'Gud'",
	 * shodetailpage.SignInPopUpDescriptionText.getText());
	 * log.info("All minipopup elements are displaying");
	 * shodetailpage.PopUpSignInButton.click(); WebElement home =
	 * driver.findElement(By.xpath("//*[text()='Hello there!']"));
	 * wait.until(ExpectedConditions.visibilityOf(home)); home.isDisplayed(); }
	 */

	/*
	 * @When("^Validate the minipopup follow button$") public void
	 * validate_the_minipopup_follow_button() throws Throwable {
	 * shodetailpage.SignInPopUp.isDisplayed();
	 * shodetailpage.SignInPopUpHeadderText.isDisplayed();
	 * assertEquals("Follow this Studio?",
	 * shodetailpage.SignInPopUpHeadderText.getText());
	 * shodetailpage.SignInPopUpDescriptionText.isDisplayed();
	 * assertEquals("Sign In to follow this studio & enter into the world of entertainment"
	 * , shodetailpage.SignInPopUpDescriptionText.getText());
	 * log.info("All minipopup elements are displaying");
	 * shodetailpage.PopUpSignInButton.click(); Thread.sleep(2000); WebElement home
	 * = driver.findElement(By.xpath("//*[text()='Hello there!']"));
	 * wait.until(ExpectedConditions.visibilityOf(home)); home.isDisplayed();
	 * 
	 * }
	 */

	@When("^while playing click on greate gud button$")
	public void while_playing_click_on_greate_gud_button() throws Throwable {
		Thread.sleep(3000);
		Actions a = new Actions(driver);
		// wait.until(ExpectedConditions.visibilityOfAllElements(videoplayer.PlayerGudICon));
		a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
		videoplayer.PlayerGudICon.click();
	}

	@And("^From sho detail page click on any promo$")
	public void from_sho_detail_page_click_on_any_promo() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfAllElements(shodetailpage.PromoCards));
		Actions actions = new Actions(driver);
		actions.moveToElement(shodetailpage.PromoCards.get(0)).click().build().perform();

	}

	/*
	 * @Then("^Validate Home page redirection$") public void
	 * validate_home_page_redirection() throws Throwable { Thread.sleep(2000);
	 * assertEquals("Please login to continue",
	 * ToastandErrormessages.ToastMessageText.getText()); WebElement home =
	 * driver.findElement(By.xpath("//*[text()='Hello there!']"));
	 * wait.until(ExpectedConditions.visibilityOf(home)); home.isDisplayed(); }
	 */

	@And("^From sho detail page click on Buy button$")
	public void from_sho_detail_page_click_on_buy_button() throws Throwable {
		shodetailpage.BuyButton.click();

	}

	@And("^From studio detail page click on follow button$")
	public void from_studio_detail_page_click_on_follow_button() throws Throwable {
		studiodetailpage.FollowButton.click();

	}

	@Then("^Check share popup is displayed with social ions$")
	public void check_share_popup_is_displayed_with_social_ions() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(ShareFeature.SharePopup));
		assertTrue(ShareFeature.SharePopup.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(ShareFeature.FacebookShareIcon));
		assertTrue(ShareFeature.FacebookShareIcon.isDisplayed());
		assertTrue(ShareFeature.TwitterShare.isDisplayed());
		assertTrue(ShareFeature.WhatsappShare.isDisplayed());
		assertTrue(ShareFeature.CopyLinkShare.isDisplayed());
	}

	@Then("^Share (.+) and verify share popup and share icons are displayed$")
	public void share_and_verify_share_popup_and_share_icons_are_displayed(String promoname) throws Throwable {
		shodetailpage.PromoCardShare(promoname);
		wait.until(ExpectedConditions.visibilityOf(ShareFeature.SharePopup));
		assertTrue(ShareFeature.SharePopup.isDisplayed());
	}

	@Then("^Vaildate Signin Popup$")
	public void vaildate_signin_popup() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(SignUp.SignInPoup));
		assertTrue(SignUp.SignInPoup.isDisplayed());
		assertTrue(SignUp.HelloThereText.isDisplayed());
	}

}
