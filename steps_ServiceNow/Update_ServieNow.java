package steps_ServiceNow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Update_ServieNow extends BaseClass{

@When("Enter the {string} in search")
public void search(String incidentno) {
	WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
	driver.switchTo().frame(frame2);
	WebElement filter = driver.findElement(By.xpath("//div[@class='input-group']/span//select"));
			Select search= new Select(filter);
			search.selectByValue("number");
	WebElement inc = driver.findElement(By.xpath("//input[@class='form-control']"));
	inc.sendKeys(incidentno,Keys.ENTER);
	}
@Then("Click on the incident number")
public void click() {
	driver.findElement(By.xpath("//td[@class='vt']/a")).click();
}
@Then("Update the incident with urgency as High")
public void updateUrgency() {
	WebElement select = driver.findElement(By.xpath("//div[@id='element.incident.urgency']/div[2]/select"));
	
	Select urgency =new Select(select);
	
	urgency.selectByValue("1");
}
@Then("Update the State as In Progress")
public void updateState() {
	WebElement select1 = driver.findElement(By.xpath("//div[@id='element.incident.state']/div[2]/select"));
	
	Select state= new Select(select1);
	state.selectByValue("2");
}
@Then("Click the Update Button")
public void update() {
	driver.findElement(By.xpath("//button[text()='Update']")).click();
}
@Then("Verify the priority and State for {string}")
public void verifyTheDetails(String incidentno) {
	WebElement filter = driver.findElement(By.xpath("//div[@class='input-group']/span//select"));
	Select search= new Select(filter);
	search.selectByValue("number");
	driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentno);
	String state = driver.findElement(By.xpath("(//td[@class='vt'])[6]")).getText();
	String actualState="In Progress";
	Assert.assertEquals(actualState,state);
	String priority= driver.findElement(By.xpath("(//td[@class='vt'])[11]")).getText();
	String actualPriority="1 - High";
	Assert.assertEquals(actualPriority,priority);
	
}
	
}




