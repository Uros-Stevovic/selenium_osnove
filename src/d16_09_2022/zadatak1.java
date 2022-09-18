package d16_09_2022;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
		File front_slika = new File("C:\\\\Nova fascikla\\\\front_uros.jpg");
		File back_slika = new File("C:\\Nova fascikla\\back_uros.jpg");
		File right_slika = new File("‪C:\\Nova fascikla\\right_uros.jpg");
		File left_slika = new File("‪C:\\Nova fascikla\\left_uros.jpg");

		driver.findElement(By.xpath("//*[@class='sc-ezWOiH fendym']")).click();

		driver.findElement(By.xpath("//*[@alt='+ Add photo']")).click();

		WebElement uploadElement = driver.findElement(By.id("imageUpload"));

		// enter the file path onto the file-selection input field
		uploadElement.sendKeys(front_slika.getAbsolutePath());

		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'sc-ftvSup')]/div[1]")));
		driver.findElement(By.xpath("//*[@loading='lazy']")).click();

		driver.findElement(By.xpath("//button[text()='Use One Side Only']")).click();
		driver.findElement(By.xpath("//button[text()='Done']")).click();

		driver.findElement(By.xpath("//*[@alt='image 2']")).click();

		driver.findElement(By.xpath("//*[@alt='+ Add photo']")).click();

		driver.findElement(By.id("imageUpload")).sendKeys(left_slika.getAbsolutePath());

		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'sc-ftvSup')]/div[2]")));
		driver.findElement(By.xpath("//div[contains(@class, 'sc-ftvSup')]/div[1]//img")).click();

		driver.findElement(By.xpath("//button[text()='Use One Side Only']")).click();
		driver.findElement(By.xpath("//button[text()='Done']")).click();

		driver.findElement(By.xpath("//*[@alt='image 3']")).click();

		driver.findElement(By.xpath("//*[@alt='+ Add photo']")).click();

		driver.findElement(By.id("imageUpload")).sendKeys(back_slika.getAbsolutePath());

		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'sc-ftvSup')]/div[3]")));
		driver.findElement(By.xpath("//div[contains(@class, 'sc-ftvSup')]/div[1]//img")).click();

		driver.findElement(By.xpath("//button[text()='Use One Side Only']")).click();
		driver.findElement(By.xpath("//button[text()='Done']")).click();

		driver.findElement(By.xpath("//*[@alt='image 4']")).click();

		driver.findElement(By.xpath("//*[@alt='+ Add photo']")).click();

		driver.findElement(By.id("imageUpload")).sendKeys(right_slika.getAbsolutePath());

		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'sc-ftvSup')]/div[4]")));
		driver.findElement(By.xpath("//div[contains(@class, 'sc-ftvSup')]/div[1]//img")).click();

		driver.findElement(By.xpath("//button[text()='Use One Side Only']")).click();
		driver.findElement(By.xpath("//button[text()='Done']")).click();

		List<WebElement> konfete = driver.findElements(By.xpath("//*[@class = 'sc-hZgfyJ kFlYLE']/div"));
		Random r = new Random();
		int a = r.nextInt(konfete.size());
		konfete.get(a).click();

		driver.findElement(By.xpath("//*[contains(text() , 'Add to cart')]")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@action='error']")));
		System.out.println("Greska!");

		Thread.sleep(10000);
		driver.quit();

	}

}
