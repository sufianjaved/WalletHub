package pages.wallethub.user;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.ApplicationConfiguration;
import utils.selenium.SeleniumFactory;

public class UserProfilePage extends SeleniumFactory {
	
	@FindBy(xpath="*//button[contains(text(), 'Edit Profile')]") public WebElement WHEditProfile_btn;
	
	public void navigateToUserProfile() throws InterruptedException
	{
		String userId = ApplicationConfiguration.getWHUsername().substring(0, ApplicationConfiguration.getWHUsername().indexOf("@"));
		driver.navigate().to(ApplicationConfiguration.getWHUserProfileURL()+ userId);
		waitForElement(WHEditProfile_btn);
	}
	
	public boolean isReviewLinkPresent()
	{
		boolean URLContainsReviewAttribute = false;
		 List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		 String URLs= "";
		 for(WebElement link:allLinks){
			 URLs = URLs + link.getAttribute("href") + "\n";
		 }
		 System.out.println(URLs);
		 
		 if(URLs.contains("?review="))
		 {
			 URLContainsReviewAttribute = true;
			 return URLContainsReviewAttribute;
		 }
		 else
			 return URLContainsReviewAttribute;
	}
}
