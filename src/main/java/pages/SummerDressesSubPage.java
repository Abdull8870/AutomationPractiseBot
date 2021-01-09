package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class SummerDressesSubPage  extends ProjectSpecificMethods{
	
	public SummerDressesSubPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how=How.ID,using="quantity_wanted")
	private WebElement eleQuantity;
	
	@Then("Increase the quantity to (.*)")
	public SummerDressesSubPage enterQuantityValue(String qty) {
		clearAndType(eleQuantity, qty);
		return this;
	}
	
	@FindBy(how=How.ID,using="group_1")
	private WebElement eleSelectSize;
	
	
	@Then("Change the size to (.*)")
	public SummerDressesSubPage selectSize(String size) {
		selectDropDownUsingText(eleSelectSize, size);
		return this;
	}
	

	@FindBy(how=How.NAME,using="Yellow")
	private WebElement eleColor;
	
	@Then("Select any colour")	
	public SummerDressesSubPage selectColor() {
		click(eleColor);
		return this;
	}
	
	@FindBy(how=How.NAME,using="Submit")
	private WebElement eleAddTocart;
	
	
	@Then("Click Add to cart")
	public SummerDressesSubPage clickAddToCart() {
		click(eleAddTocart);
		return this;
	}
	
	@FindBy(how=How.XPATH,using="//span[@title=\"Continue shopping\"]")
	private WebElement eleContinueShoppingBtn;
	
	@Then("Click on Continue Shopping")
	public SummerDressesSubPage clickContinueShopping() {
		click(eleContinueShoppingBtn);
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.invisibilityOf(eleContinueShoppingBtn));
		return this;
	}
	
	
	@FindBy(how=How.LINK_TEXT,using="Proceed to checkout")
    private WebElement eleProceedCheckOut;
	
	@FindBy(how=How.CLASS_NAME,using="icon-home")
	private WebElement eleHomeBtn;

	
	@Then("Click on proceed to checkout")
	public OrderSumAndPaymentPage clickOnProceedToCheckOut() {
		click(eleProceedCheckOut);
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(eleHomeBtn));
		scrollTillTheElement(eleProceedCheckOut);
		click(eleProceedCheckOut);
		return new OrderSumAndPaymentPage();
	}
	
	
	@FindBy(how=How.XPATH,using="//a[@title=\"Women\"]")
	private WebElement eleWomenLink;
	
	@FindBy(how=How.LINK_TEXT,using="Summer Dresses")
	private WebElement eleSummerDressesLink;
	
	

	@Then("Add all three products with Qty (.*) size (.*) and collor as yellow to the cart")
	public OrderSumAndPaymentPage purchaseAllProdcut(String qty,String size) {
		for(int i=1;i<=3;i++) {
		String ele="(//h5[@itemprop=\"name\"]/a)["+i+"]";
		WebElement product=locateElement("xpath", ele);
		click(product);
		clearAndType(eleQuantity, qty);
		selectDropDownUsingText(eleSelectSize, size);
		click(eleColor);
		click(eleAddTocart);
		if(!(i==3)) {
			click(eleContinueShoppingBtn);
			moveToElementAndClick(eleWomenLink, eleSummerDressesLink);
		}
		else {
			click(eleProceedCheckOut);
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(eleHomeBtn));
			scrollTillTheElement(eleProceedCheckOut);
			click(eleProceedCheckOut);
			break;
		}
		}
		return new OrderSumAndPaymentPage();
	}
	
		
	
	
		
}
