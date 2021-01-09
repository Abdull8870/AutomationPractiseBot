package cucumberRunner;

import org.testng.annotations.BeforeTest;

import cucumber.api.CucumberOptions;
import selenium.projectSpecificMethods.ProjectSpecificMethods;

@CucumberOptions(features="src/main/java/features/AddNewAddress.feature",
glue={"pages","hooks","selenium.base","selenium.projectSpecificMethods"},
monochrome=true)
public class AddAddressRunner extends ProjectSpecificMethods{

		
	@BeforeTest
	public void setValues() {
		nodes = "Address";
		authors = "Abdul";
		category = "Functional";
		dataSheetName="";
	}
	
	

	
}
