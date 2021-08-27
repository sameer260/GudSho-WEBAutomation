package steps.frontend;

import Pageobjects.frontend.SignUp;
import Pageobjects.frontend.homepage;
import Resources.BaseSetup;
import io.cucumber.java.en.Given;

public class AuthSigninSteps extends BaseSetup{
	
	
	SignUp sl=new SignUp();
	@Given("^Launch browser and accept cookies$")
    public void launch_browser_and_accept_cookies() throws Throwable {
		//homepage home=new homepage();
		//homepage.CookieClose.click();
		SignUp.HomePageSignInButton.click();
		SignUp.GmailLogin("sameer.g@contus.in", "Ayesha@1996");
    }

}
