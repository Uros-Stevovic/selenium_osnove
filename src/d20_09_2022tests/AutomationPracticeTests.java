package d20_09_2022tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import d20_09_2022_pages.BuyBoxPage;
import d20_09_2022_pages.LayerCartPage;


public class AutomationPracticeTests {

	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "http://automationpractice.com/";
	private BuyBoxPage buyBoxPage;
	private LayerCartPage layerCartPage;
//	private EditDialogPage editDialogPage;
//	private DeleteDialogPage deleteDialogPage;
	
	@BeforeClass 
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		buyBoxPage = new BuyBoxPage(driver, wait);
		layerCartPage = new LayerCartPage(driver, wait);
//		editDialogPage = new EditDialogPage(driver, wait);
//		deleteDialogPage = new DeleteDialogPage(driver, wait);
	}
	
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
//		driver.get(baseUrl); 
//		Thread.sleep(2000);
	}

	
	@Test (priority =10)
	public void AddingProductTotheCart() throws InterruptedException {
		driver.get("http://automationpractice.com//index.php?id_product=1&controller=product");
//		Thread.sleep(2000);
		buyBoxPage.getScroolToElement();
		buyBoxPage.getQuantityButton().clear();
		buyBoxPage.getQuantityButton().sendKeys("3");
		buyBoxPage.getChooseSizeButton().click();
		buyBoxPage.getWaitForDialogToBeVisible();
		buyBoxPage.getChooseColourButton("blue").click();
		buyBoxPage.getAddToChartButton().click();
		
		layerCartPage.getWaitForDialogToBeVisible();
		
	    Assert.assertEquals(layerCartPage.getQuantity(), 3 ,"ERROR: Wrong amount!");
	    String size = layerCartPage.getAtributes().getText();
                
	    Assert.assertTrue(size.contains("L"), "ERROR: Wrong size!");       
	    Assert.assertEquals(layerCartPage.getTotalPrice().getText() , "$" +3 * 16.51 ,
	    		"ERROR: Invalid total price!");
	    layerCartPage.getContinueShopingButton().click();
	    layerCartPage.getwaitForDialogToBeInvisible();
	    
	    
	    buyBoxPage.getQuantityButton().clear();
		buyBoxPage.getQuantityButton().sendKeys("1");
		buyBoxPage.getChooseSizeButton().click();
		buyBoxPage.getWaitForDialogToBeVisible();
		buyBoxPage.getChooseColourButton("orange").click();
		buyBoxPage.getAddToChartButton().click();
		
		layerCartPage.getProcedToCheckoutButton().click();
		
		Assert.assertEquals(
				driver.getTitle(),
				"Order - My Store", "ERROR: Wrong page!");
		
		
	
	}
	
	
	
	@Test
	public void deleteRowTest() {
//		driver.get(baseUrl + "/iframe/K5yrx");
		
	
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
