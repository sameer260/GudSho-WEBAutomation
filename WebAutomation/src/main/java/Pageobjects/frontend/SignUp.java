package Pageobjects.frontend;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Resources.BaseSetup;




public class SignUp extends BaseSetup
{
	
	public SignUp()
	{
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath="//div[@class='user-navigation']/button")
	public static WebElement HomePageSignInButton;
	
	@FindBy(xpath="//div[starts-with(@class,'form-group trialicon ng-tns-')]")
	public static WebElement PhoneNumberSignInField;
	
	@FindBy(xpath="//div[@class='ngx-mat-tel-input-container']/input")
	public static WebElement MobileNumberTextField;
	
	@FindBy(xpath="//button[starts-with(@class,'button is-default primary login e-large width-full top-space-low bottom-space ng-tns-')]")
	public static WebElement ContinueButton;
	
	@FindBy(xpath="//div[starts-with(@class,'otp-input justify-content-between ng-tns-')]/input")
	public static List<WebElement> OTPFileds;
	
	@FindBy(xpath="//button[starts-with(@class,'button is-default primary login e-large width-full bottom-space ng-tns-')]")
	public static WebElement SignInButton;
	
	@FindBy(xpath="//div[@class='form-submit']/button")
	public static WebElement RequestOTPButton;
	
	@FindBy(xpath="//div[@class='login-via-otp']/button")
	public static WebElement LoginPageSignInButton;
	
	@FindBy(xpath="//span[@class='otp']")
	public static WebElement ForgotPasswordLink;
	
	@FindBy(xpath="//div[@class='user-page-logo']")
	public static WebElement LoginPageGudShoLogo;
	
	@FindBy(xpath="//div[@class='form-container sign-in']/p")
	public static WebElement DescriptionText;
	
	@FindBy(xpath="//a[@class='sign-up']")
	public static WebElement SignInLink;
	
	@FindBy(xpath="//div[@class='ngx-mat-tel-input-container']/input")
	public static WebElement SignUpPhoneNumberField;
	
	@FindBy(xpath="//button[@type='submit']")
	public static WebElement SignUpOTPButton;
	
	//@FindBy(xpath="//div[@class='otp-input']/input")
	//public static List<WebElement> OTPFields;
	
	@FindBy(xpath="//div[@class='back-arrow']/a")
	public static WebElement BackCursorButton;
	
	
	//New Signin Design
	
	@FindBy(xpath="//div[starts-with(@class,'login-inner sign-up-choose ng-tns-')]")
	public static WebElement SignInPoup;
	
	@FindBy(xpath="//h3[text()='Hello there!']")
	public static WebElement HelloThereText;
	
	
	//Gmail
	@FindBy(xpath="//div[starts-with(@class,'login-inner sign-up-choose ng-tns-')]/button[1]")
	public static WebElement LoginWithGoogleButton;
	
	@FindBy(id="identifierId")
	public static WebElement GmailUserName;
	
	@FindBy(xpath="//span[text()='Next']")
	public static WebElement GmailNextButton;
	
	@FindBy(xpath="//input[@aria-label='Enter your password']")
	public static WebElement GmailPasswordField;
	
	
	public static void GmailLogin(String UserName,String Password) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		LoginWithGoogleButton.click();
	    Thread.sleep(5000);
		String MainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if(!MainWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
			    wait.until(ExpectedConditions.visibilityOf(GmailUserName));
				GmailUserName.sendKeys(UserName);
				GmailNextButton.click();
				wait.until(ExpectedConditions.visibilityOf(GmailPasswordField));
				GmailPasswordField.sendKeys(Password);
				GmailNextButton.click();
				Thread.sleep(500);
			}
		}
		driver.switchTo().window(MainWindow);
	}
	
	
	
}
