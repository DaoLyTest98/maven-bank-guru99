package pageObject.Guru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.Guru.CommonPageUI;
import pageUIs.Guru.ManagerPageUI;

public class ManagerPageObject extends BasePage{
	WebDriver driver;
	
	public ManagerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getTextMessageWelcome() {
		waitForAllElementVisible(driver, ManagerPageUI.WELCOME_MESSAGE_TEXT);
		return getElementText(driver, ManagerPageUI.WELCOME_MESSAGE_TEXT);
	}

	
}
