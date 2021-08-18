package steps.frontend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pageobjects.frontend.Footer;
import Pageobjects.frontend.ShareFeature;
import Pageobjects.frontend.SignUp;
import Pageobjects.frontend.ToastandErrormessages;
import Pageobjects.frontend.accountandsettingspage;
import Pageobjects.frontend.commonlocatorsandmethods;
import Pageobjects.frontend.homepage;
import Pageobjects.frontend.paymentpage;
import Pageobjects.frontend.shodetailpage;
import Pageobjects.frontend.videoplayer;
import Resources.BaseSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class footersteps extends BaseSetup {

	homepage home = new homepage();
	shodetailpage detailpage = new shodetailpage();
	paymentpage payment = new paymentpage();
	ToastandErrormessages toaster = new ToastandErrormessages();
	commonlocatorsandmethods cm = new commonlocatorsandmethods();
	ShareFeature share = new ShareFeature();
	public static Logger log = Logger.getLogger(footersteps.class.getName());
	videoplayer video = new videoplayer();
	WebDriverWait wait = new WebDriverWait(driver, 30);
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	Footer ft = new Footer();
	accountandsettingspage acc=new accountandsettingspage();
	SignUp sign=new SignUp();

	@Given("^verify gudsho logo$")
	public void verify_gudsho_logo() throws Throwable {
		commonlocatorsandmethods.scrolldownm();
		wait.until(ExpectedConditions.visibilityOf(Footer.gudshotext));
		assertTrue(Footer.gudshotext.isDisplayed());
		String actualsho = Footer.gudshotext.getAttribute("alt");
		log.info(actualsho);
		String expectedsho = "GudSho";
		log.info(expectedsho);
		assertTrue(actualsho.equalsIgnoreCase(expectedsho));

	}

	@And("^verify footer paragraph text$")
	public void verify_footer_paragraph_text() throws Throwable {
		commonlocatorsandmethods.scrolldownm();
		wait.until(ExpectedConditions.visibilityOf(Footer.footertext));
		String actualsho = Footer.footertext.getText();
		log.info(actualsho);
		String expectedsho = "Join GudSho to watch the unlimited movies, series, and award-winning GudSho Originals. Everything you want to watch anytime, anywhere, and as much.";
		log.info(expectedsho);
		assertTrue(actualsho.equalsIgnoreCase(expectedsho));
		assertTrue(Footer.CopyRightStatement.isDisplayed());
		String actulCopyright = Footer.CopyRightStatement.getText();
		String expectedCopyRightstatement = "© Copyrights 2021 by GudSho Digital";
		assertEquals(actulCopyright, expectedCopyRightstatement);

	}
	@And("^Verify Footer headings$")
    public void verify_footer_headings() throws Throwable {
        String FirstFooterHeader=Footer.FooterHeaders.get(0).getText();
        log.info(FirstFooterHeader);
        assertEquals(FirstFooterHeader,"Quick Links");
        String SecondFooterHeader=Footer.FooterHeaders.get(1).getText();
        log.info(SecondFooterHeader);
        assertEquals(SecondFooterHeader,"Connect with us");
        String ThirdFooterHeader=Footer.FooterHeaders.get(2).getText();
        log.info(ThirdFooterHeader);
        assertEquals(ThirdFooterHeader,"Download the App");
        assertTrue(Footer.sellshobutton.isDisplayed());
        assertTrue(Footer.googleplay.isDisplayed());
        assertTrue(Footer.appstore.isDisplayed());
    }

	@Given("^click about us link and verify it should redirected to correct page$")
	public void click_about_us_link_and_verify_it_should_redirected_to_correct_page() throws Throwable {
		String ChildUrl="https://stream.gudsho.com/about.php";
		String Childtitle="About Us | GudSho - All-in-One OTT Platform";	
		Footer.WindowhandleforLinks(Footer.aboutus, ChildUrl, Childtitle);
	}

	@Given("^click help&support link and verify it should redirected to correct page$")
	public void click_helpsupport_link_and_verify_it_should_redirected_to_correct_page() throws Throwable {
		String ChildUrl="https://www.gudsho.com/support";
		String Childtitle="Help Desk | GudSho";	
		Footer.WindowhandleforLinks(Footer.helpsupport, ChildUrl, Childtitle);
	}

	@Given("^click Submit your film link and verify it should redirected to correct page$")
	public void click_submit_your_film_link_and_verify_it_should_redirected_to_correct_page() throws Throwable {
		String ChildUrl="https://monetize.gudsho.com/submit-your-film";
		String Childtitle="Submit Your Film | All-in-One OTT Platform to Release Movies & Web Series- GudSho";	
		Footer.WindowhandleforLinks(Footer.submityourfilm, ChildUrl, Childtitle);
	}

	@Given("^click blog link and verify it should redirected to correct page$")
	public void click_blog_link_and_verify_it_should_redirected_to_correct_page() throws Throwable {
		String ChildUrl="https://stories.gudsho.com/";
		String Childtitle="GudSho Blog - The Future Trends & Technologies of OTT Streaming";	
		Footer.WindowhandleforLinks(Footer.blog, ChildUrl, Childtitle);
	}

	@Given("^click terms link and verify it should redirected to correct page$")
	public void click_terms_link_and_verify_it_should_redirected_to_correct_page() throws Throwable {
		String ChildUrl="https://stream.gudsho.com/terms-of-service.php";
		String Childtitle="GudSho - Terms & Conditions";	
		Footer.WindowhandleforLinks(Footer.terms, ChildUrl, Childtitle);
	}

	@Given("^click privacy link and verify it should redirected to correct page$")
	public void click_privacy_link_and_verify_it_should_redirected_to_correct_page() throws Throwable {
		String ChildUrl="https://stream.gudsho.com/privacy-policy.php";
		String Childtitle="GudSho - Privacy Policy";	
		Footer.WindowhandleforLinks(Footer.privacy, ChildUrl, Childtitle);
	}

	@Given("^click Sell your movies & series on gudsho link and verify it should redirected to correct page$")
	public void click_sell_your_movies_series_on_gudsho_link_and_verify_it_should_redirected_to_correct_page()
			throws Throwable {
		String ChildUrl="https://stream.gudsho.com/contact-sales.php";
		String Childtitle="Contact Us | GudSho";	
		Footer.WindowhandleforLinks(Footer.sellshobutton, ChildUrl, Childtitle);
    }
	 @Given("^Check Play store App redirection$")
	 public void check_play_store_app_redirection() throws Throwable {
		 String ChildUrl="https://play.google.com/store/apps/details?id=com.gudsho";
		 String Childtitle="GudSho OTT - Apps on Google Play";	
		 Footer.WindowhandleforLinks(Footer.googleplay, ChildUrl, Childtitle);
	}
	 @Given("^Check App store App redirection$")
	 public void check_app_store_app_redirection() throws Throwable {
		 String ChildUrl="https://apps.apple.com/in/app/gudsho-ott/id1539371660";
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
			String parentWindowHandle = driver.getWindowHandle();
			executor.executeScript("arguments[0].click();", Footer.appstore);
			Set<String> allWindowHandles = driver.getWindowHandles();
			Iterator<String> I1 = allWindowHandles.iterator();
			while (I1.hasNext()) {

				String child_window = I1.next();

				if (!parentWindowHandle.equals(child_window)) {
					driver.switchTo().window(child_window);
					Thread.sleep(1000);
					String title = driver.getTitle();
					log.info(title);
					String Url = driver.getCurrentUrl();
					log.info(Url);
					assertTrue(Url.equalsIgnoreCase(ChildUrl));
					driver.close();
				}
			}
			driver.switchTo().window(parentWindowHandle);
	}   
	 
	    @Given("^Check Facebook redirection$")
	    public void check_facebook_redirection() throws Throwable {
	         String ChildUrl="https://www.facebook.com/GudSho.Digital/";
			 String Childtitle="GudSho - Home | Facebook";	
			 Footer.WindowhandleforSocialLinks(Footer.ConnectUsSocialLinks.get(0), ChildUrl, Childtitle);

	    }

	    @And("^Check Twitter redirection$")
	    public void check_twitter_redirection() throws Throwable {
	    	String ChildUrl="https://twitter.com/GudShoIN";
			 String Childtitle="GudSho (@GudShoIN) / Twitter";	
			 Footer.WindowhandleforSocialLinks(Footer.ConnectUsSocialLinks.get(1), ChildUrl, Childtitle);

	    }

	    @And("^Check Instagram redirection$")
	    public void check_instagram_redirection() throws Throwable {
	    	String ChildUrl="https://www.instagram.com/accounts/login/";
			 String Childtitle="Login • Instagram";	
			 Footer.WindowhandleforSocialLinks(Footer.ConnectUsSocialLinks.get(2), ChildUrl, Childtitle);

	    }

	    @And("^Check Linkedin redirection$")
	    public void check_linkedin_redirection() throws Throwable {
	    	String ChildUrl="https://www.linkedin.com/company/gudsho/";
			 String Childtitle="GudSho | LinkedIn";	
			 Footer.WindowhandleforSocialLinks(Footer.ConnectUsSocialLinks.get(3), ChildUrl, Childtitle);

	    }

	    @And("^Check Youtube redirection$")
	    public void check_youtube_redirection() throws Throwable {
	    	String ChildUrl="https://www.youtube.com/channel/UCtCPBufttxYK_kAY8HyMfSw";
			 String Childtitle="GudSho-YouTube";	
			 Footer.WindowhandleforSocialLinks(Footer.ConnectUsSocialLinks.get(4), ChildUrl, Childtitle);

	    }
	    @Given("^Hover on profile$")
	    public void hover_on_profile() throws Throwable {
	    	Actions a =new Actions(driver);
	    	a.moveToElement(homepage.Headderprofileicon).build().perform();
	    	
	        
	    }

	    @Then("^Click on support menu and verify redirection$")
	    public void click_on_support_menu() throws Throwable {
	    	WebDriverWait wait=new WebDriverWait(driver,20);
	    	wait.until(ExpectedConditions.visibilityOf(homepage.support));
	    	String ChildUrl="https://qa.gudsho.com/support";
			String Childtitle="Support | GudSho";	
			homepage.support.click();
			wait.until(ExpectedConditions.urlMatches(ChildUrl));
			assertEquals(ChildUrl,driver.getCurrentUrl());
			assertEquals(Childtitle,driver.getTitle());
			
	    }
	    @Then("^Click on Friends menu and verify redirection$")
	    public void click_on_friends_menu_and_verify_redirection() throws Throwable {
	    	WebDriverWait wait=new WebDriverWait(driver,20);
	    	wait.until(ExpectedConditions.visibilityOf(homepage.friends));
	    	homepage.friends.click();
	    	String str=homepage.friends.getText();
	    	accountandsettingspage.FriendsTab.isDisplayed();
	    	accountandsettingspage.FriendSectionElement.isDisplayed();
	    	String areatstate=accountandsettingspage.TabSelection(str);
	    	assertEquals(areatstate,"true");
	    }
	    @Then("^Click on Account and settings menu and verify redirection$")
	    public void click_on_account_and_settings_menu_and_verify_redirection() throws Throwable {
	    	WebDriverWait wait=new WebDriverWait(driver,20);
	    	wait.until(ExpectedConditions.visibilityOf(homepage.accountsettings));
	    	homepage.accountsettings.click();
	    	String str=accountandsettingspage.MyProfileTab.getText();
	    	accountandsettingspage.MyProfileTab.isDisplayed();
	    	accountandsettingspage.MyProfileElement.isDisplayed();
	    	String areatstate=accountandsettingspage.TabSelection(str);
	    	assertEquals(areatstate,"true");
	    }
	    @Then("^Click on Signout and check toaster$")
	    public void click_on_signout_and_check_toaster() throws Throwable {
	    	WebDriverWait wait=new WebDriverWait(driver,20);
	    	wait.until(ExpectedConditions.visibilityOf(homepage.accountsettings));
	    	accountandsettingspage.SignOut.click();
	    	try{wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
	    	String toaster=ToastandErrormessages.ToastMessageText.getText();
	    	assertEquals(toaster,"Done!Signed out successfully");
	    	ToastandErrormessages.ToastMessageText.click();}catch(Exception e) {
	    	
	    	}
	    	wait.until(ExpectedConditions.visibilityOf(SignUp.HomePageSignInButton));
	    	assertTrue(SignUp.HomePageSignInButton.isDisplayed());
	    }
	    @And("^capture name and profile and verify with name and number$")
	    public void capture_name_and_profile_and_verify_with_name_and_number() throws Throwable {
	    	String Username;
	    	WebDriverWait wait=new WebDriverWait(driver,20);
	    	JavascriptExecutor js=(JavascriptExecutor)driver;
	    	String PhoneNumeber = (String) js.executeScript("return arguments[0].value;",accountandsettingspage.PhoneNumber);
	    	String str = (String) js.executeScript("return arguments[0].value;",accountandsettingspage.UserName);
	    	if(str.length()>12)
	    	{
	    	  Username=str.substring(0,12);
	    	}
	    	else
	    	{
	    	   Username=str;
	    	}
	    	System.out.println(Username);
	    	Actions a =new Actions(driver);
	    	a.moveToElement(homepage.Headderprofileicon).build().perform();
	    	wait.until(ExpectedConditions.visibilityOf(homepage.ProfileUserPhoneNumber));
	    	String phonenumber=homepage.ProfileUserPhoneNumber.getText();
			String name=homepage.ProfileUserName.getText();
			assertEquals(phonenumber,PhoneNumeber);
			assertEquals(name,Username);
	    }

	    @And("^Clear cookies$")
	    public void clear_cookies() throws Throwable {
	        driver.manage().deleteAllCookies();
	    }


	   

	
	
	
	
	
	

}
