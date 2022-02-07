package steps_ServiceNow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Delete_ServieNow extends BaseClass{

@Then("Click the Delete Button")
public void delete() {
	driver.findElement(By.xpath("//button[text()='Delete']")).click();	
}

@Then("Click on the Pop-up Alert")
public void popupAlert() {
	driver.findElement(By.xpath("//button[@id='ok_button']")).click();
}
@Then("Verify the {string} is deleted")
public void verify(String incidentno) {
	WebElement filter = driver.findElement(By.xpath("//div[@class='input-group']/span//select"));
	Select search= new Select(filter);
	search.selectByValue("number");
	driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentno,Keys.ENTER);
	String result = driver.findElement(By.xpath("//tbody/tr[@class='list2_no_records']/td")).getText();
	String actual="No records to display";
	Assert.assertEquals(actual,result);
	}
}
