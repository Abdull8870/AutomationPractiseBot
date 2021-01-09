package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class CreateAddressPage extends ProjectSpecificMethods {
	
	public CreateAddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID,using="firstname")
	private WebElement eleFirstName;
	
	@FindBy(how=How.ID,using="lastname")
	private WebElement eleLastname;
	
	
	@FindBy(how=How.ID,using="company")
	private WebElement eleCompanyName;
	
	
	@FindBy(how=How.ID,using="address1")
	private WebElement eleAddressLine1;
	
	@FindBy(how=How.ID,using="address2")
	private WebElement eleAddressLine2;
	
	@FindBy(how=How.ID,using="city")
	private WebElement eleCityName;
	
	@FindBy(how=How.ID,using="id_state")
	private WebElement eleSelectState;
	
	@FindBy(how=How.ID,using="postcode")
	private WebElement elePostcode;
	
	@FindBy(how=How.ID,using="id_country")
	private WebElement eleSelectCountryName;
	
	@FindBy(how=How.ID,using="phone")
	private WebElement eleHomePhoneNumber;
	
	@FindBy(how=How.ID,using="phone_mobile")
	private WebElement eleMobilePhoneNumber;
	
	@FindBy(how=How.ID,using="other")
	private WebElement eleOtherInformation;
    
	@FindBy(how=How.ID,using="alias")
	private WebElement eleAddressAliasName;
	
	@FindBy(how=How.ID,using="submitAddress")
	private WebElement eleSaveAddress;
	
	@FindBy(how=How.ID,using="uniform-id_state")
	private WebElement eleStateElement;
	
	@FindBy(how=How.ID,using="uniform-id_country")
	private WebElement eleCountryElement;
	
	
	@Then("Enter new address details firstName (.*) lastName (.*) companyname (.*) addressLineOne (.*) and addressLineTwo (.*)")
	public CreateAddressPage enterNewAddressDetails(String firstName,String lastname,String compName,String address1,
			String address2) {
		
		  clearAndType(eleFirstName, firstName);
		  clearAndType(eleLastname, lastname);
		  clearAndType(eleCompanyName, compName);
		  clearAndType(eleAddressLine1, address1);
		  clearAndType(eleAddressLine2, address2);
		  return this;
	}
	
	@Then("Select the state (.*) and country (.*)")
	public CreateAddressPage selectCountryAndCityAndPostCode(String stateName,String country) {
		selectDropDownUsingText(eleSelectState, stateName);
		System.out.println("waiting");
		selectDropDownUsingText(eleSelectCountryName, country);
		return this;
	}
	
	
	@Then("Enter City Name (.*) and postcode (.*)")
	public CreateAddressPage enterCityAndPostCode(String cityName,String postCode) {
		clearAndType(eleCityName, cityName);
		clearAndType(elePostcode, postCode);
		return this;
	}
    
	@And("Enter the contact details Home number (.*) Mobile number (.*) and additional info (.*)")
	public CreateAddressPage enterContactDetail(String homeNum,String mobileNum,String addInfo) {
		clearAndType(eleHomePhoneNumber, homeNum);
		clearAndType(eleMobilePhoneNumber, mobileNum);
		clearAndType(eleOtherInformation, addInfo);
		return this;
	}
   	
	@Then("Enter the alias name (.*) and click save")
	public CreateAddressPage enterAliasAndSave(String aliasName) {
		clearAndType(eleAddressAliasName, aliasName);
		click(eleSaveAddress);
		return this;
	}
	 
	
	
	
	
	
	
}
