package steps.frontend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pageobjects.frontend.ShareFeature;
import Pageobjects.frontend.ToastandErrormessages;
import Pageobjects.frontend.accountandsettingspage;
import Pageobjects.frontend.commonlocatorsandmethods;
import Pageobjects.frontend.homepage;
import Pageobjects.frontend.paymentpage;
import Pageobjects.frontend.shodetailpage;
import Pageobjects.frontend.studiodetailpage;
import Pageobjects.frontend.videoplayer;
import Resources.BaseSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class accountsandsettingssteps extends BaseSetup {

	homepage home=new homepage();
	shodetailpage detailpage=new shodetailpage();
	paymentpage payment=new paymentpage();
	ToastandErrormessages toaster=new ToastandErrormessages();
	commonlocatorsandmethods cm=new commonlocatorsandmethods();
	ShareFeature share=new ShareFeature();
	studiodetailpage studio=new studiodetailpage();
	commonSteps commonsteps=new commonSteps();
	public static Logger log=Logger.getLogger(studiodetailpagesteps.class.getName());
	videoplayer video=new videoplayer();
	WebDriverWait wait=new WebDriverWait(driver,30);
    JavascriptExecutor js = (JavascriptExecutor)driver;		
    accountandsettingspage accountsts=new accountandsettingspage();
    
    @Given("^click friends tab and enter (.+) and verify toast message$")
    public void click_friends_tab_and_enter_and_verify_toast_message(String email) throws Throwable {
    	Actions a= new Actions(driver);

       	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.AccountandSettingsTabs1)).click();
       	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.FriendsTab)).click();
       	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.inviteemail)).sendKeys(email);
       	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.invitebutton)).click();
        
    	wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
        String toast=ToastandErrormessages.ToastMessageText.getText();
        assertTrue(toast.equalsIgnoreCase("Login email and invite email are same."));
        ToastandErrormessages.ToastMessageClose.click();


    }
    	
    @Given("^click friends tab and enter (.+) and verify success  toast message$")
    public void click_friends_tab_and_enter_and_verify_success_toast_message(String newemail) throws Throwable {
       	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.AccountandSettingsTabs1)).click();
       	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.FriendsTab)).click();
       	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.inviteemail)).sendKeys(newemail);
       	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.invitebutton)).click();
          	
        wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
        String toast=ToastandErrormessages.ToastMessageText.getText();
        assertTrue(toast.equalsIgnoreCase("You successfully invited."));
        ToastandErrormessages.ToastMessageClose.click();

    }

    @Given("^click emailid tan and enter (.+) and verify error toast message$")
    public void click_emailid_tan_and_enter_and_verify_error_toast_message(String existemail) throws Throwable {
    	Actions a= new Actions(driver);

       	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.AccountandSettingsTabs1)).click();
       	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.FriendsTab)).click();
       	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.inviteemail)).sendKeys(existemail);
       	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.invitebutton)).click();
        
    	wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
        String toast=ToastandErrormessages.ToastMessageText.getText();
        assertTrue(toast.equalsIgnoreCase("You already followed your friend"));
        ToastandErrormessages.ToastMessageClose.click();

    }


    @Given("^click friends tab and enter (.+) and verify  error msg validation$")
    public void click_friends_tab_and_enter_and_verify_error_msg_validation(String dummyemail) throws Throwable {
    	Actions a= new Actions(driver);
       	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.AccountandSettingsTabs1)).click();
       	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.FriendsTab)).click();
       	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.inviteemail)).sendKeys(dummyemail);
       	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.invitebutton)).click();
        	
        String errormes1="Please enter valid email address";
        String actualemailvalidation1=accountandsettingspage.emailvalidation.getText();
        assertEquals(errormes1, actualemailvalidation1);

    }

    
    @Given("^click privacy policy tab and verify it should navigate to correct page$")
    public void click_privacy_policy_tab_and_verify_it_should_navigate_to_correct_page() throws Throwable {
        	Actions a= new Actions(driver);

       	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.AccountandSettingsTabs1)).click();
       	
       	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.privacypolicy)).click();
        String errormes2="GudSho Privacy Policy";
        String actualemailvalidation2=accountandsettingspage.verifyprivacypolicy.getText();
        assertEquals(errormes2, actualemailvalidation2);

       	
    }

    
    
    


//    @Given("^click notification tab and verify in-app toggle button$")
//    public void click_notification_tab_and_verify_inapp_toggle_button() throws Throwable {
//
//    	Actions a =new Actions(driver);
//    	accountandsettingspage.AccountandSettingsTabs1.click();
//    	accountandsettingspage.MyProfileTab.click();
//    	accountandsettingspage.notifications.click();
//    	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.inapptoggle.get(2)));
//    	accountandsettingspage.inapptoggle.get(2).getAttribute("aria-checked");
////	    String togglebuttoff1=accountandsettingspage.inapptoggle.get(2).getAttribute("aria-checked");
////	    System.out.println(togglebuttoff1);
////        boolean b1=Boolean.parseBoolean(togglebuttoff1);  
//      
//    	if(accountandsettingspage.inapptoggle.get(2).getAttribute("aria-checked").equalsIgnoreCase("false")) {  
//    	
//    		wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.inapptoggle.get(2))).click();
//    		String togglebuttoff=accountandsettingspage.inapptoggle.get(2).getAttribute("aria-checked");
//
//    		assertEquals("true", togglebuttoff);
//    	}
//    	else if(accountandsettingspage.inapptoggle.get(2).getAttribute("aria-checked").equalsIgnoreCase("true")) {  
//    		
//    		wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.inapptoggle.get(2))).click();
//    		String togglebuttoff=accountandsettingspage.inapptoggle.get(2).getAttribute("aria-checked");
//
//    		assertEquals("false", togglebuttoff);
//
//    	}
//    	else {
//    		System.out.println("toggle button is not working");
//    	}
//    }
    
    
    
    


        
    

    	
   }



