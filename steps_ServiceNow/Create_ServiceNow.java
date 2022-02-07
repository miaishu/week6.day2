package steps_ServiceNow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Create_ServiceNow extends BaseClass{
	public static String attribute;
	
	@Given("Enter username as {string}")
	public void enterUsernameAs(String username) {
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(username,Keys.TAB);
	    
	}
	@Given("Enter password as {string}")
	public void enterPasswordAs(String password) {
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(password);
	}
	@Then("Click Login")
	public void login() {
		driver.findElement(By.id("sysverb_login")).click();
			}
	@When("Search for {string} in filter navigator")
	public void searchForIncidentInFilterNavigator(String inc) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(inc,Keys.ENTER);
		Thread.sleep(2000);
	}
	@Then("Select All in filter navigator")
	public void selectInFilterNaviagtor() {
		driver.findElement(By.xpath("//a[@id='b55b4ab0c0a80009007a9c0f03fb4da9']")).click();
	}
	@When("Click on create New incident")
	public void clickOnCreateIncident() {
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//button[text()='New']")).click();
	}
	@Given("Get the incident number")
	public static String getTheIncidentNumber() {
		WebElement element = driver.findElement(By.xpath("//input[@id='incident.number']"));
		 attribute = element.getAttribute("value");
		 return attribute;
			}
	@Given("Enter the caller details as {string}")
	public void enterTheCallerDetailsAs(String callername) throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String>windows1=new ArrayList<String>(windowHandles1);
		driver.switchTo().window(windows1.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(callername,Keys.ENTER);
		driver.findElement(By.linkText(callername)).click();
		driver.switchTo().window(windows1.get(0));
	}
	@Given("Enter Short description as {string}")
	public void enterShortDescriptionAs(String shortdesc) {
		WebElement frame4 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame4);	
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys(shortdesc);
	}
	
	
	@When("Click on Submit button")
	public void clickOnButton() {
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
	}
	@Then("Verify incident no is created")
	public static void verifyIncidentNoIsCreated() {
		WebElement filter = driver.findElement(By.xpath("//div[@class='input-group']/span//select"));
		Select search= new Select(filter);
		search.selectByValue("number");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(attribute,Keys.ENTER);
		boolean displayed = driver.findElement(By.xpath("//td[@class='vt']/a")).isDisplayed();
		Assert.assertTrue(displayed);
	}

}
