package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.base.SeleniumBase;
import selenium.projectSpecificMethods.ProjectSpecificMethods;

public class loginPage extends ProjectSpecificMethods {
    int i=1;
	public loginPage() {
		PageFactory.initElements(driver, this);
	}	
	
	
	@FindBy(how=How.LINK_TEXT,using="Sign in")
    private WebElement eleSignInBtn;
	
	
	@FindBy(how=How.ID,using="email")
	private  WebElement eleEmailId;
	
	
	@FindBy(how=How.ID,using="SubmitLogin")
	private  WebElement eleLogin;
	
	@FindBy(how=How.ID,using="passwd")
	private  WebElement elePassword;
	
	
	@Given("Click on SignIn link")
	public loginPage clickSignInLink() {
		click(eleSignInBtn);
		return this;
	}

	
	@Then("Enter the username as (.*) and password (.*)")
	public loginPage enerUsername(String userName,String passWord) {
		System.out.println(userName);
		clearAndType(eleEmailId, userName);
		clearAndType(elePassword, passWord);
		
		return this;
	}

	@Then("Click the Sign in button")
	 public MyAccountPage clickSignIn(){
		click(eleLogin);
	   return new MyAccountPage();
	}



	
	

 
}
