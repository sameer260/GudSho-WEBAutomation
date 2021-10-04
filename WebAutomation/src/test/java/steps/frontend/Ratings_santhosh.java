package steps.frontend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pageobjects.frontend.commonlocatorsandmethods;
import Pageobjects.frontend.paymentpage;
import Pageobjects.frontend.videoplayer;
import Resources.BaseSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Ratings_santhosh extends BaseSetup {

	@FindBy(xpath = "//*[starts-with(@class, 'rate-desc rate-desc-be-first ')]")
	public static WebElement friendsRatingSectionNoRatings;
	@FindBy(xpath = "//*[starts-with(@class,'name-title rate-desc rate-desc-be-first ng-tns')]")
	public static WebElement firstRatingElement;
	@FindBy(xpath = "//*[starts-with(@class,'sho-main add-coins-temp ng')]")
	public static WebElement ratingPopupHeader1;
	@FindBy(xpath = "//*[starts-with(@class, 'sub add-coins-temp ng')]")
	public static WebElement ratingPopupHeader2;

	@FindBy(xpath = "//*[starts-with(@class, 'sec-title ng-tns')]")
	public static WebElement ratingPopupHeader3;
	@FindBy(xpath = "//*[starts-with(@class,'button is-icon primary-gradient large coins-temp-plan mat-button mat-button-base ng')]")
	public static WebElement ratePopupButton;

	@FindBy(xpath = "//*[starts-with(@class, 'mat-menu-trigger right-box cursor flex align-items-center')]")
	public static WebElement rateShoDetailButton;

	@FindBy(xpath = "//textarea[starts-with(@id,'mat-input')]")
	public static WebElement ratingTextBox;

	@FindBy(xpath = "//*[starts-with(@class, 'watch-play-popup coins-user add-coins-temp ng-tns')]")
	public static WebElement audienceRatingPopup;

	@FindBy(xpath = "//*[starts-with(@class,'fixed-topmenu ng-tns')]//*[starts-with(@class,'left-box cursor ng-tns-')]")
	public static WebElement audienceRatingHeader;

	@FindBy(xpath = "//*[starts-with(@class, 'progressbar-container flex align-items-center justify-content-between ng-tns')]//child::div[starts-with(@class,'ratingbar-right flex align-items-center ng-tns')]")
	public static List<WebElement> audienceAllRatings;

	@FindBy(xpath = "//span[starts-with(@class, 'cursor ng-tns')]")
	public static List<WebElement> allStarRating;

	@FindBy(xpath = "//*[starts-with(@class, 'left-box cursor ng-tns')]")
	public static WebElement audienceRatingBaner;

	@FindBy(xpath = "//*[starts-with(@class, 'bg-close_watchhistory ng-tns')]")
	public static WebElement audienceRatingClosePupup;

	@FindBy(xpath = "//*[starts-with(@class, 'rated-by-text ng-tns')]")
	public static WebElement friendsRatingPopUpHyperLink;

	@FindBy(xpath = "//*[starts-with(@class,'sho-main add-coins-temp ng-')]")
	public static WebElement friendsRatingPopUpShoName;

	@FindBy(xpath = "//*[starts-with(@class,'sho-main add-coins-temp ng-')]")
	public static WebElement friendsRatingPopUpRatingValue;

	@FindBy(xpath = "//*[@class='user-rating-list']")
	public static WebElement friendsRatingPopURatedFriendsArea;

	@FindBy(xpath = "//*[starts-with(@class, 'mat-select-value-text ng')]")
	public static WebElement allRatingDropdown;

	@FindBy(xpath = "//mat-option[@role='option']")
	public static List<WebElement> allRatingDropdownOptions;

	@FindBy(xpath = "//span[starts-with(@class, 'cursor ng-tns')]")
	public static List<WebElement> allLikeButtonsOnRating;

	@FindBy(xpath = "//span[starts-with(@class,'bg-close_watchhistory ng')]")
	public static WebElement friendsRatingPopupCloseButton;

	@FindBy(xpath = "//span[starts-with(@class,'rating-status orange ng-tns-')]")
	public static WebElement starRatingsValue;

	@FindBy(xpath = "//h5")
	public static WebElement miniPopuph1;

	@FindBy(xpath = "//span[@class='normal']")
	public static WebElement miniPopuph2;

	@FindBy(xpath = "//span[@class='normal']//following::span[2]")
	public static WebElement BuyNowButton;
	@FindBy(xpath = "//*[starts-with(@class,'footer-container ng-tns')]")
	public static WebElement friendsRatingMiniSection;
	@FindBy(xpath = "//span[starts-with(@class,'rate-desc ng-tns')]")
	public static WebElement audienceRatingCount;
	@FindBy(xpath = "//*[starts-with(@class,'rate-desc cursor ng')]")
	public static WebElement audienceRatingCountpopup;
	@FindBy(xpath = "//*[starts-with(@class,'total-views ng-tns-c196-511')]")
	public static List<WebElement> popUpAllStarCounts;

	public Ratings_santhosh() {
		PageFactory.initElements(driver, this);
	}

	JavascriptExecutor jse = (JavascriptExecutor) driver;

	WebDriverWait Wait = new WebDriverWait(driver, 20);

	String audienceCount;

	@When("^Verify rating section for new sho and click$")
	public void verify_rating_section_for_new_sho_and_click() throws Throwable {
		assertTrue(friendsRatingMiniSection.isDisplayed());
		rateShoDetailButton.click();

	}

	@When("^get the audience rating count and click your rating$")
    public void get_the_audience_rating_count_and_click_your_rating() throws Throwable {
		audienceCount = audienceRatingCount.getText();
		rateShoDetailButton.click();
	}

	@Then("^Verify audience rating count increment$")
	public void verify_audience_rating_count_increment() throws Throwable {

		String string = audienceCount;
		String[] parts = string.split(" ");
		String part1 = parts[0]; // rating value
		String part2 = parts[1]; // audience
		String part3 = parts[2]; // rated
		int beforeRateCount = NumberUtils.toInt(part1);
		Thread.sleep(2000);
		String afterRated = audienceRatingCount.getText();
		String[] newparts = afterRated.split(" ");
		String newpart1 = newparts[0]; // rating value
		String newpart2 = newparts[1]; // audience
		String newpart3 = newparts[2]; // rated
		int afterRateCount = NumberUtils.toInt(newpart1);
		assertEquals(beforeRateCount, afterRateCount);
		audienceRatingBaner.click();
		String popUpRatingValue = audienceRatingCountpopup.getText();
		String[] popUpparts = popUpRatingValue.split(" ");
		String popUppart1 = popUpparts[0]; // rating value
		String popUppart2 = popUpparts[1]; // audience
		String popUppart3 = popUpparts[2]; // rated
		int popUpRating = NumberUtils.toInt(popUppart1);
		assertEquals(popUpRating, afterRateCount);
		// int eachStar1 = 0;
		for (WebElement allStar : popUpAllStarCounts) {
			String eachStar = allStar.getText();
			int eachStar1 = NumberUtils.toInt(eachStar);
			eachStar1++;
			System.out.println(eachStar1++);
			if (eachStar1++ == afterRateCount) {
				assertEquals(eachStar1, afterRateCount);
				friendsRatingPopupCloseButton.click();
				System.out.println(eachStar1);
			}
		}

	}

	@And("^Verify buy now mini popup elements and click on buy CTA$")
	public void verify_buy_now_mini_popup_elements_and_click_on_buy_cta() throws Throwable {
		miniPopuph1.getText().equalsIgnoreCase("Want to add Rating?");
		miniPopuph2.getText().equalsIgnoreCase("Buy this Title to add rating");
		BuyNowButton.click();
	}

	@Then("^buy sho (.+) with (.+)$")
	public void buy_sho_with(String paymentmode, String paymentscenario) throws Throwable {

		paymentpage.PopupContinueButton.click();
		paymentpage.switchframe(paymentscenario, paymentmode);

	}

	@Then("^From player Give rating (.+) from player and commnets (.+) and verify in detail page$")
	public void from_player_give_rating_from_player_and_commnets_and_verify_in_detail_page(String rating,
			String comment) throws Throwable {
		Thread.sleep(10000);
		Actions action = new Actions(driver);
		action.moveToElement(videoplayer.CloseButtonforSho).click().build().perform();
		commonlocatorsandmethods.giveRatingsAndCommentsFromPlayer(rating, comment);

	}

	@Then("^Click on your rating and verify all elements (.+)$")
	public void click_on_your_rating_and_verify_all_elements(String shoname) throws Throwable {
		rateShoDetailButton.click();
		Wait.until(ExpectedConditions.visibilityOf(ratePopupButton));
		assertEquals("How would you rate", ratingPopupHeader1.getText());
		assertTrue(ratingPopupHeader2.getText().equalsIgnoreCase(shoname + " ?"));
		assertEquals("Share your review" + "\n" + "(optional)", ratingPopupHeader3.getText());
		System.out.println(ratingPopupHeader3.getText());
		assertTrue(ratePopupButton.isDisplayed());

	}

	@And("^Give (.+) and (.+)$")
	public void give_and(String rating, String comments) throws Throwable {
		commonlocatorsandmethods.giveRatingsAndCommentsFromDetailPage(rating, comments);
		;
	}

	@Then("^update (.+) rating and commnet (.+)$")
	public void update_rating_and_commnet(String newrating, String newcomment) throws Throwable {
		commonlocatorsandmethods.giveRatingsAndCommentsFromDetailPage(newrating, newcomment);

	}

	@When("^verify header rating$")
	public void verify_header_rating() throws Throwable {
		commonlocatorsandmethods.scrolldownm();
		assertTrue(audienceRatingHeader.isDisplayed());
	}

	@And("^Click on header rating and verify popup$")
	public void click_on_header_rating_and_verify_popup() throws Throwable {
		audienceRatingHeader.click();
		assertTrue(audienceRatingPopup.isDisplayed());
	}

	@Then("^with out comment submit the rating (.+) and verify$")
	public void with_out_comment_submit_the_rating_and_verify(String rating) throws Throwable {
		commonlocatorsandmethods.giveRatingsAndCommentsFromDetailPage(rating, "");
	}

	@When("^verify header rating and Click on header rating and verify popup (.+)$")
	public void verify_header_rating_and_click_on_header_rating_and_verify_popup(String shoname) throws Throwable {
		friendsRatingPopUpHyperLink.click();
		// assertEquals(shoname, friendsRatingPopUpShoName.getText());
		shoname.equalsIgnoreCase(friendsRatingPopUpShoName.getText());
		assertTrue(friendsRatingPopURatedFriendsArea.isDisplayed());
		try {
			allLikeButtonsOnRating.get(0).click();

		} catch (Exception e) {
			assertTrue(friendsRatingPopUpRatingValue.isDisplayed());
		}
		assertTrue(friendsRatingPopUpRatingValue.isDisplayed());

		allRatingDropdown.click();
		for (WebElement webElement : allRatingDropdownOptions) {
			Thread.sleep(1000);
			String DropdownText = webElement.getText();
			webElement.click();
			assertEquals(DropdownText, allRatingDropdown.getText());
			allRatingDropdown.click();

		}
		Wait.until(ExpectedConditions.visibilityOf(friendsRatingPopupCloseButton));
		// friendsRatingPopupCloseButton.click();
		jse.executeScript("arguments[0].click();", friendsRatingPopupCloseButton);
	}

}
