package pageObject.Guru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Guru.CommonPageUI;
import pageUIs.Guru.NewAccountUI;

public class NewAccountPageObject extends BasePage{
	WebDriver driver;

	public NewAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTextTitle() {
		waitForElementVisible(driver, CommonPageUI.TITLE_TEXT);
		return getElementText(driver, CommonPageUI.TITLE_TEXT);
	}

	public boolean isDisplaysTextLabelSpace(String name) {
		waitForElementVisible(driver, NewAccountUI.ACCOUNT_TYPE_LABEL, name);
		return isElementDisplayed(driver, NewAccountUI.ACCOUNT_TYPE_LABEL, name);
	}

	public void inputToDynamicTextbox(WebDriver driver, String fielName, String inputValue) {
		waitForElementVisible(driver, CommonPageUI.DYNAMIC_TEXTBOX, fielName);
		sendkeyToElement(driver, CommonPageUI.DYNAMIC_TEXTBOX, inputValue, fielName);
	}
//	public void inputTextboxInitial() {
//		driver.findElement(By.xpath(NewAccountUI.INITIAL_DEPOSIT_INPUT)).sendKeys("499");
//	}

	public String getTextMessage(String name) {
		waitForElementVisible(driver, CommonPageUI.DYNAMIC_MESSAGE, name);
		return getElementText(driver, CommonPageUI.DYNAMIC_MESSAGE, name);
	}
	public void clickButtonTabInput(WebDriver driver, String fieldName) {
		waitForElementVisible(driver, CommonPageUI.DYNAMIC_TEXTBOX, fieldName);
		clickButtonTab(driver, CommonPageUI.DYNAMIC_TEXTBOX, fieldName);
	}

	public void clickToButton(WebDriver driver,String nameButton) {
		waitForElementClickable(driver, CommonPageUI.DYNAMIC_BUTTON, nameButton);
		clickToElement(driver, CommonPageUI.DYNAMIC_BUTTON, nameButton);
	}

	public String getTextAlert() {
		return getAlertText(driver);
	}

	public void clearValueField(String nameField) {
		waitForElementVisible(driver,CommonPageUI.DYNAMIC_TEXTBOX , nameField);
		clearValueInput(driver, CommonPageUI.DYNAMIC_TEXTBOX , nameField);
	}

	public String getTextValueInput(String nameField) {
		waitForElementVisible(driver,CommonPageUI.DYNAMIC_TEXTBOX, nameField);
		return getElementText(driver, CommonPageUI.DYNAMIC_TEXTBOX, nameField);
	}

	public void clickButtonOKAlert() {
		acceptAlert(driver);	
	}

	
}
