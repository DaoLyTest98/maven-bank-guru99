package bank.guru.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.Guru.ManagerPageObject;
import pageObject.Guru.LoginPageObject;
import pageObject.Guru.RegisterPageObject;

public class LoginUser extends BaseTest{

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		userID = "mngr535358";
		password = "qYsUnUg";
		invalidUserID = "mngr53535";
		inValidPassword = "123456";
		
	}
	@Test
	public void TC_01_UserID_Blank() {
		log.info("Leave the UserID field blank");
		loginPage.inputUserID(userID);
		log.info("Enter the correct password");
		loginPage.inputPassword(password);
		log.info("Clear values entered in the password field");
        loginPage.deleteValueEmailField();
		log.info("Verify error");
		Assert.assertEquals(loginPage.getLoginUserIDBlank(), "User-ID must not be blank"); 
		
	}

	@Test
	public void TC_02_Password_Blank() {
		log.info("Enter the correct email");
		loginPage.inputUserID(userID);
		log.info("Enter the password");
		loginPage.inputPassword(password);
		log.info("Delete all values entered in the password field");
		loginPage.deleteValuePasswordField();
		log.info("Verify error");
		Assert.assertEquals(loginPage.getLoginPasswordBlank(), "Password must not be blank"); 
		
	}
	@Test
	public void TC_03_UserID_Incorrect() {
		log.info("Enter the incorrect email");
		loginPage.inputUserID(invalidUserID);
		log.info("Enter the password");
		loginPage.inputPassword(password);
		log.info("Click on the button Login");
		loginPage.clickbuttonLogin();
		log.info("Verify error alert");
		Assert.assertEquals(loginPage.getTextAlert(), "User or Password is not valid"); 
		log.info("Click on the button OK");
		loginPage.clickButtonOkAlert();
	}
	@Test
	public void TC_04_Password_Incorrect() {
		log.info("Enter the correct email");
		loginPage.inputUserID(userID);
		log.info("Enter the password");
		loginPage.inputPassword(inValidPassword);
		log.info("Click on the button Login");
		loginPage.clickbuttonLogin();
		log.info("Verify error alert");
		Assert.assertEquals(loginPage.getTextAlert(), "User or Password is not valid"); 
		log.info("Click on the button OK");
		loginPage.clickButtonOkAlert();
	}
	@Test
	public void TC_05_Login_Successfully() {
		log.info("Enter the correct email");
		loginPage.inputUserID(userID);
		log.info("Enter the password");
		loginPage.inputPassword(password);
		log.info("Click on the button Login");
		managerPage = loginPage.clickbuttonLogin();
		log.info("Verify text success");
		Assert.assertEquals(managerPage.getTextMessageWelcome(), "Welcome To Manager's Page of Guru99 Bank");
	}
	
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
	private WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	ManagerPageObject managerPage;
	public String userID,password;
	public String invalidUserID,inValidPassword;
}
