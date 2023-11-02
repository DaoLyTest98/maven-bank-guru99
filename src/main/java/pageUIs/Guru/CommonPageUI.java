package pageUIs.Guru;

public class CommonPageUI {
	public static final String DYNAMIC_LABEL_TEXT= "xpath=//td[text()='%s']";
	public static final String DYNAMIC_TEXTBOX = "xpath=//td[text()='%s']/following-sibling::td/input";
	public static final String DYNAMIC_TEXTAREA = "xpath=//td[text()='%s']/following-sibling::td/textarea";
	public static final String DYNAMIC_RADIO_BUTTON = "xpath=//input[@type='radio' and @value='%s']";
	public static final String DYNAMIC_BUTTON = "xpath=//input[@value='%s']";
	public static final String DYNAMIC_NEW_CUSTOMER_MESSAGE= "xpath=//td[text()='%s']/following-sibling::td/label";
	public static final String ADDRESS_MESSAGE= "xpath=//td[text()='Address']/following-sibling::td/label";
	public static final String DATE_OF_BIRTH_TEXTBOX = "xpath=//td[text()='Date of Birth']/following-sibling::td/input";
	public static final String DYNAMIC_VALUE_TEXT_NEW_CUSTOMER = "xpath=//td[text()='%s']/following-sibling::td";

}
