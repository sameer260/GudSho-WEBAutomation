package steps.frontend;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pageobjects.frontend.accountandsettingspage;
import Pageobjects.frontend.homepage;
import Resources.BaseSetup;
import io.cucumber.java.en.And;

public class AccountandSettingSteps extends BaseSetup {
	
	accountandsettingspage ac=new accountandsettingspage();
	homepage hm=new homepage();
	 @And("^Check (.+) in transactaions for (.+) and (.+)$")
	    public void check_in_transactaions_for_and(String shoname, String paymentmode, String paymentscenario) throws Throwable {
		Actions a =new Actions(driver);
    	a.moveToElement(homepage.Headderprofileicon).build().perform();
    	WebDriverWait wait=new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.visibilityOf(homepage.accountsettings));
    	homepage.accountsettings.click();
    	wait.until(ExpectedConditions.visibilityOf(accountandsettingspage.MyProfileTab));
    	accountandsettingspage.TabSelection("Transactions");
    	List<String> ele1=accountandsettingspage.verifyPayment(shoname);
    	for(int i=0;i<ele1.size();i++)
    	{
    		System.out.println(ele1.get(i));
    	}
    	
    }

}
