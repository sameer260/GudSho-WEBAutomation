package steps.frontend;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

import Pageobjects.frontend.Footer;
import Pageobjects.frontend.ShareFeature;
import Pageobjects.frontend.ToastandErrormessages;
import Pageobjects.frontend.commonlocatorsandmethods;
import Pageobjects.frontend.homepage;
import Pageobjects.frontend.paymentpage;
import Pageobjects.frontend.shodetailpage;
import Pageobjects.frontend.studiodetailpage;
import Pageobjects.frontend.videoplayer;
import Resources.BaseSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class footersteps  extends BaseSetup{
	
	homepage home=new homepage();
	shodetailpage detailpage=new shodetailpage();
	paymentpage payment=new paymentpage();
	ToastandErrormessages toaster=new ToastandErrormessages();
	commonlocatorsandmethods cm=new commonlocatorsandmethods();
	ShareFeature share=new ShareFeature();
//	studiodetailpage studio=new studiodetailpage();
//	public static Logger log=Logger.getLogger(studiodetailpagesteps.class.getName());
	videoplayer video=new videoplayer();
	WebDriverWait wait=new WebDriverWait(driver,30);
    JavascriptExecutor executor = (JavascriptExecutor)driver;		
    Footer ft=new Footer();
	
	
	@Given("^verify gudsho logo$")
    public void verify_gudsho_logo() throws Throwable {
		commonlocatorsandmethods.scrolldownm();
		WebElement gudlogo=wait.until(ExpectedConditions.visibilityOf(Footer.gudshotext));
		executor.executeScript("arguments[0].click();", gudlogo);
		Thread.sleep(3000);
		String actualsho=Footer.gudshotext.getAttribute("alt");

//		log.info(actualsho);
		System.out.println(actualsho);
		String expectedsho="GudSho";
//		log.info(expectedsho);
		assertTrue(actualsho.equalsIgnoreCase(expectedsho));

		
		  
    }
	@Given("^verify footer paragraph text$")
    public void verify_footer_paragraph_text() throws Throwable {
		commonlocatorsandmethods.scrolldownm();
		WebElement footerpt=wait.until(ExpectedConditions.visibilityOf(Footer.footertext));
		executor.executeScript("arguments[0].click();", footerpt);
		String actualsho=Footer.footertext.getText();

		System.out.println(actualsho);

//		log.info(actualsho);
		String expectedsho="Join GudSho to watch the unlimited movies, series, and award-winning GudSho Originals. Everything you want to watch anytime, anywhere, and as much.";
//		log.info(expectedsho);
		assertTrue(actualsho.equalsIgnoreCase(expectedsho));

    }
    @Given("^click about us link and verify it should redirected to correct page$")
    public void click_about_us_link_and_verify_it_should_redirected_to_correct_page() throws Throwable {
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle -> " + parentWindowHandle);
		 WebElement clickElement=wait.until(ExpectedConditions.elementToBeClickable(Footer.aboutus));
		   	executor.executeScript("arguments[0].click();", clickElement);
		   	clickElement.click();		   	


		Set<String> allWindowHandles = driver.getWindowHandles();
		 
		//Now iterate using Iterator
	   	Iterator<String> I1= allWindowHandles.iterator();

	   	while(I1.hasNext())
	   	{

	   	String child_window=I1.next();


	   	if(!parentWindowHandle.equals(child_window))
	   	{
	   	driver.switchTo().window(child_window);

	   	System.out.println(driver.switchTo().window(child_window).getTitle());
	   	System.out.println(driver.switchTo().window(child_window).getCurrentUrl());

		driver.close();
		//switch to the parent window
		driver.switchTo().window(parentWindowHandle);
	   	}
	   	}
    }

    
	
	@Given("^click help&support link and verify it should redirected to correct page$")
    public void click_helpsupport_link_and_verify_it_should_redirected_to_correct_page() throws Throwable {
      	String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle -> " + parentWindowHandle);
		 WebElement clickElement=wait.until(ExpectedConditions.elementToBeClickable(Footer.helpsupport));
		   	executor.executeScript("arguments[0].click();", clickElement);
		   	clickElement.click();		   	

		   	Set<String> allWindowHandles = driver.getWindowHandles();
			 
		   	//Now iterate using Iterator
		   	Iterator<String> I1= allWindowHandles.iterator();

		   	while(I1.hasNext())
		   	{

		   	String child_window=I1.next();


		   	if(!parentWindowHandle.equals(child_window))
		   	{
		   	driver.switchTo().window(child_window);

		   	System.out.println(driver.switchTo().window(child_window).getTitle());
		   	System.out.println(driver.switchTo().window(child_window).getCurrentUrl());

			driver.close();
			//switch to the parent window
			driver.switchTo().window(parentWindowHandle);
		   	}
		   	}

    }


    @Given("^click Submit your film link and verify it should redirected to correct page$")
    public void click_submit_your_film_link_and_verify_it_should_redirected_to_correct_page() throws Throwable {
    	String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle -> " + parentWindowHandle);
		 WebElement clickElement=wait.until(ExpectedConditions.elementToBeClickable(Footer.submityourfilm));
		   	executor.executeScript("arguments[0].click();", clickElement);
		   	clickElement.click();		   	

		   	Set<String> allWindowHandles = driver.getWindowHandles();
			 
		  //Now iterate using Iterator
		   	Iterator<String> I1= allWindowHandles.iterator();

		   	while(I1.hasNext())
		   	{

		   	String child_window=I1.next();


		   	if(!parentWindowHandle.equals(child_window))
		   	{
		   	driver.switchTo().window(child_window);

		   	System.out.println(driver.switchTo().window(child_window).getTitle());
		   	System.out.println(driver.switchTo().window(child_window).getCurrentUrl());


			driver.close();
			//switch to the parent window
			driver.switchTo().window(parentWindowHandle);
		   	}
		   	}
			}

    
    @Given("^click blog link and verify it should redirected to correct page$")
    public void click_blog_link_and_verify_it_should_redirected_to_correct_page() throws Throwable {
    	String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle -> " + parentWindowHandle);
		 WebElement clickElement=wait.until(ExpectedConditions.elementToBeClickable(Footer.blog));
		   	executor.executeScript("arguments[0].click();", clickElement);
		   	clickElement.click();		   	

		   	Set<String> allWindowHandles = driver.getWindowHandles();
			 
		  //Now iterate using Iterator
		   	Iterator<String> I1= allWindowHandles.iterator();

		   	while(I1.hasNext())
		   	{

		   	String child_window=I1.next();


		   	if(!parentWindowHandle.equals(child_window))
		   	{
		   	driver.switchTo().window(child_window);

		   	System.out.println(driver.switchTo().window(child_window).getTitle());
		   	System.out.println(driver.switchTo().window(child_window).getCurrentUrl());

			driver.close();
			//switch to the parent window
			driver.switchTo().window(parentWindowHandle);
		   	}
		   	}

    }


    @Given("^click terms link and verify it should redirected to correct page$")
    public void click_terms_link_and_verify_it_should_redirected_to_correct_page() throws Throwable {
    	String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle -> " + parentWindowHandle);
		 WebElement clickElement=wait.until(ExpectedConditions.elementToBeClickable(Footer.terms));
		   	executor.executeScript("arguments[0].click();", clickElement);
		   	clickElement.click();		   	

		   	Set<String> allWindowHandles = driver.getWindowHandles();
			 
		  //Now iterate using Iterator
		   	Iterator<String> I1= allWindowHandles.iterator();

		   	while(I1.hasNext())
		   	{

		   	String child_window=I1.next();


		   	if(!parentWindowHandle.equals(child_window))
		   	{
		   	driver.switchTo().window(child_window);

		   	System.out.println(driver.switchTo().window(child_window).getTitle());
		   	System.out.println(driver.switchTo().window(child_window).getCurrentUrl());

			driver.close();
			//switch to the parent window
			driver.switchTo().window(parentWindowHandle);
		   	}
		   	}


    }


    @Given("^click privacy link and verify it should redirected to correct page$")
    public void click_privacy_link_and_verify_it_should_redirected_to_correct_page() throws Throwable {
    	String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle -> " + parentWindowHandle);
		 WebElement clickElement=wait.until(ExpectedConditions.elementToBeClickable(Footer.privacy));
		   	executor.executeScript("arguments[0].click();", clickElement);
		   	clickElement.click();		   	

		   	Set<String> allWindowHandles = driver.getWindowHandles();
			 
		  //Now iterate using Iterator
		   	Iterator<String> I1= allWindowHandles.iterator();

		   	while(I1.hasNext())
		   	{

		   	String child_window=I1.next();


		   	if(!parentWindowHandle.equals(child_window))
		   	{
		   	driver.switchTo().window(child_window);

		   	System.out.println(driver.switchTo().window(child_window).getTitle());
		   	System.out.println(driver.switchTo().window(child_window).getCurrentUrl());

			driver.close();
			//switch to the parent window
			driver.switchTo().window(parentWindowHandle);
		   	}
		   	}

    }

    
    @Given("^click Sell your movies & series on gudsho link and verify it should redirected to correct page$")
    public void click_sell_your_movies_series_on_gudsho_link_and_verify_it_should_redirected_to_correct_page() throws Throwable {
    	String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle -> " + parentWindowHandle);
		 WebElement clickElement=wait.until(ExpectedConditions.elementToBeClickable(Footer.sellshobutton));
		   	executor.executeScript("arguments[0].click();", clickElement);
		   	clickElement.click();		   	

		   	Set<String> allWindowHandles = driver.getWindowHandles();
			 
		  //Now iterate using Iterator
		   	Iterator<String> I1= allWindowHandles.iterator();

		   	while(I1.hasNext())
		   	{

		   	String child_window=I1.next();


		   	if(!parentWindowHandle.equals(child_window))
		   	{
		   	driver.switchTo().window(child_window);

		   	System.out.println(driver.switchTo().window(child_window).getTitle());
		   	System.out.println(driver.switchTo().window(child_window).getCurrentUrl());

			driver.close();
			//switch to the parent window
			driver.switchTo().window(parentWindowHandle);
		   	}
		   	}

    }




}
