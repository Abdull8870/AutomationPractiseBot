package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mongodb.operation.OrderBy;

import cucumber.api.java.en.Then;
import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class OrderSumAndPaymentPage extends ProjectSpecificMethods {

	public OrderSumAndPaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	

	@FindBy(how=How.XPATH,using="//div[@class=\"checker\"]/span/input[@type=\"checkbox\"]")
	private WebElement eleAgreeTermsAndCon;

	@FindBy(how=How.NAME,using="processAddress")
    private WebElement eleProceedCheckOut;
	
	
	@Then("User clicks on proceed to check out")
    public OrderSumAndPaymentPage clickProceedToCheckout() {
		click(eleProceedCheckOut);
		return this;
	}
	
	@FindBy(how=How.NAME,using="processCarrier")
	private WebElement eleCheckOutProcessCarrier;
	
	@Then("User Agrees terms and condition and clicks on proceed to check out")
	public OrderSumAndPaymentPage clickOnAgreeTermsAndConditionAndCheckOut() {
		eleAgreeTermsAndCon.click();
//		click(eleAgreeTermsAndCon);
		click(eleCheckOutProcessCarrier);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="//a[@title=\"Pay by check.\"]")
	private WebElement elePayByCheck;
	
	
	@Then("User selects the Payment Method as check and completes the payment")
	public OrderSumAndPaymentPage clickOnPayByCheckMethod() {
		click(elePayByCheck);
		click(eleConfirmMyOrder);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="//button[@class=\"button btn btn-default button-medium\"]")
	private WebElement eleConfirmMyOrder;
	
	public OrderSumAndPaymentPage  clickOnIConfirmMyOrder() {
		click(eleConfirmMyOrder);
		return this;
	}
	
	
	@Then("User click on proceed to check out under Address section")
	public OrderSumAndPaymentPage clickCheckOutUnderAddressTab() {
		click(eleProceedCheckOut);
		return this;
	}
	
	@FindBy(how=How.ID,using="total_price_container")
	private WebElement eleTotal;
	
	public OrderSumAndPaymentPage takeScreenShotOrderSummary() {
		addSnapToWord("The OrderSummary ScreenShot 1", takeScreenShot());
		scrollTillTheElement(eleTotal);
		addSnapToWord("The OrderSummary ScreenShot 2", takeScreenShot());
		return this;
	}
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),\"I confirm my order\")]")
	private WebElement eleConfirmMyOrder2;
	
	@FindBy(how=How.XPATH,using="//a[@title=\"Back to orders\"]")
	private WebElement eleBackToOrders;
	
	public OrderSumAndPaymentPage takeOrderConfirmationScreenShot() {
		scrollTillTheElement(eleBackToOrders);
		addSnapToWord("The Order Confirmation", takeScreenShot());
		return this;
	}
	
}
