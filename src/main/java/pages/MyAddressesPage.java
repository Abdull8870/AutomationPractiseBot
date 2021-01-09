package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class MyAddressesPage extends ProjectSpecificMethods{
	
	public MyAddressesPage() {
		PageFactory.initElements(driver, this);
	}	
	
	@FindBy(how=How.LINK_TEXT,using="Add a new address")
	private WebElement eleAddANewAddress;
	
	@Then("Click on Add a new address button")
	public MyAddressesPage clickAddressTab() {
		click(eleAddANewAddress);
		return this;
	}
	

	@FindBy(how=How.XPATH,using="//a[@title=\"Women\"]")
	private WebElement eleWomenLink;
	
	@FindBy(how=How.LINK_TEXT,using="Summer Dresses")
	private WebElement eleSummerDressesLink;
	
	@Then("Click Summer section under Womens tab")
	public SummerDressesPage moveToWomentAndClickSummer() {
		moveToElementAndClick(eleWomenLink, eleSummerDressesLink);
		return new SummerDressesPage();
	}
	
	
   
}
