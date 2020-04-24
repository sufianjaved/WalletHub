package utils;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;

import utils.common.ScreenShotOnFailure;
import utils.selenium.SeleniumFactory;

public abstract class BaseTest extends SeleniumFactory {
	
	protected String packageName = this.getClass().getPackage().getName();
	protected abstract void initializePageElements();
	
	@Rule
    public ScreenShotOnFailure failure = new ScreenShotOnFailure(packageName);
	
	@Before
	public void setUp() throws Exception
	{
		if(driver!=null)
			driver.close();
		
		initializeLocalBrowser();
		initializePageElements();
	}
	
	@AfterClass
	public static void cleanUp()
	{
		if(driver!=null)
			driver.quit();
		driver = null;
	}
}
