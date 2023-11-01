package pageObject.Guru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.Guru.LoginPageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickHereLink() {
		waitForAllElementVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public void inputUserID(String userID) {
		waitForAllElementVisible(driver, LoginPageUI.USER_ID_TEXT);
		sendkeyToElement(driver, LoginPageUI.USER_ID_TEXT, userID);
	}

	public void inputPassword(String password) {
		waitForAllElementVisible(driver, LoginPageUI.PASSWORD_TEXT);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXT, password);
		
	}

	public ManagerPageObject clickbuttonLogin() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getManagerPage(driver);
	}

	public String getLoginUserIDBlank() {
		waitForElementVisible(driver, LoginPageUI.USERID_BLANK_ERROR);
		return getElementText(driver, LoginPageUI.USERID_BLANK_ERROR);
	}

	public String getLoginPasswordBlank() {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_BLANK_ERROR);
		return getElementText(driver, LoginPageUI.PASSWORD_BLANK_ERROR);
	}

	public void deleteValueEmailField() {
		clearValueInElementPressKey(driver, LoginPageUI.USER_ID_TEXT);
	}

	public void deleteValuePasswordField() {
		clearValueInElementPressKey(driver, LoginPageUI.PASSWORD_TEXT);
		
	}

	public String getTextAlert() {
		return getAlertText(driver);
	}

	public void clickButtonOkAlert() {
		acceptAlert(driver);
	}

}
