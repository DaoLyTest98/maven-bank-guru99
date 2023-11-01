package pageObject.Guru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import freemarker.core.ReturnInstruction.Return;
import pageUIs.Guru.CommonPageUI;

public class CommonPageObject extends BasePage{
	WebDriver driver;

	public CommonPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputToDynamicTextbox(WebDriver driver, String fielName, String inputValue) {
		waitForElementVisible(driver, CommonPageUI.DYNAMIC_TEXTBOX, fielName);
		if (fielName.equals("Date of Birth")) {
			removeAttributeInDOM(driver, CommonPageUI.DYNAMIC_TEXTBOX,"type");
			sleepInSecond(1);
		}
		sendkeyToElement(driver, CommonPageUI.DYNAMIC_TEXTBOX, inputValue, fielName);
	}
	public void inputToDynamicTextArea(WebDriver driver, String fielName, String inputValue) {
		waitForElementVisible(driver, CommonPageUI.DYNAMIC_TEXTAREA, fielName);
		sendkeyToElement(driver, CommonPageUI.DYNAMIC_TEXTAREA, inputValue, fielName);
	}
	public void clickToDynamicButton(WebDriver driver, String buttonValue) {
		waitForElementClickable(driver, CommonPageUI.DYNAMIC_BUTTON, buttonValue);
		clickToElement(driver, CommonPageUI.DYNAMIC_BUTTON, buttonValue);
		
	}
	public void clickToDynamicRadioButton(WebDriver driver, String radioButtonValue) {
		waitForElementClickable(driver, CommonPageUI.DYNAMIC_RADIO_BUTTON, radioButtonValue);
		clickToElement(driver, CommonPageUI.DYNAMIC_RADIO_BUTTON, radioButtonValue);
	}
	public String getTextNewCustomerMessage(String fieldName) {
		waitForElementVisible(driver, CommonPageUI.DYNAMIC_NEW_CUSTOMER_MESSAGE, fieldName);
		return getElementText(driver, CommonPageUI.DYNAMIC_NEW_CUSTOMER_MESSAGE, fieldName);
	}
	
//	public boolean isDynamicMessageDisplayed(WebDriver driver, String messageText) {
//		waitForElementVisible(driver, CommonPageUI.DYNAMIC_NEW_CUSTOMER_MESSAGE, messageText);
//		return isElementDisplayed(driver, CommonPageUI.DYNAMIC_NEW_CUSTOMER_MESSAGE, messageText);
//	}
	
//	public String getDynamicValueByRowName(WebDriver driver, String rowName) {
//		waitForElementVisible(driver, CommonPageUI.DYNAMIC_VALUE_BY_ROW_NAME, rowName);
//		return getElementText(driver, CommonPageUI.DYNAMIC_VALUE_BY_ROW_NAME, rowName);
//	}
	
	
	
}
