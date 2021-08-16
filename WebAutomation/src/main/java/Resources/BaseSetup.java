package Resources;

import static Resources.BaseSetup.options;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BaseSetup 
{
	
	public static WebDriver driver;
	static ChromeOptions options;
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
    	 options=new ChromeOptions();
    	
    	if(browsername.contains("headless"))
    	{
    	options.addArguments("--headless");
    	options.addArguments("--window-size=1920,1080");
    	
    	
    		
    	}
    	/*HashMap<String, Object> images=new HashMap<String, Object>();
    	images.put("profile.managed_default_content_settings.images", 2); 
    	options.setExperimentalOption("prefs", images);*/
        //options.addArguments("user-data-dir=C:\\Users\\user\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
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
     
     driver.get(url);
     return driver;
	}  
	
}
