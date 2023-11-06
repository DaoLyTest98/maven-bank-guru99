package commons;

import org.openqa.selenium.WebDriver;

import pageObject.Guru.CommonPageObject;
import pageObject.Guru.EditCustomerPageObject;
import pageObject.Guru.ManagerPageObject;
import pageObject.Guru.NewAccountPageObject;
import pageObject.Guru.LoginPageObject;
import pageObject.Guru.ManagerPageObject;
import pageObject.Guru.NewCustomerPageObject;
import pageObject.Guru.RegisterPageObject;

public class PageGeneratorManager {
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static ManagerPageObject getManagerPage(WebDriver driver) {
		return new ManagerPageObject(driver);
	}

	public static NewCustomerPageObject getNewCustomerPage(WebDriver driver) {
		return new NewCustomerPageObject(driver);
	}
	public static EditCustomerPageObject getEditCustomerPage(WebDriver driver) {
		return new EditCustomerPageObject(driver);
	}
	public static CommonPageObject getCommonPage(WebDriver driver) {
		return new CommonPageObject(driver);
	}
	public static NewAccountPageObject getNewAccountPage(WebDriver driver) {
		return new NewAccountPageObject(driver);
	}
	
}
