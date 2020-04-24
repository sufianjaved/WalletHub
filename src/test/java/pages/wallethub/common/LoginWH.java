package pages.wallethub.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pages.wallethub.user.UserProfilePage;
import utils.ApplicationConfiguration;
import utils.selenium.SeleniumFactory;

public class LoginWH extends SeleniumFactory {
	
	UserProfilePage userProfilePage;
	
	@FindBy(name="em") public WebElement WHEmail_textbox;
	@FindBy(name="pw") public WebElement WHPassword_textbox;
	@FindBy(xpath="//span[contains(text(), 'Login')]") public WebElement WHLogIn_btn;
	
	public void loginWalletHub() throws Exception{
		
		driver.get(ApplicationConfiguration.getWHApplicationURL());
		waitForElement(WHEmail_textbox);
		clearField(WHEmail_textbox);
		sendKeys(WHEmail_textbox,ApplicationConfiguration.getWHUsername());
		clearField(WHPassword_textbox);
		sendKeys(WHPassword_textbox,ApplicationConfiguration.getWHUserPassword());
		click(WHLogIn_btn);
		waitForElement(userProfilePage.WHEditProfile_btn);
	}

}
