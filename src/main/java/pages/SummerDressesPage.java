package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Then;
import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class SummerDressesPage extends ProjectSpecificMethods {
	
	public SummerDressesPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how=How.CLASS_NAME,using="icon-th-list")
	private WebElement eleListView;
	
	@Then("Change the item view into list")
	public SummerDressesPage selectListView() {
		click(eleListView);
		return this;
	}
	
	
	@FindBy(how=How.XPATH,using="(//h5[@itemprop=\"name\"]/a)[1]")
	private WebElement eleFirstProduct;
	
	@FindBy(how=How.XPATH,using="(//h5[@itemprop=\"name\"]/a)[2]")
	private WebElement eleSecondtProduct;
	
	@FindBy(how=How.XPATH,using="(//h5[@itemprop=\"name\"]/a)[3]")
	private WebElement eleThirdProduct;
	
	@Then("Click on the firt item of the page")
	public SummerDressesSubPage clickOnFirstProduct() {
		click(eleFirstProduct);
		return new SummerDressesSubPage();
	}
	
	@Then("Click on the Second item of the page")
	public SummerDressesSubPage clickOnSecondProduct() {
		click(eleSecondtProduct);
		return new SummerDressesSubPage();
	}
	
	@Then("Click on the Third item of the page")
	public SummerDressesSubPage clickOnThirdProduct() {
		click(eleThirdProduct);
		return new SummerDressesSubPage();
	}
	
//	@Then("Add all three products with Qty (.*) size (.*) and collor as yellow to the cart")
//	public SummerDressesPage purchaseAllProdcut(String qty,String size) {
//		String ele="(//h5[@itemprop=\"name\"]/a)["+1+"]";
//		WebElement product=locateElement("xpath", ele);
//		click(product);
//		return this;
//	}
}
