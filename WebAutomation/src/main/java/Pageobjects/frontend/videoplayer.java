package Pageobjects.frontend;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Resources.BaseSetup;


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
	
	@FindBy(xpath="//div[@class='player-clap singup-pops-player']")
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
	
	@FindBy(xpath="//div[@id='inner-video']/button[2]")
	public static WebElement CloseButtonforSho;
	
	@FindBy(xpath="//div[starts-with(@class,'player-title-detail ng-tns-')]/h2")
	public static WebElement ShoNameOnPlayer;
	
	@FindBy(xpath="//div[@id='inner-video']/div[1]/div[3]/span")
	public static WebElement PromoNameonPlayer;
	
	public static String Promoname()
	{
		String str=PromoNameonPlayer.getText();
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	
	
	































	
	
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


