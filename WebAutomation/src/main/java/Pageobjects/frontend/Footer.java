package Pageobjects.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.BaseSetup;

public class Footer extends BaseSetup {
	
	public Footer()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//body/app-root[1]/app-gud-footer[1]/footer[1]/div[1]/div[1]/img[1]") 
	public static WebElement gudshotext;
	
	@FindBy(xpath="//p[contains(text(),'Join GudSho to watch the unlimited movies, series,')]") 
	public static WebElement footertext;
	
	@FindBy(xpath="//a[contains(text(),'About Us')]") 
	public static WebElement aboutus;
	
	@FindBy(xpath="//a[contains(text(),'Help & Support')]") 
	public static WebElement helpsupport;
	
	@FindBy(xpath="//a[contains(text(),'Submit Your Film')]") 
	public static WebElement submityourfilm;
	
	@FindBy(xpath="//a[contains(text(),'Blog')]") 
	public static WebElement blog;
	
	@FindBy(xpath="//a[contains(text(),'Terms')]") 
	public static WebElement terms;
	
	@FindBy(xpath="//a[contains(text(),'Privacy')]") 
	public static WebElement privacy;
		
	@FindBy(xpath="//span[contains(text(),'Sell Your Movies & Series on GudSho')]") 
	public static WebElement sellshobutton;
	
	@FindBy(xpath="//body/app-root[1]/app-gud-footer[1]/footer[1]/div[1]/div[4]/ul[1]/li[1]/a[1]/img[1]") 
	public static WebElement googleplay;
	
	@FindBy(xpath="//body/app-root[1]/app-gud-footer[1]/footer[1]/div[1]/div[4]/ul[1]/li[2]/a[1]/img[1]") 
	public static WebElement appstore;
	
	@FindBy(xpath="//a[@href ='https://stream.gudsho.com/about.php']") 
	public static WebElement actualabouturl;


	
	
	
	
	
	
}
