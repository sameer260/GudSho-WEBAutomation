package steps.frontend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.xml.xsom.impl.scd.Iterators.Map;
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

	@When("^Add (.+) in to watchlist and check the toaster message$")
	public void add_in_to_watchlist_and_check_the_toaster_message(String shoname) throws Throwable {
		shodetailpage.WatchListButton.click();
		wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		String Toastmessage = ToastandErrormessages.ToastMessageText.getText();
		assertEquals(Toastmessage, shoname + " has been added to watchlist");
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
		wait.until(ExpectedConditions.visibilityOf(videoplayer.RateCloseButton));
		videoplayer.RateCloseButton.click();
	}

	@Then("^On home page check the added watchlist (.+)$")
	public void on_home_page_check_the_added_watchlist(String shoname) throws Throwable {
		homepage.HeaderLogo.click();
		commonlocatorsandmethods.scrolldownm();
		String str = commonlocatorsandmethods.WatchlistRowonHomePage(shoname);
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
		Thread.sleep(700);
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
		//wait.until(ExpectedConditions.visibilityOf(videoplayer.RateCloseButton));
		//videoplayer.RateCloseButton.click();
	}

	@And("^On sho detail page verify watch now button should change to resume$")
	public void on_sho_detail_page_verify_watch_now_button_should_change_to_resume() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(shodetailpage.WatchListButton));
		wait.until(ExpectedConditions.visibilityOf(shodetailpage.ResumeButtonForSho));
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
		Thread.sleep(2000);
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

    @Then("^Verify after payment (.+) is playing and close the player$")
    public void verify_after_payment_is_playing_and_close_the_player(String shoname) throws Throwable {
    	Actions a =new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
        log.info(ToastandErrormessages.ToastMessageText.getText());
        assertEquals(ToastandErrormessages.ToastMessageText.getText(),"Payment Processed");
        Thread.sleep(2000);
        a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
        wait.until(ExpectedConditions.visibilityOf(videoplayer.ShoNameOnPlayer));
        String ShonameonPlayer=videoplayer.ShoNameOnPlayer.getText();
        assertEquals(ShonameonPlayer,shoname);
        videoplayer.CloseButtonforSho.click();
        wait.until(ExpectedConditions.visibilityOf(videoplayer.RateCloseButton));
        videoplayer.RateCloseButton.click();
    }
   

    @Then("^On home page check the added watchlist (.+)$")
    public void on_home_page_check_the_added_watchlist(String shoname) throws Throwable {
        homepage.HeaderLogo.click();
        commonlocatorsandmethods.scrolldownm();
        String str=commonlocatorsandmethods.WatchlistRowonHomePage(shoname);
        log.info(str);
        assertTrue(shoname.equalsIgnoreCase(str));
        
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
   

    @Then("^On home page check liked (.+) is showing in my gud promos$")
    public void on_home_page_check_liked_is_showing_in_my_gud_promos(String promoname) throws Throwable {
    	homepage.HeaderLogo.click();
        commonlocatorsandmethods.scrolldownm();
        String PromonameongudPromos=homepage.mygudpromos(promoname);
        log.info(PromonameongudPromos);
        assertEquals(promoname,PromonameongudPromos);
    }
    @Then("^Click on Studio link and check redirected to studio detail page$")
    public void click_on_studio_link_and_check_redirected_to_studio_detail_page() throws Throwable {
        String str=shodetailpage.StudionameinStudioLink.getText();
        String Studionameinshodetailpage= str.substring(0,str.length()-2);
        shodetailpage.StudioLink.click();
        wait.until(ExpectedConditions.visibilityOf(studiodetailpage.StudioNameInStudioPage));
        String studionamestudiodetailpage=studiodetailpage.StudioNameInStudioPage.getText();
        assertTrue(Studionameinshodetailpage.equalsIgnoreCase(studionamestudiodetailpage));
    }
    @Then("^Hover on (.+) card and share promo (.+) using all shares$")
    public void hover_on_card_and_share_promo_using_all_shares(String promoname, String sharetype) throws Throwable {
           String Promoname=shodetailpage.PromoCardShare(promoname);
           String promonameonplayer=ShareFeature.SocialShare(sharetype);
           assertEquals(Promoname,promonameonplayer);
           
    }
    @When("^Play watch free content and close the player$")
    public void play_watch_free_content_and_close_the_player() throws Throwable {
        shodetailpage.BuyButton.click();
        Thread.sleep(10000);
        Actions a =new Actions(driver);
        a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
        wait.until(ExpectedConditions.visibilityOf(videoplayer.CloseButtonforSho));
        videoplayer.CloseButtonforSho.click();
        wait.until(ExpectedConditions.visibilityOf(videoplayer.RateCloseButton));
        videoplayer.RateCloseButton.click();
    }
    @And("^On sho detail page verify watch now button should change to resume$")
    public void on_sho_detail_page_verify_watch_now_button_should_change_to_resume() throws Throwable {
        wait.until(ExpectedConditions.visibilityOf(shodetailpage.WatchListButton));
        wait.until(ExpectedConditions.visibilityOf(shodetailpage.ResumeButtonForSho));
        String str=shodetailpage.ResumeButtonForSho.getText();
        log.info(str);
        assertEquals(str,"Resume");
    }

    @Then("^On Home Page check continue wathing is showing (.+)$")
    public void on_home_page_check_continue_wathing_is_showing(String shoname) throws Throwable {
        homepage.HeaderLogo.click();
        String ShonameInContinueWatching=null;
        for(int i=0;i<homepage.ShoNamesInContinueWatching.size();i++)
        {
        	if(homepage.ShoNamesInContinueWatching.get(i).getText().equalsIgnoreCase(shoname))
        	{
        		ShonameInContinueWatching=homepage.ShoNamesInContinueWatching.get(i).getText();
        		log.info(ShonameInContinueWatching);
        		break;
        	}
        }
        assertEquals(ShonameInContinueWatching,shoname);
    }
    
    @When("^Check all sho detail info and check seemore popup if (.+)$")
    public void check_all_sho_detail_info_and_check_seemore_popup_if(String available) throws Throwable {
        for(int i=0;i<shodetailpage.ShoDetailsInfo.size();i++)
        {
        	assertTrue(shodetailpage.ShoDetailsInfo.get(i).isDisplayed());
        }
        assertTrue(shodetailpage.ShoDetailDescription.isDisplayed());
        if(available.equalsIgnoreCase("Yes"))
        {
        shodetailpage.SeeMoreLink.click();
        wait.until(ExpectedConditions.visibilityOf(shodetailpage.AboutPopup));
        assertTrue(shodetailpage.AboutPopup.isDisplayed());
        assertTrue(shodetailpage.DescriptionTextInpopup.isDisplayed());
        log.info(shodetailpage.DescriptionTextInpopup.getText());
        assertTrue(shodetailpage.AboutTextinAboutPopup.isDisplayed());
        log.info(shodetailpage.AboutTextinAboutPopup.getText());
        shodetailpage.AboutPopupCrossButton.click();
        Thread.sleep(500);
        }
        else
        {
        	log.info("This sho doesnot have more description,so no See more link");
        }
       
    }
    @Then("^check About section if about tab (.+)$")
    public void check_about_section_if_about_tab(String availability) throws Throwable {
             if(availability.equalsIgnoreCase("Yes")) {
            	shodetailpage.AboutTab.click();
            	commonlocatorsandmethods.scrolldownm();
         		assertTrue(shodetailpage.EntireAboutSection.isDisplayed());
         		for(int j=0;j<shodetailpage.AboutSectionElements.size();j++)
         		{
         			assertTrue(shodetailpage.AboutSectionElements.get(j).isDisplayed());
         		}
            	 
             }
             else {
            	log.info("This Sho doesnot any Audios and promos tab");
        		commonlocatorsandmethods.scrolldownm();
        		assertTrue(shodetailpage.EntireAboutSection.isDisplayed());
        		for(int j=0;j<shodetailpage.AboutSectionElements.size();j++)
        		{
        			assertTrue(shodetailpage.AboutSectionElements.get(j).isDisplayed());
        		}
        	}
        }
    @Then("^Click on shareicon from shocard and verify share popup$")
    public void click_on_shareicon_from_shocard_and_verify_share_popup() throws Throwable {
    	WebDriverWait wait=new WebDriverWait(driver,20);
    	 Actions a=new Actions(driver);
    	 a.sendKeys(Keys.END).build().perform();
    	 a.moveToElement(shodetailpage.ShoCards.get(0)).build().perform();
         shodetailpage.ShareButtononShoCard.click();
         wait.until(ExpectedConditions.visibilityOf(ShareFeature.SharePopup));
         assertTrue(ShareFeature.SharePopup.isDisplayed());
         ShareFeature.SharepopupClose.click();
         shodetailpage.MoreLikeThisEle.click();
         Thread.sleep(2000);
         assertTrue(commonlocatorsandmethods.MoreLikethistext.isDisplayed());
         a.moveToElement(commonlocatorsandmethods.Shocards.get(0)).build().perform();
         commonlocatorsandmethods.ShareButtononShoCard.click();
         wait.until(ExpectedConditions.visibilityOf(ShareFeature.SharePopup));
         assertTrue(ShareFeature.SharePopup.isDisplayed());
        
    }

    @Then("^Check redirection of card and watchlist functionality of sho card on home page$")
    public void check_redirection_of_card_and_watchlist_functionality_of_sho_card_on_home_page() throws Throwable {
    	commonlocatorsandmethods.scrolldownm();
    	Actions a =new Actions(driver);
        a.moveToElement(shodetailpage.ShoCards.get(0)).build().perform();
        String shoname=shodetailpage.shonamefromShoCards.get(0).getAttribute("alt");
        log.info(shoname);
        shodetailpage.WatchLaterbuttononShoCard.click();
        wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
        String Toastmessage=ToastandErrormessages.ToastMessageText.getText();
        log.info(Toastmessage);
        assertEquals(Toastmessage,shoname+" has been added to watchlist");
        ToastandErrormessages.ToastMessageClose.click();
        wait.until(ExpectedConditions.elementToBeClickable(shodetailpage.ShoCards.get(0)));
        a.moveToElement(shodetailpage.ShoCards.get(0)).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(shodetailpage.WatchListButton));
        String str=shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
        assertEquals(str,shoname);
        homepage.HeaderLogo.click();
        commonlocatorsandmethods.scrolldownm();
        String str1=commonlocatorsandmethods.shocardwatchlistShoName(shoname);
        assertEquals(str1, str);
        assertEquals(str1, shoname);
        
    }
    @Then("^click on more like this link and check watchlist toaster$")
    public void click_on_see_more_link_check_share_popup_and_watchlist_toaster() throws Throwable {
   	    Actions a=new Actions(driver);
   	    a.sendKeys(Keys.END).build().perform();
   	    shodetailpage.MoreLikeThisEle.click();
   	    Thread.sleep(1500);
        wait.until(ExpectedConditions.visibilityOf(commonlocatorsandmethods.MoreLikethistext));
        assertTrue(commonlocatorsandmethods.MoreLikethistext.isDisplayed());
        a.moveToElement(commonlocatorsandmethods.Shocards.get(1)).build().perform();
        String shoname=commonlocatorsandmethods.ShoNames.get(1).getAttribute("alt");
        log.info(shoname);
        commonlocatorsandmethods.WatchLaterbuttononShoCard.click();
        wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
        String Toastmessage=ToastandErrormessages.ToastMessageText.getText();
        log.info(Toastmessage);
        assertEquals(Toastmessage,shoname+" has been added to watchlist");
        ToastandErrormessages.ToastMessageClose.click();
    }

    @And("^Check redirection of sho card$")
    public void check_redirection_of_sho_card() throws Throwable {
    	Actions a=new Actions(driver);
    	wait.until(ExpectedConditions.elementToBeClickable(commonlocatorsandmethods.Shocards.get(1)));
        String shoname=commonlocatorsandmethods.ShoNames.get(1).getAttribute("alt");
        a.moveToElement(commonlocatorsandmethods.Shocards.get(1)).click().build().perform();
        String str=shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
        assertEquals(shoname,str);
        
    }
    @When("^Scroll down page and click on watchlist button$")
    public void scroll_down_page_and_click_on_watchlist_button() throws Throwable {
       commonlocatorsandmethods.scrolldownm();
       String shoname=shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
       shodetailpage.HeaderWatchlistbutton.click();
       wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
       String toastermessage=ToastandErrormessages.ToastMessageText.getText();
       ToastandErrormessages.ToastMessageClose.click();
       assertTrue(toastermessage.equalsIgnoreCase(shoname+ " has been added to watchlist"));
       Actions a=new Actions(driver);
       a.sendKeys(Keys.HOME).build().perform();
    }

    @Then("^Click header share icon and verify share popup$")
    public void click_header_share_icon_and_verify_share_popup() throws Throwable {
    	commonlocatorsandmethods.scrolldownm();
    	shodetailpage.HeaderShareButton.click();
    	wait.until(ExpectedConditions.visibilityOf(ShareFeature.SharePopup));
        assertTrue(ShareFeature.SharePopup.isDisplayed());
    	
    }
    @When("^click header watch now button$")
    public void click_header_watch_now_button() throws Throwable {
    	commonlocatorsandmethods.scrolldownm();
    	shodetailpage.HeaderWatchButton.click();
    }


    @Then("^verify payment continue popup dislayed$")
    public void verify_payment_continue_popup_dislayed() throws Throwable {
    	wait.until(ExpectedConditions.visibilityOf(paymentpage.PopupContinueButton));
        assertTrue(paymentpage.PopupContinueButton.isDisplayed());
    }
    @Then("^verify sho is playing and close player and verify resume button$")
    public void verify_sho_is_playing_and_close_player_and_verify_resume_button() throws Throwable {
        Thread.sleep(10000);
        Actions a =new Actions(driver);
        a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
        videoplayer.CloseButton.click();  
        videoplayer.RateCloseButton.click();
    }
    @When("^Wait for Animation buttons and Verify its displaying all button$")
    public void wait_for_animation_buttons_and_verify_its_displaying_all_button() throws Throwable {
    	String shoname=shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
    	log.info(shoname);
    	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[starts-with(@class,'sho-content animation-bg ng-tns-')]"))));
    	assertTrue(shodetailpage.AnimationWatchListButton.isDisplayed());  
    	assertTrue(shodetailpage.AnimationShareButton.isDisplayed());
    	assertTrue(shodetailpage.AnimationWatchButton.isDisplayed());
    }

    @Then("^hover on banner check the sho detail element is retained$")
    public void hover_on_banner_check_the_sho_detail_element_is_retained() throws Throwable {
    	Actions a=new Actions(driver);
    	a.moveToElement(shodetailpage.AnimationWatchListButton).build().perform();
    	assertTrue(shodetailpage.WatchListButton.isDisplayed());
    }
    static int timeleft;
    @When("^Play video till (.+) and close player$")
    public void play_video_till_and_close_player(String time) throws Throwable {
    	shodetailpage.WatchFreeButton.click();
    	Thread.sleep(10000);
    	Actions a =new Actions(driver);
    	a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
    	timeleft=videoplayer.TimeLeftCal(time);
    	log.info(timeleft);
    	videoplayer.CloseButton.click();
    	wait.until(ExpectedConditions.visibilityOf(videoplayer.RateCloseButton));
    	videoplayer.RateCloseButton.click();
    	
    }

    @Then("^verify time left on sho detail page$")
    public void verify_time_left_on_sho_detail_page() throws Throwable {
      wait.until(ExpectedConditions.visibilityOf(shodetailpage.TimeLeftonShodetailpage));
      String timeLeftonshodetailpage= shodetailpage.TimeLeftonShodetailpage.getText();
      log.info(timeLeftonshodetailpage);
      assertEquals(timeleft+"m left",timeLeftonshodetailpage);
      log.info(timeLeftonshodetailpage);
    }
    
    @Then("^Check right and left arrow is working as expected$")
    public void check_right_and_left_arrow_is_working_as_expected() throws Throwable {
    	Actions a=new Actions(driver);
    	a.sendKeys(Keys.END).build().perform();
        commonlocatorsandmethods.RightLeftArrows();
    }

	@Then("^verify all lables of the card with sho detail page$")
	public void verify_all_lables_of_the_card_with_sho_detail_page() throws Throwable {
		Actions a = new Actions(driver);
		a.sendKeys(Keys.END).build().perform();
		wait.until(ExpectedConditions.visibilityOf(shodetailpage.MoreLikeThisEle));
		a.moveToElement(commonlocatorsandmethods.ShoCards.get(0)).build().perform();
		wait.until(ExpectedConditions.visibilityOf(commonlocatorsandmethods.ShoSeriesCardLabel));
		String sholabel = commonlocatorsandmethods.ShoSeriesCardLabel.getText();
		String Shoduration = commonlocatorsandmethods.ShoCardDuration.getText();
		String ShoGenere = commonlocatorsandmethods.ShoCardGenere.getText();
		String Sholanguage = commonlocatorsandmethods.ShoCardLanguage.getText();
		String ShonameonCard;
		try {
			ShonameonCard = commonlocatorsandmethods.ShoNameOnShoCard.getText();
		} catch (Exception e) {
			ShonameonCard = commonlocatorsandmethods.ShoNameOnShoCardImage.getAttribute("alt");
		}

		shodetailpage.ShareButtononShoCard.click();
		wait.until(ExpectedConditions.visibilityOf(ShareFeature.SharePopup));
		assertTrue(ShareFeature.SharePopup.isDisplayed());
		ShareFeature.SharepopupClose.click();
		a.moveToElement(shodetailpage.ShoCards.get(0)).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(shodetailpage.WatchListButton));
		String Sholabelonshobanner = shodetailpage.ShoDetailsInfo.get(0).getText();
		String ShoDurationShobanner = shodetailpage.ShoDetailsInfo.get(2).getText();
		String ShoGenereShobanner = shodetailpage.ShoDetailsInfo.get(3).getText();
		String ShoanguageShobanner = shodetailpage.ShoDetailsInfo.get(5).getText();
		String Shonameofshodetailpage = shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");

		assertTrue(sholabel.equalsIgnoreCase(Sholabelonshobanner));
		assertTrue(Shoduration.equalsIgnoreCase(ShoDurationShobanner));
		assertTrue(ShoGenere.equalsIgnoreCase(ShoGenereShobanner));
		assertTrue(Sholanguage.equalsIgnoreCase(ShoanguageShobanner));
		assertTrue(ShonameonCard.equalsIgnoreCase(Shonameofshodetailpage));

	}
	@And("^verify price label$")
    public void verify_price_label() throws Throwable {
		Actions a = new Actions(driver);
		commonlocatorsandmethods.scrolldownm();
		String str=commonlocatorsandmethods.PriceLabel();
		String pricelabelonshocard = str.replace("\n", "").replace("\r", "");
		a.moveToElement(shodetailpage.ShoCards.get(0)).click().build().perform();
		commonlocatorsandmethods.CheckPriceverification(pricelabelonshocard);
		
		
    }
	

	    @And("^Take a gud and view count of (.+)$")
	    public void take_a_gud_and_view_count_of(String promoname) throws Throwable {
	    	viewcountbeforeplay= shodetailpage.ViewCount(promoname);
	    	gudcountbeforeplay=shodetailpage.GudCount(promoname);
	    }
	   
	    @When("^Play (.+) and (.+) promo$")
	    public void play_and_promo(String promoname, String useraction) throws Throwable {
	    	shodetailpage.PromoCardClick(promoname);
	        Actions a=new Actions(driver);
	        a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
	        Thread.sleep(700);
	        videoplayer.PlayerGudICon.click();
	        wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
	        String actual=ToastandErrormessages.ToastMessageText.getText();
	        log.info(actual);
	        if(useraction.equalsIgnoreCase("Like"))
	        {
	        assertEquals(actual,"You liked this promo");
	        }
	        else if(useraction.equalsIgnoreCase("UnLike"))
	        {
	        	assertEquals(actual,"You unliked this promo");
	        }
	        ToastandErrormessages.ToastMessageClose.click();
	        a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
	        wait.until(ExpectedConditions.visibilityOf(videoplayer.PromoNameonPlayer));
	        String promonameonplayer=videoplayer.Promoname();
	        log.info(promonameonplayer);
	        assertTrue(promonameonplayer.equalsIgnoreCase(promoname));
	        a.moveToElement(videoplayer.CloseButton).click().build().perform();
	    }
	    static int viewcountbeforeplay;
		static int gudcountbeforeplay;
	    @Then("^verify view and gudcount of (.+) for (.+)$")
	    public void verify_view_and_gudcount_of_for(String promoname, String useraction) throws Throwable {
	    	wait.until(ExpectedConditions.visibilityOfAllElements(shodetailpage.PromoNamesofPromoCards));
		    int viewcountafterview=shodetailpage.ViewCount(promoname);
	        int gudcountaftergud=shodetailpage.GudCount(promoname);
	        assertEquals(viewcountafterview,viewcountbeforeplay+1);
	        if(useraction.equalsIgnoreCase("Like"))
	        {
	        	assertEquals(gudcountaftergud,gudcountbeforeplay+1);
	        }
	        else if(useraction.equalsIgnoreCase("Unlike"))
	        {
	        	assertEquals(gudcountaftergud,gudcountbeforeplay-1);
	        }
	         
	    }
	    
	//Home Page Scenarios
	    
	    @And("^Check redirection of sho card (.+) is in mywatchlist row$")
	    public void check_redirection_of_sho_card_is_in_mywatchlist_row(String shoname) throws Throwable {
	        commonlocatorsandmethods.WatchlistRowonHomePageCardClick(shoname);
	        wait.until(ExpectedConditions.visibilityOf(shodetailpage.WatchListButton));
	        String str=shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
	        assertEquals(str,shoname);
	    }

	    @And("^Remove (.+) card from watchlist and verify$")
	    public void remove_card_from_watchlist_and_verify(String shoname) throws Throwable {
	    	String str=commonlocatorsandmethods.RemoveWatchlistRowonHomePage(shoname);
	        log.info(str);
	        wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
	        String toastermessage=ToastandErrormessages.ToastMessageText.getText();
	        ToastandErrormessages.ToastMessageClose.click();
	        log.info(toastermessage);
	        assertTrue(toastermessage.equalsIgnoreCase(shoname+ " has been removed from watchlist"));
	        String str1=commonlocatorsandmethods.WatchlistRowonHomePage(shoname);
	        assertEquals(null,str1);
	        
	    }
	    @And("^veirfy time left on continue watching (.+) on home page$")
	    public void veirfy_time_left_on_continue_watching_on_home_page(String shoname) throws Throwable {
	    	String timeLeftonshodetailpage= shodetailpage.TimeLeftonShodetailpage.getText();
	    	homepage.HeaderLogo.click();
	        String ShonameInContinueWatching=null;
	        String timeLeftonCard=null;
	        for(int i=0;i<homepage.ShoNamesInContinueWatching.size();i++)
	        {
	        	if(homepage.ShoNamesInContinueWatching.get(i).getText().equalsIgnoreCase(shoname))
	        	{
	        		ShonameInContinueWatching=homepage.ShoNamesInContinueWatching.get(i).getText();
	        		log.info(ShonameInContinueWatching);
	        		timeLeftonCard=shodetailpage.TimeLeftInContinueWatching.get(i).getText();
	        		log.info(timeLeftonCard);
	        		break;
	        	}
	        }
	        
	        assertEquals(ShonameInContinueWatching,shoname);
	        assertEquals(timeleft+"m left",timeLeftonCard);
	        assertEquals(timeLeftonshodetailpage, timeLeftonCard);
	        
	    }


    
}
