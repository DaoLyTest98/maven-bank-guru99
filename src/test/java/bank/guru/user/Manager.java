package bank.guru.user;


import org.aspectj.lang.annotation.After;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.Guru.CommonPageObject;
import pageObject.Guru.LoginPageObject;
import pageObject.Guru.ManagerPageObject;
import pageObject.Guru.NewCustomerPageObject;

public class Manager extends BaseTest{
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		loginPage = PageGeneratorManager.getLoginPage(driver);
		userID = "mngr535358";
		password = "qYsUnUg";
		log.info("Enter the correct email");
		loginPage.inputUserID(userID);
		log.info("Enter the password");
		loginPage.inputPassword(password);
		log.info("Click on the button Login");
		managerPage = loginPage.clickbuttonLogin();
		log.info("Verify text success");
	}
	//@Test
	public void TC_01_Verify_Text_Title_And_Text_Label() {
		log.info("Click Customer Page Menu");
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
//		log.info("Block Ads");
//		newCustomerPage.blockAds(driver);
		log.info("Verify text title");
		Assert.assertEquals(newCustomerPage.getTextTitle(), "Add New Customer");
		log.info("Verify the text in the Customer Name label");
		Assert.assertTrue(newCustomerPage.isDisplaysTextLabel("Customer Name"));
		log.info("Verify the text in the Gender label");
		Assert.assertTrue(newCustomerPage.isDisplaysTextLabel("Gender"));
		log.info("Verify the text in the Date of Birth label");
		Assert.assertTrue(newCustomerPage.isDisplaysTextLabel("Date of Birth"));
		log.info("Verify the text in the Address label");
		Assert.assertTrue(newCustomerPage.isDisplaysTextLabel("Address"));
		log.info("Verify the text in the City label");
		Assert.assertTrue(newCustomerPage.isDisplaysTextLabel("City"));
		log.info("Verify the text in the State label");
		Assert.assertTrue(newCustomerPage.isDisplaysTextLabel("State"));
		log.info("Verify the text in the PIN label");
		Assert.assertTrue(newCustomerPage.isDisplaysTextLabel("PIN"));
		log.info("Verify the text in the Mobile Number label");
		Assert.assertTrue(newCustomerPage.isDisplaysTextLabel("Mobile Number"));
		log.info("Verify the text in the E-mail label");
		Assert.assertTrue(newCustomerPage.isDisplaysTextLabel("E-mail"));
		log.info("Verify the text in the Password label");
		Assert.assertTrue(newCustomerPage.isDisplaysTextLabel("Password"));
	}
	
	//@Test
	public void TC_03_Customer_Name_Blank() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Leak the Customer Name field blank ");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", "");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTab("Customer Name");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("Customer Name"),"Customer name must not be blank");
	}
	
	//@Test
	public void TC_04_Customer_Name_Numberic() {
		log.info("Enter numeic value in Customer Name Field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", "1234");
//		log.info("Click button Tab");
//		newCustomerPage.clickButtonTab("Customer Name");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("Customer Name"),"Numbers are not allowed");
	}
	//@Test
	public void TC_05_Customer_Name_Special() {
		log.info("Enter special character value in Customer Name Field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", "@#$$");
//		log.info("Click button Tab");
//		newCustomerPage.clickButtonTab("Customer Name");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("Customer Name"),"Special characters are not allowed");
	}
	
	//@Test
	public void TC_06_Customer_Name_First_Character() {
		log.info("Enter First character as blank space");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", " DaoLy");
//		log.info("Click button Tab");
//		newCustomerPage.clickButtonTab("Customer Name");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("Customer Name"),"First character can not have space");
	}
	@Test
	public void TC_07_Date_Of_Birth_Blank() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter First character as blank space");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", "DaoLy");
		log.info("Do not enter a value in Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTab("Date of Birth");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("Date of Birth"),"Date Field must not be blank");
	}
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	LoginPageObject loginPage;
	ManagerPageObject managerPage;
	NewCustomerPageObject newCustomerPage;
	CommonPageObject commonPage;
	public String userID,password;
}
