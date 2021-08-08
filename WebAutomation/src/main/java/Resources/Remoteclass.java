package Resources;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Remoteclass {
	
	public static void remote() throws MalformedURLException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
		
		
		WebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.13:8181/wd/hub"),dc);
		driver.manage().window().maximize();
		driver.get("https://qa.gudsho.com");
	}
	
	
	
	

}
