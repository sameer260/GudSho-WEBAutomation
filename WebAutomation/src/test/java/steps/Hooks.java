package steps;



import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pageobjects.frontend.SignUp;
import Pageobjects.frontend.ToastandErrormessages;
import Pageobjects.frontend.homepage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import Resources.BaseSetup;
import Resources.Remoteclass;


public class Hooks extends BaseSetup {
	 
	/*@Before("@Remote")
	public void abcd() throws InterruptedException, IOException
	{
		Remoteclass.remote();

		
	}	*/
	
	@Before(order=0)
	public void launchdriverandapplication() throws InterruptedException, IOException
	{
		
		BaseSetup.intiliazedriver();
		//BaseSetup.remote();

		
	}	
	@Before(order=1)
	public void Closecookie() throws InterruptedException, IOException
	{
		homepage home=new homepage();
		homepage.CookieClose.click();
		
	}	
	@Before("not @Paywall")
	public void loginapplication() throws InterruptedException, IOException
	{
			
		System.out.println("This Before Hook for not applicable to Paywall,Signup and Login features");
		SignUp sl=new SignUp();
		ToastandErrormessages ts=new ToastandErrormessages();
		SignUp.HomePageSignInButton.click();
		SignUp.GmailLogin("sameer.g@contus.in", "Ayesha@1996");
		WebDriverWait wait=new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		ToastandErrormessages.ToastMessageClose.click();
		
		
		
	}
	@After()
	public void teardown(Scenario scenario)
	{
		if(scenario.isFailed())
		{

		  byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	       scenario.attach(screenshot, "image/png", "image");
	       
		}
		driver.quit();
	}

}
