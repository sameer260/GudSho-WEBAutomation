package parallel;


import static org.junit.Assert.assertTrue;
import org.apache.log4j.Logger;
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
import io.cucumber.java.en.Given;

public class commonSteps extends BaseSetup {
	
	
	homepage home=new homepage();
	shodetailpage detailpage=new shodetailpage();
	paymentpage payment=new paymentpage();
	ToastandErrormessages toaster=new ToastandErrormessages();
	commonlocatorsandmethods cm=new commonlocatorsandmethods();
	ShareFeature share=new ShareFeature();
	studiodetailpage studio=new studiodetailpage();
	public static Logger log=Logger.getLogger(commonSteps.class.getName());
	videoplayer video=new videoplayer();
	WebDriverWait wait=new WebDriverWait(driver,30);
	
	
	
	@Given("^Search any studio (.+) and verify it should redirected to correct page$")
    public void search_any_studio_and_verify_it_should_redirected_to_correct_page(String studioname) throws Throwable {
		homepage.HomePageSearch(studioname);
		wait.until(ExpectedConditions.visibilityOf(studiodetailpage.StudioNameInStudioPage));
		String studionameinstudiodetailpage = studiodetailpage.StudioNameInStudioPage.getText();
		log.info(studionameinstudiodetailpage);
		assertTrue(studionameinstudiodetailpage.equalsIgnoreCase(studioname));

	}
	@Given("^Search any (.+) and verfiy its redirected to correct page$")
	public void search_any_and_verfiy_its_redirected_to_correct_page(String shoname) throws Throwable {
		homepage.HomePageSearch(shoname);
		wait.until(ExpectedConditions.visibilityOf(shodetailpage.ShoNameonShoDetailPage));
		String shonameonshodetailpage = shodetailpage.ShoNameonShoDetailPage.getAttribute("alt");
		log.info(shonameonshodetailpage);
		assertTrue(shonameonshodetailpage.equalsIgnoreCase(shoname));
	}

}
