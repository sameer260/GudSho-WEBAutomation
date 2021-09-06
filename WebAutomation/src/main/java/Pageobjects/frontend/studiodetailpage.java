package Pageobjects.frontend;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.BaseSetup;
import groovy.util.logging.Log;

public class studiodetailpage extends BaseSetup {
	
	public studiodetailpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='studiodetail-left']/h1") 
	public static WebElement StudioNameInStudioPage;
	
	@FindBy(xpath="//li[@class='follow']//app-follow-studios/button") 
	public static WebElement FollowButton;
	
	@FindBy(xpath="//li[@class='share flex align-items-center justify-content-center cursor']")
	public static WebElement StudioShareButton;
	
	@FindBy(xpath="//div[@class='swiper-slide ng-star-inserted swiper-slide-active']/div/div")
	public static WebElement StudioBanner;
	
	@FindBy(xpath="//div[@class='swiper-slide ng-star-inserted swiper-slide-active']/div/div/img")
	public static WebElement ShoNameonStudioBanner;
	
	@FindBy(xpath="//div[@class='slider-content banner-slider-content ng-star-inserted']/swiper/div/div[1]")
	public static WebElement NextSliderButton;
	
	@FindBy(xpath="//div[@class='swiper-slide ng-star-inserted swiper-slide-active']/div/div/div/button")
	public static WebElement PlayTrailerButton;
	
	@FindBy(xpath="//app-gud-slider[@class='home-slider promo flicks-promos ng-star-inserted']/div/div[2]/swiper/div/app-gud-card/div/div/div[1]")
	public static List<WebElement> clickpromo;
	
	@FindBy(xpath="//div[starts-with(@class,'card-main vertical-card ng-tns-')]")
	public static List<WebElement> shocard;
	
	@FindBy(xpath="//div[@class='create-shos-series']/div/app-gud-card/div/div/div")
	public static WebElement selectshocardfromgenre;
		
	@FindBy(xpath="//ul[@class='swiper-wrapper choose-genre']/li")
	public static List<WebElement> selectgenre;
	
	@FindBy(xpath="//div[starts-with(@class,'card-footer ng-tns-')]/h4")
	public static List<WebElement> verifypromonameonstudiopage; 

	@FindBy(xpath="//*[@class='swiper-container swiper-container-initialized swiper-container-horizontal']//following::a[1]//child::img")
	public static List<WebElement> selectshonamefromstudiopage;
	
	@FindBy(xpath="//a[starts-with(@class,'ng-tns-')]/app-gud-image/div/div/img")
	public static List<WebElement> ShoNameattribtute;
	
	@FindBy(xpath="//div[@class='home-slider promo flicks-promos ng-star-inserted']/app-gud-card")
	public static WebElement SeeALLpromoelem;
	
	
	/*public static String BannerImageClick(String shoname) throws InterruptedException
	{
		 Actions a =new Actions(driver);
		 while(!(studiodetailpage.ShoNamesOnStudioBanner.getText().equalsIgnoreCase(shoname)))
		  {
			  a.moveToElement(studiodetailpage.NextSliderButton).click().build().perform();  
		  }
		 Thread.sleep(1000); 
		 PlayTrailerButton.click();
		return shoname;
		 
		 
	}*/
	
	@FindBy(xpath="//div[@class='cdk-overlay-pane delete-popup']")
	public static WebElement UnfollowPopup;
	
	@FindBy(xpath="//div[@class='clearfix']")
	public static WebElement ConfirmationHeading;
	
	@FindBy(xpath="//div[@class='clearfix']/mat-dialog-content")
	public static WebElement ConfirmationTextPopup;
	
	@FindBy(xpath="//mat-dialog-actions[@class='mat-dialog-actions ng-star-inserted']/button[1]")
	public static WebElement PopUpNoButton;
	
	@FindBy(xpath="//mat-dialog-actions[@class='mat-dialog-actions ng-star-inserted']/button[2]")
	public static WebElement PopUpYesButton;
	
	@FindBy(xpath="//p[@class='description text-control-five mobile-content']")
	public static WebElement StudioDescriptionText;
	
	@FindBy(xpath="//div[@class='swiper-slide lasts desk ng-star-inserted']")
	public static WebElement WatchfreeButton;
	
	@FindBy(xpath="//div[@class='genre-main ng-star-inserted']/app-gud-card/div/div/div")
	public static List<WebElement> WatchFreeShoCards;
	
	@FindBy(xpath="//div[@class='text-center no-datafound ng-star-inserted']/h3")
	public static WebElement NoshoGenereText;
	
	@FindBy(xpath="//div[@class='text-center no-datafound ng-star-inserted']/button")
	public static WebElement StudioHomeButton;
	
	@FindBy(xpath="//div[@class='create-shos-series']")
	public static WebElement HomeSectionElement;
	
	@FindBy(xpath="//div[starts-with(@class,'hover-share flex align-items-center justify-content-center ng-tns-')]")
	public static WebElement PromoShareIcon;
	
	@FindBy(xpath="//div[@class='promo-card card-slider ng-star-inserted']/div[1]/h3")
	public static List<WebElement> PromoSeeAllLink;
	
	@FindBy(xpath="//div[@class='home-slider promo flicks-promos ng-star-inserted']/app-gud-card/div")
	public static List<WebElement> SeeAllPromoCards;
	
	@FindBy(xpath="//div[@class='release-card card-slider ng-star-inserted']/div[1]/h3")
	public static List<WebElement> ShoSeeAllLink;
	
	@FindBy(xpath="//span[contains(text(),'others')]")
	public static List<WebElement> followerslink;
	
	@FindBy(xpath="//h5[contains(text(),'Followers')]")
	public static WebElement verifyfollowerstext;

	@FindBy(xpath="//span[@class='studio-followers-close']")
	public static WebElement studiofollowersclose;

	
