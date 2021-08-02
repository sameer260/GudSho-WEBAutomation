package Pageobjects.frontend;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Resources.BaseSetup;

public class commonlocatorsandmethods extends BaseSetup {
	
	public commonlocatorsandmethods()
	{
		PageFactory.initElements(driver,this);
	}
	
	//Home Page- Watch List Elements and Methods-start
	static By ShoCradShareButton=By.xpath("//div[@class='slider-content hovered']/swiper/div/app-gud-card/div/div/div[2]/div/div/div/div[2]"); 
	static By WatchListRow=By.xpath("//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider[2]/div/div[2]/swiper/div/app-gud-card");
	static By WatchListRowShoCard=By.xpath("//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider[2]/div/div[2]/swiper/div/app-gud-card/div");
	static By ShoNameonShoCard=By.xpath("//app-gud-shocial[@class='ng-star-inserted']/div/div/app-gud-slider[2]/div/div[2]//following::a[1]//child::img");
	static By ShoCardWatchListButton=By.xpath("//div[@class='slider-content hovered']/swiper/div/app-gud-card/div/div/div[2]/div/div/div/div[1]");
	
	
	public static void shocardwatchlist(String shoname) throws InterruptedException
	{
		WebElement watchlist=driver.findElement(WatchListRow);
		for(int i=0;i<watchlist.findElements(WatchListRowShoCard).size();i++)
		{
			Actions a =new Actions(driver);
			a.moveToElement(driver.findElements(WatchListRowShoCard).get(i)).build().perform();
			Thread.sleep(500);
			if(watchlist.findElement(ShoNameonShoCard).getText().equalsIgnoreCase(shoname))
			{
				watchlist.findElement(ShoCardWatchListButton).click();
				break;
			}
			
		}
	}	
		
		public static String shocardwatchlistShoName(String shoname) throws InterruptedException
		{
			String Shonameonshocard = null;
			WebElement watchlist=driver.findElement(WatchListRow);
			for(int i=0;i<watchlist.findElements(WatchListRowShoCard).size();i++)
			{
				Actions a =new Actions(driver);
				a.moveToElement(driver.findElements(WatchListRowShoCard).get(i)).build().perform();
				Thread.sleep(500);
				if(watchlist.findElement(ShoNameonShoCard).getAttribute("alt").equalsIgnoreCase(shoname))
				{
					Shonameonshocard= watchlist.findElement(ShoNameonShoCard).getAttribute("alt");
					break;
				}
				
			}
			return Shonameonshocard;
	}
	
	//Home Page-Watch List Elements and Methods -End
	
	// All see All pages Elements for so cards
		
    @FindBy(xpath="//h3[@class='see-category']")
    public static WebElement MoreLikethistext;
    
    @FindBy(xpath="//span[@class='back-icon cursor ng-star-inserted']")
    public static WebElement SeeAllPageBackButton;
    
    @FindBy(xpath="//div[@class='see-all-content ng-star-inserted']/app-gud-card/div/div/div")
    public static List<WebElement> Shocards;
    
    @FindBy(xpath="//div[@class='see-all-content ng-star-inserted']/app-gud-card//following::a[1]//child::img")
    public static List<WebElement> ShoNames;
    
    @FindBy(xpath="//div[starts-with(@class,'follow-btn ng-tns-')]/app-watch-later/div")
	public static WebElement WatchLaterbuttononShoCard;
	
	@FindBy(xpath="//div[starts-with(@class,'hover-share flex align-items-center justify-content-center ng-tns-')]")
	public static WebElement ShareButtononShoCard;
	
    
  
	
	
	
	public static void scrolldownm()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			Object lastHeight = js.executeScript("return document.body.scrollHeight");
			while (true) {
				js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);
				Object newHeight = js.executeScript("return document.body.scrollHeight");
				if (newHeight.equals(lastHeight)) {
					break;
				}
				lastHeight = newHeight;
			       }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void scrollup()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,-250)", "");
	}
	
	
}
