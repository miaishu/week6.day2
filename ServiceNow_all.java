package week6.day2Assign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ServiceNow_all extends BaseClass{
	
	
	@Test(dataProvider="fetchdata",priority=1,groups={"imp" , "least"},retryAnalyzer=week6.day2Assign.RetryFailures.class)
	public void createInc(String name, String sd)  throws InterruptedException, IOException {
		
		driver.findElement(By.xpath("//a[@id='b55b4ab0c0a80009007a9c0f03fb4da9']")).click();
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String>windows1=new ArrayList<String>(windowHandles1);
		driver.switchTo().window(windows1.get(1));
		Thread.sleep(2000);
		//WebElement filter = driver.findElement(By.xpath("//select[@id='448a0f0d1b110110c557a8e5604bcb94_select']"));
		//Select select1= new Select(filter);
		//select1.selectByValue("name");
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(name,Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='"+name+"']")).click();
		driver.switchTo().window(windows1.get(0));
		WebElement frame4 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame4);	
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys(sd);
		WebElement element = driver.findElement(By.xpath("//input[@id='incident.number']"));
		String attribute = element.getAttribute("value");
		System.out.println(attribute);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		//driver.close();
		//WebElement frame5 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		//driver.switchTo().frame(frame5);
		WebElement filter = driver.findElement(By.xpath("//div[@class='input-group']/span//select"));
		Select search= new Select(filter);
		search.selectByValue("number");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(attribute,Keys.ENTER);
		boolean displayed = driver.findElement(By.xpath("//td[@class='vt']/a")).isDisplayed();
		Assert.assertTrue(displayed);
		}
	
	
	
	@Test(priority=2,groups={"least"},retryAnalyzer=week6.day2Assign.RetryFailures.class)
	public void updateSer() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[@id='b55b4ab0c0a80009007a9c0f03fb4da9']")).click();
		WebElement iframe0 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(iframe0);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//th[@name='priority']"));
		Actions builder = new Actions(driver);
		builder.doubleClick();
		driver.findElement(By.xpath("//td[@class='vt']/a")).click();
		
		WebElement select = driver.findElement(By.xpath("//div[@id='element.incident.urgency']/div[2]/select"));
		
		Select urgency =new Select(select);
		
		urgency.selectByValue("1");
		
		WebElement select1 = driver.findElement(By.xpath("//div[@id='element.incident.state']/div[2]/select"));
		
		Select state= new Select(select1);
		state.selectByValue("2");
		String incidentno = driver.findElement(By.xpath("//div[@id='element.incident.number']/div[2]")).getText();
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		WebElement filter = driver.findElement(By.xpath("//div[@class='input-group']/span//select"));
		Select search= new Select(filter);
		search.selectByValue("number");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incidentno);
		String stateLevel = driver.findElement(By.xpath("(//td[@class='vt'])[6]")).getText();
		String actualState="In Progress";
		Assert.assertEquals(actualState,stateLevel);
		String priority= driver.findElement(By.xpath("(//td[@class='vt'])[11]")).getText();
		String actualPriority="1 - High";
		Assert.assertEquals(actualPriority,priority);
				
	}
	
	@Test(dataProvider ="fetchdata1",priority=3,groups={"imp"},retryAnalyzer=week6.day2Assign.RetryFailures.class)
	public void assign(String incno) throws InterruptedException {
		
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		WebElement frame0 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame0);
		WebElement filter = driver.findElement(By.xpath("//div[@class='input-group']/span//select"));
		Select search= new Select(filter);
		search.selectByValue("number");
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incno,Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']/span")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>windows= new ArrayList<String>(windowHandles);
		driver.switchTo().window(windows.get(1));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys("Software",Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Software']")).click();
		Thread.sleep(3000);
		driver.switchTo().window(windows.get(0));
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame1);
		WebElement sd = driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']"));
		sd.clear();
		sd.sendKeys("Changed the Assignment group");
		driver.findElement(By.xpath("//button[text()='Update']")).click();
		WebElement filter1 = driver.findElement(By.xpath("//div[@class='input-group']/span//select"));
		Select search1= new Select(filter1);
		search1.selectByValue("number");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incno);
		String state = driver.findElement(By.xpath("(//td[@class='vt'])[8]")).getText();
		String actualState="Software";
		Assert.assertEquals(actualState,state);
	}
		
	



	@Test(dataProvider ="fetchdata1",priority=4,groups={"least"},retryAnalyzer=week6.day2Assign.RetryFailures.class)
	public void delete_ser(String incno) {
		
		driver.findElement(By.xpath("//a[@id='b55b4ab0c0a80009007a9c0f03fb4da9']")).click();
		WebElement iframe0 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		
		driver.switchTo().frame(iframe0);
		
		WebElement filter = driver.findElement(By.xpath("//div[@class='input-group']/span//select"));
		Select search= new Select(filter);
		search.selectByValue("number");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incno,Keys.ENTER);
		//driver.findElement(By.xpath("//th[@name='priority']"));
		//Actions builder = new Actions(driver);
		//builder.doubleClick();	
		driver.findElement(By.xpath("//td[@class='vt']/a")).click();
		//driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("INC0000009",Keys.ENTER);
		//driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		WebElement filter1 = driver.findElement(By.xpath("//div[@class='input-group']/span//select"));
		Select search1= new Select(filter1);
		search1.selectByValue("number");
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(incno,Keys.ENTER);
		String result = driver.findElement(By.xpath("//tbody/tr[@class='list2_no_records']/td")).getText();
		String actual="No records to display";
		Assert.assertEquals(actual,result);


}


}
