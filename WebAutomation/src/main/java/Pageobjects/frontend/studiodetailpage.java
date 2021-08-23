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
	
	@FindBy(xpath="//span[@class='total-follow']")
	public static WebElement StudioFollowerCount;
	
	
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
	

}
