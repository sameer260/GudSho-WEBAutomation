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

public class studiodetailpagesteps  extends BaseSetup{
	
	homepage home=new homepage();
	shodetailpage detailpage=new shodetailpage();
	paymentpage payment=new paymentpage();
	ToastandErrormessages toaster=new ToastandErrormessages();
	commonlocatorsandmethods cm=new commonlocatorsandmethods();
	ShareFeature share=new ShareFeature();
	studiodetailpage studio=new studiodetailpage();
	public static Logger log=Logger.getLogger(studiodetailpagesteps.class.getName());
	videoplayer video=new videoplayer();
	WebDriverWait wait=new WebDriverWait(driver,30);
	
	
	 @Then("^Share studio with all share icons$")
	    public void share_studio_with_all_share_icons() throws Throwable {
	        ShareFeature.Studioshare();
	    }
	 

	 @Then("^Click on Banner image and verify redirection to correct sho detail page$")
	    public void click_on_banner_image_and_verify_redirection_to_correct_sho_detail_page() throws Throwable {
		 String shonameonstudiobanner=studiodetailpage.ShoNameonStudioBanner.getAttribute("alt");   
		 studiodetailpage.StudioBanner.click();
		   String shonameonshodetailpage = shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
			log.info(shonameonshodetailpage);
			assertTrue(shonameonshodetailpage.equalsIgnoreCase(shonameonstudiobanner));
	        
	    }
	 @When("^Click studio share icon$")
	    public void click_studio_share_icon() throws Throwable {
	        studiodetailpage.StudioShareButton.click();
	    }
	 
	 
	 //Ramya Code
	 
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
			 Actions a=new Actions(driver);
			 for(int i=0;i<studiodetailpage.selectgenre.size();i++)
			 {
				 if(studiodetailpage.selectgenre.get(i).getText().equalsIgnoreCase(genere))
				 {
					 studiodetailpage.selectgenre.get(i).click();
					 break;
				 }
			 }
			 Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfAllElements(studiodetailpage.selectshocardfromgenre));
			String actualsho=studiodetailpage.ShoNameattribtute.get(0).getAttribute("alt");
			log.info(actualsho);
			studiodetailpage.selectshocardfromgenre.click();
			String expectedsho=shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
			log.info(expectedsho);
			assertTrue(actualsho.equalsIgnoreCase(expectedsho));
	      
		}
		@When("^verfiy promo player$")
		   public void verfiy_promo_player() throws Throwable {
		       String actualpromotext= studiodetailpage.verifypromonameonstudiopage.get(0).getText();
		       log.info(actualpromotext);
		       Actions a=new Actions(driver);
		       a.moveToElement(studiodetailpage.clickpromo.get(0)).click().build().perform();
		       Thread.sleep(10000);
		       a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
		       String Expectedpromotext=videoplayer.Promoname();
		       log.info(Expectedpromotext);
		       assertEquals(actualpromotext,Expectedpromotext);

		}

		@When("^click sho card and verify its redirected sho detail page$")
		   public void click_sho_card_and_verify_its_redirected_sho_detail_page() throws Throwable {
		//commonlocatorsandmethods.scrolldownm();
		Actions a=new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(studiodetailpage.shocard.get(0)));
		a.moveToElement(studiodetailpage.shocard.get(0)).build().perform();
		String actualsho=studiodetailpage.selectshonamefromstudiopage.get(0).getAttribute("alt");
		log.info(actualsho);
		a.moveToElement(studiodetailpage.selectshonamefromstudiopage.get(0)).click().build().perform();
		String expectedsho=shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
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
	        String toastmessage=ToastandErrormessages.ToastMessageText.getText();
	        log.info(toastmessage);
	        assertEquals(toastmessage,"You have unfollowed this studio");
	        
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
	    	String str=studiodetailpage.ShoNameattribtute.get(0).getAttribute("alt");
	        studiodetailpage.WatchFreeShoCards.get(0).click();
	        wait.until(ExpectedConditions.visibilityOf(shodetailpage.WatchListButton));
	        String str1=shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
	        assertEquals(str,str1);
	    }
	    @When("^Click (.+) which doesnot have any shos$")
	    public void click_which_doesnot_have_any_shos(String genere) throws Throwable {
	    	for(int i=0;i<studiodetailpage.selectgenre.size();i++)
			 {
				 if(studiodetailpage.selectgenre.get(i).getText().equalsIgnoreCase(genere))
				 {
					 studiodetailpage.selectgenre.get(i).click();
					 break;
				 }
			 }
	    	assertTrue(studiodetailpage.NoshoGenereText.isDisplayed());
	    	String txt=studiodetailpage.NoshoGenereText.getText();
	    	assertEquals("Sorry! There are no contents under this genre at this moment.",txt);
	    	assertTrue(studiodetailpage.StudioHomeButton.isDisplayed());
	    	
	    }

	    @Then("^Click on studio home and verify its redirection to home$")
	    public void click_on_studio_home_and_verify_its_redirection_to_home() throws Throwable {
	    	studiodetailpage.StudioHomeButton.click();
	    	assertTrue(studiodetailpage.HomeSectionElement.isDisplayed());
	    }
	    @Then("^Share sho card from home and verify popup$")
	    public void share_sho_card_from_home_and_verify_popup() throws Throwable {
	    	Actions a =new Actions(driver);
	    	//a.sendKeys(Keys.END).build().perform();
	    	a.moveToElement(studiodetailpage.shocard.get(0)).build().perform();
	        commonlocatorsandmethods.ShareButtononShoCard.click();
	        wait.until(ExpectedConditions.visibilityOf(ShareFeature.SharePopup));
	        assertTrue(ShareFeature.SharePopup.isDisplayed());
	        ShareFeature.SharepopupClose.click();
	    }

	    @Then("^Click (.+) share sho card and verify popup$")
	    public void click_share_sho_card_and_verify_popup(String genere) throws Throwable {
	    	for(int i=0;i<studiodetailpage.selectgenre.size();i++)
			 {
				 if(studiodetailpage.selectgenre.get(i).getText().equalsIgnoreCase(genere))
				 {
					 studiodetailpage.selectgenre.get(i).click();
					 break;
				 }
			 }
	    	Actions a =new Actions(driver);
	    	a.moveToElement(studiodetailpage.selectshocardfromgenre).build().perform();
	        commonlocatorsandmethods.ShareButtononShoCard.click();
	        wait.until(ExpectedConditions.visibilityOf(ShareFeature.SharePopup));
	        assertTrue(ShareFeature.SharePopup.isDisplayed());
	        ShareFeature.SharepopupClose.click();
	    }

	    @Then("^Verify share popup on watch free tab sho card$")
	    public void click_on_watchfree_tab_and_share_sho_card_and_verify_popup() throws Throwable {
	    	studiodetailpage.WatchfreeButton.click();
	    	Actions a =new Actions(driver);
	    	a.moveToElement(studiodetailpage.WatchFreeShoCards.get(0)).build().perform();
	        commonlocatorsandmethods.ShareButtononShoCard.click();
	        wait.until(ExpectedConditions.visibilityOf(ShareFeature.SharePopup));
	        assertTrue(ShareFeature.SharePopup.isDisplayed());
	        ShareFeature.SharepopupClose.click();
	    }
	    @Then("^verify promo share popup$")
	    public void verify_promo_share_popup() throws Throwable {
	    	Actions a=new Actions(driver);
	    	a.moveToElement(studiodetailpage.clickpromo.get(0)).build().perform();
	        wait.until(ExpectedConditions.visibilityOf(studiodetailpage.PromoShareIcon));
	        studiodetailpage.PromoShareIcon.click();
	        assertTrue(ShareFeature.SharePopup.isDisplayed());
	        ShareFeature.SharepopupClose.click();
	    }

	    @And("^Click on promo see all link and verify share popup$")
	    public void click_on_promo_see_all_link() throws Throwable {
	    	Actions a=new Actions(driver);
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
	    	Actions a =new Actions(driver);
	        String promonameonstudiodetailpage=studiodetailpage.Promoclick(promoname);
	        assertTrue(promoname.equalsIgnoreCase(promonameonstudiodetailpage));
	        Thread.sleep(8000);
	        a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
	        videoplayer.PlayerGudICon.click();
	        wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
	        String toastmessage=ToastandErrormessages.ToastMessageText.getText();
	        ToastandErrormessages.ToastMessageText.click();
	        assertEquals(toastmessage, "You liked this promo");
	        a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
	        videoplayer.CloseButton.click();
	        wait.until(ExpectedConditions.elementToBeClickable(homepage.HeaderLogo));  
	    }
	    @When("^Play promo from see all page$")
	    public void play_promo_from_see_all_page() throws Throwable {
	        
	    	Actions a=new Actions(driver);
	    	a.moveToElement(studiodetailpage.PromoSeeAllLink.get(0)).click().build().perform();;
	        Thread.sleep(3000);
	        wait.until(ExpectedConditions.visibilityOf(studiodetailpage.SeeALLpromoelem));
	        
	    }

	    @Then("^check redirection of promo and then to sho detail page$")
	    public void check_redirection_of_promo_and_then_to_sho_detail_page() throws Throwable {
	    	Actions a=new Actions(driver);
	    	String promoname=studiodetailpage.verifypromonameonstudiopage.get(0).getText();
	    	log.info(promoname);
	    	a.moveToElement(studiodetailpage.SeeAllPromoCards.get(0)).click().build().perform();
	    	Thread.sleep(5000);
	    	a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
	    	String promonameonplayer=videoplayer.Promoname();
	    	log.info(promonameonplayer);
	    	assertEquals(promoname, promonameonplayer);
	    	String shoname=videoplayer.ShoNameOnPlayer.getText();
	    	videoplayer.CloseButton.click();
	    	wait.until(ExpectedConditions.visibilityOf(shodetailpage.WatchListButton));
	    	String str=shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
	    	log.info(str);
	    	assertTrue(shoname.equalsIgnoreCase(str));
	    	
	    }
	    @When("^Click on sho see all link$")
	    public void click_on_sho_see_all_link() throws Throwable {
	    	Actions a =new Actions(driver);
	    	a.moveToElement(studiodetailpage.ShoSeeAllLink.get(0)).click().build().perform();
	        Thread.sleep(3000);
	        wait.until(ExpectedConditions.visibilityOfAllElements(commonlocatorsandmethods.Shocards));
	        
	    }
	    
	    @Then("^Check watchlist in see all$")
	    public void check_watchlist_in_see_all() throws Throwable {
	    	Actions a=new Actions(driver);
	    	String str=commonlocatorsandmethods.ShoNames.get(0).getAttribute("alt");
	        log.info(str);
	    	a.moveToElement(commonlocatorsandmethods.Shocards.get(0)).build().perform();
	    	commonlocatorsandmethods.WatchLaterbuttononShoCard.click();
	        wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
	        String toastmessage=ToastandErrormessages.ToastMessageText.getText();
	        assertEquals(toastmessage,str+" has been added to watchlist");
	        ToastandErrormessages.ToastMessageClose.click();
	    }

	    @Then("^check sho card redirection in see all$")
	    public void check_sho_card_redirection_in_see_all() throws Throwable {
	    	Actions a=new Actions(driver);
	    	String str=commonlocatorsandmethods.ShoNames.get(0).getAttribute("alt");
	        log.info(str);
	        a.moveToElement(commonlocatorsandmethods.Shocards.get(0)).click().build().perform();
	        wait.until(ExpectedConditions.visibilityOf(shodetailpage.WatchListButton));
	        String str1=shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
	        log.info(str1);
	        assertEquals(str, str1);
	    }

	    @Then("^Check Share popup in see all$")
	    public void check_share_popup_in_see_all() throws Throwable {
	    	Actions a=new Actions(driver);
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
	    	String shoname=studiodetailpage.ShoNameattribtute.get(0).getAttribute("alt");
	        log.info(shoname);
	    	homepage.HeaderLogo.click();
	        commonlocatorsandmethods.scrolldownm();
	        String str=commonlocatorsandmethods.WatchlistRowonHomePage(shoname);
	        log.info(str);
	        assertEquals(shoname,str);
	    }
	    @When("^Click on watchlist button on sho card and check toaster$")
	    public void click_on_watchlist_button_on_sho_card_and_check_toaster() throws Throwable {
	    	Actions a=new Actions(driver);
	    	String shoname=studiodetailpage.ShoNameattribtute.get(1).getAttribute("alt");
	        a.moveToElement(studiodetailpage.shocard.get(1)).build().perform();
	        commonlocatorsandmethods.WatchLaterbuttononShoCard.click();
	        wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
	        String toast=ToastandErrormessages.ToastMessageText.getText();
	        ToastandErrormessages.ToastMessageClose.click();
	        assertTrue(toast.equalsIgnoreCase(shoname+" has been added to watchlist"));
	    }

	    @Then("^On home page check this sho card on watchlist row$")
	    public void on_home_page_check_this_sho_card_on_watchlist_row() throws Throwable {
	    	String shoname=studiodetailpage.ShoNameattribtute.get(1).getAttribute("alt");
	    	homepage.HeaderLogo.click();
	        commonlocatorsandmethods.scrolldownm();
	        String str=commonlocatorsandmethods.WatchlistRowonHomePage(shoname);
	        log.info(str);
	        assertEquals(shoname,str);
	    	
	    }
	    @And("^Click on any (.+)$")
	    public void click_on_any(String genere) throws Throwable {
	    	for(int i=0;i<studiodetailpage.selectgenre.size();i++)
			 {
				 if(studiodetailpage.selectgenre.get(i).getText().equalsIgnoreCase(genere))
				 {
					 studiodetailpage.selectgenre.get(i).click();
					 break;
				 }
			 }
	    }
	    

	    


	    

}

