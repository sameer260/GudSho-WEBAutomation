package parallel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.openqa.selenium.interactions.Actions;
import Pageobjects.frontend.shodetailpage;
import Pageobjects.frontend.videoplayer;
import Resources.BaseSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class videoplayersteps extends BaseSetup {
	
	videoplayer video=new videoplayer();
	Actions a =new Actions(driver);
	
	   @When("^Play promo$")
	    public void play_promo() throws Throwable {
		   a.moveToElement(shodetailpage.PromoCards.get(0)).click().build().perform();
		   Thread.sleep(5000);
	    }

	   @Then("^Pause Video at (.+) and play agian$")
	    public void pause_video_at_and_play_agian(String runningtime) throws Throwable {
	        a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
	        String currentrunningtime=videoplayer.playeerpause(runningtime);
	        assertEquals(currentrunningtime,runningtime);
	        Thread.sleep(1000);
	        videoplayer.PlayerPauseandPlayButton.click();
	        Thread.sleep(3000);
	        String runningdurationafterplay=videoplayer.CurrentDuration.getText();
	        assertNotEquals(runningdurationafterplay,runningtime); 
	    }
	   @And("^Forward video after (.+) and Backward video after (.+)$")
	    public void forward_video_after_and_backward_video_after(String forwardduration, String backwordduration) throws Throwable {
		   String durationafterward=videoplayer.forwardm(forwardduration);
		   assertNotEquals(forwardduration,durationafterward);
		   videoplayer.PlayerPauseandPlayButton.click();
		   String durationafterbackward=videoplayer.forwardm(backwordduration);
		   assertNotEquals(durationafterbackward,backwordduration);
		   
	        
	        
	    }

	  
	

}
