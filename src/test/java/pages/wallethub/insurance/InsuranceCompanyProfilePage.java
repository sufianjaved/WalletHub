package pages.wallethub.insurance;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.ApplicationConfiguration;
import utils.selenium.SeleniumFactory;

public class InsuranceCompanyProfilePage extends SeleniumFactory {
	
	@FindBy(xpath="//a/span[contains(text(), 'Reviews')]") public WebElement Reviews_tab;
	@FindBy(xpath = "//*[@class='review-action ng-enter-element']//*[name()='svg']") public List<WebElement> ReviewStar_icons;
	@FindBy(xpath="//*[@class='dropdown second']") public WebElement InsuranceType_dropdown;
	@FindBy(xpath = "//*[@class='dropdown second opened']/ul/li") public List<WebElement> ListInsuranceType_listItems;
	@FindBy(xpath="//textarea[@class='textarea wrev-user-input validate']") public WebElement Review_textarea;
	@FindBy(xpath="//div[contains(text(), 'Submit')]") public WebElement Submit_btn;
	@FindBy(xpath="//div[contains(text(), 'Continue')]") public WebElement Continue_btn;
	@FindBy(xpath = "(//div[@itemprop='description'])[1]") public WebElement MyReview_text;
	
	
	static String reviewText = "";
	public void navigateToCompanyProfile() throws InterruptedException
	{
		driver.navigate().to(ApplicationConfiguration.getWHInsuranceCompanyProfileURL());
	}
	
	public void accessReviewsTab()
	{
		waitForElement(Reviews_tab);
		click(Reviews_tab);
	}
	
	public void hoverOverStars() throws Exception
	{
		Assert.assertTrue(validateHoverOntoStars(ReviewStar_icons));
	}
	
	public void selectPolicyWithFourStarRating() throws Exception
	{
		click(ReviewStar_icons.get(3));
		waitForElement(InsuranceType_dropdown);
		click(InsuranceType_dropdown);
		click(ListInsuranceType_listItems.get(1));

	}
	
	public void submitReview() throws Exception
	{
		final String alphabet = "0123456789 TEST";
	    final int N = alphabet.length();
	    Random r = new Random();
	    for (int i = 0; i < 200; i++) {
	    	reviewText = reviewText + Character.toString(alphabet.charAt(r.nextInt(N)));
	    }
		sendKeys(Review_textarea,reviewText);
		click(Submit_btn);
		waitForElement(Continue_btn);
		
		navigateToCompanyProfile();
	}
	
	public boolean isMyReviewShownOnUI()
	{
		
		if(MyReview_text.getText() == reviewText)
		{ 
			return true;
		}
		else
		return false;
		
	}
}
