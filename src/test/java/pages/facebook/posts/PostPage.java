package pages.facebook.posts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.ApplicationConfiguration;
import utils.selenium.SeleniumFactory;

public class PostPage extends SeleniumFactory {
	
	@FindBy(xpath = "//span[text()='Create Post']") public	WebElement CreatePost_btn;
	@FindBy(xpath = "//div[@class='_1mf _1mj']") public WebElement Text_textarea;
	@FindBy(xpath = "//span[text()='Post']") public	WebElement SubmitPost_btn;
	@FindBy(xpath = "//a[@title='Profile']") public WebElement Profile_url;
	@FindBy(id="pagelet_timeline_profile_actions") public WebElement Timeline_caption;
	@FindBy(xpath = "//div[@data-testid='post_message']") public List<WebElement> AllPosts_list;
	
	
	static String postTextMessage = ApplicationConfiguration.getFBStatusMessage();
	public void createFBPost() throws Exception {
		waitForElement(CreatePost_btn);
		click(CreatePost_btn);
		sendKeys(Text_textarea,postTextMessage);
		click(SubmitPost_btn);
	}
	
	public boolean isPostSuccessful()
	{
		waitForElement(Profile_url);
		click(Profile_url);
		waitForElement(Timeline_caption);
		String postedText = AllPosts_list.get(0).getText();
		if(postedText == postTextMessage)
			return true;
		else
			return false;
	}
}