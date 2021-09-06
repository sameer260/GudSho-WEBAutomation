package steps.frontend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

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

         a.moveToElement(accountandsettingspage.AccountandSettingsTabs1).click().build().perform();

       	wait.until(ExpectedConditions.elementToBeClickable(accountandsettingspage.MyProfileTab)).click();
       	
       	wait.until(ExpectedConditions.elementToBeClickable(accountandsettingspage.privacypolicy)).click();
        String errormes2="GudSho Privacy Policy";
       wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.verifyprivacypolicy));
       assertTrue(accountandsettingspage.verifyprivacypolicy.isDisplayed());
       	
    }

    
    @Given("^enter (.+) and (.+) and (.+) details  and click save button and verify toast message$")
    public void enter_and_and_details_and_click_save_button_and_verify_toast_message(String name, String dob, String gendar) throws Throwable {
    	Actions a= new Actions(driver);

    	a.moveToElement(accountandsettingspage.AccountandSettingsTabs1).click().build().perform();

      	wait.until(ExpectedConditions.elementToBeClickable(accountandsettingspage.MyProfileTab)).click();
      	
       	wait.until(ExpectedConditions.elementToBeClickable(accountandsettingspage.profilename)).clear();
   	
       	wait.until(ExpectedConditions.elementToBeClickable(accountandsettingspage.profilename)).sendKeys(name);
   	
       	wait.until(ExpectedConditions.elementToBeClickable(accountandsettingspage.dob)).clear();
       	wait.until(ExpectedConditions.elementToBeClickable(accountandsettingspage.dob)).sendKeys(dob);
       	

       	wait.until(ExpectedConditions.elementToBeClickable(accountandsettingspage.gendar1)).click();

    	js.executeScript("arguments[0].click();", accountandsettingspage.gendar1);

       	wait.until(ExpectedConditions.elementToBeClickable(accountandsettingspage.profilesavebutton)).click();

    	wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
        String toast=ToastandErrormessages.ToastMessageText.getText();
        assertTrue(toast.equalsIgnoreCase("Your profile has been updated successfully"));
        ToastandErrormessages.ToastMessageClose.click();

    }
    
    @Given("^enter (.+) and (.+) and (.+) details  and click save button and verify name error message$")
    public void enter_and_and_details_and_click_save_button_and_verify_name_error_message(String name, String dob, String gendar) throws Throwable {
    
    Actions a=new Actions(driver);


	a.moveToElement(accountandsettingspage.AccountandSettingsTabs1).click().build().perform();

  	wait.until(ExpectedConditions.elementToBeClickable(accountandsettingspage.MyProfileTab)).click();
  	
   	wait.until(ExpectedConditions.elementToBeClickable(accountandsettingspage.profilename)).clear();
	
   	wait.until(ExpectedConditions.elementToBeClickable(accountandsettingspage.profilename)).sendKeys(name);
	
   	wait.until(ExpectedConditions.elementToBeClickable(accountandsettingspage.dob)).clear();
   	wait.until(ExpectedConditions.elementToBeClickable(accountandsettingspage.dob)).sendKeys(dob);
   	

  	wait.until(ExpectedConditions.elementToBeClickable(accountandsettingspage.gendar1)).click();

	js.executeScript("arguments[0].click();", accountandsettingspage.gendar1);

   	wait.until(ExpectedConditions.elementToBeClickable(accountandsettingspage.profilesavebutton)).click();

    String errormesforname="Only characters allowed";
    String actualnamevalidation=accountandsettingspage.profilenamevalidation.getText();
    assertEquals(errormesforname, actualnamevalidation);
    String errormesfordate="Please enter a valid date";
    String actualdatevalidation=accountandsettingspage.profiledatevalidation.getText();
    assertEquals(errormesfordate, actualdatevalidation);


    
    

    	
   }
    

}

