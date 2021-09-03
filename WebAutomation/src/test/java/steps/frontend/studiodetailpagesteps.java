package steps.frontend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class studiodetailpagesteps extends BaseSetup {

	homepage home = new homepage();
	shodetailpage detailpage = new shodetailpage();
	paymentpage payment = new paymentpage();
	ToastandErrormessages toaster = new ToastandErrormessages();
	commonlocatorsandmethods cm = new commonlocatorsandmethods();
	ShareFeature share = new ShareFeature();
	studiodetailpage studio = new studiodetailpage();
	public static Logger log = Logger.getLogger(studiodetailpagesteps.class.getName());
	videoplayer video = new videoplayer();
	WebDriverWait wait = new WebDriverWait(driver, 30);

	@Then("^Share studio with all share icons$")
	public void share_studio_with_all_share_icons() throws Throwable {
		ShareFeature.Studioshare();
	}

	@Then("^Click on Banner image and verify redirection to correct sho detail page$")
	public void click_on_banner_image_and_verify_redirection_to_correct_sho_detail_page() throws Throwable {
		String shonameonstudiobanner = studiodetailpage.ShoNameonStudioBanner.getAttribute("alt");
		studiodetailpage.StudioBanner.click();
		String shonameonshodetailpage = shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
		log.info(shonameonshodetailpage);
		assertTrue(shonameonshodetailpage.equalsIgnoreCase(shonameonstudiobanner));

	}

	@When("^Click studio share icon$")
	public void click_studio_share_icon() throws Throwable {
		studiodetailpage.StudioShareButton.click();
	}

	// Ramya Code

	@When("^Click on Follow button$")
	public void click_on_follow_button() throws Throwable {
		studiodetailpage.FollowButton.click();
	}

	@Then("^check  toaster message and verify following text$")
	public void check_toaster_message_and_verify_following_text() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		String followtext = ToastandErrormessages.ToastMessageText.getText();
		assertEquals(followtext, "You have started following this studio");
		log.info("the toaster message is: " + followtext);
		ToastandErrormessages.ToastMessageClose.click();
	}

	@Then("^close player$")
	public void close_player() throws Throwable {
		videoplayer.CloseButton.click();

	}

	@When("^click (.+) and verify sho card redirection$")
	public void click_and_verify_sho_card_redirection(String genere) throws Throwable {
		Actions a = new Actions(driver);
		for (int i = 0; i < studiodetailpage.selectgenre.size(); i++) {
			if (studiodetailpage.selectgenre.get(i).getText().equalsIgnoreCase(genere)) {
				studiodetailpage.selectgenre.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfAllElements(studiodetailpage.selectshocardfromgenre));
		String actualsho = studiodetailpage.ShoNameattribtute.get(0).getAttribute("alt");
		log.info(actualsho);
		studiodetailpage.selectshocardfromgenre.click();
		String expectedsho = shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
		log.info(expectedsho);
		assertTrue(actualsho.equalsIgnoreCase(expectedsho));

	}

	@When("^verfiy promo player$")
	public void verfiy_promo_player() throws Throwable {
		String actualpromotext = studiodetailpage.verifypromonameonstudiopage.get(0).getText();
		log.info(actualpromotext);
		Actions a = new Actions(driver);
		a.moveToElement(studiodetailpage.clickpromo.get(0)).click().build().perform();
		Thread.sleep(10000);
		a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
		String Expectedpromotext = videoplayer.Promoname();
		log.info(Expectedpromotext);
		assertEquals(actualpromotext, Expectedpromotext);
		

	}

	@When("^click sho card and verify its redirected sho detail page$")
	public void click_sho_card_and_verify_its_redirected_sho_detail_page() throws Throwable {
		// commonlocatorsandmethods.scrolldownm();
		Actions a = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(studiodetailpage.shocard.get(0)));
		a.moveToElement(studiodetailpage.shocard.get(0)).build().perform();
		String actualsho = studiodetailpage.selectshonamefromstudiopage.get(0).getAttribute("alt");
		log.info(actualsho);
		a.moveToElement(studiodetailpage.selectshonamefromstudiopage.get(0)).click().build().perform();
		String expectedsho = shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
		log.info(expectedsho);
		assertTrue(actualsho.equalsIgnoreCase(expectedsho));

	}

	@Then("^From popup check unfollow studio and check toaster$")
	public void from_popup_check_unfollow_studio_and_check_toaster() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(studiodetailpage.UnfollowPopup));
		assertTrue(studiodetailpage.ConfirmationTextPopup.isDisplayed());
		assertTrue(studiodetailpage.ConfirmationHeading.isDisplayed());
		studiodetailpage.PopUpNoButton.click();
		studiodetailpage.FollowButton.click();
		wait.until(ExpectedConditions.visibilityOf(studiodetailpage.UnfollowPopup));
		assertTrue(studiodetailpage.ConfirmationTextPopup.isDisplayed());
		assertTrue(studiodetailpage.ConfirmationHeading.isDisplayed());
		studiodetailpage.PopUpYesButton.click();
		wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		String toastmessage = ToastandErrormessages.ToastMessageText.getText();
		log.info(toastmessage);
		assertEquals(toastmessage, "You have unfollowed this studio");

	}

	@And("^check studio info$")
	public void check_studio_info() throws Throwable {
		log.info(studiodetailpage.StudioDescriptionText.getText());
		assertTrue(studiodetailpage.StudioDescriptionText.isDisplayed());
	}

	@When("^click on watch free tab$")
	public void click_on_watch_free_tab() throws Throwable {
		studiodetailpage.WatchfreeButton.click();
	}

	@Then("^Check redirection of sho card from watch free tab$")
	public void check_redirection_of_sho_card_from_watch_free_tab() throws Throwable {
		String str = studiodetailpage.ShoNameattribtute.get(0).getAttribute("alt");
		studiodetailpage.WatchFreeShoCards.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(shodetailpage.WatchListButton));
		String str1 = shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
		assertEquals(str, str1);
	}

	@When("^Click (.+) which doesnot have any shos$")
	public void click_which_doesnot_have_any_shos(String genere) throws Throwable {
		for (int i = 0; i < studiodetailpage.selectgenre.size(); i++) {
			if (studiodetailpage.selectgenre.get(i).getText().equalsIgnoreCase(genere)) {
				studiodetailpage.selectgenre.get(i).click();
				break;
			}
		}
		assertTrue(studiodetailpage.NoshoGenereText.isDisplayed());
		String txt = studiodetailpage.NoshoGenereText.getText();
		assertEquals("Sorry! There are no contents under this genre at this moment.", txt);
		assertTrue(studiodetailpage.StudioHomeButton.isDisplayed());

	}

	@Then("^Click on studio home and verify its redirection to home$")
	public void click_on_studio_home_and_verify_its_redirection_to_home() throws Throwable {
		studiodetailpage.StudioHomeButton.click();
		assertTrue(studiodetailpage.HomeSectionElement.isDisplayed());
	}

	@Then("^Share sho card from home and verify popup$")
	public void share_sho_card_from_home_and_verify_popup() throws Throwable {
		Actions a = new Actions(driver);
		// a.sendKeys(Keys.END).build().perform();
		a.moveToElement(studiodetailpage.shocard.get(0)).build().perform();
		commonlocatorsandmethods.ShareButtononShoCard.click();
		wait.until(ExpectedConditions.visibilityOf(ShareFeature.SharePopup));
		assertTrue(ShareFeature.SharePopup.isDisplayed());
		ShareFeature.SharepopupClose.click();
	}

	@Then("^Click (.+) share sho card and verify popup$")
	public void click_share_sho_card_and_verify_popup(String genere) throws Throwable {
		for (int i = 0; i < studiodetailpage.selectgenre.size(); i++) {
			if (studiodetailpage.selectgenre.get(i).getText().equalsIgnoreCase(genere)) {
				studiodetailpage.selectgenre.get(i).click();
				break;
			}
		}
		Actions a = new Actions(driver);
		a.moveToElement(studiodetailpage.selectshocardfromgenre).build().perform();
		commonlocatorsandmethods.ShareButtononShoCard.click();
		wait.until(ExpectedConditions.visibilityOf(ShareFeature.SharePopup));
		assertTrue(ShareFeature.SharePopup.isDisplayed());
		ShareFeature.SharepopupClose.click();
	}

	@Then("^Verify share popup on watch free tab sho card$")
	public void click_on_watchfree_tab_and_share_sho_card_and_verify_popup() throws Throwable {
		studiodetailpage.WatchfreeButton.click();
		Actions a = new Actions(driver);
		a.moveToElement(studiodetailpage.WatchFreeShoCards.get(0)).build().perform();
		commonlocatorsandmethods.ShareButtononShoCard.click();
		wait.until(ExpectedConditions.visibilityOf(ShareFeature.SharePopup));
		assertTrue(ShareFeature.SharePopup.isDisplayed());
		ShareFeature.SharepopupClose.click();
	}

	@Then("^verify promo share popup$")
	public void verify_promo_share_popup() throws Throwable {
		Actions a = new Actions(driver);
		a.moveToElement(studiodetailpage.clickpromo.get(0)).build().perform();
		wait.until(ExpectedConditions.visibilityOf(studiodetailpage.PromoShareIcon));
		studiodetailpage.PromoShareIcon.click();
		assertTrue(ShareFeature.SharePopup.isDisplayed());
		ShareFeature.SharepopupClose.click();
	}

	@And("^Click on promo see all link and verify share popup$")
	public void click_on_promo_see_all_link() throws Throwable {
		Actions a = new Actions(driver);
		studiodetailpage.PromoSeeAllLink.get(0).click();
		Thread.sleep(1000);
		a.moveToElement(studiodetailpage.SeeAllPromoCards.get(1)).build().perform();
		studiodetailpage.PromoShareIcon.click();
		assertTrue(ShareFeature.SharePopup.isDisplayed());
		ShareFeature.SharepopupClose.click();
		commonlocatorsandmethods.SeeAllPageBackButton.click();
		wait.until(ExpectedConditions.visibilityOf(studiodetailpage.StudioNameInStudioPage));
		assertTrue(studiodetailpage.StudioNameInStudioPage.isDisplayed());

	}

	@When("^play (.+) from the row and like promo$")
	public void play_from_the_row_and_like_promo(String promoname) throws Throwable {
		Actions a = new Actions(driver);
		String promonameonstudiodetailpage = studiodetailpage.Promoclick(promoname);
		assertTrue(promoname.equalsIgnoreCase(promonameonstudiodetailpage));
		Thread.sleep(8000);
		a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
		videoplayer.PlayerGudICon.click();
		wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		String toastmessage = ToastandErrormessages.ToastMessageText.getText();
		ToastandErrormessages.ToastMessageText.click();
		assertEquals(toastmessage, "You liked this promo");
		a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
		videoplayer.CloseButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(homepage.HeaderLogo));
	}

	@When("^Play promo from see all page$")
	public void play_promo_from_see_all_page() throws Throwable {

		Actions a = new Actions(driver);
		a.moveToElement(studiodetailpage.PromoSeeAllLink.get(0)).click().build().perform();
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(studiodetailpage.SeeALLpromoelem));

	}

	@Then("^check redirection of promo and then to sho detail page$")
	public void check_redirection_of_promo_and_then_to_sho_detail_page() throws Throwable {
		Actions a = new Actions(driver);
		String promoname = studiodetailpage.verifypromonameonstudiopage.get(0).getText();
		log.info(promoname);
		a.moveToElement(studiodetailpage.SeeAllPromoCards.get(0)).click().build().perform();
		Thread.sleep(5000);
		a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
		String promonameonplayer = videoplayer.Promoname();
		log.info(promonameonplayer);
		assertEquals(promoname, promonameonplayer);
		String shoname = videoplayer.ShoNameOnPlayer.getText();
		videoplayer.CloseButton.click();
		wait.until(ExpectedConditions.visibilityOf(shodetailpage.WatchListButton));
		String str = shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
		log.info(str);
		assertTrue(shoname.equalsIgnoreCase(str));

	}

	@When("^Click on sho see all link$")
	public void click_on_sho_see_all_link() throws Throwable {
		Actions a = new Actions(driver);
		a.moveToElement(studiodetailpage.ShoSeeAllLink.get(0)).click().build().perform();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfAllElements(commonlocatorsandmethods.Shocards));

	}

	@Then("^Check watchlist in see all$")
	public void check_watchlist_in_see_all() throws Throwable {
		Actions a = new Actions(driver);
		String str = commonlocatorsandmethods.ShoNames.get(0).getAttribute("alt");
		log.info(str);
		a.moveToElement(commonlocatorsandmethods.Shocards.get(0)).build().perform();
		commonlocatorsandmethods.WatchLaterbuttononShoCard.click();
		wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		String toastmessage = ToastandErrormessages.ToastMessageText.getText();
		assertEquals(toastmessage, str + " has been added to watchlist");
		ToastandErrormessages.ToastMessageClose.click();
	}

	@Then("^check sho card redirection in see all$")
	public void check_sho_card_redirection_in_see_all() throws Throwable {
		Actions a = new Actions(driver);
		String str = commonlocatorsandmethods.ShoNames.get(0).getAttribute("alt");
		log.info(str);
		a.moveToElement(commonlocatorsandmethods.Shocards.get(0)).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(shodetailpage.WatchListButton));
		String str1 = shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
		log.info(str1);
		assertEquals(str, str1);
	}

	@Then("^Check Share popup in see all$")
	public void check_share_popup_in_see_all() throws Throwable {
		Actions a = new Actions(driver);
		a.moveToElement(commonlocatorsandmethods.Shocards.get(0)).build().perform();
		commonlocatorsandmethods.ShareButtononShoCard.click();
		wait.until(ExpectedConditions.visibilityOf(ShareFeature.SharePopup));
		assertTrue(ShareFeature.SharePopup.isDisplayed());
		ShareFeature.SharepopupClose.click();
		Thread.sleep(2000);
		commonlocatorsandmethods.SeeAllPageBackButton.click();
		wait.until(ExpectedConditions.visibilityOf(studiodetailpage.StudioNameInStudioPage));
		assertTrue(studiodetailpage.StudioNameInStudioPage.isDisplayed());
	}

	@And("^On home page check the added watchlist$")
	public void on_home_page_check_the_added_watchlist() throws Throwable {
		String shoname = studiodetailpage.ShoNameattribtute.get(0).getAttribute("alt");
		log.info(shoname);
		homepage.HeaderLogo.click();
		commonlocatorsandmethods.scrolldownm();
		String str = commonlocatorsandmethods.WatchlistRowonHomePage(shoname);
		log.info(str);
		assertEquals(shoname, str);
	}

	@When("^Click on watchlist button on sho card and check toaster$")
	public void click_on_watchlist_button_on_sho_card_and_check_toaster() throws Throwable {
		Actions a = new Actions(driver);
		String shoname = studiodetailpage.ShoNameattribtute.get(1).getAttribute("alt");
		a.moveToElement(studiodetailpage.shocard.get(1)).build().perform();
		commonlocatorsandmethods.WatchLaterbuttononShoCard.click();
		wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		String toast = ToastandErrormessages.ToastMessageText.getText();
		ToastandErrormessages.ToastMessageClose.click();
		assertTrue(toast.equalsIgnoreCase(shoname + " has been added to watchlist"));
	}

	@Then("^On home page check this sho card on watchlist row$")
	public void on_home_page_check_this_sho_card_on_watchlist_row() throws Throwable {
		String shoname = studiodetailpage.ShoNameattribtute.get(1).getAttribute("alt");
		homepage.HeaderLogo.click();
		commonlocatorsandmethods.scrolldownm();
		String str = commonlocatorsandmethods.WatchlistRowonHomePage(shoname);
		log.info(str);
		assertEquals(shoname, str);

	}

	@And("^Click on any (.+)$")
	public void click_on_any(String genere) throws Throwable {
		for (int i = 0; i < studiodetailpage.selectgenre.size(); i++) {
			if (studiodetailpage.selectgenre.get(i).getText().equalsIgnoreCase(genere)) {
				studiodetailpage.selectgenre.get(i).click();
				break;
			}
		}
	}
	int afterStudiocountonstudiodetail;
	
	    @When("^Click on (.+) and check followers count$")
	    public void click_on_and_check_followers_count(String useraction) throws Throwable {
	    	   String studiofollowercount= studiodetailpage.StudioFollowerCount.getText();
		       String str=studiofollowercount.substring(0,studiofollowercount.lastIndexOf(" Followers"));
		       int beforeStudiocountonstudiodetail=Integer.parseInt(str);
		       studiodetailpage.FollowButton.click();
		       if(useraction.equalsIgnoreCase("Follow"))
		       {
		    	    wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
					String followtext = ToastandErrormessages.ToastMessageText.getText();
					assertEquals(followtext, "You have started following this studio");
					log.info("the toaster message is: " + followtext);
					ToastandErrormessages.ToastMessageClose.click();
		       }
		       else if(useraction.equalsIgnoreCase("UnFollow"))
		       {
		    	   wait.until(ExpectedConditions.visibilityOf(studiodetailpage.UnfollowPopup));
					assertTrue(studiodetailpage.ConfirmationTextPopup.isDisplayed());
					assertTrue(studiodetailpage.ConfirmationHeading.isDisplayed());
					studiodetailpage.PopUpNoButton.click();
					studiodetailpage.FollowButton.click();
					wait.until(ExpectedConditions.visibilityOf(studiodetailpage.UnfollowPopup));
					assertTrue(studiodetailpage.ConfirmationTextPopup.isDisplayed());
					assertTrue(studiodetailpage.ConfirmationHeading.isDisplayed());
					studiodetailpage.PopUpYesButton.click();
					wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
					String toastmessage = ToastandErrormessages.ToastMessageText.getText();
					log.info(toastmessage);
					assertEquals(toastmessage, "You have unfollowed this studio");
		       }
		       if(useraction.equalsIgnoreCase("Follow"))
		       {
		    	    String Afterstudiofollowercount= studiodetailpage.StudioFollowerCount.getText();
				    String str1=Afterstudiofollowercount.substring(0,Afterstudiofollowercount.lastIndexOf(" Followers"));
				    afterStudiocountonstudiodetail=Integer.parseInt(str1);
				    assertEquals(beforeStudiocountonstudiodetail+1, afterStudiocountonstudiodetail); 
		       }
		       else if(useraction.equalsIgnoreCase("UnFollow"))
		       {
		    	   String Afterstudiofollowercount= studiodetailpage.StudioFollowerCount.getText();
				    String str1=Afterstudiofollowercount.substring(0,Afterstudiofollowercount.lastIndexOf(" Followers"));
				    afterStudiocountonstudiodetail=Integer.parseInt(str1);
				    assertEquals(beforeStudiocountonstudiodetail-1, afterStudiocountonstudiodetail); 
		       }
	    }
	    
	    @Then("^Check studio count on home page after (.+)$")
	    public void check_studio_count_on_home_page_after(String useraction) throws Throwable {
	    	 homepage.HeaderLogo.click();
		     commonlocatorsandmethods.scrolldownm();
	        if(useraction.equalsIgnoreCase("Follow"))
	        {
	        	String studiofollowcount=homepage.FollowerCount.get(0).getText();
		        String str1=studiofollowcount.substring(0,studiofollowcount.lastIndexOf(" Followers"));
		        int studiofollowercountint=Integer.parseInt(str1);
		        assertEquals(afterStudiocountonstudiodetail, studiofollowercountint);
	        }
	        else if(useraction.equalsIgnoreCase("Unfollow"))
	        {
	        	String studiofollowcount=homepage.FollowerCount.get(0).getText();
		        String str1=studiofollowcount.substring(0,studiofollowcount.lastIndexOf(" Followers"));
		        int studiofollowercountint=Integer.parseInt(str1);
		        assertEquals(afterStudiocountonstudiodetail, studiofollowercountint);
	        }
	    }
	    int gudcountbefore;
	    int viewcountbefore;
	    @And("^capture view and gud count of (.+)$")
	    public void capture_view_and_gud_count_of(String promoname) throws Throwable {
	       gudcountbefore=shodetailpage.GudCount(promoname, shodetailpage.PromoNamesofPromoCards);
	       viewcountbefore=shodetailpage.ViewCount(promoname, shodetailpage.PromoNamesofPromoCards);
	        
	    }
	    @Then("^Wait till studio page load$")
	    public void wait_till_studio_page_load() throws Throwable {
	       wait.until(ExpectedConditions.visibilityOf(studiodetailpage.StudioNameInStudioPage));
	    }
	    @And("^verify gud and view count of (.+) again for (.+)$")
	    public void verify_gud_and_view_count_of_again_for(String promoname, String useraction) throws Throwable {
	    	int gudcountafter=shodetailpage.GudCount(promoname, shodetailpage.PromoNamesofPromoCards);
	        int viewcountafter=shodetailpage.ViewCount(promoname, shodetailpage.PromoNamesofPromoCards);
	    	if(useraction.equalsIgnoreCase("Like"))
	    	{
	        assertEquals(gudcountbefore+1,gudcountafter);
	        assertEquals(viewcountbefore+1, viewcountafter);
	    	}
	    	else if(useraction.equalsIgnoreCase("Unlinke"))
	    	{
	    		assertEquals(gudcountbefore-1,gudcountafter);
		        assertEquals(viewcountbefore+1, viewcountafter);
	    	}
	    }
	    @Then("^Check gud and view count of (.+) in see all page for (.+)$")
	    public void check_gud_and_view_count_of_in_see_all_page_for(String promoname, String useraction) throws Throwable {
	    	Actions a = new Actions(driver);
			a.moveToElement(studiodetailpage.PromoSeeAllLink.get(0)).click().build().perform();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOf(studiodetailpage.SeeALLpromoelem));
			int gudcount=shodetailpage.GudCount(promoname, studiodetailpage.verifypromonameonstudiopage);
			int viewcount=shodetailpage.ViewCount(promoname, studiodetailpage.verifypromonameonstudiopage);
			if(useraction.equalsIgnoreCase("Like"))
	    	{
	        assertEquals(gudcountbefore+1,gudcount);
	        assertEquals(viewcountbefore+1, viewcount);
	    	}
	    	else if(useraction.equalsIgnoreCase("Unlinke"))
	    	{
	    		assertEquals(gudcountbefore-1,gudcount);
		        assertEquals(viewcountbefore+1,viewcount);
	    	}
			
			
	    }
	    @Then("^Check right and left arrows on sho card rows$")
	    public void check_right_and_left_arrows_on_sho_card_rows() throws Throwable {
	    	Actions a=new Actions(driver);
	    	a.sendKeys(Keys.END).build().perform();
	        commonlocatorsandmethods.RightLeftArrows(commonlocatorsandmethods.NextArrow,commonlocatorsandmethods.PreviousArrow,3);
	    }
	    @Then("^verify banner static image is displaying$")
	    public void verify_banner_static_image_is_displaying() throws Throwable {
	       String stsicbannerimageURL= studiodetailpage.StaticBannerImage.getAttribute("src");
	       assertEquals("https://gudsho-static.akamaized-staging.net/Images/static/studio-placeholder.png",stsicbannerimageURL);
	        
	    }
	    
	    
	    
	    
	//Ramya Count
	    
	    @Then("^click followers link and verify it should display  followers list pop up$")
	    public void click_followers_link_and_verify_it_should_display_followers_list_pop_up() throws Throwable {
	    	    Actions a=new Actions(driver);
	    	    studiodetailpage.followers();
	    		a.moveToElement(studiodetailpage.studiofollowersclose).click().build().perform();
	    		assertTrue(studiodetailpage.StudioNameInStudioPage.isDisplayed());
	    	}
    
	    
	    
	    @Then("^click report studio  button in studio page and verify it displays popup of report studio list and check success  message$")
        public void click_report_studio_button_in_studio_page_and_verify_it_displays_popup_of_report_studio_list_and_check_success_message() throws Throwable {
	    	Actions a=new Actions(driver);
	    	wait.until(ExpectedConditions.visibilityOf(studiodetailpage.reportstudio)).click();
	    	a.moveToElement(studiodetailpage.reportstudiobutton).click().build().perform();
	    	studiodetailpage.reportstudio();
	    	a.moveToElement(studiodetailpage.reportbutton).click().build().perform();
	    	wait.until(ExpectedConditions.visibilityOf(studiodetailpage.ReportThankYouText));
	    	String thankyoutext=studiodetailpage.ReportThankYouText.getText();
	    	assertEquals(thankyoutext, "Thank you, for letting us know");
	    	a.moveToElement(studiodetailpage.reportclose).click().build().perform();
	    	wait.until(ExpectedConditions.visibilityOf(studiodetailpage.StudioNameInStudioPage));
	    	assertTrue(studiodetailpage.StudioNameInStudioPage.isDisplayed());
	    }

	    

	    @Then("^click report studio  button in studio page and verify it displays popup of report studio list and check cancel scenario also$")
	    public void click_report_studio_button_in_studio_page_and_verify_it_displays_popup_of_report_studio_list_and_check_cancel_scenario_also() throws Throwable {
	    	Actions a=new Actions(driver);
	    	wait.until(ExpectedConditions.visibilityOf(studiodetailpage.reportstudio)).click();
	    	a.moveToElement(studiodetailpage.reportstudiobutton).click().build().perform();
	    	studiodetailpage.reportstudio();
	    	a.moveToElement(studiodetailpage.reportbutton).click().build().perform();
	    	wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
	    	String toast=ToastandErrormessages.ToastMessageText.getText();
	    	assertTrue(toast.equalsIgnoreCase("You already reported this studio"));
	    	ToastandErrormessages.ToastMessageClose.click();
	    	a.moveToElement(studiodetailpage.reportcancel).click().build().perform();
	    	wait.until(ExpectedConditions.visibilityOf(studiodetailpage.StudioNameInStudioPage));
	    	assertTrue(studiodetailpage.StudioNameInStudioPage.isDisplayed());
	    }

	    @Then("^click report studio  close button in studio page and verify it should redirected to studio detail page$")
	    public void click_report_studio_close_button_in_studio_page_and_verify_it_should_redirected_to_studio_detail_page() throws Throwable {
	    	Actions a=new Actions(driver);
	    	studiodetailpage.reportstudio.click();
	    	a.moveToElement(studiodetailpage.reportstudiobutton).click().build().perform();
	    	studiodetailpage.reportstudio();
	    	studiodetailpage.studiofollowersclose.click();
	    	wait.until(ExpectedConditions.visibilityOf(studiodetailpage.StudioNameInStudioPage));
	    	assertTrue(studiodetailpage.StudioNameInStudioPage.isDisplayed());

	    }

	    
	    
	    

}
