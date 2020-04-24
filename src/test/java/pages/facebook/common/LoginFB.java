package pages.facebook.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.ApplicationConfiguration;
import utils.selenium.SeleniumFactory;

public class LoginFB extends SeleniumFactory {
	
	@FindBy(id="email") public WebElement FBEmail_textbox;
	@FindBy(id="pass") public WebElement FBPassword_textbox;
	@FindBy(xpath="//input[contains(@value,'Log In')]") public WebElement FBLogIn_btn;
	
	public void loginFaceBook() throws Exception{
		driver.get(ApplicationConfiguration.getFBApplicationURL());
		waitForElement(FBEmail_textbox);
		clearField(FBEmail_textbox);
		sendKeys(FBEmail_textbox, ApplicationConfiguration.getFBUsername());
		clearField(FBPassword_textbox);
		sendKeys(FBPassword_textbox, ApplicationConfiguration.getFBUserPassword());
		click(FBLogIn_btn);
	}

}
