package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class BaseSetup 
{
	
	public static WebDriver driver;
	public static WebDriver intiliazedriver() throws IOException
	{
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Baseproperties.properties");
    prop.load(fis);
    String browsername=prop.getProperty("browser");
    String url=prop.getProperty("baseurl");
    if(browsername.contains("chrome"))
    {
    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe");
    	ChromeOptions options=new ChromeOptions();
    	
    	if(browsername.contains("headless"))
    	{
    	options.addArguments("headless");
    	options.addArguments("window-size=1080");
    	
    	
    		
    	}
    	options.addArguments("--disable-notifications");
    	driver=new ChromeDriver(options);
    	        
    }
    else if(browsername.contains("Firefox"))
    {
    	System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\BrowserDrivers\\geckodriver.exe");
    	driver=new FirefoxDriver();
    }
    else if(browsername.contains("internetexplorer"))
    {
    	System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\BrowserDrivers\\msedgedriver.exe");
    	driver=new EdgeDriver();
    }
    
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     driver.manage().deleteAllCookies();
     driver.get(url);
     return driver;
	}  
	
	public static WebDriver remote() throws MalformedURLException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		
		driver=new RemoteWebDriver(new URL("http://192.168.0.13:8181/wd/hub"),dc);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://qa.gudsho.com");
		return driver;
	}

}
