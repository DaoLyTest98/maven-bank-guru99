package bank.guru.user;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObject.Guru.ManagerPageObject;
import pageObject.Guru.LoginPageObject;
import pageObject.Guru.RegisterPageObject;

public class RegisterAccount extends BaseTest{
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		log.info("Click on the textlink 'Here' ");
		registerPage = loginPage.clickHereLink();
	}
	@Test
	public void TC_01_Email_Blank() {
		log.info("Block adds");
		registerPage.blockAds(driver);
		log.info("Click on the button Submit");
		registerPage.clickButtonSumbit();
		log.info("Verify text error");
		Assert.assertEquals(registerPage.getTextErrorEmailBlank(), "Email ID must not be blank");
		
	}
	@Test(description = "Email address without the username before the @ symbol")
	public void TC_02_Email_Without_Username() {
		log.info("Enter the email address without the username before the @ symbol");
		registerPage.inputEmail(emailWithoutUsername);
		log.info("Click on the button Submit");
		registerPage.clickButtonSumbit();
		log.info("Verify text error");
		Assert.assertEquals(registerPage.getTextErrorEmailBlank(), "Email ID is not valid");
		
	}

	@Test(description = "Email address without the '@' symbol")
	public void TC_03_Email_Without_At_Sign() {
		log.info("Enter the email address without '@' symbol");
		registerPage.inputEmail(emailWithoutUsername);
		log.info("Click on the button Submit");
		registerPage.clickButtonSumbit();
		log.info("Verify text error");
		Assert.assertEquals(registerPage.getTextErrorEmailBlank(), "Email ID is not valid");
		
	}
	@Test(description = "Email address without the username before the @ symbol")
	public void TC_04_Email_Without_Domail() {
		log.info("Enter the email address without Domain");
		registerPage.inputEmail(emailWithoutUsername);
		log.info("Click on the button Submit");
		registerPage.clickButtonSumbit();
		log.info("Verify text error");
		Assert.assertEquals(registerPage.getTextErrorEmailBlank(), "Email ID is not valid");
		
	}
	@Test(description = "Successful account registration flow")
	public void TC_05_SignUpAccountSuccess() {
		registerPage.inputEmail(vaildEmail);
		registerPage.clickButtonSumbit();
		userID = registerPage.getUserIDText();
		password = registerPage.getPasswordText();
		registerPage.openLoginPage(GlobalConstants.BANK_GURU_URL);
		loginPage.inputUserID(userID);
		loginPage.inputPassword(password);
		homePage = loginPage.clickbuttonLogin();
		Assert.assertEquals(homePage.getTextMessageWelcome(), "Welcome To Manager's Page of Guru99 Bank");
		
	}
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
	
	private WebDriver driver;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	ManagerPageObject homePage;
	private String vaildEmail = "a@gmail.com";
	private String emailWithoutUsername = "@gmail.com";
	private String emailWithoutAtSign = "lygmail.com";
	private String emailWithoutDomain = "ly@";
	public String userID,password;
}
