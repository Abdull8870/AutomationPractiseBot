package cucumberRunner;

import org.testng.annotations.BeforeTest;

import cucumber.api.CucumberOptions;
import selenium.projectSpecificMethods.ProjectSpecificMethods;

@CucumberOptions(features="src/main/java/features/OrderPlacingAlernative.feature",
glue={"pages","hooks","selenium.base","selenium.projectSpecificMethods"},
monochrome=true)
public class AlternativeOptionRunner extends ProjectSpecificMethods {
					
			@BeforeTest
			public void setValues() {
				nodes = "Alternative";
				authors = "Abdul";
				category = "Functional";
				dataSheetName="";
			}


}
