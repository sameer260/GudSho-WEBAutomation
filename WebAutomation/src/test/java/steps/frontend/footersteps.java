package steps.frontend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pageobjects.frontend.Footer;
import Pageobjects.frontend.ShareFeature;
import Pageobjects.frontend.ToastandErrormessages;
import Pageobjects.frontend.commonlocatorsandmethods;
import Pageobjects.frontend.homepage;
import Pageobjects.frontend.paymentpage;
import Pageobjects.frontend.shodetailpage;
import Pageobjects.frontend.videoplayer;
import Resources.BaseSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;


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
		String Childtitle="GudSho - Watch Unlimited Movies & Web Series Online";	
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
	
	
	
	
	
	

}
