package d13_09_2022;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class zadatak3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php\r\n");
		
		for (int i = 1; i <= 5; i++) {

			driver.findElement(By.xpath("//*[@class = 'btn btn-info add-new']")).click();
			driver.findElement(By.xpath("//*[@name = 'name']")).sendKeys("Uros Stevovic");
			driver.findElement(By.xpath("//*[@name = 'department']")).sendKeys("HR");
			driver.findElement(By.xpath("//*[@name = 'phone']")).sendKeys("065548547");
			driver.findElement(By.xpath("//*[@class = 'table table-bordered']/tbody/tr[last()]/td[last()]/a")).click();
			Thread.sleep(1000);

		}
		
		
		Thread.sleep(5000);
		driver.quit();

		
		
	}

}
