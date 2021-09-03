package Pageobjects.frontend;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.BaseSetup;

public class accountandsettingspage extends BaseSetup
{
	public accountandsettingspage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='accout-lists menus']/ul/li[4]")
	public static WebElement SignOut;
	
	@FindBy(xpath="//span[@class='blue cursor']")
	public static WebElement NotificationSettingLink;
	
	@FindBy(xpath="//div[text()='Notifications']")
	public static WebElement NotificationsTab;
	
	@FindBy(xpath="//div[@class='notify-wrapper']")
	public static WebElement NotificationElements;
	
	@FindBy(xpath="//div[@role='tab']/div[1]")
	public static List<WebElement> AccountandSettingsTabs;
	
	@FindBy(xpath="//div[@role='tab']")
	public static List<WebElement> CheckTabSelection;
	
	public static String TabSelection(String TabName)
	{
		String ariaselectedstate=null;
		for(int i=0;i<AccountandSettingsTabs.size();i++)
		{
			if(AccountandSettingsTabs.get(i).getText().equalsIgnoreCase(TabName))
			{
				CheckTabSelection.get(i).click();
				ariaselectedstate=CheckTabSelection.get(i).getAttribute("aria-selected");
				
			}
		}
		return ariaselectedstate;
	}

    @FindBy(xpath="//div[text()='Friends']")
    public static WebElement FriendsTab;
    
    @FindBy(xpath="//div[@class='profile-details friends-page gs-sycned']/div")
    public static WebElement FriendSectionElement;
    
    @FindBy(xpath="//div[text()='My Profile']")
    public static WebElement MyProfileTab;
    
    @FindBy(xpath="//div[@class='profile-details user-details']")
    public static WebElement MyProfileElement;
    
    @FindBy(id="profile-firstname")
    public static WebElement UserName;
    
    @FindBy(id="phoneNumber")
    public static WebElement PhoneNumber;
    
    
    // Transaction History
    
    @FindBy(xpath="//div[@class='ng-scroll-content']/table/thead/tr/th")
    public static List<WebElement> TableHeaders;
    
    @FindBy(xpath="//div[@class='ng-scroll-content']/table/tbody/tr/td[1]/span[1]")
    public static List<WebElement> Dateofpurchase;
    
    @FindBy(xpath="//div[@class='ng-scroll-content']/table/tbody/tr/td[1]/span[2]")
    public static List<WebElement> TimeOfPurchase;
    
    @FindBy(xpath="//div[@class='ng-scroll-content']/table/tbody/tr/td[2]/div/span")
    public static List<WebElement> ShoNameonGrid;
    
    @FindBy(xpath="//div[@class='ng-scroll-content']/table/tbody/tr/td[3]/div")
    public static List<WebElement> ShoPrice;
    
    @FindBy(xpath="//div[@class='ng-scroll-content']/table/tbody/tr/td[4]")
    public static List<WebElement> ModeOfPayment;
    
    @FindBy(xpath="//div[@class='ng-scroll-content']/table/tbody/tr/td[5]")
    public static List<WebElement> TransactionID;
    
    @FindBy(xpath="//div[@class='ng-scroll-content']/table/tbody/tr/td[6]")
    public static List<WebElement> PaymentGatewayMode;
    
    @FindBy(xpath="//div[@class='ng-scroll-content']/table/tbody/tr/td[7]")
    public static List<WebElement> PaymentStatus;
    
	
	public static List<String> verifyPayment(String shoname) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfAllElements(TableHeaders));
		List<String> ele = new ArrayList<String>();
		for (int i = 0; i < ShoNameonGrid.size(); i++) {

			if (ShoNameonGrid.get(i).getText().equalsIgnoreCase(shoname)) {
				ele.add(Dateofpurchase.get(i).getText());
				ele.add(TimeOfPurchase.get(i).getText());
				ele.add(ShoNameonGrid.get(i).getText());
				ele.add(ShoPrice.get(i).getText());
				ele.add(ModeOfPayment.get(i).getText());
				ele.add(TransactionID.get(i).getText());
				ele.add(PaymentGatewayMode.get(i).getText());
				ele.add(PaymentStatus.get(i).getText());
				break;
			}
		}
		return ele;

	}

	// watch history
	
	@FindBy(xpath = "//div[@class='user-details ng-star-inserted']")
	public static WebElement hoverOnMyProfile;

	@FindBy(xpath = "//*[text()='My Watch History']")
	public static WebElement myWatchHistory;

	@FindBy(xpath = "//*[@class='mat-ripple history-remove cursor flex align-items-center']")
	public static List<WebElement> allDeleteButtonsWatchHistory;

	@FindBy(xpath = "//*[@class='history-list flex align-items-center ng-star-inserted']//h4")
	public static List<WebElement> allShoNames;

	@FindBy(xpath = "//*[text()='Clear All']")
	public static WebElement clearAll;

	@FindBy(xpath = "//*[@class='mat-dialog-header']")
	public static WebElement clearAllPopUpHeader;

	@FindBy(xpath = "//*[@class='mat-dialog-content']")
	public static WebElement clearAllPopUpText;

	@FindBy(xpath = "//*[@class='button is-default border-only large mat-button mat-button-base']")
	public static WebElement cancellButton;

	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement deletePermanentlyButton;

	@FindBy(xpath = "//*[starts-with(@class,'video-titles ng-tns')]//child::img")
	public static WebElement playerTitleName;

	@FindBy(xpath = "//*[@class='placeholder-title ng-star-inserted']")
	public static WebElement clearAllPlaceHolder;

	@FindBy(xpath = "//*[@class='history-date']")
	public static WebElement watchHistoryPlaydate;
	
	//Notifications
	
	@FindBy(xpath="//div[@class='notify-wrapper']/ul/li/h4")
	public static List<WebElement> NotificationTypes;
	
	@FindBy(xpath="//div[@class='notify-wrapper']/ul/li/p")
	public static List<WebElement> NotificationDescriptions;
	
	@FindBy(xpath="//div[@class='notify-wrapper']/ul/li/mat-slide-toggle")
	public static List<WebElement> ToggleButtons;
	
	@FindBy(xpath="//input[@type='checkbox']")
	public static List<WebElement> InputAttributes;
	
	// Friends
	
	@FindBy(xpath="//div[@id='mat-tab-label-0-1']")
    public static WebElement insidefriendstab;

    @FindBy(xpath="//input[@id='email']")
    public static WebElement inviteemail;
    
    @FindBy(xpath="//span[contains(text(),'Invite')]")
    public static WebElement invitebutton;
    
    @FindBy(xpath="//div[@id='mat-tab-label-0-2']")
    public static WebElement notifications;

    @FindBy(xpath="//div[@class='mat-slide-toggle-bar mat-slide-toggle-bar-no-side-margin']/input")
    public static List<WebElement> inapptoggle;
    
    @FindBy(xpath="//mat-slide-toggle[@id='mat-slide-toggle-4']")
    public static WebElement pushtoggle;
    

    @FindBy(xpath="//input[@id='profile-firstname']")
    public static WebElement profilename;
    
    @FindBy(xpath="//input[@id='dob']")
    public static WebElement dob;
      

    @FindBy(xpath="//small[contains(text(),'Please enter valid email address')]")
    public static WebElement emailvalidation;

    @FindBy(xpath="//div[text()='Privacy & Security']")
    public static WebElement privacypolicy;
    
    @FindBy(xpath="//div[@class='privacy-section']/h3")
    public static WebElement verifyprivacypolicy;
	
	
	
}
