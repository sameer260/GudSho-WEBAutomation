package Pageobjects.frontend;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Resources.BaseSetup;
import steps.frontend.videoplayersteps;



public class videoplayer extends BaseSetup{
	
	
	public static Logger log=Logger.getLogger(videoplayer.class.getName());
	public videoplayer()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='plyr__poster']")
	public static WebElement HoverOnPlayer;
	
	@FindBy(xpath="//div[@class='player-logo']")
	public static WebElement PlayerGudShoLogo;
	
	@FindBy(xpath="//div[@class='next-promo ng-star-inserted']/span")
	public static WebElement PromosandExtrasText;
	
	@FindBy(xpath="//div[starts-with(@class,'promo-player-details ng-tns-')]/app-player-gud/button")
	public static WebElement PlayerGudICon;
	
	@FindBy(xpath="//div[@class='sign-popup ng-star-inserted']")
	public static WebElement SignInPopup;
	
	@FindBy(xpath="//div[@class='content-wrapper']/h5")
	public static WebElement SignUpHeadText;
	
	@FindBy(xpath="//div[@class='content-wrapper']/span")
	public static WebElement SignUpDescriptionText;
	
	@FindBy(xpath="//div[@class='content-wrapper']/button[2]")
	public static WebElement PopUpSignInButton;
	
	@FindBy(xpath="//div[@class='center_right']/button")
	public static WebElement FullScreenButton;
	
	@FindBy(xpath="//div[@id='inner-video']/button")
	public static WebElement CloseButton;
	
	@FindBy(xpath="//div[@id='inner-video']/button")
	public static WebElement CloseButtonforSho;
	
	@FindBy(xpath="//div[starts-with(@class,'player-title-detail ng-tns-')]/h2")
	public static WebElement ShoNameOnPlayer;
	
	@FindBy(xpath="//div[@id='inner-video']/div[1]/div[3]/span")
	public static WebElement PromoNameonPlayer;
	
	public static String Promoname()
	{
		String str=PromoNameonPlayer.getText();
		log.info(str);
		return str.substring(17);
	}
	
	//Player Settings/Actions
	
	@FindBy(xpath="//div[@class='center_control']/button[3]")
	public static WebElement PlayerPauseandPlayButton;
	
	@FindBy(xpath="//div[@class='plyr__controls__item plyr__volume']/button")
	public static WebElement VolumeButton;
	
	@FindBy(xpath="//div[@class='plyr__controls__item plyr__volume']/input")
	public static WebElement VolumeButtonAttribute;
	
	@FindBy(xpath="//div[@class='center_right']/button")
	public static WebElement FullScreensButton;
	
	@FindBy(xpath="//div[@class='video-promo-body']/div/span")
	public static WebElement HeadingsofPromosandExtras;
	
	@FindBy(xpath="//span[@class='cursor']")
	public static WebElement HidePromos;
	
	@FindBy(xpath="//div[@class='center_left']/div[1]")
	public static WebElement getDuration;
	
	@FindBy(xpath="//div[@aria-label='Current time']")
	public static WebElement CurrentDuration;
	  
	@FindBy(xpath="//div[@class='center_control']/button[4]")
	public static WebElement playerforwardbutton;
	
	@FindBy(xpath="//div[@class='center_control']/button[2]")
	public static WebElement playerbackwordbutton;
	
	@FindBy(xpath="//div[starts-with(@class,'close add-coins-temp')]")
	public static WebElement RateCloseButton;
	
	
	   
	
	
	
	
	
	public static String playeerpause(String k) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(getDuration));
		String totoaldurationofvideo=getDuration.getText();
	    log.info("Total duration of the video: " + totoaldurationofvideo);
		Thread.sleep(1000);
		
		while(!(CurrentDuration.getText().equals(k)))
		{
			log.info(CurrentDuration.getText());	
		}
		PlayerPauseandPlayButton.click();
		 String currentdusration=CurrentDuration.getText();
		 log.info("Video paused at:" + k);
		 return currentdusration;
	}
	
	public static String forwardm(String forward) throws InterruptedException
	{
		
		while(!CurrentDuration.getText().equals(forward))
		{
			
		}
		PlayerPauseandPlayButton.click();
		playerforwardbutton.click();
		String currentdusrationafterforward=CurrentDuration.getText();
		log.info(currentdusrationafterforward);
		return currentdusrationafterforward;
	}
	
	
	
	public static String backwardm(String backward) throws InterruptedException
	{
		
		while(!CurrentDuration.getText().equals(backward))
		{
			
		}
		PlayerPauseandPlayButton.click();
		playerbackwordbutton.click();
		String currentdurationafterbackward=CurrentDuration.getText();
		log.info(currentdurationafterbackward);
		return currentdurationafterbackward;
	
	}
	/*public static String enterfullscreentooltip;
	public static String exitfullscreentooltip1;
	public static void audiomuteandadjust() throws InterruptedException
	{
		VolumeButton.click();
		Thread.sleep(2000);
		volumeattributevalueinmute=VolumeButtonAttribute.getAttribute("aria-valuetext");
		log.info(volumeattributevalueinmute);
		log.info("Audio muted");
		Thread.sleep(4000);
		Actions a=new Actions(driver);
		a.moveToElement(VolumeButton).click().build().perform();
		Thread.sleep(1000);
		volumeattributevalueinfullvolume=VolumeButtonAttribute.getAttribute("aria-valuetext");
		log.info(volumeattributevalueinfullvolume);
		log.info("Audio unmuted");
		a.moveToElement(VolumeButton).build().perform();
		a.moveToElement(driver.findElement(volumecontrol)).click().build().perform();
		Thread.sleep(1000);
		volumeafterclickingonvolumecontrol=VolumeButtonAttribute.getAttribute("aria-valuetext");
		log.info(volumeafterclickingonvolumecontrol);
		WebElement ele=driver.findElement(fullscreensbutton);
		a.moveToElement(ele).build().perform();
		Thread.sleep(2000);
		enterfullscreentooltip=driver.findElement(fullscreenbuttontooltip).getText();
		log.info(enterfullscreentooltip);
		ele.click();
		Thread.sleep(3000);
		a.moveToElement(ele).click().build().perform();
		log.info("Full screen exited");
		
	}*/
	
	
	@FindBy(xpath="//div[@class='center_left']/div[2]")
	public static WebElement RunningDuration;
	
	@FindBy(xpath="//div[@class='center_left']/div[1]")
	public static WebElement TotalDuration;
	
	@FindBy(xpath="//input[@data-plyr='seek']")
	public static WebElement SeekBar;
	
	
	public static String ForwardTillToCheckTimeLeft() throws InterruptedException
	{
		Actions a=new Actions(driver);
		
		for(int i=0;i<=5;i++)
		{
			
			playerforwardbutton.click();
			
		}
		PlayerPauseandPlayButton.click();
		String currentdurationafterbackward=CurrentDuration.getText();
		log.info(currentdurationafterbackward);
		System.out.println(currentdurationafterbackward);
		return currentdurationafterbackward;
		
	}
	

	public static int TimeLeftCal(String afterduration) throws InterruptedException
	{
		// Total Duration changing in to the Minutes and RoundOff
		
		String TotalDurationofvideo=TotalDuration.getText();
        String TotalDurationMinutesSplit=TotalDurationofvideo.substring(0,2);
        double ChangingStringtodouble=Integer.parseInt(TotalDurationMinutesSplit);
        String SecondsSepartion=TotalDurationofvideo.substring(3); 
        double Stringtodouble=Integer.parseInt(SecondsSepartion);
        double secondstominutes=Stringtodouble/60;
        double MinandSecondsadd=secondstominutes+ChangingStringtodouble;
        
        
       
        // Forward Video
        
       // String Forwardthevideo=ForwardTillToCheckTimeLeft();   
        String Forwardthevideo=SeekBarAttribute(afterduration);  
        log.info(Forwardthevideo);
        
        //Current Duration Changing in to Minutes and RoundOff
        
        String TotalDurationMinutesSplitInMinutes=Forwardthevideo.substring(0,2);
        double StringtoInteger=Integer.parseInt(TotalDurationMinutesSplitInMinutes);
        String DurationInseconds=Forwardthevideo.substring(3); 
        double secintomin=Integer.parseInt(DurationInseconds);
        double mintueconversion=secintomin/60;
        double minandsecondsadition=mintueconversion+StringtoInteger;
        double finaltime=MinandSecondsadd-minandsecondsadition;
        
        //Check the Time Left calculation
       
        double finaltimeleftround=Math.ceil(finaltime);
    	int finaltimeleftint=(int)finaltimeleftround;
		

		return finaltimeleftint;
	
	}
	
	
	public static String SeekBarAttribute(String duration) throws InterruptedException {
		
		
		Actions a =new Actions(driver);
		while (!(SeekBar.getAttribute("aria-valuetext").substring(0, 5).substring(0, 2).equals(duration.subSequence(0, 2)))) {
              playerforwardbutton.click();
              Thread.sleep(500);
              a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
		}
		PlayerPauseandPlayButton.click();
		String currentduration = CurrentDuration.getText();
		return currentduration;
	}
	
}	
	

























