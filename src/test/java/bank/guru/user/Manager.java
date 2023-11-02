package bank.guru.user;


import org.aspectj.lang.annotation.After;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.DataHelper;
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
		validEmployeeName = "Dao Ly";
		validDate="02/13/1995";
		validAddress= "Ha Noi";
		validCity="Ha Noi";
		validState="Single";
		validPIN="123456";
		validMobile="098765432";
		gender = "male";
		email = DataHelper.getDataHelper().getEmailAddress();
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
		newCustomerPage.clickButtonTabInput("Customer Name");
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
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", " Dao Ly");
//		log.info("Click button Tab");
//		newCustomerPage.clickButtonTab("Customer Name");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("Customer Name"),"First character can not have space");
	}
	//@Test
	public void TC_07_Date_Of_Birth_Blank() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Do not enter a value in Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("Date of Birth");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("Date of Birth"),"Date Field must not be blank");
	}
	//@Test
	public void TC_08_Date_Of_Birth_Blank() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Do not enter a value in Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/2/222222");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("Date of Birth");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("Date of Birth"),"Date Field must not be blank");
	}
	
	//@Test
	public void TC_09_Address_Blank() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth(validDate);
		log.info("Do not enter a value in Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address","");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabTextarea("Address");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextAddressMessage("Address"),"Address Field must not be blank");
	}
	
	//@Test
	public void TC_10_Address_First_Blank() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter First character as blank space");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Do not enter a value in Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter First character as blank space");
		newCustomerPage.inputToDynamicTextArea(driver,"Address"," HaNoi");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabTextarea("Address");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextAddressMessage("Address"),"First character can not have space");
	}
	//@Test
	public void TC_11_City_Blank() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter First character as blank space");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Do not enter a value in Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter First character as blank space");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Do not enter a value in City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City","");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("City");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("City"),"City Field must not be blank");
	}
	//@Test
	public void TC_12_City_Numeic() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter First character as blank space");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Do not enter a value in Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter First character as blank space");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter numeic value in City Field");
		newCustomerPage.inputToDynamicTextbox(driver,"City","12345");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("City");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("City"),"Numbers are not allowed");
	}
	//@Test
	public void TC_13_City_Special() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter First character as blank space");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Do not enter a value in Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter First character as blank space");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter special character value in City Field");
		newCustomerPage.inputToDynamicTextbox(driver,"City","!@#$#");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("City");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("City"),"Special characters are not allowed");
	}
	//@Test
	public void TC_14_City_First_Blank() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter First character as blank space");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Do not enter a value in Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter First character as blank space");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Do not enter a value in City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City"," HaNoi");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("City");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("City"),"First character can not have space");
	}
	//@Test
	public void TC_15_State_Blank() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Do not enter a value in State field");
		newCustomerPage.inputToDynamicTextbox(driver,"State","");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("State");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("State"),"State must not be blank");
	}
	//@Test
	public void TC_16_State_Numeic() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter numeic value in State Field");
		newCustomerPage.inputToDynamicTextbox(driver,"State","12223");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("State");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("State"),"Numbers are not allowed");
	}
	//@Test
	public void TC_17_State_Special() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter special character value in State Field");
		newCustomerPage.inputToDynamicTextbox(driver,"State","@!!");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("State");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("State"),"Special characters are not allowed");
	}
	//@Test
	public void TC_18_State_First_Blank() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter First character as blank space");
		newCustomerPage.inputToDynamicTextbox(driver,"State"," Doc than");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("State");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("State"),"First character can not have space");
	}
	//@Test
	public void TC_19_State_First_Blank() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter the correct value in the State field");
		newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
		log.info("Do not enter a value in PIN field");
		newCustomerPage.inputToDynamicTextbox(driver,"PIN","");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("PIN");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("PIN"),"PIN Code must not be blank");
	}
	//@Test
	public void TC_20_PIN_Character() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter the correct value in the State field");
		newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
		log.info("Enter Character value in PIN Field");
		newCustomerPage.inputToDynamicTextbox(driver,"PIN","avbbb");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("PIN");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("PIN"),"Characters are not allowed");
	}
	//@Test
	public void TC_21_PIN_Less_Six_Digits() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter the correct value in the State field");
		newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
		log.info("Enter less than 6 digit in PIN Field");
		newCustomerPage.inputToDynamicTextbox(driver,"PIN","11111");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("PIN");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("PIN"),"PIN Code must have 6 Digits");
	}
	//@Test
	public void TC_22_PIN_Special() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter the correct value in the State field");
		newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
		log.info("Enter Special Character in PIN File ");
		newCustomerPage.inputToDynamicTextbox(driver,"PIN","12@#$");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("PIN");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("PIN"),"Special characters are not allowed");
	}
	//@Test
	public void TC_23_PIN_First_Blank() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter the correct value in the State field");
		newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
		log.info("Enter First character as blank space");
		newCustomerPage.inputToDynamicTextbox(driver,"PIN"," 1233");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("PIN");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("PIN"),"First character can not have space");
	}
	//@Test
	public void TC_24_Mobile_Number_Blank() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter the correct value in the State field");
		newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
		log.info("Enter the correct value in the PIN field");
		newCustomerPage.inputToDynamicTextbox(driver,"PIN",validPIN);
		log.info("Do not enter a value in Mobile Number field");
		newCustomerPage.inputToDynamicTextbox(driver,"Mobile Number","");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("Mobile Number");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("Mobile Number"),"Mobile no must not be blank");
	}
	//@Test
	public void TC_25_Mobile_Character() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter the correct value in the State field");
		newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
		log.info("Enter the correct value in the PIN field");
		newCustomerPage.inputToDynamicTextbox(driver,"PIN",validPIN);
		log.info("Enter Character value in Mobile Number Field");
		newCustomerPage.inputToDynamicTextbox(driver,"Mobile Number","acvdd");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("Mobile Number");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("Mobile Number"),"Characters are not allowed");
	}
	//@Test
	public void TC_26_Mobile_Number_Special() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter the correct value in the State field");
		newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
		log.info("Enter the correct value in the PIN field");
		newCustomerPage.inputToDynamicTextbox(driver,"PIN",validPIN);
		log.info("Enter Special Character in Mobile Number File ");
		newCustomerPage.inputToDynamicTextbox(driver,"Mobile Number","123!@#$");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("Mobile Number");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("Mobile Number"),"Special characters are not allowed");
	}
	//@Test
	public void TC_27_Mobile_Number_First_Blank() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter the correct value in the State field");
		newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
		log.info("Enter the correct value in the PIN field");
		newCustomerPage.inputToDynamicTextbox(driver,"PIN",validPIN);
		log.info("Enter First character as blank space");
		newCustomerPage.inputToDynamicTextbox(driver,"Mobile Number"," 1223455");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("Mobile Number");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("Mobile Number"),"First character can not have space");
	}
	//@Test
	public void TC_28_Email_Blank() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter the correct value in the State field");
		newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
		log.info("Enter the correct value in the PIN field");
		newCustomerPage.inputToDynamicTextbox(driver,"PIN",validPIN);
		log.info("Enter the correct value in the Mobile Number field");
		newCustomerPage.inputToDynamicTextbox(driver,"Mobile Number",validMobile);
		log.info("Do not enter a value in Email field");
		newCustomerPage.inputToDynamicTextbox(driver,"E-mail","");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("E-mail");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("E-mail"),"Email-ID must not be blank");
	}
	//@Test
	public void TC_29_Email_First_Character_Blank() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter the correct value in the State field");
		newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
		log.info("Enter the correct value in the PIN field");
		newCustomerPage.inputToDynamicTextbox(driver,"PIN",validPIN);
		log.info("Enter the correct value in the Mobile Number field");
		newCustomerPage.inputToDynamicTextbox(driver,"Mobile Number",validMobile);
		log.info("Enter First character as blank space");
		newCustomerPage.inputToDynamicTextbox(driver,"E-mail"," dao@gmail.com");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("E-mail");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("E-mail"),"First character can not have space");
	}
	//@Test
	public void TC_30_Email_Without_Username() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter the correct value in the State field");
		newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
		log.info("Enter the correct value in the PIN field");
		newCustomerPage.inputToDynamicTextbox(driver,"PIN",validPIN);
		log.info("Enter the correct value in the Mobile Number field");
		newCustomerPage.inputToDynamicTextbox(driver,"Mobile Number",validMobile);
		log.info("Enter the email address without the username before the @ symbol");
		newCustomerPage.inputToDynamicTextbox(driver,"E-mail","@gmail.com");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("E-mail");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("E-mail"),"Email-ID is not valid");
	}
	//@Test
	public void TC_31_Email_Without_At_Sign() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter the correct value in the State field");
		newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
		log.info("Enter the correct value in the PIN field");
		newCustomerPage.inputToDynamicTextbox(driver,"PIN",validPIN);
		log.info("Enter the correct value in the Mobile Number field");
		newCustomerPage.inputToDynamicTextbox(driver,"Mobile Number",validMobile);
		log.info("Enter the email address without '@' symbol");
		newCustomerPage.inputToDynamicTextbox(driver,"E-mail","agmail.com");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("E-mail");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("E-mail"),"Email-ID is not valid");
	}
	//@Test
	public void TC_32_Email_Miss_Domain() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter the correct value in the State field");
		newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
		log.info("Enter the correct value in the PIN field");
		newCustomerPage.inputToDynamicTextbox(driver,"PIN",validPIN);
		log.info("Enter the correct value in the Mobile Number field");
		newCustomerPage.inputToDynamicTextbox(driver,"Mobile Number",validMobile);
		log.info("Enter the missing domain in the email address");
		newCustomerPage.inputToDynamicTextbox(driver,"E-mail","employeeName@");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("E-mail");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("E-mail"),"Email-ID is not valid");
	}
	
	//@Test
	public void TC_33_Password_Blank() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter the correct value in the State field");
		newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
		log.info("Enter the correct value in the PIN field");
		newCustomerPage.inputToDynamicTextbox(driver,"PIN",validPIN);
		log.info("Enter the correct value in the Mobile Number field");
		newCustomerPage.inputToDynamicTextbox(driver,"Mobile Number",validMobile);
		log.info("Enter the missing domain in the email address");
		newCustomerPage.inputToDynamicTextbox(driver,"E-mail",email);
		log.info("Do not enter a value in Password field");
		newCustomerPage.inputToDynamicTextbox(driver,"Password","");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("Password");
		log.info("Verify error message");
		Assert.assertEquals(newCustomerPage.getTextNewCustomerMessage("Password"),"Password must not be blank");
	}
	//@Test
	public void TC_34_Alert_Submit_Button_Blank_Field() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the correct value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter the correct value in the State field");
		newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
		log.info("Enter the correct value in the PIN field");
		newCustomerPage.inputToDynamicTextbox(driver,"PIN",validPIN);
		log.info("Enter the correct value in the Mobile Number field");
		newCustomerPage.inputToDynamicTextbox(driver,"Mobile Number",validMobile);
		log.info("Enter the missing domain in the email address");
		newCustomerPage.inputToDynamicTextbox(driver,"E-mail",email);
		log.info("Do not enter a value in Password field");
		newCustomerPage.inputToDynamicTextbox(driver,"Password","");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("Password");
		log.info("Click button Submit");
		newCustomerPage.clickButton(driver,"Submit");
		log.info("Verify text Alert");
		Assert.assertEquals(newCustomerPage.getTextMessageAlert(), "please fill all fields");
		log.info("Click on the button OK");
		loginPage.clickButtonOkAlert();
	}
	//@Test
	public void TC_35_Alert_Submit_Button_Incorrect_Field() {
		newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
		log.info("Enter the incorrect value in the Customer Name field");
		newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", " employeeName");
		log.info("Enter the correct value in the Date of Birth field");
		newCustomerPage.inputToTextboxDateBirth("17/02/1995");
		log.info("Enter the correct value in the Address field");
		newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
		log.info("Enter the correct value in the City field");
		newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
		log.info("Enter the correct value in the State field");
		newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
		log.info("Enter the correct value in the PIN field");
		newCustomerPage.inputToDynamicTextbox(driver,"PIN",validPIN);
		log.info("Enter the correct value in the Mobile Number field");
		newCustomerPage.inputToDynamicTextbox(driver,"Mobile Number",validMobile);
		log.info("Enter the correct value in the E-mail field");
		newCustomerPage.inputToDynamicTextbox(driver,"E-mail",email);
		log.info("Enter the correct value in the Password field");
		newCustomerPage.inputToDynamicTextbox(driver,"Password","12345");
		log.info("Click button Tab");
		newCustomerPage.clickButtonTabInput("Password");
		log.info("Click button Submit");
		newCustomerPage.clickButton(driver,"Submit");
		log.info("Verify text Alert");
		Assert.assertEquals(newCustomerPage.getTextMessageAlert(), "please fill all fields");
		log.info("Click on the button OK");
		loginPage.clickButtonOkAlert();
	}
	//@Test
		public void TC_36_Rest_Button() {
			newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
			log.info("Enter the correct value in the Customer Name field");
			newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", validEmployeeName);
			log.info("Enter the correct value in the Date of Birth field");
			newCustomerPage.inputToTextboxDateBirth("17/02/1995");
			log.info("Enter the correct value in the Address field");
			newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
			log.info("Enter the correct value in the City field");
			newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
			log.info("Enter the correct value in the State field");
			newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
			log.info("Enter the correct value in the PIN field");
			newCustomerPage.inputToDynamicTextbox(driver,"PIN",validPIN);
			log.info("Enter the correct value in the Mobile Number field");
			newCustomerPage.inputToDynamicTextbox(driver,"Mobile Number",validMobile);
			log.info("Enter the correct value in the E-mail field");
			newCustomerPage.inputToDynamicTextbox(driver,"E-mail",email);
			log.info("Enter the correct value in the Password field");
			newCustomerPage.inputToDynamicTextbox(driver,"Password","12345");
			log.info("Click button Reset");
			newCustomerPage.clickButton(driver,"Reset");
			log.info("Verify value input");
			Assert.assertTrue(newCustomerPage.getTextValueInput("Customer Name"));
			Assert.assertTrue(newCustomerPage.getTextValueInput("Date of Birth"));
			Assert.assertTrue(newCustomerPage.getTextValueInput("Address"));
			Assert.assertTrue(newCustomerPage.getTextValueInput("City"));
			Assert.assertTrue(newCustomerPage.getTextValueInput("State"));
			Assert.assertTrue(newCustomerPage.getTextValueInput("PIN"));
			Assert.assertTrue(newCustomerPage.getTextValueInput("Mobile Number"));
			Assert.assertTrue(newCustomerPage.getTextValueInput("E-mail"));
			Assert.assertTrue(newCustomerPage.getTextValueInput("Password"));
		}
		
		@Test
		public void TC_37_Register_Successful() {
			newCustomerPage= (NewCustomerPageObject)managerPage.openMenuPage(driver, "New Customer");
			log.info("Enter the correct value in the Customer Name field");
			newCustomerPage.inputToDynamicTextbox(driver, "Customer Name", "Dao Ly");
			log.info("Enter the correct value in the Date of Birth field");
			newCustomerPage.inputToTextboxDateBirth(validDate);
			log.info("Enter the correct value in the Address field");
			newCustomerPage.inputToDynamicTextArea(driver,"Address",validAddress);
			log.info("Enter the correct value in the City field");
			newCustomerPage.inputToDynamicTextbox(driver,"City",validCity);
			log.info("Enter the correct value in the State field");
			newCustomerPage.inputToDynamicTextbox(driver,"State",validState);
			log.info("Enter the correct value in the PIN field");
			newCustomerPage.inputToDynamicTextbox(driver,"PIN",validPIN);
			log.info("Enter the correct value in the Mobile Number field");
			newCustomerPage.inputToDynamicTextbox(driver,"Mobile Number",validMobile);
			log.info("Enter the correct value in the E-mail field");
			newCustomerPage.inputToDynamicTextbox(driver,"E-mail",email);
			log.info("Enter the correct value in the Password field");
			newCustomerPage.inputToDynamicTextbox(driver,"Password","12345");
			log.info("Click button Submit");
			newCustomerPage.clickButton(driver,"Submit");
			log.info("Verify text successful");
			Assert.assertEquals(newCustomerPage.getTextTitle(), "Customer Registered Successfully!!!");
			log.info("Verify text value");
			Assert.assertEquals(newCustomerPage.retrievesTheEnteredValues("Customer Name"), validEmployeeName);
			Assert.assertEquals(newCustomerPage.retrievesTheEnteredValues("Gender"), gender);
			Assert.assertEquals(newCustomerPage.retrievesTheEnteredValues("Birthdate"), validDate);
			Assert.assertEquals(newCustomerPage.retrievesTheEnteredValues("Address"), validAddress);
			Assert.assertEquals(newCustomerPage.retrievesTheEnteredValues("City"), validCity);
			Assert.assertEquals(newCustomerPage.retrievesTheEnteredValues("State"), validState);
			Assert.assertEquals(newCustomerPage.retrievesTheEnteredValues("Pin"), validPIN);
			Assert.assertEquals(newCustomerPage.retrievesTheEnteredValues("Mobile No."), validMobile);
			Assert.assertEquals(newCustomerPage.retrievesTheEnteredValues("Email"), email);
	
			
		}
	@AfterClass
	public void afterClass() {
		//closeBrowserDriver();
	}
	

	private WebDriver driver;
	LoginPageObject loginPage;
	ManagerPageObject managerPage;
	NewCustomerPageObject newCustomerPage;
	CommonPageObject commonPage;
	public String userID,password;
	public String email, validEmployeeName,gender;
	public String validDate,validAddress,validCity,validState,validPIN,validMobile;
}
