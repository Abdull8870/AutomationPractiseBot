package cucumberRunner;

import org.testng.annotations.BeforeTest;

import cucumber.api.CucumberOptions;
import selenium.projectSpecificMethods.ProjectSpecificMethods;

@CucumberOptions(features="src/main/java/features/Order.feature",
glue={"pages","hooks","selenium.base","selenium.projectSpecificMethods"},
monochrome=true)

public class PlaceOrderRunner extends ProjectSpecificMethods {
							
	@BeforeTest
	
	public void setValues() {
		nodes = "Order";
		authors = "Abdul";
		category = "Functional";
		dataSheetName="";
						}


}
