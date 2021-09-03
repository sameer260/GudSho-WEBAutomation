package Pageobjects.frontend;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.BaseSetup;
import steps.frontend.shodetailpagesteps;

public class paymentpage extends BaseSetup {
	public static Logger log = Logger.getLogger(paymentpage.class.getName());
	public paymentpage()
	{
		 PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//div[@class='continue-btn coins-temp-plan']/button")
	public static WebElement PopupContinueButton;
	
	@FindBy(xpath="//div[@class='mat-tab-labels']/div")
	public static List<WebElement> PaymentMethods;
	
	@FindBy(xpath="//div[@class='paytm-wrap']/div/button")
	public static WebElement PaymentviaPaytm;
	
	@FindBy(xpath="//div[@class='payment-type-methods white']/section[1]")
	public static WebElement PayTMDebitCardPayment;
	
	@FindBy(xpath="//div[@class='pos-r']/input")
	public static WebElement PayTmCardField;
	
	@FindBy(id="mm")
	public static WebElement PayTmCardExpiryMonth;
	
	@FindBy(id="yy")
	public static WebElement PayTmCardExpiryYear;
	
	@FindBy(xpath="//input[@type='password']")
	public static WebElement PayTmCVVno;
	
	@FindBy(xpath="//body/div[@id='app']/main[1]/div[3]/div[4]/section[1]/section[1]/div[2]/section[1]/section[1]/div[1]/div[4]/section[1]/button[1]")
	public static WebElement PayButtonInPayTM;
	
	@FindBy(xpath="//div[@class='btn-grp']/button")
	public static List<WebElement> ChoosePaymentScenario;
	
	@FindBy(id="card-number")
	public static WebElement RazoarPayCardno;
	
	@FindBy(id="expires_at")
	public static WebElement RazoarPayCardnoExpiryDate;
	
	@FindBy(id="key_no")
	public static WebElement RazoarPayCardnoCVV;
	
	@FindBy(id="name")
	public static WebElement RazoarPayCardnoName;
	
	@FindBy(xpath="//div[@class='cards-info ng-star-inserted']/app-card-payments/form/button[1]")
	public static WebElement RazoarPayButton;
	
	@FindBy(id="virtualaddress")
	public static WebElement UPIField;
	
	@FindBy(xpath="//div[@class='cards-info ng-star-inserted']/app-upi-mode/form/button[1]")
	public static WebElement UPIPayButton;
	
	@FindBy(xpath="//button[text()='Success']")
	public static WebElement RazorPaySuccessButton;
	
	@FindBy(css=".danger")
	public static WebElement RazorPayFailureButton;
	
	
	//Razor Pay Standard Check out
	
	@FindBy(xpath="//div[@class='methods-block']/div/button")
	public static List<WebElement> RazorPayPaymentModes; 
	
	@FindBy(id="card_number")
	public static WebElement CardNum;
	
	@FindBy(id="card_expiry")
	public static WebElement ExpiryField;
	
	@FindBy(id="card_name")
	public static WebElement CardHolderName;
	
	@FindBy(id="card_cvv")
	public static WebElement CVVNo;
	
	@FindBy(id="should-save-card")
	public static WebElement RememberCheckbox;
	
	@FindBy(id="footer")
	public static WebElement PayButton;
	
	@FindBy(id="vpa-upi")
	public static WebElement UPIIdField;
	
	@FindBy(xpath="//div[@id='netb-banks']/div")
	public static WebElement SBIBankNetBanking;
	
	@FindBy(xpath="//iframe[@class='razorpay-checkout-frame']")
	public static WebElement RozarPayFrame;
	
	@FindBy(id="otp-sec")
	public static WebElement SkipOTP;
	
	@FindBy(id="header")
	public static WebElement RazorPayHeader;
	
	@FindBy(id="modal-close")
	public static WebElement RozarPaypopupclose;
	
	@FindBy(xpath="//button[@type='button']")
	public static WebElement TryAgainButton;
	
	@FindBy(xpath="//a[@class='back-link']")
	public static WebElement BackToShoPageLink;
	
	@FindBy(xpath="//div[@class='title-section']")
	public static WebElement ImageSection;
	
	
	public static void PaymentviaCard()
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(paymentpage.CardNum));
		CardNum.sendKeys("4111111111111111");
		ExpiryField.sendKeys("1025");
		CardHolderName.clear();
		CardHolderName.sendKeys("sameer");
		CVVNo.sendKeys("123");
		RememberCheckbox.click();
		PayButton.click();
	}
	
	
	
	
	public static void SelectPaymentMode(String PaymentMode) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(RazorPayHeader));
		
		
			
		if(PaymentMode.equalsIgnoreCase("Card"))
		{
			RazorPayPaymentModes.get(0).click();
			Thread.sleep(1000);
			try{
				PaymentviaCard();
			}
			catch(Exception e)
			{
				SkipOTP.click();
				Thread.sleep(1000);
				PaymentviaCard();
			}
        }
		else if(PaymentMode.equalsIgnoreCase("UPI"))
		{
			RazorPayPaymentModes.get(1).click();
			Thread.sleep(1000);
			UPIIdField.sendKeys("sameer239@ybl");
			PayButton.click();
			Thread.sleep(5000);
			
		}
		else if(PaymentMode.equalsIgnoreCase("Net Banking"))
		{
			RazorPayPaymentModes.get(2).click();
			Thread.sleep(1000);
			SBIBankNetBanking.click();
			PayButton.click();
			Thread.sleep(3000);
		}
	}
	
	
	
	public static void switchframe(String paymentscenario,String PaymentMode) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
	    driver.switchTo().frame(RozarPayFrame);
		SelectPaymentMode(PaymentMode);
		driver.switchTo().defaultContent();
		if(PaymentMode.equalsIgnoreCase("UPI"))
		{
			Thread.sleep(5000);
		}
		else {
		
		if(paymentscenario.equalsIgnoreCase("Success"))
		{
			wait.until(ExpectedConditions.visibilityOf(RazorPaySuccessButton));
			RazorPaySuccessButton.click();
		}
		else if(paymentscenario.equalsIgnoreCase("Failed"))
		{
			wait.until(ExpectedConditions.visibilityOf(RazorPayFailureButton));
			RazorPayFailureButton.click();
		}
	  }
	}
	
	@FindBy(xpath="//mat-dialog-container[@role='dialog']")
	public static WebElement PaymentFailurePopup;
	
	@FindBy(xpath="//div[@class='transaction-id flex justify-content-center flex-column align-items-center']/h4")
	public static WebElement TransactionFailedTextonPopup;
	
	@FindBy(xpath="//div[@class='transaction-id flex justify-content-center flex-column align-items-center']/p")
	public static WebElement TransactionId;
	
	@FindBy(xpath="//div[@class='payment-footer']/div/button")
	public static WebElement CancelButtonOnFailurePopup;
	
	
	
	public static String paymentStatus(String paymentscenario,String shoname)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		Actions a=new Actions(driver);
		String transactionid=null;
		
		if(paymentscenario.equalsIgnoreCase("Success"))
		{
			a.moveToElement(videoplayer.HoverOnPlayer).build().perform();
	        wait.until(ExpectedConditions.visibilityOf(videoplayer.ShoNameOnPlayer));
	        String ShonameonPlayer=videoplayer.ShoNameOnPlayer.getText();
	        assertTrue(ShonameonPlayer.equalsIgnoreCase(shoname));
	        videoplayer.CloseButtonforSho.click();
	        wait.until(ExpectedConditions.visibilityOf(videoplayer.RateCloseButton));
	        videoplayer.RateCloseButton.click();
		}
		else if(paymentscenario.equalsIgnoreCase("Failed"))
		{
			wait.until(ExpectedConditions.visibilityOf(PaymentFailurePopup));
			assertEquals(TransactionFailedTextonPopup.getText(),"Transaction Failed");
			transactionid=TransactionId.getText();
			log.info(transactionid);
			CancelButtonOnFailurePopup.click();
		}
		return transactionid;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}	



















































	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


