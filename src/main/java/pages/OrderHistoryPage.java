package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class OrderHistoryPage extends ProjectSpecificMethods{
	
	public OrderHistoryPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.LINK_TEXT,using="Google Plus")
	private WebElement eleGooglePlus;
	
	@Then("User takes screenshot of the order summary details")
	public OrderHistoryPage takeOrderHistoryScreenshot() {
		scrollTillTheElement(eleGooglePlus);
		addSnapToWord("The OrderSummary ScreenShot", takeScreenShot());
		return this;
	}
	


}
