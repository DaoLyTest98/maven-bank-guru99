package pageObject.Guru;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import commons.BasePage;
import commons.BaseTest;
import commons.PageGeneratorManager;
import pageUIs.Guru.RegisterPageUI;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputEmail(String email) {
		waitForAllElementVisible(driver, RegisterPageUI.EMAIL_INPUT);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_INPUT, email);
	}

	public void clickButtonSumbit() {
		waitForElementClickable(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}
	public String getUserIDText() {
		waitForElementVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getElementText(driver, RegisterPageUI.USER_ID_TEXT);
	}
	public String getPasswordText() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXT);
		return getElementText(driver, RegisterPageUI.PASSWORD_TEXT);
	}

	public LoginPageObject openLoginPage(String loginPageUrl) {
		openPageUrl(driver, loginPageUrl);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public String getTextErrorEmailBlank() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR);
	}
}
