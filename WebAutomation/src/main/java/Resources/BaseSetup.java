package Resources;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pageobjects.frontend.SignUp;
import Pageobjects.frontend.homepage;



public class BaseSetup 
{
	
	public static WebDriver driver;
	SignUp si=new SignUp();
	homepage home=new homepage();
	public static WebDriver intiliazedriver() throws IOException
	{
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Baseproperties.properties");
    prop.load(fis);
    String browsername=prop.getProperty("browser");
    String url=prop.getProperty("baseurl");
    if(browsername.contains("chrome"))
    {
    	try{			
    	    
    	    File file = new File("Cookies.data");							
    	    FileReader fileReader = new FileReader(file);							
    	    BufferedReader Buffreader = new BufferedReader(fileReader);							
    	    String strline;			
    	    while((strline=Buffreader.readLine())!=null){									
    	    StringTokenizer token = new StringTokenizer(strline,";");									
    	    while(token.hasMoreTokens()){					
    	    String name = token.nextToken();					
    	    String value = token.nextToken();					
    	    String domain = token.nextToken();					
    	    String path = token.nextToken();					
    	    Date expiry = null;					
    	    		
    	    /*String val;			
    	    if(!(val=token.nextToken()).equals("null"))
    		{		
    	    	expiry = new Date(val);					
    	    }		*/
    	    Boolean isSecure = new Boolean(token.nextToken()).								
    	    booleanValue();		
    	    Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);			
    	    System.out.println(ck);
    	    driver.manage().addCookie(ck); // This will add the stored cookie to your current session					
    	    }		
    	    }		
    	    }catch(Exception ex){					
    	    ex.printStackTrace();			
    	    }
    	/*System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe");
    	ChromeOptions options=new ChromeOptions();
    	HashMap<String, Object> images=new HashMap<String, Object>();
    	images.put("profile.managed_default_content_settings.images", 2); 
    	options.setExperimentalOption("prefs", images);
    	driver=new ChromeDriver(options);*/
    	        
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
	public static void login() throws InterruptedException
	{
		
		WebDriver driver;	
        System.setProperty("webdriver.chrome.driver","G:///chromedriver.exe");					
		driver=new ChromeDriver();        
		driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");

       				
        // Input Email id and Password If you are already Register		
		SignUp.HomePageSignInButton.click();
		SignUp.GmailLogin("sameer.g@contus.in", "Ayesha@1996");		
		homepage.CookieClose.click();
        		
        // create file named Cookies to store Login Information		
        File file = new File("Cookies.data");							
        try		
        {	  
            // Delete old file if exists
			file.delete();		
            file.createNewFile();			
            FileWriter fileWrite = new FileWriter(file);							
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
            // loop for getting the cookie information 		
            	
            // loop for getting the cookie information 		
            for(Cookie ck : driver.manage().getCookies())							
            {			
                Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									
                Bwrite.newLine();             
            }			
            Bwrite.close();			
            fileWrite.close();	
            
        }
        catch(Exception ex)					
        {		
            ex.printStackTrace();			
        }		
    }	
	

}

		
