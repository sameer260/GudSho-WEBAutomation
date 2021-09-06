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



	@FindBy(xpath="//div[@role='tab']/div[1]")
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




	@FindBy(xpath="//a[routerlink='/support']")
	public static WebElement supportlink;


	@FindBy(xpath="//div[@class='profile-details friends-page gs-sycned']/div")
	public static WebElement FriendSectionElement;





	@FindBy(xpath="//div[@class='profile-details user-details']")
	public static WebElement MyProfileElement;

	@FindBy(id="profile-firstname")
	public static WebElement UserName;

	@FindBy(id="phoneNumber")
	public static WebElement PhoneNumber;







	//ramya code
	
	@FindBy(xpath="//header/div[1]/div[2]/div[3]")
	public static WebElement AccountandSettingsTabs1;

	@FindBy(partialLinkText="Friends")
	public static WebElement FriendsTab;

	@FindBy(partialLinkText="Account & Settin")
	public static WebElement MyProfileTab;


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

	@FindBy(xpath="//div[@id='mat-tab-label-0-5']")
	public static WebElement privacypolicy;

	@FindBy(xpath="//h3[contains(text(),'GudSho Privacy Policy')]")
	public static WebElement verifyprivacypolicy;
	
	@FindBy(xpath="//mat-radio-group[@class='mat-radio-group ng-pristine ng-valid ng-touched']")
	public static List<WebElement> gendar;
	
	@FindBy(xpath="//span[contains(text(),'Save')]")
	public static WebElement profilesavebutton;
	
	@FindBy(xpath="//mat-radio-button[@id='mat-radio-2']")
	public static WebElement gendar1;

	@FindBy(xpath="//div[contains(text(),'Only characters allowed')]")
	public static WebElement profilenamevalidation;

	@FindBy(xpath="//div[contains(text(),'Please enter a valid date')]")
	public static WebElement profiledatevalidation;

	

//    public static int click_on_anygendar(String selectgendar) throws Throwable {
//    	for(int i=0;i<accountandsettingspage.gendar.size();i++)
//		 {
//			 if(accountandsettingspage.gendar.get(i).getText().equalsIgnoreCase(selectgendar))
//			 {
//				 accountandsettingspage.gendar.get(i).click();
//				 break;
//			 }
//		 }
//		return 0;
//		
//    }


}