/*static double EntireVideoDurationInMinutesUpperLimit;
static int SecondsInInteger;
static double EntireVideoDurationInMinutes;
public static void TotalDurationInMinutes()
{
	// Get total Duration of the Video
	String TotalDurationFromPlayer=TotalDuration.getText();
	//Get only Minutes (Separation) from above total duration
	String MinutesFromDuration=TotalDurationFromPlayer.substring(0,2);
	//Convert Minutes(String) to Double
	double MinutesInDoubleFormat=Integer.parseInt(MinutesFromDuration);
	//Seconds Separation from the Total Duration
	String SecondsOnTotalDuration=TotalDurationFromPlayer.substring(3);
	//Changing Seconds In to Integer
	SecondsInInteger=Integer.parseInt(SecondsOnTotalDuration);
	//Changing Seconds In to Double
	double SecondsInDouble=Integer.parseInt(SecondsOnTotalDuration);
	//Changing SecondsIntoMinutes
	double SecondsIntoMinutes=SecondsInDouble/60;
	//Adding Minutes and Seconds(Which is converted in to Minutes)
	EntireVideoDurationInMinutes=SecondsIntoMinutes+MinutesInDoubleFormat;
	//Round Of to the Upper Limit
	EntireVideoDurationInMinutesUpperLimit=Math.ceil(EntireVideoDurationInMinutes);
	
}



public static int getCurrentDurationInMinutes() throws InterruptedException
{
	        int timeleft = 0;
	        //Current Duration of the video
	        String CurrentDuration=ForwardTillToCheckTimeLeft();
	        //Get only Minutes (Separation) from above total duration
			String MinutesFromDuration=CurrentDuration.substring(0,2);
			//Convert Minutes(String) to Double
			double MinutesInDoubleFormat=Integer.parseInt(MinutesFromDuration);
			//Seconds Separation from the Total Duration
			String SecondsOnTotalDuration=CurrentDuration.substring(3);
			//Changing Seconds In to Integer
			int SecondsInIntegerInCurrentDuration=Integer.parseInt(SecondsOnTotalDuration);
			//Changing Seconds In to Double
			double SecondsInDouble=Integer.parseInt(SecondsOnTotalDuration);
			//Changing SecondsIntoMinutes
			double SecondsIntoMinutes=SecondsInDouble/60;
			//Adding Minutes and Seconds(Which is converted in to Minutes)
			double EntireVideoDurationInMinutesInGetDuration=SecondsIntoMinutes+MinutesInDoubleFormat;
			//Round Of to the Upper Limit
			double EntireVideoDurationInMinutesUpperLimitInCurrentDuration=Math.ceil(EntireVideoDurationInMinutesInGetDuration);
			//Time Left on sho detail page should be in double
			double TimeLeftonShodetailpage=EntireVideoDurationInMinutes-EntireVideoDurationInMinutesInGetDuration;
			System.out.println(TimeLeftonShodetailpage);
			int FinalGetDuration=SecondsInInteger-5;
			if(SecondsInIntegerInCurrentDuration>=FinalGetDuration)
			{
				log.info("Watch Now Displayed");
			}
			else
			{
				double timeleftindouble=Math.ceil(TimeLeftonShodetailpage);
				timeleft=(int)timeleftindouble;
				log.info(timeleft);
				System.out.println(timeleft);
			}
			return timeleft;
}











/*while(!CurrentDuration.getText().equals(forwardtill))
{
	playerforwardbutton.click();
}
PlayerPauseandPlayButton.click();
String currentdurationafterbackward=CurrentDuration.getText();
log.info(currentdurationafterbackward);
return currentdurationafterbackward;*/







