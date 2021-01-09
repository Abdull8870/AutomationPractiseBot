package cucumberRunner;

import org.testng.annotations.BeforeTest;

import cucumber.api.CucumberOptions;
import selenium.projectSpecificMethods.ProjectSpecificMethods;


@CucumberOptions(features="src/main/java/features/AddAddressAndPlaceOrder.feature",
glue={"pages","hooks","selenium.base","selenium.projectSpecificMethods"},
monochrome=true)
public class AddressPlusOrderRunner extends ProjectSpecificMethods {

	
@BeforeTest
public void setValues() {
	nodes = "MainTestScenario";
	authors = "Abdul";
	category = "Functional";
	dataSheetName="";
}

	
	
}
