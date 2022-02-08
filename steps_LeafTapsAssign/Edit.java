package steps_LeafTapsAssign;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Edit extends BaseClass{
	@Then ("Click Phone")	
	public void mobno() {
		//driver.findElement(By.xpath("//span[text()=Phone]")).click();
		driver.findElement(By.linkText("Phone")).click();
		}

	@Given("Enter {string}")
	public void enterno(String no) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(no);
		Thread.sleep(2000);
	}

	@Then("Click first data")
	public void firstData() {
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	}

	@Then("Clear companyName")
	public void clearData() {
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
	}

	@Then("Update companyName {string}")
	public void update(String newName) {
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(newName);
	}
	@Then("Click the submitButton")
	public void submit1() {
	driver.findElement(By.name("submitButton")).click();
	}
	
	@Then("Verify")
	public void verify() {
		boolean displayed = driver.findElement(By.id("viewLead_companyName_sp")).isDisplayed();
				Assert.assertTrue(displayed);
	}
}
		
		