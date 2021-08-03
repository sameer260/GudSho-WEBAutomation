package steps.frontend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.apache.log4j.Logger;
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
				 }
			 }
			 WebElement shocard11=wait.until(ExpectedConditions.elementToBeClickable(studiodetailpage.selectshocardfromgenre));
			String actualsho=studiodetailpage.ShonameofcardsonGeners.get(0).getAttribute("alt");
			log.info(actualsho);
			studiodetailpage.selectshocardfromgenre.click();
			String expectedsho=shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
			log.info(expectedsho);
			assertTrue(actualsho.equalsIgnoreCase(expectedsho));
	      
		}
		@When("^verfiy promo player$")
		   public void verfiy_promo_player() throws Throwable {
		       String actualpromotext= studiodetailpage.verifypromonameonstudiopage.getText();
		       log.info(actualpromotext);
		       Actions a=new Actions(driver);
		       a.moveToElement(studiodetailpage.clickpromo).click().build().perform();
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
		wait.until(ExpectedConditions.elementToBeClickable(studiodetailpage.shocard1));
		a.moveToElement(studiodetailpage.shocard1).build().perform();
		String actualsho=studiodetailpage.selectshonamefromstudiopage.getAttribute("alt");
		log.info(actualsho);
		a.moveToElement(studiodetailpage.selectshonamefromstudiopage).click().build().perform();
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
	    	String str=studiodetailpage.ShonameofcardsonGeners.get(0).getAttribute("alt");
	        studiodetailpage.WatchFreeShoCards.get(0).click();
	        wait.until(ExpectedConditions.visibilityOf(shodetailpage.WatchListButton));
	        String str1=shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
	        assertEquals(str,str1);
	    }

}
