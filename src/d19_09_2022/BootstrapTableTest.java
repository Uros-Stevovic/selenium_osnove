package d19_09_2022;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import org.openqa.selenium.TakesScreenshot;
public class BootstrapTableTest {

	private WebDriver driver;
	private WebDriverWait wait;
	private String baseURL = "https://s.bootsnipp.com";
	
	@BeforeClass 
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@BeforeMethod
	public void beforeMethod() {
		
	}
	
	@Test (priority = 1)
	public void editRaw() throws InterruptedException {		
		String firstName = "Uros";
		String lastName = "Stevovic";
		String midName ="Sasa";
		driver.get(baseURL + "/iframe/K5yrx");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Table with Edit and Update Data - Bootsnipp.com";
		
		Assert.assertEquals(actualTitle, expectedTitle, "ERROR: Unexpected title.");
		
		driver.findElement(By.xpath("//*[@class='update btn btn-warning btn-sm']")).click();
		wait.until(
		ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='fn']")));
		
		driver.findElement(By.id("fn")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(By.xpath("//*[@id='fn']")).sendKeys(firstName);
		driver.findElement(By.id("ln")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(By.xpath("//*[@id='ln']")).sendKeys(lastName);
		driver.findElement(By.id("mn")).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		driver.findElement(By.xpath("//*[@id='mn']")).sendKeys(midName);
		
		driver.findElement(By.xpath("//*[@id='up']")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='fn']")));
		
		String actualName = driver.findElement(By.xpath("//*[@id='f1']")).getText();
		String expectedName = firstName;
		Assert.assertEquals(actualName, expectedName, " ERROR - invalid name");
		
		String actualLastName = driver.findElement(By.xpath("//*[@id='l1']")).getText();
		String expectedLastName = lastName;
		Assert.assertEquals(actualLastName, expectedLastName, "ERROR - invalid lastname");
		
		String actualMidName = driver.findElement(By.xpath("//*[@id='m1']")).getText();
		String expectedMidName = midName;
		Assert.assertEquals(actualMidName, expectedMidName, "ERROR - invalid midname");
		
		
		Thread.sleep(5000);
	}
	
	@Test (priority = 2)
	public void deleteRow() throws InterruptedException {
		driver.get(baseURL + "/iframe/K5yrx");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Table with Edit and Update Data - Bootsnipp.com";
		
		Assert.assertEquals(actualTitle, expectedTitle, "ERROR: Unexpected title.");
		
		driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-trash']")).click();
		wait.until(
		ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='del']")));
		
		driver.findElement(By.xpath("//*[@id='del']")).click();
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='del']")));
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='m1']")));
		System.out.println("Prvi red je obrisan! ");
		
//		 List<WebElement> rows = driver.findElements(By.tagName("tr"));
//		 System.out.println("Broj redova je " + rows.size());
//		 rows.size(); 

		Thread.sleep(5000);
	}
	
	
	@Test (priority = 3)
	public void takeAScreenshot() throws Exception {
		driver.get(baseURL + "/iframe/K5yrx");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Table with Edit and Update Data - Bootsnipp.com";
		
		Assert.assertEquals(actualTitle, expectedTitle, "ERROR: Unexpected title.");
		
//		try {
//			FileHandler.copy(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),
//					new File("C:\\Users\\Vulkan\\eclipse-workspace\\selenium_osnove\\src\\paket_za_domaci\\DrugaSlika.png"));
//		} catch (IOException e) {
//			System.out.println("Picture wasn't stored");
//		}	
//		
		
		
//		BootstrapTableTest.takeSnapShot(driver, "C:\\Nova fascikla") ;
		Thread.sleep(5000);
	}
	

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