//int lastfivesecondsduration=doubletointeger-5;
//int stringtointegermin=Integer.parseInt(DurationInseconds); 
//System.out.println(Math.ceil(z));
//int doubletointeger=Integer.parseInt(SecondsSepartion);
/*if (stringtointegermin >= lastfivesecondsduration) {

log.info("Fully Watched");
System.out.println("Fully watched");
}*/


















	
	
	/*static By playerandpausetooltip=By.xpath("//div[@class='center_control']/button[3]/span");
	static By fullscreenbuttontooltip=By.xpath("//div[@class='center_right']/button/span[2]");
	static By exitfullscreentooltip=By.xpath("//div[@class='center_right']/button/span[1]");
	static By nextepisodebutton=By.xpath("//div[@class='gudsho-next-episodes']");
	static By episodepopupbutton=By.xpath("//div[@class='gudsho-seasons plyr__controls__item']");
	static By seriesnameonepisodepopup=By.xpath("//div[@class='season-popup-head']/h5");
	static By seasondropdown=By.xpath("//div[@class='season-popup-head']/mat-form-field");
	static By seasonname=By.xpath("//mat-option[@role='option']");
	static By episodepopupclose=By.xpath("//span[@class='mat-ripple close-season cursor']");
	static By episodesnames=By.xpath("//div[@class='episode-list-right']/h4");
	static By episodedesc=By.xpath("//div[@class='episode-list-right']/p");
	static By showpromosonplayer=By.xpath("//span[@class='show-promo-details cursor ng-star-inserted open-promo-details']");
	static By promonamesonrightsidepanel=By.xpath("//div[@class='promo-list-right']/h4");
	static By viewcountonpromorightside=By.xpath("//div[@class='view-count flex']");
	static By gudcountonpromorightside=By.xpath("//div[@class='clap-count flex align-items-center']/span");
	static By gudcountonplayer=By.xpath("//span[@class='guds-count ng-star-inserted']");
	static By addfeelresonplayer=By.xpath("//div[@class='player-feelers ng-star-inserted']/h3");
	static By feelerstext=By.xpath("//ul[@class='feelers-wrap']/li/span[2]");*/


