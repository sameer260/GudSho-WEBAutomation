package Pageobjects.frontend;




import static org.junit.Assert.assertTrue;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Resources.BaseSetup;


public class Footer extends BaseSetup {
	
	public static Logger log = Logger.getLogger(Footer.class.getName());
	
	
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
	
	@FindBy(xpath="//span[@class='copy-rights']")
	public static WebElement CopyRightStatement;
	
	@FindBy(xpath="//h4[@class='footer-title']")
	public static List<WebElement> FooterHeaders;
	
	@FindBy(xpath="//div[@class='footer-connect footer-sec']/ul/li/a")
	public static List<WebElement> ConnectUsSocialLinks;
	
	commonlocatorsandmethods cm=new commonlocatorsandmethods();
	public static void WindowhandleforLinks(WebElement element,String ChildUrl,String Childtitle) throws InterruptedException {
		commonlocatorsandmethods.scrolldownm();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String parentWindowHandle = driver.getWindowHandle();
		executor.executeScript("arguments[0].click();", element);
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> I1 = allWindowHandles.iterator();
		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parentWindowHandle.equals(child_window)) {
				driver.switchTo().window(child_window);
				String title = driver.getTitle();
				log.info(title);
				assertTrue(title.equalsIgnoreCase(Childtitle));
				String Url = driver.getCurrentUrl();
				log.info(Url);
				assertTrue(Url.equalsIgnoreCase(ChildUrl));
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowHandle);
	}
	
	public static void WindowhandleforSocialLinks(WebElement element,String ChildUrl,String Childtitle) throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String parentWindowHandle = driver.getWindowHandle();
		executor.executeScript("arguments[0].click();", element);
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> I1 = allWindowHandles.iterator();
		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parentWindowHandle.equals(child_window)) {
				driver.switchTo().window(child_window);
				String title = driver.getTitle();
				log.info(title);
				String Url = driver.getCurrentUrl();
				log.info(Url);
				//assertTrue(Url.equalsIgnoreCase(ChildUrl));
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowHandle);
	}
	
	
	
	
	
	
}

