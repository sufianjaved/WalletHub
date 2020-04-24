package utils.selenium;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeleniumFactory extends EnvironmentSetup {
	
	Logger logger = LogManager.getLogger("common");
	public JavascriptExecutor js = (JavascriptExecutor) driver;
	public Actions actions;
	
	public SeleniumFactory(){
		super();
	}
	
	public WebElement getElement(By selector) {
        try {
            return driver.findElement(selector);
        } catch (Exception e) {
        	logger.error(String.format("Element %s does not exist - proceeding", selector));
        	return null;
        }
    }
	
	public WebElement waitForElement(By selector){
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
	}
	
	public WebElement waitForElement(WebElement element){
	    return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public boolean elementExists(By locator){
	    return elementExists(getElement(locator));
	}
	
	public boolean elementExists(WebElement element){
		boolean isElementExists = false;
	    try {
	    	if(element.isEnabled() && ExpectedConditions.elementToBeClickable(element)!=null)
	    		isElementExists = true;
		} catch (Exception e) {
		}
		return isElementExists;
	}
	
	public void click(WebElement element){
		waitForElement(element);
		element.click();
	}
	
	public void click(By selector){
		waitForElement(selector);
		click(getElement(selector));
	}
	
	public void sendKeys(By selector, CharSequence... keysToSend) throws Exception {
		waitForElement(selector);
        WebElement element = getElement(selector);
        try {
        	sendKeys(element,keysToSend);
        } catch (Exception e) {
        	logger.error(String.format("Error in sending [%s] to the following element: [%s]", keysToSend, element.toString()));
        }
    }
	
	public void sendKeys(WebElement element, CharSequence... keysToSend) throws Exception {
		waitForElement(element);
        try {
            element.sendKeys(keysToSend);
        } catch (Exception e) {
        	logger.error(String.format("Error in sending [%s] to the following element: [%s]", keysToSend, element.toString()));
        }
    }
	
	public void clearField(By selector) {
		waitForElement(selector);
		WebElement element = getElement(selector);
        try {
        	clearField(element);
        } catch (Exception e) {
        	logger.error(String.format("The following element could not be cleared: [%s]", element.getText()));
        }
    }
	
	public void clearField(WebElement element) {
        try {
        	waitForElement(element);
            element.clear();
        } catch (Exception e) {
        	logger.error(String.format("The following element could not be cleared: [%s]", element.getText()));
        }
    }
	
	public boolean validateHoverOntoStars(List<WebElement> startsList) {
        actions = new Actions(driver);
		for(int i=1 ; i<=4; i++) {
			js.executeScript("arguments[0].scrollIntoView(true);", startsList.get(i));
			actions.moveToElement(startsList.get(i)).perform();
			if(i==4)
				return true;
		}
		return false;
    }
	
}
