package steps_ServiceNow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Assign_ServieNow extends BaseClass{
@Then("Select Open in filter navigator")
public void select() {
	driver.findElement(By.xpath("//div[text()='Open']")).click();
}

@Then("Assign the incident to Software group")
public void assignGroup() throws InterruptedException {
	driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']/span")).click();
	Set<String> windowHandles = driver.getWindowHandles();
	List<String>windows= new ArrayList<String>(windowHandles);
	driver.switchTo().window(windows.get(1));
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys("Software",Keys.ENTER);
	driver.findElement(By.xpath("//a[text()='Software']")).click();
	Thread.sleep(3000);
	driver.switchTo().window(windows.get(0));
}
@Then("Update the incident with work notes")
public void updateWorknotes() {
	WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
	driver.switchTo().frame(frame1);
	WebElement sd = driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']"));
	sd.clear();
	sd.sendKeys("Changed the Assignment group");
}

@Then("Verify the incident assignedgroup")
public void verifyGroup(String incidentno) {
	WebElement filter = driver.findElement(By.xpath("//div[@class='input-group']/span//select"));
	Select search= new Select(filter);
	search.selectByValue("number");
	driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentno);
	String state = driver.findElement(By.xpath("(//td[@class='vt'])[8]")).getText();
	String actualState="Software";
	Assert.assertEquals(actualState,state);
}
}
