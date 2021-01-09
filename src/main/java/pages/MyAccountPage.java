package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class MyAccountPage extends ProjectSpecificMethods {
	
		public MyAccountPage() {
			PageFactory.initElements(driver, this);
		}	
		
		@FindBy(how=How.XPATH,using="//a[@title=\"Addresses\"]")
		private WebElement eleAddressTab;
		
		@Then("Click on on the link MY ADDRESSES") 
		public MyAccountPage clickAddressTab() {
			click(eleAddressTab);
			return this;
		}
		
		
		@FindBy(how=How.XPATH,using="//a[@title=\"View my customer account\"]")
		private WebElement eleUserProfile;
		
		@Then("User clicks on profile")
		public MyAccountPage clickOnUserProfile() {
			click(eleUserProfile);
			return this;
		}
		
		
		@FindBy(how=How.XPATH,using="//a[@title=\"Orders\"]")
		private WebElement eleOrderHistory;
		
		@Then("User clicks on order history and details")
		public OrderHistoryPage clickOrderHistory() {
			click(eleOrderHistory);
			return new OrderHistoryPage();
		}
		
		@FindBy(how=How.LINK_TEXT,using="Sign out")
		private WebElement eleSignOut;
		
		
		@Then("User sign out of the application")
		public loginPage clickSignOut() {
			click(eleSignOut);
			return new loginPage();
		}
		

}
