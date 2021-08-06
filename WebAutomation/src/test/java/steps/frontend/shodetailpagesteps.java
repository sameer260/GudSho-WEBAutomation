package steps.frontend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tigervnc.rdr.Exception;

import Pageobjects.frontend.ShareFeature;
import Pageobjects.frontend.ToastandErrormessages;
import Pageobjects.frontend.commonlocatorsandmethods;
import Pageobjects.frontend.homepage;
import Pageobjects.frontend.paymentpage;
import Pageobjects.frontend.shodetailpage;
import Pageobjects.frontend.studiodetailpage;
import Pageobjects.frontend.videoplayer;
import Resources.BaseSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class shodetailpagesteps extends BaseSetup {
	homepage home = new homepage();
	shodetailpage detailpage = new shodetailpage();
	paymentpage payment = new paymentpage();
	ToastandErrormessages toaster = new ToastandErrormessages();
	commonlocatorsandmethods cm = new commonlocatorsandmethods();
	ShareFeature share = new ShareFeature();
	studiodetailpage studio = new studiodetailpage();
	public static Logger log = Logger.getLogger(shodetailpagesteps.class.getName());
	videoplayer video = new videoplayer();
	WebDriverWait wait = new WebDriverWait(driver, 30);

	@When("^Buy the sho using (.+) with (.+)$")
	public void buy_the_sho_using_with(String paymentmode, String paymentscenario) throws Throwable {
		shodetailpage.BuyButton.click();
		wait.until(ExpectedConditions.visibilityOf(paymentpage.PopupContinueButton));
		paymentpage.PopupContinueButton.click();
		paymentpage.switchframe(paymentscenario, paymentmode);

	}

	@Then("^Verify after payment (.+) is playing and close the player$")
	public void verify_after_payment_is_playing_and_close_the_player(String shoname) throws Throwable {
		Actions a = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		log.info(ToastandErrormessages.ToastMessageText.getText());
		assertEquals(ToastandErrormessages.ToastMessageText.getText(), "Payment Processed");
		Thread.sleep(2000);
		a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
		wait.until(ExpectedConditions.visibilityOf(videoplayer.ShoNameOnPlayer));
		String ShonameonPlayer = videoplayer.ShoNameOnPlayer.getText();
		assertEquals(ShonameonPlayer, shoname);
		videoplayer.CloseButtonforSho.click();
	}

	@When("^Add (.+) in to watchlist and check the toaster message$")
	public void add_in_to_watchlist_and_check_the_toaster_message(String shoname) throws Throwable {
		shodetailpage.WatchListButton.click();
		wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		String Toastmessage = ToastandErrormessages.ToastMessageText.getText();
		assertEquals(Toastmessage, shoname + " has been added to watchlist");
	}

	@Then("^On home page check the added watchlist (.+)$")
	public void on_home_page_check_the_added_watchlist(String shoname) throws Throwable {
		homepage.HeaderLogo.click();
		commonlocatorsandmethods.scrolldownm();
		String str = commonlocatorsandmethods.shocardwatchlistShoName(shoname);
		log.info(str);
		assertEquals(shoname, str);

	}

	@When("^Click on Share button$")
	public void click_on_share_button() throws Throwable {
		shodetailpage.ShareButton.click();
	}

	@Then("^Share the (.+) using all social icons$")
	public void share_the_using_all_social_icons(String shoorpromo) throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(ShareFeature.SharePopup));
		ShareFeature.SocialShare(shoorpromo);

	}

	@When("^Play (.+) and like promo$")
	public void play_and_like_promo(String promoname) throws Throwable {
		shodetailpage.PromoCardClick(promoname);
		Actions a = new Actions(driver);
		a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
		videoplayer.PlayerGudICon.click();
		wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		String actual = ToastandErrormessages.ToastMessageText.getText();
		log.info(actual);
		assertEquals(actual, "You liked this promo");
		ToastandErrormessages.ToastMessageClose.click();
		a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
		wait.until(ExpectedConditions.visibilityOf(videoplayer.PromoNameonPlayer));
		String promonameonplayer = videoplayer.Promoname();
		log.info(promonameonplayer);
		assertTrue(promonameonplayer.equalsIgnoreCase(promoname));
		a.moveToElement(videoplayer.CloseButton).click().build().perform();
	}

	@Then("^On home page check liked (.+) is showing in my gud promos$")
	public void on_home_page_check_liked_is_showing_in_my_gud_promos(String promoname) throws Throwable {
		homepage.HeaderLogo.click();
		commonlocatorsandmethods.scrolldownm();
		String PromonameongudPromos = homepage.mygudpromos(promoname);
		log.info(PromonameongudPromos);
		assertEquals(promoname, PromonameongudPromos);
	}

	@Then("^Click on Studio link and check redirected to studio detail page$")
	public void click_on_studio_link_and_check_redirected_to_studio_detail_page() throws Throwable {
		String str = shodetailpage.StudionameinStudioLink.getText();
		String Studionameinshodetailpage = str.substring(0, str.length() - 2);
		shodetailpage.StudioLink.click();
		wait.until(ExpectedConditions.visibilityOf(studiodetailpage.StudioNameInStudioPage));
		String studionamestudiodetailpage = studiodetailpage.StudioNameInStudioPage.getText();
		assertTrue(Studionameinshodetailpage.equalsIgnoreCase(studionamestudiodetailpage));
	}

	@Then("^Hover on (.+) card and share promo (.+) using all shares$")
	public void hover_on_card_and_share_promo_using_all_shares(String promoname, String sharetype) throws Throwable {
		String Promoname = shodetailpage.PromoCardShare(promoname);
		String promonameonplayer = ShareFeature.SocialShare(sharetype);
		assertEquals(Promoname, promonameonplayer);

	}

	 @When("^Play watch free content and close the player$")
	    public void play_watch_free_content_and_close_the_player() throws Throwable {
		shodetailpage.BuyButton.click();
		Thread.sleep(10000);
		Actions a = new Actions(driver);
		a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
		wait.until(ExpectedConditions.visibilityOf(videoplayer.CloseButtonforSho));
		videoplayer.CloseButtonforSho.click();
	}

	@And("^On sho detail page verify watch now button should change to resume$")
	public void on_sho_detail_page_verify_watch_now_button_should_change_to_resume() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(shodetailpage.WatchListButton));
		String str = shodetailpage.ResumeButtonForSho.getText();
		log.info(str);
		assertEquals(str, "Resume");
	}

	@Then("^On Home Page check continue wathing is showing (.+)$")
	public void on_home_page_check_continue_wathing_is_showing(String shoname) throws Throwable {
		homepage.HeaderLogo.click();
		String ShonameInContinueWatching = null;
		for (int i = 0; i < homepage.ShoNamesInContinueWatching.size(); i++) {
			if (homepage.ShoNamesInContinueWatching.get(i).getText().equalsIgnoreCase(shoname)) {
				ShonameInContinueWatching = homepage.ShoNamesInContinueWatching.get(i).getText();
				log.info(ShonameInContinueWatching);
				break;
			}
		}
		assertEquals(ShonameInContinueWatching, shoname);
	}

	@When("^Check all sho detail info and check seemore popup if (.+)$")
	public void check_all_sho_detail_info_and_check_seemore_popup_if(String available) throws Throwable {
		for (int i = 0; i < shodetailpage.ShoDetailsInfo.size(); i++) {
			assertTrue(shodetailpage.ShoDetailsInfo.get(i).isDisplayed());
		}
		assertTrue(shodetailpage.ShoDetailDescription.isDisplayed());
		if (available.equalsIgnoreCase("Yes")) {
			shodetailpage.SeeMoreLink.click();
			wait.until(ExpectedConditions.visibilityOf(shodetailpage.AboutPopup));
			assertTrue(shodetailpage.AboutPopup.isDisplayed());
			assertTrue(shodetailpage.DescriptionTextInpopup.isDisplayed());
			log.info(shodetailpage.DescriptionTextInpopup.getText());
			assertTrue(shodetailpage.AboutTextinAboutPopup.isDisplayed());
			log.info(shodetailpage.AboutTextinAboutPopup.getText());
			shodetailpage.AboutPopupCrossButton.click();
			Thread.sleep(500);
		} else {
			log.info("This sho doesnot have more description,so no See more link");
		}

	}

	@Then("^check About section if about tab (.+)$")
	public void check_about_section_if_about_tab(String availability) throws Throwable {
		if (availability.equalsIgnoreCase("Yes")) {
			shodetailpage.AboutTab.click();
			commonlocatorsandmethods.scrolldownm();
			assertTrue(shodetailpage.EntireAboutSection.isDisplayed());
			for (int j = 0; j < shodetailpage.AboutSectionElements.size(); j++) {
				assertTrue(shodetailpage.AboutSectionElements.get(j).isDisplayed());
			}

		} else {
			log.info("This Sho doesnot any Audios and promos tab");
			commonlocatorsandmethods.scrolldownm();
			assertTrue(shodetailpage.EntireAboutSection.isDisplayed());
			for (int j = 0; j < shodetailpage.AboutSectionElements.size(); j++) {
				assertTrue(shodetailpage.AboutSectionElements.get(j).isDisplayed());
			}
		}
	}

	@Then("^Click on shareicon from shocard and verify share popup$")
	public void click_on_shareicon_from_shocard_and_verify_share_popup() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.END).build().perform();
		a.moveToElement(shodetailpage.ShoCards.get(0)).build().perform();
		shodetailpage.ShareButtononShoCard.click();
		wait.until(ExpectedConditions.visibilityOf(ShareFeature.SharePopup));
		assertTrue(ShareFeature.SharePopup.isDisplayed());
		ShareFeature.SharepopupClose.click();
		shodetailpage.MoreLikeThisEle.click();
		wait.until(ExpectedConditions.visibilityOf(commonlocatorsandmethods.MoreLikethistext));
		assertTrue(commonlocatorsandmethods.MoreLikethistext.isDisplayed());
		a.moveToElement(commonlocatorsandmethods.Shocards.get(0)).build().perform();
		commonlocatorsandmethods.ShareButtononShoCard.click();
		wait.until(ExpectedConditions.visibilityOf(ShareFeature.SharePopup));
		assertTrue(ShareFeature.SharePopup.isDisplayed());

	}

	@Then("^Check redirection of card and watchlist functionality of sho card on home page$")
	public void check_redirection_of_card_and_watchlist_functionality_of_sho_card_on_home_page() throws Throwable {
		commonlocatorsandmethods.scrolldownm();
		Actions a = new Actions(driver);
		a.moveToElement(shodetailpage.ShoCards.get(0)).build().perform();
		String shoname = shodetailpage.shonamefromShoCards.get(0).getAttribute("alt");
		log.info(shoname);
		shodetailpage.WatchLaterbuttononShoCard.click();
		wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		String Toastmessage = ToastandErrormessages.ToastMessageText.getText();
		log.info(Toastmessage);
		assertEquals(Toastmessage, shoname + " has been added to watchlist");
		ToastandErrormessages.ToastMessageClose.click();
		wait.until(ExpectedConditions.elementToBeClickable(shodetailpage.ShoCards.get(0)));
		a.moveToElement(shodetailpage.ShoCards.get(0)).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(shodetailpage.WatchListButton));
		String str = shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
		assertEquals(str, shoname);
		homepage.HeaderLogo.click();
		commonlocatorsandmethods.scrolldownm();
		String str1 = commonlocatorsandmethods.shocardwatchlistShoName(shoname);
		assertEquals(str1, str);
		assertEquals(str1, shoname);

	}

	@Then("^click on more like this link and check watchlist toaster$")
	public void click_on_see_more_link_check_share_popup_and_watchlist_toaster() throws Throwable {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.END).build().perform();
		shodetailpage.MoreLikeThisEle.click();
		Thread.sleep(1500);
		wait.until(ExpectedConditions.visibilityOf(commonlocatorsandmethods.MoreLikethistext));
		assertTrue(commonlocatorsandmethods.MoreLikethistext.isDisplayed());
		a.moveToElement(commonlocatorsandmethods.Shocards.get(1)).build().perform();
		String shoname = commonlocatorsandmethods.ShoNames.get(1).getAttribute("alt");
		log.info(shoname);
		commonlocatorsandmethods.WatchLaterbuttononShoCard.click();
		wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		String Toastmessage = ToastandErrormessages.ToastMessageText.getText();
		log.info(Toastmessage);
		assertEquals(Toastmessage, shoname + " has been added to watchlist");
		ToastandErrormessages.ToastMessageClose.click();
	}

	@And("^Check redirection of sho card$")
	public void check_redirection_of_sho_card() throws Throwable {
		Actions a = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(commonlocatorsandmethods.Shocards.get(1)));
		String shoname = commonlocatorsandmethods.ShoNames.get(1).getAttribute("alt");
		a.moveToElement(commonlocatorsandmethods.Shocards.get(1)).click().build().perform();
		String str = shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
		assertEquals(shoname, str);

	}

}
