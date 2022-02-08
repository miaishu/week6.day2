package week6.day2Assign;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	 public static ChromeDriver driver; 
	 
@BeforeMethod
public void preCondn() throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://dev113523.service-now.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	driver.manage().window().maximize();
	WebElement frame = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
	driver.switchTo().frame(frame);
	driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin",Keys.TAB);
	driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Ishu1990");
	driver.findElement(By.id("sysverb_login")).click();
	driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident",Keys.ENTER);
	Thread.sleep(1000);
	
	}

	@AfterMethod
	public void postcndn() {
		//driver.close();
	}
	
	@DataProvider(name="fetchdata")
	public String[][] sendData() throws IOException{
		return Exceldata_Servicenow.readExcel();
		 }
	
	
	@DataProvider(name="fetchdata1")
	public String[][] sendData1() throws IOException{
		return Exceldata_Servicenow_Update.readExcel();
		 }
}
	
	
