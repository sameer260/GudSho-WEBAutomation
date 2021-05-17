package steps.frontend;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class paywallsteps extends BaseSetup {
      
	public static Logger log=Logger.getLogger(paywallsteps.class.getName());
	  SignUp sign=new SignUp();
	  shodetailpage shodetail= new shodetailpage();	
	  homepage home=new homepage();
	  videoplayer video=new videoplayer();
	  ToastandErrormessages toaster=new ToastandErrormessages();
	  audioplayer audio=new audioplayer();
	  studiodetailpage studio=new studiodetailpage();
	  WebDriverWait wait=new WebDriverWait(driver,20);
	
	 @Given("^Search (.+) click on watchlist button$")
	    public void search_click_on_watchlist_button(String shoseries) throws Throwable {
		   homepage.HomePageSearch(shoseries);
	       wait.until(ExpectedConditions.visibilityOf(shodetailpage.ShoNameonShoDetailPage));
	       assertEquals(shoseries, shodetailpage.ShoNameonShoDetailPage.getText());
	       log.info("Page Redirected to the  "+shoseries +" detail page");
		   shodetailpage.WatchListButton.click();
		   log.info("Clicked on the watch list button");
		   log.info("Step Passed");
	    }
	 @Then("^Signin popup should open and verify the text$")
	    public void signin_popup_should_open_and_verify_the_text() throws Throwable {
		   wait.until(ExpectedConditions.visibilityOf(shodetailpage.SignInPopUp));
	       assertTrue(shodetailpage.SignInPopUp.isDisplayed());
	       log.info("Signin popup is displayed");
	       assertEquals(shodetailpage.SignInPopUpHeadderText.getText(),"Want to save & watch later?");
	       log.info(shodetailpage.SignInPopUpHeadderText.getText());
	       assertEquals(shodetailpage.SignInPopUpDescriptionText.getText(),"Sign In to save this video & watch again later");
	       log.info(shodetailpage.SignInPopUpDescriptionText.getText());
	       log.info("Step Passed");
	    }
	 @And("^click on signin button and it should redirect to the login page$")
	    public void click_on_signin_button_and_it_should_rdirect_to_the_login_page() throws Throwable {
		 shodetailpage.PopUpSignInButton.click();
		 log.info("Clicked on Signin Button");
		 wait.until(ExpectedConditions.visibilityOf(SignUp.HelloThereText));
		 assertTrue(SignUp.HelloThereText.isDisplayed());
		 log.info("Its redirected to the Login page and Step Passed");
		 log.info("Step Passed");
		 
	    }
	 @And("^Again click back and add watchlist from header$")
	    public void again_click_back_and_add_watchlist_from_header() throws Throwable {
		   SignUp.BackCursorButton.click();
		   wait.until(ExpectedConditions.visibilityOf(shodetailpage.ShoNameonShoDetailPage));
	       commonlocatorsandmethods.scrolldownm();
	       wait.until(ExpectedConditions.visibilityOf(shodetailpage.HeaderWatchlistButton));
		   shodetailpage.HeaderWatchlistButton.click();
		   log.info("Clicked on the watch list button");
		   log.info("Step Passed");
	    }
	 @Given("^Search (.+) click on watch free button$")
	    public void search_click_buy_or_watch_free_button(String shoseries) throws Throwable {
	       homepage.HomePageSearch(shoseries); 
	       wait.until(ExpectedConditions.visibilityOf(shodetailpage.ShoNameonShoDetailPage));
	       assertEquals(shoseries, shodetailpage.ShoNameonShoDetailPage.getText());
	       log.info("Page Redirected to the  "+shoseries +" detail page");
	       shodetailpage.WatchFreeButton.click();
	       log.info("Clicked on Watch Free button");
	       log.info("Step Passed");
	    }

	 @Then("^Page should redirect to the login page$")
	    public void page_should_redirect_to_the_login_page() throws Throwable {
	    	wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
	    	log.info(ToastandErrormessages.ToastMessageText.getText());
		    assertEquals(ToastandErrormessages.ToastMessageText.getText(), "Please login to continue");
		    assertTrue(SignUp.HelloThereText.isDisplayed());
		    ToastandErrormessages.ToastMessageClose.click();
		    log.info("Step Passed");
	    }
     @And("^Again click back and click on watch free button from header$")
	    public void again_click_back_and_click_buy_or_watch_free_button_from_header() throws Throwable {
	    	SignUp.BackCursorButton.click();
	    	commonlocatorsandmethods.scrolldownm();
	    	shodetailpage.HeaderWatchFreeButton.click();
	    	wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
	    	log.info(ToastandErrormessages.ToastMessageText.getText());
	    	assertTrue(SignUp.HelloThereText.isDisplayed());
		    assertEquals(ToastandErrormessages.ToastMessageText.getText(), "Please login to continue");
		    ToastandErrormessages.ToastMessageClose.click();
		    log.info("Step Passed");
	    }
	 @Given("^Search (.+) and click on buy button$")
	    public void search_and_click_on_buy_button(String shoseries) throws Throwable {
		       homepage.HomePageSearch(shoseries); 
		       wait.until(ExpectedConditions.visibilityOf(shodetailpage.ShoNameonShoDetailPage));
		       assertEquals(shoseries, shodetailpage.ShoNameonShoDetailPage.getText());
		       log.info("Page Redirected to the  "+shoseries +" detail page");
		       shodetailpage.BuyButton.click();
		       log.info("Clicked on Buy Button");
		       log.info("Step Passed");
	    }

	 @And("^Again Click buy button from headder and check same$")
	    public void again_click_buy_button_from_headder_and_check_same() throws Throwable {
	    	SignUp.BackCursorButton.click();
	    	commonlocatorsandmethods.scrolldownm();
	    	shodetailpage.HeaderBuyButton.click();
	    	wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
	    	log.info(ToastandErrormessages.ToastMessageText.getText());
	    	assertTrue(SignUp.HelloThereText.isDisplayed());
		    assertEquals(ToastandErrormessages.ToastMessageText.getText(), "Please login to continue");
		    ToastandErrormessages.ToastMessageClose.click();
		    log.info("Step Passed");
	    }
	 @Given("^Search (.+) and click on first episode$")
	    public void search_and_click_on_first_episode(String shoseries) throws Throwable {
		       homepage.HomePageSearch(shoseries); 
		       wait.until(ExpectedConditions.visibilityOf(shodetailpage.ShoNameonShoDetailPage));
		       assertEquals(shoseries, shodetailpage.ShoNameonShoDetailPage.getText());
		       log.info("Page Redirected to the  "+shoseries + " detail page");
		       ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", shodetailpage.MusicalTracksTitle);
		       Actions a =new Actions(driver);
		       a.moveToElement(shodetailpage.EpisodeCards.get(0)).click().build().perform();
		       log.info("Clicked on Episode card");
	    }

	 @Then("^Click on any episode it should redirect to login page$")
	    public void click_on_any_episode_it_should_redirect_to_login_page() throws Throwable {
	    	   Thread.sleep(500);
	    	   Actions a =new Actions(driver);
		       a.moveToElement(shodetailpage.EpisodeCards.get(0)).click().build().perform();
		       wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		       log.info(ToastandErrormessages.ToastMessageText.getText());
			   assertEquals(ToastandErrormessages.ToastMessageText.getText(), "Please login to continue");
			   assertTrue(SignUp.HelloThereText.isDisplayed());
			   ToastandErrormessages.ToastMessageClose.click();
			   log.info("Step Passed");
	    }

	  @And("^Click back and now select (.+) from season dropdown$")
	    public void click_back_and_now_select_from_season_dropdown(String seasonname) throws Throwable {
	    	SignUp.BackCursorButton.click();
	    	log.info("Clicked on Back Button");
	    	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", shodetailpage.MusicalTracksTitle);
	    	Actions a =new Actions(driver);
	    	a.moveToElement(shodetailpage.SeasonDropDownButton).click().build().perform();
	    	log.info("Click on Season dropdown button");
	    	for(int i=0;i<shodetailpage.SeasonNamesinDropdownText.size();i++)
	    	{
	    		if(shodetailpage.SeasonNamesinDropdownText.get(i).getText().equalsIgnoreCase(seasonname))
	    		{
	    			shodetailpage.SeasonNamesinDropdownText.get(i).click();
	    			break;
	    		}
	    	}
	    	 log.info("Step Passed");
	    }
	    
	    @Given("^Search (.+) and click on any promo$")
	      public void search_and_click_on_any_promo(String shoseries) throws Throwable {
		       homepage.HomePageSearch(shoseries); 
		       wait.until(ExpectedConditions.visibilityOf(shodetailpage.ShoNameonShoDetailPage));
		       assertEquals(shoseries, shodetailpage.ShoNameonShoDetailPage.getText());
		       log.info("Page Redirected to the  "+shoseries + " detail page");
		       Actions a=new Actions(driver);
		       a.moveToElement(shodetailpage.PromoCards.get(0)).click().build().perform();
		       log.info("Clicked on Promo Card");
		       log.info("Step Passed");
	    }

	    @Then("^verify the promo is playing and give gud on promo$")
	    public void verify_the_promo_is_playing_and_give_gud_on_promo() throws Throwable {
	    	   wait.until(ExpectedConditions.visibilityOf(videoplayer.PlayerGudShoLogo));
	    	   Thread.sleep(2000);
	    	   Actions a=new Actions(driver);
	    	   a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
	    	   log.info("Hover on Player");
	    	   a.moveToElement(videoplayer.PlayerGudICon).click().build().perform();
	    	   log.info("Clicked on Gud Icon");
	    	   log.info("Step Passed");
	    }

	    @And("^verify signin popup opened and verify the text$")
	    public void verify_signin_popup_opened_and_verify_the_text() throws Throwable {
	    	   assertTrue(videoplayer.SignInPopup.isDisplayed());
	    	   log.info(videoplayer.SignUpHeadText.getText());
	    	   assertEquals(videoplayer.SignUpHeadText.getText(),"Like this Promo?");
	    	   log.info(videoplayer.SignUpDescriptionText.getText());
	    	   assertEquals(videoplayer.SignUpDescriptionText.getText(),"Sign in now to rate this promo 'Gud'");
	    }
	    @Given("^Search (.+) and Click on episode link$")
	    public void search_and_click_on_episode_link(String shoseries) throws Throwable {
		       homepage.HomePageSearch(shoseries); 
		       wait.until(ExpectedConditions.visibilityOf(shodetailpage.ShoNameonShoDetailPage));
		       assertEquals(shoseries, shodetailpage.ShoNameonShoDetailPage.getText());
		       log.info("Page Redirected to the  "+shoseries +" detail page");
		       shodetailpage.FullEpisodesLink.click();
		       log.info("Cliked on Full Episodes Link");
		       wait.until(ExpectedConditions.visibilityOf(shodetailpage.AllEpisodesText));
		       shodetailpage.EpisodeNamesInEpisodePage.get(0).click();
	    }
	    @And("^select any (.+) from the season dropdown and on episode$")
	    public void select_any_from_the_season_dropdown_and_on_episode(String seasonname) throws Throwable {
	    	   SignUp.BackCursorButton.click();
	    	   shodetailpage.SeasonDropdownInEpisodePage.click();
	    	   log.info("Click on Season dropdown button");
		    	for(int i=0;i<shodetailpage.SeasonNamesinDropdownText.size();i++)
		    	{
		    		if(shodetailpage.SeasonNamesinDropdownText.get(i).getText().equalsIgnoreCase(seasonname))
		    		{
		    			shodetailpage.SeasonNamesinDropdownText.get(i).click();
		    			break;
		    		}
		    	}
		    	shodetailpage.EpisodeNamesInEpisodePage.get(0).click();
		    	 log.info("Step Passed");
	    }
	    @Given("^Search (.+) and play any song$")
	    public void search_and_play_any_song(String shoseries) throws Throwable {
		       homepage.HomePageSearch(shoseries); 
		       wait.until(ExpectedConditions.visibilityOf(shodetailpage.ShoNameonShoDetailPage));
		       assertEquals(shoseries, shodetailpage.ShoNameonShoDetailPage.getText());
		       log.info("Page Redirected to the  "+shoseries +" detail page");
		       shodetailpage.AudioSongsRowsList.get(0).click();
		       log.info("Clicked on first song:"+ shodetailpage.SongsNamesText.get(0).getText());
		       wait.until(ExpectedConditions.visibilityOf(audioplayer.GudShoLogoOnPlayer));
		       assertEquals(shodetailpage.SongsNamesText.get(0).getText(), audioplayer.SongNameOnPlayer.getText()); 
		       log.info("Step Passed");
	    }
	    @When("^Add to fav the song and verify the signin popup$")
	    public void add_to_fav_the_song_and_verify_the_signin_popup() throws Throwable {
	    	   audioplayer.HeartIconButton.click();
	    	   log.info("Clicked On Audio Fav Icon");
	    	   assertTrue(shodetailpage.SignInPopUp.isDisplayed());
	    	   assertEquals(shodetailpage.SignInPopUpHeadderText.getText(), "Like this Audio?");
	    	   log.info(shodetailpage.SignInPopUpHeadderText.getText());
	    	   assertEquals(shodetailpage.SignInPopUpDescriptionText.getText(),"Sign in now to mark this audio as favourite.");
	    	   log.info(shodetailpage.SignInPopUpDescriptionText.getText());
	    }
	    @And("^try same above scenario from player full screen$")
	    public void try_same_above_scenario_from_player_full_screen() throws Throwable {
	    	   SignUp.BackCursorButton.click();
	    	   wait.until(ExpectedConditions.visibilityOf(videoplayer.PlayerGudShoLogo));
	    	   Thread.sleep(2000);
	    	   Actions a=new Actions(driver);
	    	   a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
	    	   log.info("Hover on Player");
	    	   videoplayer.FullScreenButton.click();
	    	   a.moveToElement(videoplayer.PlayerGudICon).click().build().perform();
	    	   log.info("Clicked on Gud Icon");
	    	   assertTrue(videoplayer.SignInPopup.isDisplayed());
	    	   log.info(videoplayer.SignUpHeadText.getText());
	    	   assertEquals(videoplayer.SignUpHeadText.getText(),"Like this Promo?");
	    	   log.info(videoplayer.SignUpDescriptionText.getText());
	    	   assertEquals(videoplayer.SignUpDescriptionText.getText(),"Sign in now to rate this promo 'Gud'");
	    	   shodetailpage.PopUpSignInButton.click();
	  		   log.info("Clicked on Signin Button");
	  		   wait.until(ExpectedConditions.visibilityOf(SignUp.HelloThereText));
	  		   assertTrue(SignUp.HelloThereText.isDisplayed());
	  		   log.info("Step Passed");	   
	    }
	    @Given("^Search any (.+) and follow the studio$")
	    public void search_any_and_follow_the_studio(String studio) throws Throwable {
		       homepage.HomePageSearch(studio); 
		       wait.until(ExpectedConditions.visibilityOf(studiodetailpage.StudioNameInStudioPage));
		       assertEquals(studio, studiodetailpage.StudioNameInStudioPage.getText());
		       log.info("Page Redirected to the  "+studio +" detail page");
		       studiodetailpage.FollowButton.click();
			   log.info("Clicked on the follow button button");
			   log.info("Step Passed");
	    }

	    @When("^Signin popup should display and verify the text$")
	    public void signin_popup_should_display_and_verify_the_text() throws Throwable {
	    	   wait.until(ExpectedConditions.visibilityOf(shodetailpage.SignInPopUp));
		       assertTrue(shodetailpage.SignInPopUp.isDisplayed());
		       log.info("Signin popup is displayed");
		       assertEquals(shodetailpage.SignInPopUpHeadderText.getText(),"Follow this Studio?");
		       log.info(shodetailpage.SignInPopUpHeadderText.getText());
		       assertEquals(shodetailpage.SignInPopUpDescriptionText.getText(),"Sign In to follow this studio & enter into the world of entertainment");
		       log.info(shodetailpage.SignInPopUpDescriptionText.getText());
		       log.info("Step Passed");
	    }
	    @And("^Come back do same follow from header$")
	    public void come_back_do_same_follow_from_header() throws Throwable {
	            SignUp.BackCursorButton.click();
	            log.info("Clicked back to studio detailpage");
	            commonlocatorsandmethods.scrolldownm();
	            studiodetailpage.HeaderFollowButton.click();
	            log.info("Clicked on follow button");
	    }
	    @Given("^Search any (.+) and add to watchlist from any sho card$")
	    public void search_any_and_add_to_watchlist_from_any_sho_card(String studio) throws Throwable {
	    	   homepage.HomePageSearch(studio); 
		       wait.until(ExpectedConditions.visibilityOf(studiodetailpage.StudioNameInStudioPage));
		       assertEquals(studio, studiodetailpage.StudioNameInStudioPage.getText());
		       log.info("Page Redirected to the  "+studio +" detail page");
		       Actions a=new Actions(driver);
		       a.moveToElement(studiodetailpage.ShoCards.get(0)).build().perform();
		       studiodetailpage.WatchListIcon.get(0).click(); 
	    }
	    @Given("^Search any (.+) and add to audio fav$")
	    public void search_any_and_add_to_audio_fav(String studio) throws Throwable {
	    	   homepage.HomePageSearch(studio); 
		       wait.until(ExpectedConditions.visibilityOf(studiodetailpage.StudioNameInStudioPage));
		       assertEquals(studio, studiodetailpage.StudioNameInStudioPage.getText());
		       log.info("Page Redirected to the  "+studio +" detail page");
		       commonlocatorsandmethods.scrolldownm();
		       Actions a=new Actions(driver);
		       a.moveToElement(studiodetailpage.AudioCards.get(0)).click().build().perform(); 
	    }
	    
	   
	
	
}
