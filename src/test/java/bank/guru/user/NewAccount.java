package bank.guru.user;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.Guru.LoginPageObject;
import pageObject.Guru.ManagerPageObject;
import pageObject.Guru.NewAccountPageObject;

public class NewAccount extends BaseTest{
	private WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		customerId = "64317";
		userID = "mngr535358";
		password = "qYsUnUg";
		initialDeposit = "5000";
		log.info("Enter the correct email");
		loginPage.inputUserID(userID);
		log.info("Enter the password");
		loginPage.inputPassword(password);
		log.info("Click on the button Login");
		managerPage = loginPage.clickbuttonLogin();
		newAccountPage = (NewAccountPageObject)managerPage.openMenuPage(driver, "New Account");
	}
	
	@Test
	public void NewAccount_01_Check_UI() {
//		log.info("Block Ads");
//		newAccountPage.blockAds(driver);
		log.info("Verify text title");
		Assert.assertEquals(newAccountPage.getTextTitle(),"Add new account form");
		log.info("Verify text label");
		Assert.assertTrue(newAccountPage.isDisplaysTextLabelSpace("Customer id"));
		Assert.assertTrue(newAccountPage.isDisplaysTextLabelSpace("Account type"));
		Assert.assertTrue(newAccountPage.isDisplaysTextLabelSpace("Initial deposit"));
	}
	@Test
	public void NewAccount_04_Customer_ID_Blank() {
		log.info("Do not enter a value in Customer id field");
		newAccountPage.inputToDynamicTextbox(driver, "Customer id", "");
		newAccountPage.clickButtonTabInput(driver, "Customer id");
	
		Assert.assertEquals(newAccountPage.getTextMessage("Customer id"), "Customer ID is required");
	}
	@Test
	public void NewAccount_05_Customer_ID_Character() {
		customerId = "abc";
		log.info("Enter Character value in Customer id");
		newAccountPage.inputToDynamicTextbox(driver, "Customer id", customerId);
		newAccountPage.clickButtonTabInput(driver, "Customer id");
	
		Assert.assertEquals(newAccountPage.getTextMessage("Customer id"), "Characters are not allowed");
	}
	
	@Test
	public void NewAccount_06_Customer_ID_Special_Character() {
		customerId = "@#$";
		log.info("Do not enter a value in Customer id field");
		newAccountPage.inputToDynamicTextbox(driver, "Customer id", customerId);
		newAccountPage.clickButtonTabInput(driver, "Customer id");
	
		Assert.assertEquals(newAccountPage.getTextMessage("Customer id"), "Special characters are not allowed");
	}
	@Test
	public void NewAccount_07_Email_Not_Exist() {
		log.info("Enter an unregistered Customer id");
		newAccountPage.inputToDynamicTextbox(driver, "Customer id", customerId);
		log.info("Enter the remaining fields correctly");
		newAccountPage.inputToDynamicTextbox(driver, "Initial deposit", initialDeposit);
		log.info("Click on the button Submit ");
		newAccountPage.clickToButton(driver,"submit");
		Assert.assertEquals(newAccountPage.getTextAlert(), "Please fill all fields");
		newAccountPage.clickButtonOKAlert();
	}
	@Test
	public void NewAccount_08_Customer_ID_First_Blank() {
		customerId = " 1234";
		log.info("Enter First character as blank space");
		newAccountPage.inputToDynamicTextbox(driver, "Customer id", customerId);
		log.info("Enter correct Initial deposit field");
		newAccountPage.inputToDynamicTextbox(driver, "Initial deposit", initialDeposit);
		Assert.assertEquals(newAccountPage.getTextMessage("Customer id"), "First character can not have space");
	}
	
	@Test
	public void NewAccount_09_Intital_Blank() {
		log.info("Enter correct value Customer id");
		newAccountPage.inputToDynamicTextbox(driver, "Customer id", customerId);
		log.info("Enter the remaining fields correctly");
		newAccountPage.inputToDynamicTextbox(driver, "Initial deposit", initialDeposit);
		log.info("Clear value in Initial deposit field");
		newAccountPage.clearValueField("Initial deposit");
		Assert.assertEquals(newAccountPage.getTextMessage("Initial deposit"), "Initial Deposit must not be blank");
	}
	@Test
	public void NewAccount_10_Intital_Blank() {
		initialDeposit = "aaaa";
		log.info("Enter correct value Customer id");
		newAccountPage.inputToDynamicTextbox(driver, "Customer id", customerId);
		log.info("Enter the remaining fields correctly");
		newAccountPage.inputToDynamicTextbox(driver, "Initial deposit", initialDeposit);
		Assert.assertEquals(newAccountPage.getTextMessage("Initial deposit"), "Characters are not allowed");
	}
	@Test
	public void NewAccount_11_Intital_Special_Character() {
		initialDeposit = "@#$$";
		log.info("Enter correct value Customer id");
		newAccountPage.inputToDynamicTextbox(driver, "Customer id", customerId);
		log.info("Enter the remaining fields correctly");
		newAccountPage.inputToDynamicTextbox(driver, "Initial deposit", initialDeposit);
		Assert.assertEquals(newAccountPage.getTextMessage("Initial deposit"), "Special characters are not allowed");
	}
	@Test
	public void NewAccount_12_Intital_Less_500() {
		log.info("Enter correct value Customer id");
		newAccountPage.inputToDynamicTextbox(driver, "Customer id", customerId);
		log.info("Enter the remaining fields correctly");
		newAccountPage.inputToDynamicTextbox(driver, "Initial deposit", "499");
		newAccountPage.clickToButton(driver,"submit");
		Assert.assertEquals(newAccountPage.getTextAlert(), "Intial deposite must be Rs. 500 or more");
	}

	@Test
	public void NewAccount_13_Intital_First_Blank() {
		initialDeposit = " 599";
		log.info("Enter correct value Customer id");
		newAccountPage.inputToDynamicTextbox(driver, "Customer id", customerId);
		log.info("Enter the remaining fields correctly");
		newAccountPage.inputToDynamicTextbox(driver, "Initial deposit", initialDeposit);
		Assert.assertEquals(newAccountPage.getTextMessage("Initial deposit"), "First character can not have space");
	}
	@Test
	public void NewAccount_14_Check_Submit_Button_Blank() {
//		log.info("Block Ads");
//		newAccountPage.blockAds(driver);
		log.info("Enter correct value Customer id");
		newAccountPage.inputToDynamicTextbox(driver, "Customer id", "");
		log.info("Enter the remaining fields correctly");
		newAccountPage.inputToDynamicTextbox(driver, "Initial deposit", "12222");
		newAccountPage.clickToButton(driver,"submit");
		Assert.assertEquals(newAccountPage.getTextAlert(), "Please fill all fields");
		newAccountPage.clickButtonOKAlert();
	}
	
	@Test
	public void NewAccount_15_Check_Submit_Button_Incorrect() {
		log.info("Enter correct value Customer id");
		newAccountPage.inputToDynamicTextbox(driver, "Customer id", " aaaaaaaaaa");
		log.info("Enter the remaining fields correctly");
		newAccountPage.inputToDynamicTextbox(driver, "Initial deposit", "09jhh");
		newAccountPage.clickToButton(driver,"submit");
		Assert.assertEquals(newAccountPage.getTextAlert(), "Please fill all fields");
		newAccountPage.clickButtonOKAlert();
	}
	@Test
	public void NewAccount_16_Check_Reset_Button() {
		log.info("Enter correct value Customer id");
		newAccountPage.inputToDynamicTextbox(driver, "Customer id", "aaaaaaaaaa");
		log.info("Enter the remaining fields correctly");
		newAccountPage.inputToDynamicTextbox(driver, "Initial deposit", "600");
		newAccountPage.clickToButton(driver,"reset");
		Assert.assertEquals(newAccountPage.getTextValueInput("Customer id"), "");
		Assert.assertEquals(newAccountPage.getTextValueInput("Initial deposit"), "");
	}
	
	
	
	LoginPageObject loginPage;
	NewAccountPageObject newAccountPage;
	ManagerPageObject managerPage;
	public String customerId,initialDeposit; 
	public String userID,password; 
}
