package Pageobjects.frontend;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.BaseSetup;

public class accountandsettingspage extends BaseSetup
{
	public accountandsettingspage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Sign out']")
	public static WebElement SignOut;
	
	@FindBy(xpath="//span[@class='blue cursor']")
	public static WebElement NotificationSettingLink;
	
	@FindBy(xpath="//div[text()='Notifications']")
	public static WebElement NotificationsTab;
	
	@FindBy(xpath="//div[@class='notify-wrapper']")
	public static WebElement NotificationElements;
	
//	@FindBy(xpath="//div[@role='tab']/div[1]")
//	public static List<WebElement> AccountandSettingsTabs;
	
	@FindBy(xpath="//header/div[1]/div[2]/div[3]")
	public static List<WebElement> AccountandSettingsTabs;

	
//	@FindBy(xpath="//div[@role='tab']")
//	public static List<WebElement> CheckTabSelection;
	
	@FindBy(xpath="//app-header-menu/div[1]/div[1]")
	public static List<WebElement> CheckTabSelection;

	
	public static String TabSelection(String TabName)
	{
		String ariaselectedstate=null;
		for(int i=0;i<AccountandSettingsTabs.size();i++)
		{
			if(AccountandSettingsTabs.get(i).getText().equalsIgnoreCase(TabName))
			{
				ariaselectedstate=CheckTabSelection.get(i).getAttribute("aria-selected");
			}
		}
		return ariaselectedstate;
	}

//    @FindBy(xpath="//div[text()='Friends']")
//    public static WebElement FriendsTab;
    
 @FindBy(partialLinkText="Friends")
  public static WebElement FriendsTab;

 
 @FindBy(xpath="//a[routerlink='/support']")
 public static WebElement supportlink;

    
    @FindBy(xpath="//div[@class='profile-details friends-page gs-sycned']/div")
    public static WebElement FriendSectionElement;
    
//    @FindBy(xpath="//div[text()='My Profile']")
//   public static WebElement MyProfileTab;
    
    @FindBy(xpath="//a[routerlink='/profile']")
    public static WebElement MyProfileTab;
    
    @FindBy(xpath="//div[contains(text(),'My Watch History')]")
    public static WebElement mywatchhistory;

    @FindBy(xpath="//mat-tab-body/div[1]/app-gud-my-watch-history[1]/div[1]/div[2]/ul[1]/li[1]/span[1]")
    public static WebElement deletewatchhistory;

    @FindBy(xpath="//span[contains(text(),'Clear All')]")
    public static WebElement clearallwatchhistory;

    
    @FindBy(xpath="//div[@class='profile-details user-details']")
    public static WebElement MyProfileElement;
    
    @FindBy(id="profile-firstname")
    public static WebElement UserName;
    
    @FindBy(id="phoneNumber")
    public static WebElement PhoneNumber;
    
  
    @FindBy(xpath="//input[@id='email']")
    public static WebElement inviteemail;
    
    @FindBy(xpath="//span[contains(text(),'Invite')]")
    public static WebElement invitebutton;

	public static String invitenewemail(String emailid) {
	accountandsettingspage.inviteemail.sendKeys(emailid);
		
		
		return emailid;
		
	}

	
}
