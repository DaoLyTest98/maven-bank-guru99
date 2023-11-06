package pageObject.Guru;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Guru.CommonPageUI;
import pageUIs.Guru.NewCustomerPageUI;

public class NewCustomerPageObject extends BasePage {
	private WebDriver driver;

	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTextTitle() {
		waitForElementVisible(driver, CommonPageUI.TITLE_TEXT);
		return getElementText(driver, CommonPageUI.TITLE_TEXT);
	}

	public boolean isDisplaysTextLabel(String name) {
		waitForElementVisible(driver, CommonPageUI.DYNAMIC_LABEL_TEXT, name);
		return isElementDisplayed(driver, CommonPageUI.DYNAMIC_LABEL_TEXT, name);
	}

	public void inputToDynamicTextbox(WebDriver driver, String fielName, String inputValue) {
		waitForElementVisible(driver, CommonPageUI.DYNAMIC_TEXTBOX, fielName);
		if (fielName.equals("Date of Birth")) {
			removeAttributeInDOM(driver, CommonPageUI.DYNAMIC_TEXTBOX, "type");
			sleepInSecond(2);
		}
		sendkeyToElement(driver, CommonPageUI.DYNAMIC_TEXTBOX, inputValue, fielName);
	}

	public void inputToTextboxDateBirth(String inputValue) {
		waitForElementVisible(driver, CommonPageUI.DATE_OF_BIRTH_TEXTBOX);
		sendkeyToElement(driver, CommonPageUI.DATE_OF_BIRTH_TEXTBOX, inputValue);
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
		waitForElementVisible(driver, CommonPageUI.DYNAMIC_MESSAGE, fieldName);
		return getElementText(driver, CommonPageUI.DYNAMIC_MESSAGE, fieldName);
	}

	public String getTextAddressMessage(String fieldName) {
		waitForElementVisible(driver, CommonPageUI.ADDRESS_MESSAGE, fieldName);
		return getElementText(driver, CommonPageUI.ADDRESS_MESSAGE, fieldName);
	}

	public void clickButtonTabInput(String fieldName) {
		waitForElementVisible(driver, CommonPageUI.DYNAMIC_TEXTBOX, fieldName);
		clickButtonTab(driver, CommonPageUI.DYNAMIC_TEXTBOX, fieldName);
	}

	public void clickButtonTabTextarea(String fieldName) {
		waitForElementVisible(driver, CommonPageUI.DYNAMIC_TEXTAREA, fieldName);
		clickButtonTab(driver, CommonPageUI.DYNAMIC_TEXTAREA, fieldName);
	}

	public void clickButton(WebDriver driver, String fileName) {
		waitForElementClickable(driver, CommonPageUI.DYNAMIC_BUTTON, fileName);
		clickToElement(driver, CommonPageUI.DYNAMIC_BUTTON, fileName);
	}

	public String getTextMessageAlert() {
		return getAlertText(driver);
	}

	public boolean getTextValueInput(String fieldName) {
		if (fieldName == "Address") {
			waitForAllElementVisible(driver, CommonPageUI.DYNAMIC_TEXTAREA, fieldName);
			if (getElementText(driver, CommonPageUI.DYNAMIC_TEXTAREA, fieldName).equals("")) {
				return true;
			}
			return false;
		} else {
			waitForAllElementVisible(driver, CommonPageUI.DYNAMIC_TEXTBOX, fieldName);
			if (getElementText(driver, CommonPageUI.DYNAMIC_TEXTBOX, fieldName).equals("")) {
				return true;
			}
			return false;
		}

	}

	public String retrievesTheEnteredValues(String rowName) {
		if (rowName == "Birthdate") {
			waitForElementVisible(driver, CommonPageUI.DYNAMIC_VALUE_TEXT_NEW_CUSTOMER, rowName);
			// Đổi định dạng ngày tháng từ "dd/mm/yyyy" sang "yyyy/dd/mm"
			SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-mm-dd");
			SimpleDateFormat newFormat = new SimpleDateFormat("mm/dd/yyyy");
			try {
				// Phân tích chuổi ngày tháng từ định dạng ban đầu
				Date date = originalFormat
						.parse(getElementText(driver, CommonPageUI.DYNAMIC_VALUE_TEXT_NEW_CUSTOMER, rowName));
				// Chuyển đổi sang định dạng mới
				String formattedDate = newFormat.format(date);
				return formattedDate;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		waitForElementVisible(driver, CommonPageUI.DYNAMIC_VALUE_TEXT_NEW_CUSTOMER, rowName);
		return getElementText(driver, CommonPageUI.DYNAMIC_VALUE_TEXT_NEW_CUSTOMER, rowName);
	}
}
