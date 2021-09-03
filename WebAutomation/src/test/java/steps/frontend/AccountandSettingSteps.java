package steps.frontend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pageobjects.frontend.ToastandErrormessages;
import Pageobjects.frontend.accountandsettingspage;
import Pageobjects.frontend.homepage;
import Pageobjects.frontend.paymentpage;
import Pageobjects.frontend.shodetailpage;
import Resources.BaseSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountandSettingSteps extends BaseSetup {
	
	
	accountandsettingspage ac=new accountandsettingspage();
	homepage hm=new homepage();
	paymentpage pm=new paymentpage();
	WebDriverWait wait=new WebDriverWait(driver,20);
	ToastandErrormessages toast=new ToastandErrormessages();
	public static Logger log = Logger.getLogger(AccountandSettingSteps.class.getName());
	
	//Transactions
	
	String transactionid;
	 @Then("^Check payment status for (.+) for (.+)$")
	    public void check_payment_status_for_for(String paymentscenario, String shoname) throws Throwable {
	
		 wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		 String toastMessage=ToastandErrormessages.ToastMessageText.getText();
	     log.info(toastMessage);
		 if(paymentscenario.equalsIgnoreCase("Success"))
			{
			 assertEquals(toastMessage,"Payment Processed");
			}
			else if(paymentscenario.equalsIgnoreCase("Failed"))
			{
				 assertEquals(toastMessage,"Transaction failed, please try again or change method.");
			}
		     transactionid= paymentpage.paymentStatus(paymentscenario, shoname);
		     log.info(transactionid);
		    wait.until(ExpectedConditions.visibilityOf(shodetailpage.WatchListButton));
	    }
	 @And("^Check (.+) in transactions for (.+) and (.+)$")
	    public void check_in_transactaions_for_and(String shoname, String paymentmode, String paymentscenario) throws Throwable {
		Actions a =new Actions(driver);
    	a.moveToElement(homepage.Headderprofileicon).build().perform();
    	WebDriverWait wait=new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.visibilityOf(homepage.accountsettings));
    	homepage.accountsettings.click();
    	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.MyProfileTab));
    	accountandsettingspage.TabSelection("Transactions");
    	List<String> ele1=accountandsettingspage.verifyPayment(shoname);
    	
    		String purchaseDate=ele1.get(0);
    		log.info(purchaseDate);
    		SimpleDateFormat DateFormat=new SimpleDateFormat("dd MMM yyyy");
    		Date dateFormat=new Date();
    		String Systemdate=DateFormat.format(dateFormat);
    		log.info(Systemdate);
    		assertEquals(Systemdate,purchaseDate);
    		
    		
    		String time=ele1.get(1);
    		log.info(time);
    		SimpleDateFormat timeformat=new SimpleDateFormat("h:mm a");
    		Date Timeformat=new Date();
    		String Systemtime=timeformat.format(Timeformat);
    		log.info(Systemtime);
    		if(Systemtime.equalsIgnoreCase(time))
    		{
    			assertEquals(Systemtime,time);
    		}
    		else {
    			SimpleDateFormat s1=new SimpleDateFormat("mm");
    			Date date = new Date();
    	        System.out.println("Current Date " + s1.format(date));
    			Calendar c = Calendar.getInstance();
    			c.setTime(date);
    			c.add(Calendar.SECOND, 1);
    			Date currentDatePlusOne = c.getTime();
    	        String ss= s1.format(currentDatePlusOne);
    	        SimpleDateFormat timeformat1=new SimpleDateFormat("h:"+ss+" a");
    	        Date Timeformat1=new Date();
        		String Systemtime1=timeformat1.format(Timeformat1);
        		log.info(Systemtime1);
        		assertEquals(Systemtime1,time);
    		}
    		
    		String ShoName=ele1.get(2);
    		log.info(ShoName);
    		assertTrue(ShoName.equalsIgnoreCase(shoname));
    		
    		String amount=ele1.get(3);
    		log.info(amount);
    		String shoPrice=amount.replace(" ", "");
    		System.out.println(shodetailpagesteps.shopriceonshodetail);
    		assertEquals(shoPrice, shodetailpagesteps.shopriceonshodetail);
    		
    		String Mode=ele1.get(4);
    		log.info(Mode);
    		assertTrue(Mode.equalsIgnoreCase(paymentmode));
    		
    		if(paymentscenario.equalsIgnoreCase("Success"))
    		{
    			log.info("No Transaction id for Success Payment");
    		}else if(paymentscenario.equalsIgnoreCase("Failed")) {
    		String transctionID=ele1.get(5);
    		log.info(transctionID);
    		assertTrue(transctionID.equalsIgnoreCase(transactionid));
    		}
    		
    		String PaymentMode=ele1.get(6);
    		log.info(PaymentMode);
    		assertTrue(PaymentMode.equalsIgnoreCase("Razorpay"));
    		
    		String Paymentstatus=ele1.get(7);
    		log.info(Paymentstatus);
    		assertTrue(Paymentstatus.equalsIgnoreCase(paymentscenario));
    
    }
	    @When("^Click on Continue Button and check Razor payment popup$")
	    public void click_on_continue_button_and_check_razor_payment_popup() throws Throwable {
	    	shodetailpage.BuyButton.click();
			wait.until(ExpectedConditions.visibilityOf(paymentpage.PopupContinueButton));
			paymentpage.PopupContinueButton.click();
		    driver.switchTo().frame(paymentpage.RozarPayFrame);
	    }

	    @Then("^Check razor payment popup validation$")
	    public void check_razor_payment_popup_validation() throws Throwable {
	        wait.until(ExpectedConditions.visibilityOf(paymentpage.RazorPayHeader));
	        paymentpage.RozarPaypopupclose.click();
	        driver.switchTo().defaultContent();
	        wait.until(ExpectedConditions.elementToBeClickable(paymentpage.TryAgainButton));
	        assertTrue(paymentpage.ImageSection.isDisplayed());
	        paymentpage.TryAgainButton.click();
	        driver.switchTo().frame(paymentpage.RozarPayFrame);
	        wait.until(ExpectedConditions.visibilityOf(paymentpage.RazorPayHeader));
	        paymentpage.RozarPaypopupclose.click();
	        driver.switchTo().defaultContent();
	        assertTrue(paymentpage.ImageSection.isDisplayed());
	        wait.until(ExpectedConditions.elementToBeClickable(paymentpage.BackToShoPageLink));
	        paymentpage.BackToShoPageLink.click();
	        wait.until(ExpectedConditions.visibilityOf(shodetailpage.WatchListButton));
	        assertTrue(shodetailpage.WatchListButton.isDisplayed());
	        
	    }
	 
	//Watch History
	    
	

		@Given("^navigate to my watch history$")
		public void navigate_to_my_watch_history() throws Throwable {
			Actions actions = new Actions(driver);
			wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.hoverOnMyProfile));
			actions.moveToElement(accountandsettingspage.hoverOnMyProfile).build().perform();
			wait.until(ExpectedConditions.visibilityOf(homepage.accountsettings));
			homepage.accountsettings.click();
			accountandsettingspage.myWatchHistory.click();
			Thread.sleep(1000);

		}

		@Then("^Verify deletion on the watch history$")
		public void verify_the_deletion_on_the_watch_history() throws Throwable {
			wait.until(ExpectedConditions.visibilityOfAllElements(accountandsettingspage.allShoNames));
			String firstShoName = accountandsettingspage.allShoNames.get(0).getText();
			accountandsettingspage.allDeleteButtonsWatchHistory.get(0).click();
			wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
			assertEquals(firstShoName + " has been removed from Watch History",
					ToastandErrormessages.ToastMessageText.getText());

		}

		@Then("^Verify clear all on the watch history$")
		public void verify_clear_all_on_the_watch_history() throws Throwable {
			accountandsettingspage.clearAll.click();
			wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.clearAllPopUpHeader));
			assertEquals("Watch History", accountandsettingspage.clearAllPopUpHeader.getText());
			assertEquals("You cannot undo this action. Are you sure want to clear watch history?",
					accountandsettingspage.clearAllPopUpText.getText());
			assertTrue(accountandsettingspage.cancellButton.isDisplayed());
			assertTrue(accountandsettingspage.deletePermanentlyButton.isDisplayed());
			accountandsettingspage.deletePermanentlyButton.click();
			wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
			assertEquals("Watch History has been cleared successfully", ToastandErrormessages.ToastMessageText.getText());
			assertEquals("Huh, its likely that you havent watched anything yet!", accountandsettingspage.clearAllPlaceHolder.getText());

		}

		@Then("^Verify player redirection from watch history$")
		public void verify_player_redirection_from_watch_history() throws Throwable {
			String firstSho = accountandsettingspage.allShoNames.get(0).getText();
			accountandsettingspage.allShoNames.get(0).click();
			Thread.sleep(10000);
			Actions actions = new Actions(driver);
			actions.moveToElement(accountandsettingspage.playerTitleName).build().perform();
			String playerShoName = accountandsettingspage.playerTitleName.getAttribute("alt");
			assertEquals(firstSho, playerShoName);

		}

		@Then("^Verify (.+) from watchh history$")
		public void verify_from_watchh_history(String shoname) throws Throwable {
			Thread.sleep(1000);
			String firstShoName = accountandsettingspage.allShoNames.get(0).getText();
			assertEquals(shoname, firstShoName);
			String playDate = accountandsettingspage.watchHistoryPlaydate.getText();
			SimpleDateFormat DateFormat = new SimpleDateFormat("dd MMM yyyy");
			Date dateFormat = new Date();
			String Systemdate = DateFormat.format(dateFormat);
			assertEquals(Systemdate, playDate);
		}
		
		@Given("^navigate to notifications tab$")
	    public void navigate_to_notifications_tab() throws Throwable {
			Actions actions = new Actions(driver);
			wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.hoverOnMyProfile));
			actions.moveToElement(accountandsettingspage.hoverOnMyProfile).build().perform();
			wait.until(ExpectedConditions.visibilityOf(homepage.accountsettings));
			homepage.accountsettings.click();
			accountandsettingspage.NotificationsTab.click();
			wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.NotificationElements));
			assertTrue(accountandsettingspage.NotificationElements.isDisplayed());
			String str = accountandsettingspage.NotificationsTab.getText();
			String areatstate = accountandsettingspage.TabSelection(str);
			assertEquals(areatstate, "true");
	    }

		 @Then("^Check notification toggle status for (.+)$")
		    public void check_notification_toggle_status_for(String notificationtype) throws Throwable {
			
			 
			 for(int i=0;i<accountandsettingspage.NotificationTypes.size();i++)
				{
				 String ToggleButtonAfter=null;
					if(accountandsettingspage.NotificationTypes.get(i).getText().equalsIgnoreCase(notificationtype))
					{
						String notificationdescription=accountandsettingspage.NotificationDescriptions.get(i).getText();
						log.info(notificationdescription);
						String NotificationType=accountandsettingspage.NotificationTypes.get(i).getText();
						log.info(NotificationType);
						String IntialToggleButtonposition=accountandsettingspage.InputAttributes.get(i).getAttribute("aria-checked");
						log.info(IntialToggleButtonposition);
						assertEquals(NotificationType,notificationtype);
						if(IntialToggleButtonposition.equalsIgnoreCase("true"))
						{
					    accountandsettingspage.ToggleButtons.get(i).click();
					    Thread.sleep(500);
					    ToggleButtonAfter=accountandsettingspage.InputAttributes.get(i).getAttribute("aria-checked");
						assertEquals(ToggleButtonAfter, "false");
						accountandsettingspage.ToggleButtons.get(i).click();
						Thread.sleep(500);
					    ToggleButtonAfter=accountandsettingspage.InputAttributes.get(i).getAttribute("aria-checked");
						assertEquals(ToggleButtonAfter, "true");
						}
						else
						{
							accountandsettingspage.ToggleButtons.get(i).click();
							Thread.sleep(500);
							ToggleButtonAfter=accountandsettingspage.InputAttributes.get(i).getAttribute("aria-checked");
							assertEquals(ToggleButtonAfter, "true");
							accountandsettingspage.ToggleButtons.get(i).click();
							Thread.sleep(500);
							ToggleButtonAfter=accountandsettingspage.InputAttributes.get(i).getAttribute("aria-checked");
							assertEquals(ToggleButtonAfter, "false");
						}
						break;
						
					}
				}
		    }
		
		 @Given("^click friends tab and enter (.+) and verify toast message$")
		    public void click_friends_tab_and_enter_and_verify_toast_message(String selfinvite) throws Throwable {
			 Actions actions = new Actions(driver);
				wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.hoverOnMyProfile));
				actions.moveToElement(accountandsettingspage.hoverOnMyProfile).build().perform();
				wait.until(ExpectedConditions.visibilityOf(homepage.accountsettings));
				homepage.accountsettings.click();
				WebDriverWait wait=new WebDriverWait(driver,20);
		    	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.FriendsTab));
		    	accountandsettingspage.FriendsTab.click();
		    	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.FriendSectionElement));
		    	String str=accountandsettingspage.FriendsTab.getText();
		    	assertTrue(accountandsettingspage.FriendsTab.isDisplayed());
		    	assertTrue(accountandsettingspage.FriendSectionElement.isDisplayed());
		    	String areatstate=accountandsettingspage.TabSelection(str);
		    	assertEquals(areatstate,"true");
		    	
		       	accountandsettingspage.inviteemail.sendKeys(selfinvite);
		       	JavascriptExecutor js=(JavascriptExecutor)driver;
		       	js.executeScript("arguments[0].click();", accountandsettingspage.invitebutton);
		       	
		        
		    	wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		        String toast=ToastandErrormessages.ToastMessageText.getText();
		        assertTrue(toast.equalsIgnoreCase("Login email and invite email are same."));
		        ToastandErrormessages.ToastMessageClose.click();


		    }
		    	
		    @Then("^click friends tab and enter (.+) and verify success  toast message$")
		    public void click_friends_tab_and_enter_and_verify_success_toast_message(String newinvite) throws Throwable {
		    	accountandsettingspage.inviteemail.clear();
		       	accountandsettingspage.inviteemail.sendKeys(newinvite);
		       	JavascriptExecutor js=(JavascriptExecutor)driver;
		       	js.executeScript("arguments[0].click();", accountandsettingspage.invitebutton);
		        
		          	
		        wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		        String toast=ToastandErrormessages.ToastMessageText.getText();
		        assertTrue(toast.equalsIgnoreCase("You successfully invited."));
		        ToastandErrormessages.ToastMessageClose.click();

		    }

		    @And("^click emailid tab and enter (.+) and verify error toast message$")
		    public void click_emailid_tan_and_enter_and_verify_error_toast_message(String sameinvite) throws Throwable {
		    	accountandsettingspage.inviteemail.clear();
		    	accountandsettingspage.inviteemail.sendKeys(sameinvite);
		    	JavascriptExecutor js=(JavascriptExecutor)driver;
		       	js.executeScript("arguments[0].click();", accountandsettingspage.invitebutton);
		       
		        
		    	wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		        String toast=ToastandErrormessages.ToastMessageText.getText();
		        assertTrue(toast.equalsIgnoreCase("You already followed your friend"));
		        ToastandErrormessages.ToastMessageClose.click();

		    }



		    @And("^verify null value and (.+)$")
		    public void verify_null_value_and(String invalidemail) throws Throwable {
		    	accountandsettingspage.inviteemail.clear();
		    	JavascriptExecutor js=(JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", accountandsettingspage.invitebutton);
		    	String errormes1="Please enter valid email address";
		        String actualemailvalidation1=accountandsettingspage.emailvalidation.getText();
		        assertEquals(errormes1, actualemailvalidation1);
		    	
		    	accountandsettingspage.inviteemail.sendKeys(invalidemail);
		       	js.executeScript("arguments[0].click();", accountandsettingspage.invitebutton);
		        	
		        String errormes2="Please enter valid email address";
		        String actualemailvalidation2=accountandsettingspage.emailvalidation.getText();
		        assertEquals(errormes2, actualemailvalidation2);

		    }

		    
		    @Given("^click privacy policy tab and verify it should navigate to correct page$")
		    public void click_privacy_policy_tab_and_verify_it_should_navigate_to_correct_page() throws Throwable {
		    	Actions actions = new Actions(driver);
				wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.hoverOnMyProfile));
				actions.moveToElement(accountandsettingspage.hoverOnMyProfile).build().perform();
				wait.until(ExpectedConditions.visibilityOf(homepage.accountsettings));
				homepage.accountsettings.click();
				accountandsettingspage.privacypolicy.click();
				wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.verifyprivacypolicy));
				assertTrue(accountandsettingspage.verifyprivacypolicy.isDisplayed());
				String str = accountandsettingspage.privacypolicy.getText();
				String areatstate = accountandsettingspage.TabSelection(str);
				assertEquals(areatstate, "true");
		        String ActualHeadingonPage="GudSho Privacy Policy";
		        String ExpectedHeadingonPage=accountandsettingspage.verifyprivacypolicy.getText();
		        assertEquals(ActualHeadingonPage, ExpectedHeadingonPage);
	
		    }
		    @Then("^Check mute and unmute functionality$")
		    public void check_mute_and_unmute_functionality() throws Throwable {
		       // throw new PendingException();
		    }
		
}
