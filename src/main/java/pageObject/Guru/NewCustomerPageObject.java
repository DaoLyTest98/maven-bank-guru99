package pageObject.Guru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Guru.CommonPageUI;
import pageUIs.Guru.NewCustomerPageUI;

public class NewCustomerPageObject extends BasePage{
	private WebDriver driver;
	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public String getTextTitle() {
		waitForElementVisible(driver, NewCustomerPageUI.TITLE_TEXT);
		return getElementText(driver, NewCustomerPageUI.TITLE_TEXT);
	}
	public boolean isDisplaysTextLabel(String name) {
		waitForElementVisible(driver, CommonPageUI.DYNAMIC_LABEL_TEXT, name);
		return isElementDisplayed(driver, CommonPageUI.DYNAMIC_LABEL_TEXT, name);
	}
	public void inputToDynamicTextbox(WebDriver driver, String fielName, String inputValue) {
		waitForElementVisible(driver, CommonPageUI.DYNAMIC_TEXTBOX, fielName);
		if (fielName.equals("Date of Birth")) {
			removeAttributeInDOM(driver, CommonPageUI.DYNAMIC_TEXTBOX,"type");
			sleepInSecond(2);
		}
		sendkeyToElement(driver, CommonPageUI.DYNAMIC_TEXTBOX, inputValue, fielName);
	}
	public void inputToTextboxDateBirth(String inputValue) {
		waitForElementVisible(driver, CommonPageUI.DATE_OF_BIRTH_TEXTBOX);
		sendkeyToElement(driver, CommonPageUI.DATE_OF_BIRTH_TEXTBOX,inputValue);
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
	public void clickButtonTab(String fieldName) {
		waitForElementVisible(driver, CommonPageUI.DYNAMIC_TEXTBOX, fieldName);
		clickButtonTab(driver, CommonPageUI.DYNAMIC_TEXTBOX, fieldName);
	}
}
