package steps_LeafTapsAssign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Features.BaseClass;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead extends BaseClass {
	
public static String test;
@Then("Get the id")
public String id() {
	 test = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	return test;
}


@Then("Enter LeadID no")
public void leadID(String test) {
	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(test);
	
}

@Then("Verify {string}")
public void verify2(String data)
{
	boolean displayed = driver.findElement(By.className("x-paging-info")).isDisplayed();
	Assert.assertEquals(data, displayed);
}
}







