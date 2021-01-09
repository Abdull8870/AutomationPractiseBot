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
	
	@FindBy(how=How.XPATH,using="//ul[@class=\"footer_links clearfix\"]")
	private WebElement eleFooter;
	
	@FindBy(how=How.XPATH,using="//tr[@class=\"last_item \"]")
	private  WebElement eleLastItem;
	
	@Then("User takes screenshot of the order summary details")
	public OrderHistoryPage takeOrderHistoryScreenshot() {
		addSnapToWord("The OrderSummary ScreenShot 1", takeScreenShot());
		ScrolDown(0, 500);
//		scrollTillTheElement(eleLastItem);
		addSnapToWord("The OrderSummary ScreenShot 2", takeScreenShot());
		return this;
	}
	


}
