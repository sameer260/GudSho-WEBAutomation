package steps.frontend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pageobjects.frontend.ToastandErrormessages;
import Pageobjects.frontend.homepage;
import Resources.BaseSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsAndSettings_santhosh extends BaseSetup {

	public AccountsAndSettings_santhosh() {
		PageFactory.initElements(driver, this);
	}

	// my watch history related page objects

	@FindBy(xpath = "//div[@class='user-details ng-star-inserted']")
	public static WebElement hoverOnMyProfile;

	@FindBy(xpath = "//*[text()='My Watch History']")
	public static WebElement myWatchHistory;

	@FindBy(xpath = "//*[@class='mat-ripple history-remove cursor flex align-items-center']")
	public static List<WebElement> allDeleteButtonsWatchHistory;

	@FindBy(xpath = "//*[@class='history-list flex align-items-center ng-star-inserted']//h4")
	public static List<WebElement> allShoNames;

	@FindBy(xpath = "//*[text()='Clear All']")
	public static WebElement clearAll;

	@FindBy(xpath = "//*[@class='mat-dialog-header']")
	public static WebElement clearAllPopUpHeader;

	@FindBy(xpath = "//*[@class='mat-dialog-content']")
	public static WebElement clearAllPopUpText;

	@FindBy(xpath = "//*[@class='button is-default border-only large mat-button mat-button-base']")
	public static WebElement cancellButton;

	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement deletePermanentlyButton;

	@FindBy(xpath = "//*[starts-with(@class,'video-titles ng-tns')]//child::img")
	public static WebElement playerTitleName;

	@FindBy(xpath = "//*[@class='placeholder-title ng-star-inserted']")
	public static WebElement clearAllPlaceHolder;

	@FindBy(xpath = "//*[@class='history-date']")
	public static WebElement watchHistoryPlaydate;

	WebDriverWait wait = new WebDriverWait(driver, 30);

	@Given("^navigate to my watch history$")
	public void navigate_to_my_watch_history() throws Throwable {
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOf(hoverOnMyProfile));
		actions.moveToElement(hoverOnMyProfile).build().perform();
		wait.until(ExpectedConditions.visibilityOf(homepage.accountsettings));
		homepage.accountsettings.click();
		myWatchHistory.click();
		Thread.sleep(1000);

	}

	@Then("^Verify deletion on the watch history$")
	public void verify_the_deletion_on_the_watch_history() throws Throwable {
		wait.until(ExpectedConditions.visibilityOfAllElements(allShoNames));
		String firstShoName = allShoNames.get(0).getText();
		allDeleteButtonsWatchHistory.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		assertEquals(firstShoName + " has been removed from Watch History",
				ToastandErrormessages.ToastMessageText.getText());

	}

	@Then("^Verify clear all on the watch history$")
	public void verify_clear_all_on_the_watch_history() throws Throwable {
		clearAll.click();
		wait.until(ExpectedConditions.visibilityOf(clearAllPopUpHeader));
		assertEquals("Watch History", clearAllPopUpHeader.getText());
		assertEquals("You cannot undo this action. Are you sure want to clear watch history?",
				clearAllPopUpText.getText());
		assertTrue(cancellButton.isDisplayed());
		assertTrue(deletePermanentlyButton.isDisplayed());
		deletePermanentlyButton.click();
		wait.until(ExpectedConditions.visibilityOf(ToastandErrormessages.ToastMessageText));
		assertEquals("Watch History has been cleared successfully", ToastandErrormessages.ToastMessageText.getText());
		assertEquals("Huh, its likely that you havent watched anything yet!", clearAllPlaceHolder.getText());

	}

	@Then("^Verify player redirection from watch history$")
	public void verify_player_redirection_from_watch_history() throws Throwable {
		String firstSho = allShoNames.get(0).getText();
		allShoNames.get(0).click();
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.moveToElement(playerTitleName).build().perform();
		String playerShoName = playerTitleName.getAttribute("alt");
		assertEquals(firstSho, playerShoName);

	}

	@Then("^Verify (.+) from watchh history$")
	public void verify_from_watchh_history(String shoname) throws Throwable {
		Thread.sleep(1000);
		String firstShoName = allShoNames.get(0).getText();
		assertEquals(shoname, firstShoName);
		String playDate = watchHistoryPlaydate.getText();
		SimpleDateFormat DateFormat = new SimpleDateFormat("dd MMM yyyy");
		Date dateFormat = new Date();
		String Systemdate = DateFormat.format(dateFormat);
		assertEquals(Systemdate, playDate);
	}

}
