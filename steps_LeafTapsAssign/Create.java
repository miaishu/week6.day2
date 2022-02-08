package steps_LeafTapsAssign;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Create extends BaseClass{
	
	@Given("Enter Username as {string}")
	public void userName(String uname) {
		driver.findElement(By.id("username")).sendKeys(uname);
	}

	@Given("Enter Password as {string}")
	public void passWord(String pword) {
		driver.findElement(By.id("password")).sendKeys(pword);	
	}
	@Then ("Click on Login")
	public void login() {
	driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("Click on {string}")
	public void select(String value) {
		driver.findElement(By.linkText(value)).click();
	}
	@When("Verify {string} page")
	public void verify(String title) {
	boolean displayed = driver.findElement(By.linkText(title)).isDisplayed();	
	//Assert.assertTrue(displayed);
		}
	@When("Enter Companyname {string}")
	public void enterCompanyName(String cname) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		}
	@When("Enter Firstname {string}")
	public void enterFirstName(String fname) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
	}
	@When("Enter Lastname {string}")
	public void enterLastName(String lname) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
	}
	@When("Click on Submit")
	public void submit() {
		driver.findElement(By.name("submitButton")).click();	
	}
	

}





	


