package d13_09_2022;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login\r\n" );
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name = 'username']")) .sendKeys("Admin");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("admin123");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@class = 'oxd-input oxd-input--active']")) .sendKeys("Me");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='oxd-userdropdown-tab']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='oxd-userdropdown-link']")).click();
		
		Thread.sleep(5000);
		driver.quit();
	
		
	}

}
