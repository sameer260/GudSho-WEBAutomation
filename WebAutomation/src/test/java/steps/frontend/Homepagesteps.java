package steps.frontend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lowagie.text.List;

import Pageobjects.frontend.Footer;
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
	WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	commonSteps com = new commonSteps();

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
		a.moveToElement(shodetailpage.PromoNamesofPromoCards.get(0)).click().build().perform();
	}

	@Then("^verify redirection of promo player$")
	public void verify_redirection_of_promo_player() throws Throwable {
		Thread.sleep(8000);
		videoplayer.PromoNameonPlayer.isDisplayed();
		Actions a =new Actions(driver);
		a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
		videoplayer.CloseButton.click();

	}

	@Then("^Click on notifications link and it should redirect to notifications tab$")
	public void click_on_notifications_link_and_it_should_redirect_to_notifications_tab() throws Throwable {
		// wait.until(ExpectedConditions.elementToBeClickable(accountandsettingspage.NotificationSettingLink)).click();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", accountandsettingspage.NotificationSettingLink);
		// accountandsettingspage.NotificationSettingLink.click();
		assertTrue(accountandsettingspage.NotificationsTab.isDisplayed());
		wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.NotificationElements));
		assertTrue(accountandsettingspage.NotificationElements.isDisplayed());
		String str = accountandsettingspage.NotificationsTab.getText();
		String areatstate = accountandsettingspage.TabSelection(str);
		assertEquals(areatstate, "true");
	}

	// phase 2 home

	static String mainShoName;

	@Given("^From home page click on add to watchlist in (.+) title card$")
	public void from_home_page_click_on_add_to_watchlist_in_title_card(String shoName) throws Throwable {

		commonlocatorsandmethods.hoverTitleCardHome(shoName);
		homepage.addToWatchlistButton.click();
		mainShoName = shoName;
		log.info(mainShoName);
		log.info(shoName);

	}

	@When("^check card availbility on my watchlist row$")
	public void check_card_availbility_on_my_watchlist_row() throws Throwable {
		commonlocatorsandmethods.scrolldownm();
		String mywatchlistShoCardName = commonlocatorsandmethods.WatchlistRowonHomePage(mainShoName);
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

	}

	@When("^Click on share button from the card and verify share popup$")
	public void click_on_share_button_from_the_card_and_verify_share_popup() throws Throwable {
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(commonlocatorsandmethods.ShareButtononShoCard));
		actions.moveToElement(commonlocatorsandmethods.ShareButtononShoCard).click().build().perform();
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
		Thread.sleep(1500);
		wait.until(ExpectedConditions.visibilityOfAllElements(homepage.shoTypeRowSeeAll));
		Actions actions = new Actions(driver);
		actions.moveToElement(homepage.shoTypeRowSeeAll.get(0)).click().build().perform();
	}

	String masterShoName;

	@When("^Hover and click on click on add to watchlist in (.+) title card$")
	public void hover_and_click_on_click_on_add_to_watchlist_in_title_card(String shoname) throws Throwable {
		commonlocatorsandmethods.hoverTitleCardHome(shoname);
		homepage.addToWatchlistButton.click();

	}

	@And("^Navigate back and (.+) availbility on my watchlist row$")
	public void navigate_back_and_availbility_on_my_watchlist_row(String shoname) throws Throwable {
		driver.navigate().back();
		commonlocatorsandmethods.scrolldownm();
		String mywatchlistShoCardName = commonlocatorsandmethods.WatchlistRowonHomePage(shoname);
		assertTrue(mywatchlistShoCardName.equalsIgnoreCase(shoname));

	}

	@When("^From see all page click on sho card (.+) and verif redirection$")
	public void from_see_all_page_click_on_sho_card_and_verif_redirection(String shoname) throws Throwable {
		commonlocatorsandmethods.clickTitleCardHome(shoname);
		String shoDetailPageShoName = shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
		System.out.println("detail page sho name: " + shoDetailPageShoName);
		assertTrue(shoname.equalsIgnoreCase(shoDetailPageShoName));

	}

	@Given("^From home page hover on (.+) promo card$")
	public void from_home_page_click_on_share_button_in_promo_card_and_verify_share_popup(String promoName)
			throws Throwable {
		commonlocatorsandmethods.scrolldownm();
		commonlocatorsandmethods.PromoCardHover(promoName);
	}

	@Given("^From home page click on promo type row see all hyperlink$")
	public void from_home_page_click_on_promo_type_row_see_all_hyperlink() throws Throwable {
		commonlocatorsandmethods.scrolldownm();
		Actions actions = new Actions(driver);
		actions.moveToElement(homepage.promoSeeAll).click().build().perform();

	}

	@Given("^From home page hover on (.+) promo card and close the player$")
	public void from_home_page_hover_on_promo_card_and_close_the_player(String promoname) throws Throwable {
		commonlocatorsandmethods.scrolldownm();
		commonlocatorsandmethods.PromoCardClick(promoname);
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.moveToElement(videoplayer.HoverOnPlayer).build().perform();
		videoplayer.PlayerGudICon.click();
		actions.moveToElement(videoplayer.HoverOnPlayer).build().perform();
		videoplayer.CloseButton.click();

	}

	@When("^From home page click onfollow button and verify the button changes$")
	public void from_home_page_click_onfollow_button_and_verify_the_button_changes() throws Throwable {
		Actions a =new Actions(driver);
		a.moveToElement(homepage.followButtons.get(1)).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		assertEquals("You have started following this studio", ToastandErrormessages.ToastMessageText.getText());

	}

	@And("^Close promo player (.+) and verify redirection$")
	public void close_promo_player_and_verify_redirection(String promoName) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		commonlocatorsandmethods.scrolldownm();
		commonlocatorsandmethods.PromoCardClick(promoName);
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.moveToElement(videoplayer.HoverOnPlayer).build().perform();
		videoplayer.CloseButton.click();
		wait.until(ExpectedConditions.visibilityOf(shodetailpage.ShoNameonShoDetailPage));
		assertTrue(shodetailpage.ShoNameonShoDetailPage.isDisplayed());

	}

		

	int GudCountonHomepage;
	int ViewCountonHomepage;
	@Given("^From home get the gud count and view count of the promo (.+)$")
    public void from_home_get_the_gud_count_and_view_count_of_the_promo(String promoname) throws Throwable {
		commonlocatorsandmethods.scrolldownm();
		GudCountonHomepage=shodetailpage.GudCount(promoname,homepage.allPromoNames);
		ViewCountonHomepage=shodetailpage.ViewCount(promoname,homepage.allPromoNames); 
    }
	 
	

	    @Then("^Verify the view count and gud count of (.+)$")
	    public void verify_the_view_count_and_gud_count_of(String promoname) throws Throwable {
    	wait.until(ExpectedConditions.visibilityOf(homepage.HeaderLogo));
    	commonlocatorsandmethods.scrolldownm();
    	int afterGudCountonHomepage = 0;
    	int afterViewCountonHomepage = 0;
    	for(int i=0;i<homepage.allPromoNames.size();i++)
        {
        	if(homepage.allPromoNames.get(i).getText().equalsIgnoreCase(promoname))
        	{
        		afterGudCountonHomepage=shodetailpage.GudCount(promoname,homepage.allPromoNames);
        		afterViewCountonHomepage=shodetailpage.ViewCount(promoname,homepage.allPromoNames);
        		break;
        	}
        }
    	
		assertEquals(afterGudCountonHomepage, GudCountonHomepage+1);
		assertEquals(afterViewCountonHomepage, ViewCountonHomepage+1);	
    }
	    @And("^Check from gud and view Count from my gud promos for (.+)$")
	    public void check_from_gud_and_view_count_from_my_gud_promos_for(String promoname) throws Throwable {
	    	String PromonameongudPromos=homepage.mygudpromos(promoname);
	        log.info(PromonameongudPromos);
	        int gudcountinmygudpromos=homepage.GudCount(promoname);
	        System.out.println(gudcountinmygudpromos);
	        int viewcountinmygudpromos=homepage.ViewCount(promoname);
	        System.out.println(viewcountinmygudpromos);
	        assertEquals(gudcountinmygudpromos, GudCountonHomepage+1);
			assertEquals(viewcountinmygudpromos, ViewCountonHomepage+1);	
	    }

    
    @Then("^Verify the disliked promo from my gudpromos row (.+)$")
    public void verify_the_disliked_promo_from_my_gudpromos_row(String promoname) throws Throwable {
    	homepage.HeaderLogo.click();
		commonlocatorsandmethods.scrolldownm();
		String PromonameongudPromos = homepage.mygudpromosdislike(promoname);
		log.info(PromonameongudPromos);
		assertNotEquals(promoname, PromonameongudPromos);
    }
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
    @Then("^After unlike verify view and gud count of (.+)$")
    public void after_unlike_verify_view_and_gud_count_of(String promoname) throws Throwable {
    	wait.until(ExpectedConditions.visibilityOf(homepage.HeaderLogo));
    	commonlocatorsandmethods.scrolldownm();
    	int afterGudCountonHomepage = 0;
    	int afterViewCountonHomepage = 0;
    	for(int i=0;i<homepage.allPromoNames.size();i++)
        {
        	if(homepage.allPromoNames.get(i).getText().equalsIgnoreCase(promoname))
        	{
        		afterGudCountonHomepage=shodetailpage.GudCount(promoname,homepage.allPromoNames);
        		afterViewCountonHomepage=shodetailpage.ViewCount(promoname,homepage.allPromoNames);
        		break;
        	}
        }
    	
		assertEquals(afterGudCountonHomepage, GudCountonHomepage-1);
		assertEquals(afterViewCountonHomepage, ViewCountonHomepage+1);
    }
    int Studiofollowerscount;
    @Given("^Check Follow count of studio$")
    public void check_follow_count_of_studio() throws Throwable {
    	commonlocatorsandmethods.scrolldownm();
        String followcount=homepage.FollowerCount.get(1).getText();
        String str=followcount.substring(0,followcount.lastIndexOf(" Followers"));
        Studiofollowerscount=Integer.parseInt(str);
       log.info(Studiofollowerscount);
    }

    @Then("^click on Studio card and check count on studio page$")
    public void click_on_studio_card_and_check_count_on_studio_page() throws Throwable {
    	String studionameoncard = homepage.RowStudioNameonCard.get(1).getText();
		homepage.StudioCards.get(1).click();
		wait.until(ExpectedConditions.visibilityOf(studiodetailpage.StudioNameInStudioPage));
		String studioname = studiodetailpage.StudioNameInStudioPage.getText();
		log.info(studioname);
		assertEquals(studioname, studionameoncard);
    }
    @And("^verify studio follower count incremented by one$")
    public void vrify_studio_follower_count_incremented_by_one() throws Throwable {
    	String followcount=homepage.FollowerCount.get(1).getText();
        String str=followcount.substring(0,followcount.lastIndexOf(" Followers"));
        int Studiofollowerscountafterfollow=Integer.parseInt(str);
        assertEquals(Studiofollowerscountafterfollow,Studiofollowerscount+1);
    }
    @And("^verify count on studio detail page$")
    public void verify_count_on_studio_detail_page() throws Throwable {
        String followCountonStudio=studiodetailpage.StudioFollowerCount.getText();
        String str=followCountonStudio.substring(0,followCountonStudio.lastIndexOf(" Followers"));
        int Studiocountonstudiodetail=Integer.parseInt(str);
        log.info(Studiocountonstudiodetail);
        assertEquals(Studiocountonstudiodetail, Studiofollowerscount+1);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   /* @Given("^get studio followers count click on studio follow verify the incremented count$")
    public void get_studio_followers_count_click_on_studio_follow_verify_the_incremented_count() throws Throwable {
    	commonlocatorsandmethods.scrolldownm();
		String intialFollowCount = homepage.allStudioFollowersCount.get(0).getText();
		System.out.println(intialFollowCount);
		Actions action = new Actions(driver);
		action.moveToElement(homepage.followButtons.get(0)).click().build().perform();
		Thread.sleep(2000);
		String finalFollowCount = homepage.allStudioFollowersCount.get(0).getText();
		wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		assertEquals("You have started following this studio", ToastandErrormessages.ToastMessageText.getText());
		System.out.println("inital count :" +intialFollowCount+ "final follow count :"+finalFollowCount);
		assertNotEquals(intialFollowCount, finalFollowCount);
    }*/
    
}
