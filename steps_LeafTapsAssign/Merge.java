package steps_LeafTapsAssign;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Merge extends BaseClass {

@When("Go to Lookup Table from lead")
public void lookup() {
	driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
	Set<String> allWindows = driver.getWindowHandles();
	List<String> allhandles = new ArrayList<String>(allWindows);
	driver.switchTo().window(allhandles.get(1));
}
	
@Then("Search the FirstName as {string}")
public void name(String sname) {
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(sname);
}
@Then("Click Find Leads")
public void click(){
	
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	
}
	
@Then("Select the first row")
public void rowSelect() throws InterruptedException {
	Thread.sleep(2000);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	Set<String> allWindows = driver.getWindowHandles();
	List<String> allhandles = new ArrayList<String>(allWindows);
	driver.switchTo().window(allhandles.get(0));
}

@When("Go to Lookup Table to lead")
public void lookup1() {
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	Set<String> allWindows = driver.getWindowHandles();
	List<String> allhandles = new ArrayList<String>(allWindows);
	driver.switchTo().window(allhandles.get(1));
}
@Then("Search the MergeName as {string}")
public void name1(String mname) {
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(mname);
	//driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
}

	
@Then ("Click on Popup Alert")
public void alertOk() {
	driver.switchTo().alert().accept();
}

@Then("Verify the FirstName in ViewLead")
public void verify1() {
	boolean displayed = driver.findElement(By.id("viewLead_firstName_sp")).isDisplayed();	
	Assert.assertTrue(displayed);
		}



}
