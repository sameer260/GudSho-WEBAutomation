package Pageobjects.frontend;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.BaseSetup;

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
	public static WebElement clickpromo;
	
	@FindBy(xpath="//div[@class='swiper-container swiper-container-initialized swiper-container-horizontal']/app-gud-card/div/div/div")
	public static WebElement shocard1;
	
	@FindBy(xpath="//div[@class='create-shos-series']/div/app-gud-card/div/div/div")
	public static WebElement selectshocardfromgenre;
		
	@FindBy(xpath="//ul[@class='swiper-wrapper choose-genre']/li")
	public static List<WebElement> selectgenre;
	
	@FindBy(xpath="//div[starts-with(@class,'card-footer ng-tns-')]/h4")
	public static WebElement verifypromonameonstudiopage; 

	@FindBy(xpath="//*[@class='swiper-container swiper-container-initialized swiper-container-horizontal']//following::a[1]//child::img")
	public static WebElement selectshonamefromstudiopage;
	
	@FindBy(xpath="//*[@class='genre-main ng-star-inserted']//following::a[1]//child::img")
	public static WebElement ShonameofcardsonGeners;
	
	
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
	
	
	
	

}