//	@FindBy(xpath="//div[@class='studio-followers-name']//h6::*")
//	public static WebElement followername;
	
	@FindBy(xpath="//body/app-root[1]/div[1]/app-gud-studios[1]/div[2]/div[1]/div[2]/ng-scrollbar[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[7]/div[2]")
	public static WebElement followername;

	@FindBy(xpath="//body/app-root[1]/div[1]/app-gud-studios[1]/div[1]/div[1]/div[3]/div[1]/div[2]/ul[1]/li[1]")
	public static WebElement reportstudio;
	
	@FindBy(xpath="//*[@role='menuitem']")
	public static WebElement reportstudiobutton;

	
	@FindBy(xpath="//body/app-root[1]/div[1]/app-gud-studios[1]/div[2]/div[1]/div[2]/mat-radio-group[1]")
	public static List<WebElement> reportstudiopopup;

	
	@FindBy(xpath="//body/app-root[1]/div[1]/app-gud-studios[1]/div[2]/div[1]/div[2]/div[1]/button[1]")
	public static WebElement reportbutton;
	
	@FindBy(xpath="//span[contains(text(),'Close')]")
	public static WebElement reportclose;

	@FindBy(xpath="//span[contains(text(),'Cancel')]")
	public static WebElement reportcancel;

	@FindBy(xpath="//span[contains(text(),'Yes')]")
	public static WebElement followyes;
	
	@FindBy(xpath="//header/div[1]/div[2]/div[3]")
	public static WebElement profile;
	
	@FindBy(xpath="//app-header-menu/div[1]/div[1]/div[1]/div[1]")
	public static WebElement profilename;



	public static String Promoclick(String promoname)
	{	
		Actions a=new Actions(driver);
		String promonameonstudiopage=null;
		for(int i=0;i<verifypromonameonstudiopage.size();i++)
		{
			if(verifypromonameonstudiopage.get(i).getText().equalsIgnoreCase(promoname))
			{
				promonameonstudiopage=verifypromonameonstudiopage.get(i).getText();
				a.moveToElement(clickpromo.get(i)).click().build().perform();
				break;
				
			}
		}
		return promonameonstudiopage;
	}
	
     public static void followers() {
	    	for(int i=0;i<studiodetailpage.followerslink.size();i++) {
	    		if(studiodetailpage.followerslink.get(i).getText() != null)
	    		{
	    			studiodetailpage.followerslink.get(i).click();
	    			String flist= studiodetailpage.followerslink.get(i).getText();
	    			System.out.println(flist);
	    			break;
	    		}

     }
     }
     public static void reportstudio() {
	    	for(int i=0;i<studiodetailpage.reportstudiopopup.size();i++)
	    	{
	    		if(studiodetailpage.reportstudiopopup.get(i).getText() != null)
	    		{
	    			studiodetailpage.reportstudiopopup.get(i).click();
	    			String reportpopup= studiodetailpage.reportstudiopopup.get(i).getText();
	    			System.out.println(reportpopup);
	    			break;
	    		}
	    	}

     }
     

}
